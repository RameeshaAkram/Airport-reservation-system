package GUI;
import administrator.Administrator;
import ars.Filing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AdminRegister extends JFrame {
    JLabel screenTitle;
    JLabel Name;
    JTextField firstName;
    JTextField lastName;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userName;
    JPasswordField password;
    JButton Register;
    JButton bckBtn;

    public AdminRegister(Object obj){
        super("Registration Window");
        ModernTheme.install();
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(26, 33, 54));
        setLayout(null);

        screenTitle = new JLabel("Register Admin Here ");
        screenTitle.setForeground(new Color(212, 210, 210, 255));
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(170, 80, 200, 25);
        add(screenTitle);

        Name = new JLabel("Name");
        Name.setForeground(new Color(212, 210, 210, 255));
        Name.setBounds(50, 140, 80, 25);
        add(Name);

        firstName=new JTextField();
        firstName.setBounds(140, 140, 100, 25);
        add(firstName);

        lastName=new JTextField();
        lastName.setBounds(245, 140, 100, 25);
        add(lastName);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(new Color(212, 210, 210, 255));
        userLabel.setBounds(50, 180, 80, 25);
        add(userLabel);

        userName=new JTextField();
        userName.setBounds(140, 180 ,205, 25);
        add(userName);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(new Color(212, 210, 210, 255));
        passwordLabel.setBounds(50, 220, 80, 25);
        add(passwordLabel);

        password=new JPasswordField();
        password.setBounds(140, 220, 205, 25);
        add(password);

        Register = new JButton("Register");
        Register.setForeground(new Color(212, 210, 210, 255));
        Register.setBackground(new Color(50, 81, 127, 255));
        Register.setBounds(192, 270, 100, 25);
        add(Register);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen(obj);
                dispose();

            }
        });

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fn = firstName.getText();
                String ln = lastName.getText();
                String un = userName.getText();
                char[] pass = password.getPassword();
                String p = String.valueOf(pass);
                String resource = obj.getClass().getSimpleName();
                // CHeck not confirm yet
                new File(resource).delete();
                if (new File(resource).isFile())
                    JOptionPane.showMessageDialog(null, "Administrator Already Exists");
                else {
                    if (fn.isBlank() || ln.isBlank() || un.isBlank() || p.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                    } else {
                        Administrator a = new Administrator(fn, ln, un, p);
                        Filing.Registration(a);
                        JOptionPane.showMessageDialog(null, "Registration Successful");
                        clearForm();
                        new LoginScreen(obj);
                        dispose();
                    }
//                }
                }
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void clearForm(){
        firstName.setText(" ");
        lastName.setText(" ");
        userName.setText(" ");
        password.setText(" ");


    }
}

