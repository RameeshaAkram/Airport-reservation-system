package GUI;

import administrator.Flights;
import ars.Filing;
import extras.Date;
import extras.Time;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateFlights extends JFrame {
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

    JButton updateBtn;
    JButton bckBtn;

    public UpdateFlights(Flights f){
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

        flightNumberField = new JTextField(f.getFlightNumber());
        flightNumberField.setForeground(Color.black);
        flightNumberField.setBounds(150, 100, 100, 25);
        add(flightNumberField);

        PlaneNumber = new JLabel("Plane Number:");
        PlaneNumber.setForeground(new Color(212, 210, 210, 255));
        PlaneNumber.setBounds(50, 140, 80, 25);
        add(PlaneNumber);

        PlaneNumberField = new JTextField(f.getPlaneNumber());
        PlaneNumberField.setForeground(Color.black);
        PlaneNumberField.setBounds(150, 140, 100, 25);
        add(PlaneNumberField);

        Date = new JLabel("Date:");
        Date.setForeground(new Color(212, 210, 210, 255));
        Date.setBounds(50, 180, 80, 25);
        add(Date);

        DateField = new JTextField(f.date.getDay());
        DateField.setForeground(Color.black);
        DateField.setBounds(150, 180, 30, 25);
        add(DateField);

        JTextField DateField1 = new JTextField(f.date.getMonth());
        DateField1.setForeground(Color.black);
        DateField1.setBounds(200, 180, 30, 25);
        add(DateField1);

        JTextField DateField2 = new JTextField(f.date.getYear());
        DateField2.setForeground(Color.black);
        DateField2.setBounds(250, 180, 30, 25);
        add(DateField2);

        Departure = new JLabel("Start Time:");
        Departure.setForeground(new Color(212, 210, 210, 255));
        Departure.setBounds(50, 220, 80, 25);
        add(Departure);

        DepartureField = new JTextField(f.departure.getHours());
        DepartureField.setForeground(Color.black);
        DepartureField.setBounds(140, 220, 50, 25);
        add(DepartureField);

        JTextField DepartureField1 = new JTextField(f.departure.getMinutes());
        DepartureField1.setForeground(Color.black);
        DepartureField1.setBounds(200, 220, 50, 25);
        add(DepartureField1);

        Arrival = new JLabel("Arrival Time:");
        Arrival.setForeground(new Color(212, 210, 210, 255));
        Arrival.setBounds(50, 260, 80, 25);
        add(Arrival);

        ArrivalField = new JTextField(f.arrival.getHours());
        ArrivalField.setForeground(Color.black);
        ArrivalField.setBounds(140, 260, 50, 25);
        add(ArrivalField);

        JTextField ArrivalField1 = new JTextField(f.arrival.getMinutes());
        ArrivalField1.setForeground(Color.black);
        ArrivalField1.setBounds(200, 260, 50, 25);
        add(ArrivalField1);

        Start = new JLabel("From:");
        Start.setForeground(new Color(212, 210, 210, 255));
        Start.setBounds(50, 300, 80, 25);
        add(Start);

        StartField = new JTextField(f.getStart());
        StartField.setForeground(Color.black);
        StartField.setBounds(150, 300, 100, 25);
        add(StartField);

        End = new JLabel("To:");
        End.setForeground(new Color(212, 210, 210, 255));
        End.setBounds(50, 340, 80, 25);
        add(End);

        EndField = new JTextField(f.getEnd());
        EndField.setForeground(Color.black);
        EndField.setBounds(150, 340, 100, 25);
        add(EndField);


        Seats = new JLabel("Seats:");
        Seats.setForeground(new Color(212, 210, 210, 255));
        Seats.setBounds(50, 380, 80, 25);
        add(Seats);

        SeatsField = new JTextField(String.valueOf(f.getSeats()));
        SeatsField.setForeground(Color.black);
        SeatsField.setBounds(150, 380, 100, 25);
        add(SeatsField);

        updateBtn = new JButton("Update");
        updateBtn.setForeground(new Color(212, 210, 210, 255));
        updateBtn.setBackground(new Color(50, 81, 127, 255));
        updateBtn.setBounds(100,420,100,25);
        add(updateBtn);


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

        updateBtn.addActionListener(new ActionListener() {
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
                int i = Integer.parseInt(SeatsField.getText());

                if (n.isBlank() || g.isBlank() || k.isBlank() || l.isBlank() || String.valueOf(i).isBlank() || a.isBlank()
                || b.isBlank() || c.isBlank() || x.isBlank() || y.isBlank() || z.isBlank() || z1.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                } else {

                    ArrayList<Flights> flights = Filing.readObjectFromFile();
                    Flights f = new Flights(n, g, new Date(a, b, c), new Time(x ,y) ,new Time(z, z1) , k, l, i);
                    if(f.checkFlights(f)) {
                        flights.add(f);
                        Filing.writeObjectToFile(flights);
                        JOptionPane.showMessageDialog(null, "The desired item is updated, Refresh to see the updated list");
                        new FlightsList<>(0);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please enter valid details!");
                        new UpdateFlights(f);
                    }
                    dispose();
                }
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
