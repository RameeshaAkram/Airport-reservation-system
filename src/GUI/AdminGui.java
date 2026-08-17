package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGui extends JFrame {
    JButton manageFlights;
    JButton manageStaff;
    JPanel panel;
    JButton bckBtn;

    public AdminGui(){
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(26, 33, 54, 255));

        manageFlights = new JButton("Manage Flights");
        manageFlights.setForeground(new Color(212, 210, 210, 255));
        manageFlights.setBackground(new Color(50, 81, 127, 255));
        manageFlights.setBounds(180, 180, 120, 25);

        manageStaff = new JButton("Manage Staff");
        manageStaff.setForeground(new Color(212, 210, 210, 255));
        manageStaff.setBackground(new Color(50, 81, 127, 255));
        manageStaff.setBounds(180, 220, 120, 25);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);

        panel.add(manageFlights);
        panel.add(manageStaff);
        panel.add(bckBtn);
        add(panel);


        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();
            }
        });

        manageFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightsList<>(0);
                dispose();
            }
        });

        manageStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StaffScreen();
                dispose();
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);



    }
}

