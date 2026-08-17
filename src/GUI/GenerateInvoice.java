package GUI;

import User.Invoice;
import User.Passenger;
import administrator.Flights;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateInvoice extends JFrame {

    JTextArea billinginfo;
    JLabel screenTitle;
    JButton bckBtn;

    public GenerateInvoice(Passenger p, String c, Flights f) {
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(26, 33, 54));
        setLayout(null);

        screenTitle = new JLabel("INVOICE");
        screenTitle.setForeground(new Color(212, 210, 210, 255));
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(250, 50, 200, 25);
        add(screenTitle);

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127));
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


        billinginfo = new JTextArea();
        billinginfo.setEditable(false);
        billinginfo.setBackground(new Color(50, 81, 127));
        billinginfo.setForeground(new Color(212, 210, 210, 255));
        billinginfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        billinginfo.setText("======================================" + System.lineSeparator() + "   YOUR INVOICE HAS BEEN GENERATED    " +
                System.lineSeparator() + "  ======================================" + System.lineSeparator() + invoice(f, p));

        JScrollPane sp = new JScrollPane(billinginfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setBounds(150, 150, 300, 400);
        add(sp);

        sp.setVisible(true);

        ModernTheme.decorateFrame(this);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public String invoice(Flights f, Passenger p) {

        return
        "Passenger Details: \n" + p.getDetails()+
        "\nFlight number: " + f.getFlightNumber()+
        "\nPlane number: " + f.getPlaneNumber()+
        "\nFrom: " + f.getStart()+
        "\nTo: " + f.getEnd()+
        "\nDate: " + f.getDate()+
        "\nTime of Departure: " + f.getDeparture()+
        "\nTime of Arrival: " + f.getArrival()+
        "\n======================================"+
        "\nGRAND TOTAL: " + Invoice.totalBill+
        "\n======================================\n";
    }
}
