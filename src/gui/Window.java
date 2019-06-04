package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout layout0 = new BorderLayout();
        layout0.setHgap(5);
        layout0.setVgap(5);
        setLayout(layout0);
        setBounds(400, 400, 400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        Font font0 = new Font("Courier", Font.BOLD, 12);
        textArea.setFont(font0);

        JPanel panel = new JPanel();

        BorderLayout layout1 = new BorderLayout();
        layout1.setHgap(5);
        layout1.setVgap(5);
        panel.setLayout(layout1);

        JTextField textField = new JTextField();
        Font font1 = new Font("Courier", Font.BOLD, 12);
        textField.setFont(font1);

        JButton pushButton = new JButton("Отправить");
        Font font2 = new Font("Courier", Font.BOLD, 12);
        pushButton.setFont(font2);

        panel.add(textField, BorderLayout.CENTER);
        panel.add(pushButton, BorderLayout.EAST);

        JMenuBar mainMenu = new JMenuBar();
        JMenu options = new JMenu("Опции");
        JMenuItem itemExit = new JMenuItem("Выход");
        options.add(itemExit);
        mainMenu.add(options);

        setJMenuBar(mainMenu);
        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
    }
}
