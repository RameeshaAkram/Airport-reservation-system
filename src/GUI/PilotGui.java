package GUI;

import administrator.Flights;
import administrator.Pilots;
import ars.Filing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PilotGui extends JFrame {

    Random rand = new Random();
    JLabel screenTitle;
    JButton addBtn;
    JButton bckBtn;
    JLabel Name;
    JTextField NameField;
    JLabel lastName;
    JTextField lastNameField;
    JLabel Age;
    JTextField AgeField;
    JLabel FlyingHours;
    JTextField FlyingHoursField;
    JLabel Gender;
    JTextField genderField;
    JLabel PhNumber;
    JTextField PhNumberField;
    JLabel Email;
    JTextField EmailField;

    public PilotGui(){
        super("Airline Reservation System");
        ModernTheme.install();
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(26, 33, 54));
        setLayout(null);

        screenTitle = new JLabel("ADD PILOT");
        screenTitle.setForeground(new Color(212, 210, 210, 255));
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        Name = new JLabel("Name:");
        Name.setForeground(new Color(212, 210, 210, 255));
        Name.setBounds(50, 100, 80, 25);
        add(Name);

        NameField = new JTextField();
        NameField.setForeground(Color.black);
        NameField.setBounds(150, 100, 100, 25);
        add(NameField);

        lastName = new JLabel("Last Name:");
        lastName.setForeground(new Color(212, 210, 210, 255));
        lastName.setBounds(50, 140, 80, 25);
        add(lastName);

        lastNameField = new JTextField();
        lastNameField.setForeground(Color.black);
        lastNameField.setBounds(150, 140, 100, 25);
        add(lastNameField);

        Age = new JLabel("Age:");
        Age.setForeground(new Color(212, 210, 210, 255));
        Age.setBounds(50, 180, 80, 25);
        add(Age);

        AgeField = new JTextField();
        AgeField.setForeground(Color.black);
        AgeField.setBounds(150, 180, 30, 25);
        add(AgeField);


        FlyingHours = new JLabel("Flying Hours:");
        FlyingHours.setForeground(new Color(212, 210, 210, 255));
        FlyingHours.setBounds(50, 220, 80, 25);
        add(FlyingHours);

        FlyingHoursField = new JTextField();
        FlyingHoursField.setForeground(Color.black);
        FlyingHoursField.setBounds(150, 220, 100, 25);
        add(FlyingHoursField);

        PhNumber = new JLabel("Phone Number:");
        PhNumber.setForeground(new Color(212, 210, 210, 255));
        PhNumber.setBounds(50, 260, 80, 25);
        add(PhNumber);

        PhNumberField = new JTextField();
        PhNumberField.setForeground(Color.black);
        PhNumberField.setBounds(150, 260, 100, 25);
        add(PhNumberField);

        Gender = new JLabel("Gender:");
        Gender.setForeground(new Color(212, 210, 210, 255));
        Gender.setBounds(50, 300, 80, 25);
        add(Gender);

        genderField = new JTextField();
        genderField.setForeground(Color.black);
        genderField.setBounds(140, 300, 50, 25);
        add(genderField);

        Email = new JLabel("Email:");
        Email.setForeground(new Color(212, 210, 210, 255));
        Email.setBounds(50, 340, 80, 25);
        add(Email);

        EmailField = new JTextField();
        EmailField.setForeground(Color.black);
        EmailField.setBounds(140, 340, 50, 25);
        add(EmailField);

        addBtn = new JButton("Add Pilot");
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
                new StaffScreen();
                dispose();
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n = NameField.getText();
                String g = lastNameField.getText();
                String k = AgeField.getText();
                int l = Integer.parseInt(FlyingHoursField.getText());
                char s = genderField.getText().charAt(0);
                String a = PhNumberField.getText();
                String b = EmailField.getText();


                if (n.isBlank() || g.isBlank() || k.isBlank() || String.valueOf(l).isBlank() || String.valueOf(s).isBlank() || a.isBlank() || b.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                } else {
                    ArrayList<Flights> flights = Filing.readObjectFromFile();
                    int upperBound = flights.size();
                    int i = rand.nextInt(upperBound-1);
                    String m = flights.get(i).getFlightNumber();
                    String q = flights.get(i).getPlaneNumber();
                    JOptionPane.showMessageDialog(null, "The pilot has been assigned to Flight number "+m+" and Plane Number "+q);
                    new StaffScreen();
                    dispose();
                }
            }
        });
        ModernTheme.decorateFrame(this);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
