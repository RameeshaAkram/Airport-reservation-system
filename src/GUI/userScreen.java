package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userScreen extends JFrame {

    JButton availableFlights;
    JButton bookedFlights;
    JPanel panel;
    JButton bckBtn;

    public userScreen(){
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(26, 33, 54, 255));

        availableFlights = new JButton("Available Flights");
        availableFlights.setForeground(new Color(212, 210, 210, 255));
        availableFlights.setBackground(new Color(50, 81, 127, 255));
        availableFlights.setBounds(180, 180, 150, 25);

        bookedFlights = new JButton("Booked Flights");
        bookedFlights.setForeground(new Color(212, 210, 210, 255));
        bookedFlights.setBackground(new Color(50, 81, 127, 255));
        bookedFlights.setBounds(180, 220, 150, 25);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);

        panel.add(availableFlights);
        panel.add(bookedFlights);
        panel.add(bckBtn);
        add(panel);


        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();
            }
        });

        availableFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightsList<>(1);
                dispose();
            }
        });

        bookedFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new bookedFlights();
                dispose();
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
