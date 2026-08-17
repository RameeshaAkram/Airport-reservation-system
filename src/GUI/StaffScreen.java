package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffScreen extends JFrame {

    JLabel screenTitle;
    JPanel panel;
    JButton bckBtn;
    JButton Pilot;
    JButton airHostess;

    public StaffScreen(){
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(26, 33, 54, 255));

        screenTitle = new JLabel("Manage Staff Here");
        screenTitle.setForeground(new Color(212, 210, 210, 255));
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(200, 50, 200, 25);
        panel.add(screenTitle,BorderLayout.CENTER);

        Pilot = new JButton("Add Pilot");
        Pilot.setForeground(new Color(212, 210, 210, 255));
        Pilot.setBackground(new Color(50, 81, 127, 255));
        Pilot.setBounds(180, 180, 150, 25);
        panel.add(Pilot);

        airHostess = new JButton("Add Air Hostess");
        airHostess.setForeground(new Color(212, 210, 210, 255));
        airHostess.setBackground(new Color(50, 81, 127, 255));
        airHostess.setBounds(180, 220, 150, 25);
        panel.add(airHostess);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        panel.add(bckBtn);
        add(panel);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminGui();
                dispose();
            }
        });

        Pilot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PilotGui();
                dispose();
            }
        });

        airHostess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new airHostessGui();
                dispose();
            }
        });

        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
