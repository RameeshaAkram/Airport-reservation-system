package GUI;

import administrator.Flights;
import ars.Filing;
import extras.Date;
import extras.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFlight extends JFrame {
        JLabel screenTitle;
        JLabel flightNumber;
        JTextField flightNumberField;
        JLabel PlaneNumber;
        JTextField PlaneNumberField;
        JLabel Date;
        JTextField DateField;
        JLabel Start;
        JTextField StartField;
        JLabel End;
        JTextField EndField;
        JLabel Departure;
        JTextField DepartureField;
        JLabel Arrival;
        JTextField ArrivalField;
        JLabel Seats;
        JTextField SeatsField;

        JButton addBtn;
        JButton bckBtn;

        public AddFlight(){
            super("Airline Reservation System");
            ModernTheme.install();
            setSize(600,800);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            getContentPane().setBackground(new Color(26, 33, 54));
            setLayout(null);


            screenTitle = new JLabel("ADD FLIGHT");
            screenTitle.setForeground(new Color(212, 210, 210, 255));
            screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
            screenTitle.setBounds(180, 50, 200, 25);
            add(screenTitle);

            flightNumber = new JLabel("Flight Number:");
            flightNumber.setForeground(new Color(212, 210, 210, 255));
            flightNumber.setBounds(50, 100, 80, 25);
            add(flightNumber);

            flightNumberField = new JTextField();
            flightNumberField.setForeground(Color.black);
            flightNumberField.setBounds(150, 100, 100, 25);
            add(flightNumberField);

            PlaneNumber = new JLabel("Plane Number:");
            PlaneNumber.setForeground(new Color(212, 210, 210, 255));
            PlaneNumber.setBounds(50, 140, 80, 25);
            add(PlaneNumber);

            PlaneNumberField = new JTextField();
            PlaneNumberField.setForeground(Color.black);
            PlaneNumberField.setBounds(150, 140, 100, 25);
            add(PlaneNumberField);

            Date = new JLabel("Date:");
            Date.setForeground(new Color(212, 210, 210, 255));
            Date.setBounds(50, 180, 80, 25);
            add(Date);

            DateField = new JTextField();
            DateField.setForeground(Color.black);
            DateField.setBounds(150, 180, 30, 25);
            add(DateField);

            JTextField DateField1 = new JTextField();
            DateField1.setForeground(Color.black);
            DateField1.setBounds(200, 180, 30, 25);
            add(DateField1);

            JTextField DateField2 = new JTextField();
            DateField2.setForeground(Color.black);
            DateField2.setBounds(250, 180, 30, 25);
            add(DateField2);

            Start = new JLabel("From:");
            Start.setForeground(new Color(212, 210, 210, 255));
            Start.setBounds(50, 220, 80, 25);
            add(Start);

            StartField = new JTextField();
            StartField.setForeground(Color.black);
            StartField.setBounds(150, 220, 100, 25);
            add(StartField);

            End = new JLabel("To:");
            End.setForeground(new Color(212, 210, 210, 255));
            End.setBounds(50, 260, 80, 25);
            add(End);

            EndField = new JTextField();
            EndField.setForeground(Color.black);
            EndField.setBounds(150, 260, 100, 25);
            add(EndField);

            Departure = new JLabel("Start Time:");
            Departure.setForeground(new Color(212, 210, 210, 255));
            Departure.setBounds(50, 300, 80, 25);
            add(Departure);

            DepartureField = new JTextField();
            DepartureField.setForeground(Color.black);
            DepartureField.setBounds(140, 300, 50, 25);
            add(DepartureField);

            JTextField DepartureField1 = new JTextField();
            DepartureField1.setForeground(Color.black);
            DepartureField1.setBounds(200, 300, 50, 25);
            add(DepartureField1);
            
            Arrival = new JLabel("Arrival Time:");
            Arrival.setForeground(new Color(212, 210, 210, 255));
            Arrival.setBounds(50, 340, 80, 25);
            add(Arrival);

            ArrivalField = new JTextField();
            ArrivalField.setForeground(Color.black);
            ArrivalField.setBounds(140, 340, 50, 25);
            add(ArrivalField);

            JTextField ArrivalField1 = new JTextField();
            ArrivalField1.setForeground(Color.black);
            ArrivalField1.setBounds(200, 340, 50, 25);
            add(ArrivalField1);

            Seats = new JLabel("Seats:");
            Seats.setForeground(new Color(212, 210, 210, 255));
            Seats.setBounds(50, 380, 80, 25);
            add(Seats);

            SeatsField = new JTextField();
            SeatsField.setForeground(Color.black);
            SeatsField.setBounds(150, 380, 100, 25);
            add(SeatsField);

            addBtn = new JButton("Add Flight");
            addBtn.setForeground(new Color(212, 210, 210, 255));
            addBtn.setBackground(new Color(50, 81, 127, 255));
            addBtn.setBounds(100,420,100,25);
            add(addBtn);


            bckBtn = new JButton("<");
            bckBtn.setForeground(new Color(212, 210, 210, 255));
            bckBtn.setBackground(new Color(50, 81, 127, 255));
            bckBtn.setBounds(20,20, 20, 20);
            bckBtn.setBorder(null);
            add(bckBtn);

            bckBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new FlightsList<>(0);
                    dispose();
                }
            });

            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String n = flightNumberField.getText();
                    String g = PlaneNumberField.getText();
                    String a = DateField.getText();
                    String b = DateField1.getText();
                    String c = DateField2.getText();
                    String x = DepartureField.getText();
                    String y = DepartureField1.getText();
                    String z = ArrivalField.getText();
                    String z1 = ArrivalField1.getText();
                    String k = StartField.getText();
                    String l = EndField.getText();
                    String s = SeatsField.getText();

                    if (n.isBlank() || g.isBlank() || k.isBlank() || l.isBlank() || s.isBlank() || a.isBlank()
                            || b.isBlank() || c.isBlank() || x.isBlank() || y.isBlank() || z.isBlank() || z1.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                    } else {

                        ArrayList<Flights> flights = Filing.readObjectFromFile();
                        Flights f = new Flights(n, g, new Date(a, b, c), new Time(x ,y) ,new Time(z, z1) , k, l, Integer.parseInt(s));
                        flights.add(f);
                        Filing.writeObjectToFile(flights);
                        JOptionPane.showMessageDialog(null, "The desired item is added, Refresh to see the updated list");
                        new FlightsList<>(0);
                        dispose();
                    }
                }
            });
            ModernTheme.decorateFrame(this);
            setLocationRelativeTo(null);
            setVisible(true);
        }


    }
