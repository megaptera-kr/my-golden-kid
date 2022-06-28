import panels.BulletinBoardPanel;
import panels.GenerateMenuPanel;
import panels.GreetingPanel;

import javax.swing.*;
import java.awt.*;
public class RandomMenu {
  private JFrame frame;
  private JPanel contentPanel;
  public static void main(String[] args) {
    RandomMenu application = new RandomMenu();
    application.run();
  }
  public void run() {
    // Swing 기본 세팅
    frame = new JFrame("한끼 얌얌");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));
    frame.setSize(600, 700);
    frame.setVisible(true);

    initNavigationButton();

    initContentPanel();

    // TODO: 홈으로 버튼을 누르지 않아도 실행되는 메인 greeting page가 있어야 할 것 같은데..
  }

  public void initNavigationButton() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    frame.add(panel, BorderLayout.PAGE_START);
    frame.add(panel);

    panel.add(createGoHomeButton());
    panel.add(createBulletinBoardButton());
  }

  public JButton createGoHomeButton() {
    JButton button = new JButton("홈으로");
    button.addActionListener(event -> {
      GreetingPanel greetingPanel = new GreetingPanel();
      contentPanel.add(greetingPanel);
      displayContentPanel(greetingPanel);
    });

    return button;
  }
  public JButton createBulletinBoardButton() {
    JButton button = new JButton("자랑하기");
    button.addActionListener(event -> {
      BulletinBoardPanel bulletinBoardPanel = new BulletinBoardPanel();
      displayContentPanel(bulletinBoardPanel);
    });

    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.setVisible(true);
    frame.add(contentPanel);
  }

  public void displayContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}