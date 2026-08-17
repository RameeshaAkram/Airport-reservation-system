package GUI;

import User.Invoice;
import User.Passenger;
import administrator.Flights;
import ars.Filing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class personDetails extends JFrame {

    JLabel screenTitle;
    JButton bckBtn;
    JLabel FirstName;
    JTextField FirstNameField;
    JLabel LastName;
    JTextField LastNameField;
    JLabel phNumber;
    JTextField phNumberDetails;
    JLabel Email;
    JTextField EmailField;
    JLabel Age;
    JTextField AgeField;
    JLabel Membership;
    JTextField MembershipField;
    JLabel Gender;
    JTextField GenderField;
    JLabel ticket;
    JRadioButton firstClass;
    JRadioButton businessClass;
    JButton invoiceBtn;
    ArrayList<Invoice> invoices = new ArrayList<>();

    public personDetails(Flights f1){
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(600,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(26, 33, 54));
        setLayout(null);


        screenTitle = new JLabel("ADD DETAILS");
        screenTitle.setForeground(new Color(212, 210, 210, 255));
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        FirstName = new JLabel("First Name:");
        FirstName.setForeground(new Color(212, 210, 210, 255));
        FirstName.setBounds(50, 100, 80, 25);
        add(FirstName);

        FirstNameField = new JTextField();
        FirstNameField.setForeground(Color.black);
        FirstNameField.setBounds(150, 100, 100, 25);
        add(FirstNameField);

        LastName = new JLabel("Last Name:");
        LastName.setForeground(new Color(212, 210, 210, 255));
        LastName.setBounds(50, 140, 80, 25);
        add(LastName);

        LastNameField = new JTextField();
        LastNameField.setForeground(Color.black);
        LastNameField.setBounds(150, 140, 100, 25);
        add(LastNameField);

        phNumber = new JLabel("Phone Number:");
        phNumber.setForeground(new Color(212, 210, 210, 255));
        phNumber.setBounds(50, 180, 120, 25);
        add(phNumber);

        phNumberDetails = new JTextField();
        phNumberDetails.setForeground(Color.black);
        phNumberDetails.setBounds(150, 180, 100, 25);
        add(phNumberDetails);


        Email = new JLabel("Email:");
        Email.setForeground(new Color(212, 210, 210, 255));
        Email.setBounds(50, 220, 80, 25);
        add(Email);

        EmailField = new JTextField();
        EmailField.setForeground(Color.black);
        EmailField.setBounds(150, 220, 100, 25);
        add(EmailField);

        Age = new JLabel("Age:");
        Age.setForeground(new Color(212, 210, 210, 255));
        Age.setBounds(50, 260, 50, 25);
        add(Age);

        AgeField = new JTextField();
        AgeField.setForeground(Color.black);
        AgeField.setBounds(150, 260, 100, 25);
        add(AgeField);

        Membership = new JLabel("Membership: (Y or N)");
        Membership.setForeground(new Color(212, 210, 210, 255));
        Membership.setBounds(50, 300, 150, 25);
        add(Membership);

        MembershipField = new JTextField();
        MembershipField.setForeground(Color.black);
        MembershipField.setBounds(180, 300, 50, 25);
        add(MembershipField);


        Gender = new JLabel("Gender: (M or F)");
        Gender.setForeground(new Color(212, 210, 210, 255));
        Gender.setBounds(50, 340, 150, 25);
        add(Gender);

        GenderField = new JTextField();
        GenderField.setForeground(Color.black);
        GenderField.setBounds(180, 340, 50, 25);
        add(GenderField);

        ticket = new JLabel("Class: ");
        ticket.setForeground(new Color(212, 210, 210, 255));
        ticket.setBounds(50, 380, 120, 25);
        add(ticket);

        firstClass = new JRadioButton("First Class");
        firstClass.setForeground(new Color(212, 210, 210, 255));
        firstClass.setBackground(new Color(26, 33, 54, 255));
        firstClass.setBounds(150, 380, 100, 25);
        firstClass.setBorder(null);
        add(firstClass);

        businessClass = new JRadioButton("Business Class");
        businessClass.setForeground(new Color(212, 210, 210, 255));
        businessClass.setBackground(new Color(26, 33, 54, 255));
        businessClass.setBounds(250, 380, 125, 25);
        businessClass.setBorder(null);
        add(businessClass);


        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        invoiceBtn = new JButton("Generate Invoice");
        invoiceBtn.setForeground(new Color(212, 210, 210, 255));
        invoiceBtn.setBackground(new Color(50, 81, 127, 255));
        invoiceBtn.setBounds(160,420, 150, 25);
        add(invoiceBtn);


        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightsList<>(1);
                dispose();
            }
        });

        firstClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstClass.isSelected()){
                    businessClass.setSelected(false);
                }
            }
        });

        businessClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(businessClass.isSelected()){
                    firstClass.setSelected(false);
                }
            }
        });

        invoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a = FirstNameField.getText();
                String b = LastNameField.getText();
                String c = AgeField.getText();
                String d = phNumberDetails.getText();
                String f = MembershipField.getText().toUpperCase(Locale.ROOT);
                String g = GenderField.getText();
                String h = EmailField.getText();
                String k = flightClass();

                if(a.isBlank() || b.isBlank() || c.isBlank() || d.isBlank() || f.isBlank() || g.isBlank() || h.isBlank()){
                    JOptionPane.showMessageDialog(null, "Some field is empty");
                }
                else {
                    Passenger p = new Passenger(a, b, d, h, c, f, g);
                    Invoice i = new Invoice(p, k, f1);
                    if(Filing.readBookedFlights() != null) {
                        invoices = Filing.readBookedFlights();
                    }
                    invoices.add(i);
                    Filing.writeBookedFlights(invoices);
                    new GenerateInvoice(p, k, f1);
                }
            dispose();

            }

            private String flightClass() {
                if(firstClass.isSelected()){
                    return "first";
                }
                else return "business";
            }
        });

        ModernTheme.decorateFrame(this);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
