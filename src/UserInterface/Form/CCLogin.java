package UserInterface.Form;

import javax.swing.*;
import UserInterface.Gui.EcuaFauna2K24A;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCLogin {
    private static final String USERNAME = "pat_mic";
    private static final String PASSWORD = "123456";

    public static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void showLogin() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Clave:");
        JPasswordField passwordText = new JPasswordField();
        JButton loginButton = new JButton("Iniciar Sesión");

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel());
        panel.add(loginButton);

        loginFrame.add(panel);
        loginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (authenticate(username, password)) {
                    loginFrame.dispose();
                    // Iniciar la aplicación principal aquí
                    SwingUtilities.invokeLater(() -> new EcuaFauna2K24A().setVisible(true));
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
