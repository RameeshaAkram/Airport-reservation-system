package GUI;

import administrator.Administrator;
import administrator.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginScreen extends JFrame {
    JLabel loginTitle;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userName;
    JPasswordField password;
    JButton Login;
    JButton Register;
    JButton bckBtn;

    public LoginScreen(Object obj){
        super("Login Window");
        ModernTheme.install();
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(26, 33, 54));
        setLayout(null);

        loginTitle = new JLabel("LOGIN");
        loginTitle.setForeground(new Color(212, 210, 210, 255));
        loginTitle.setFont(new Font("Serif", Font.BOLD, 17));
        loginTitle.setBounds(180, 50, 200, 25);
        add(loginTitle);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(new Color(212, 210, 210, 255));
        userLabel.setBounds(50, 100, 80, 25);
        add(userLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(new Color(212, 210, 210, 255));
        passwordLabel.setBounds(50, 140, 80, 25);
        add(passwordLabel);

        userName=new JTextField();
        userName.setBounds(140, 100, 160, 25);
        add(userName);

        password=new JPasswordField();
        password.setBounds(140, 140, 160, 25);
        add(password);

        Login = new JButton("login");
        Login.setForeground(new Color(212, 210, 210, 255));
        Login.setBackground(new Color(50, 81, 126, 255));
        Login.setBounds(100, 200, 100, 25);
        add(Login);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();

            }
        });

        Login.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char [] pass = password.getPassword();
                String p= String.valueOf(pass);
                String resource=obj.getClass().getSimpleName();
                if(new File(resource).isFile()) {
                    if (userName.getText().isBlank() || p.isBlank())
                        JOptionPane.showMessageDialog(null, "Invalid Input");
                    else {
                        if (new Login().LoggingIn(obj, userName.getText(), p)) {

                            JOptionPane.showMessageDialog(null, "Login SuccessFul");
                            if (obj instanceof Administrator) {
                                AdminGui s = new AdminGui();
                                dispose();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Login Failed");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Register First");
                }
            }
        });

        Register = new JButton("Register");
        Register.setForeground(new Color(212, 210, 210, 255));
        Register.setBackground(new Color(50, 81, 127, 255));
        Register.setBounds(210, 200, 100, 25);
        add(Register);
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    dispose();
                    AdminRegister ars = new AdminRegister(obj);
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
