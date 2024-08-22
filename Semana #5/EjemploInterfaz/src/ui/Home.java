package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class Home extends JFrame {
    private JLabel jlName;
    private JTextField tfName;
    private JButton btnLogIn;
    private JPanel MainPanel;
    private JLabel jlPassword;
    private JPasswordField pfPassword;

    public Home() {
        String username = "BelenCA";
        String password = "Password123";
        setContentPane(MainPanel);
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordInput = String.valueOf(pfPassword.getPassword());
                if (Objects.equals(tfName.getText(), username) && Objects.equals(passwordInput, password)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenid@, " + tfName.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                }
            }
        });
    }
}