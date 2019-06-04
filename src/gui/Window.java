package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(getStandardLayout());
        setBounds(400, 400, 400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.BOLD, 10));
        textArea.setBackground(new Color(45, 55, 70, 45));

        JPanel panel = new JPanel(getStandardLayout());

        JTextField textField = new JTextField();
        textField.setFont(new Font("Courier", Font.BOLD, 10));
        panel.add(textField, BorderLayout.CENTER);

        panel.add(getPanel(), BorderLayout.WEST);
        panel.add(getPanel(), BorderLayout.SOUTH);

        JButton pushButton = new JButton("Отправить");
        pushButton.setFont(new Font("Courier", Font.BOLD, 12));

        JPanel gapPanel = new JPanel(getStandardLayout());
        panel.add(gapPanel, BorderLayout.EAST);
        gapPanel.add(pushButton, BorderLayout.CENTER);
        gapPanel.add(getPanel(), BorderLayout.EAST);

        JMenuBar mainMenu = new JMenuBar();
        JMenu options = new JMenu("Опции");
        options.setFont(new Font("Courier", Font.BOLD, 12));
        JMenuItem itemExit = new JMenuItem("Выход");
        itemExit.setFont(new Font("Courier", Font.BOLD, 10));
        options.add(itemExit);
        mainMenu.add(options);

        setJMenuBar(mainMenu);
        add(getPanel(), BorderLayout.NORTH);
        add(getPanel(), BorderLayout.EAST);
        add(getPanel(), BorderLayout.WEST);
        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private BorderLayout getStandardLayout() {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(5);
        layout.setVgap(5);
        return layout;
    }

    private JPanel getPanel() {
        return new JPanel(getStandardLayout());
    }
}
