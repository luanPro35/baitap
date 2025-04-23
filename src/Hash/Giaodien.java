package org.example.Hash;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;

public class Giaodien extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Giaodien() {
        setTitle("Đăng ký / Đăng nhập");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createRegisterPanel(), "register");
        mainPanel.add(createLoginPanel(), "login");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField passwordConfirmField = new JPasswordField();
        JButton registerButton = new JButton("Đăng ký");
        JButton switchToLogin = new JButton("Chuyển sang đăng nhập");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(new JLabel("Nhập lại mật khẩu:"));
        panel.add(passwordConfirmField);
        panel.add(registerButton);
        panel.add(switchToLogin);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String passwordConfirm = String.valueOf(passwordConfirmField.getPassword());

            if (username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            } else if (!password.equals(passwordConfirm)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu và xác nhận mật khẩu không khớp.");
            } else {
                Database db = new Database();
                if (db.userExists(username)) {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại.");
                } else if (db.insertUser(username, password)) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                    usernameField.setText("");
                    passwordField.setText("");
                    passwordConfirmField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi đăng ký tài khoản.");
                }
            }
        });

        switchToLogin.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        return panel;
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Đăng nhập");
        JButton switchToRegister = new JButton("Chuyển sang đăng ký");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(switchToRegister);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            Database db = new Database();
            String storedHash = db.getHashedPassword(username);

            if (storedHash == null) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập không tồn tại.");
            } else {
                if (BCrypt.checkpw(password, storedHash)) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sai mật khẩu.");
                }
            }
        });

        switchToRegister.addActionListener(e -> cardLayout.show(mainPanel, "register"));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Giaodien::new);
    }
}
