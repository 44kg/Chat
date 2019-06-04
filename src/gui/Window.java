package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window() throws HeadlessException{
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(getStandardLayout());
        setBounds(100, 100, 600, 500);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.BOLD, 10));
//        textArea.setBackground(new Color(45, 55, 70, 45));

        JPanel panel = new JPanel(getStandardLayout());

        JTextField textField = new JTextField();
        textField.setFont(new Font("Courier", Font.BOLD, 10));
        textField.addActionListener(getActionListener(textField, textArea));
        panel.add(textField, BorderLayout.CENTER);

        panel.add(getPanel(), BorderLayout.WEST);
        panel.add(getPanel(), BorderLayout.SOUTH);

        JButton pushButton = new JButton("Отправить");
        pushButton.setFont(new Font("Courier", Font.BOLD, 12));
        pushButton.addActionListener(getActionListener(textField, textArea));

        JPanel gapPanel = new JPanel(getStandardLayout());
        panel.add(gapPanel, BorderLayout.EAST);
        gapPanel.add(pushButton, BorderLayout.CENTER);
        gapPanel.add(getPanel(), BorderLayout.EAST);

        JMenuBar mainMenu = new JMenuBar();
        JMenu options = new JMenu("Меню");
        options.setFont(new Font("Courier", Font.BOLD, 12));
        JMenuItem itemExit = new JMenuItem("Выход");
        itemExit.setFont(new Font("Courier", Font.BOLD, 10));
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        options.add(itemExit);
        mainMenu.add(options);

        setJMenuBar(mainMenu);
        add(getPanel(), BorderLayout.NORTH);
        add(getPanel(), BorderLayout.EAST);
        add(getPanel(), BorderLayout.WEST);
        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
        textField.grabFocus();
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

    private ActionListener getActionListener(JTextField textField, JTextArea textArea) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.setText("");
                textArea.append("Вы: " + text + '\n');
                textField.grabFocus();
            }
        };
    }
}
