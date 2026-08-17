package GUI;

import administrator.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusScreen extends JFrame {

    JButton admin;
    JButton user;


    public StatusScreen(){
        super("Login Window");
        ModernTheme.install();
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(26, 33, 54, 255));

        admin = new JButton("Admin");
        admin.setForeground(new Color(212, 210, 210, 255));
        admin.setBackground(new Color(50, 81, 127, 255));
        admin.setBounds(190, 180, 130, 50);
        admin.setBorder(null);

        user= new JButton("User");
        user.setForeground(new Color(212, 210, 210, 255));
        user.setBackground(new Color(50, 81, 127, 255));
        user.setBounds(190, 250, 130, 50);
        user.setBorder(null);

        p.add(admin);
        p.add(user);
        add(p);

        admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LoginScreen(new Administrator());
                dispose();
            }
        });

        user.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new userScreen();
                dispose();
            }
        });

        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
