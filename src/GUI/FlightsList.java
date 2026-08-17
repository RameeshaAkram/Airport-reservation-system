package GUI;

import administrator.Flights;
import ars.Filing;
import extras.Date;
import extras.Time;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightsList<i> extends JFrame {

    JButton bckBtn;
    JButton addbtn;
    JButton updatebtn;
    JButton deletebtn;
    JButton refreshbtn;
    JButton bookbtn;
    JScrollPane scroll;
    String[] rowFields;

    String[] headers = {"Flight Number", "Plane Number", "Date", "From", "To", "Departure", "Arrival", "Seats"};

    public FlightsList(int z) {

        super("Flights");
        ModernTheme.install();
        setSize(810, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(26, 33, 54, 255));

        bckBtn = new JButton("<");
        bckBtn.setForeground(new Color(212, 210, 210, 255));
        bckBtn.setBackground(new Color(50, 81, 127, 255));
        bckBtn.setBounds(20, 20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);


        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(headers);
        Filing f = new Filing();
        Flights fl = new Flights();
        ArrayList<Flights> flights = Filing.readObjectFromFile();
        String[] rowData = new String[8];
        for (int i = 0; i < flights.size(); i++) {
            rowData[0] = (flights.get(i)).getFlightNumber();
            rowData[1] = (flights.get(i)).getPlaneNumber();
            rowData[2] = (flights.get(i)).getDate();
            rowData[3] = (flights.get(i)).getStart();
            rowData[4] = (flights.get(i)).getEnd();
            rowData[5] = (flights.get(i)).getDeparture();
            rowData[6] = (flights.get(i)).getArrival();
            rowData[7] = String.valueOf((flights.get(i)).getSeats());

            model.addRow(rowData);
        }

        table.setModel(model);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Flight Number").setCellRenderer(dtcr);
        table.getColumn("Plane Number").setCellRenderer(dtcr);
        table.getColumn("Date").setCellRenderer(dtcr);
        table.getColumn("From").setCellRenderer(dtcr);
        table.getColumn("To").setCellRenderer(dtcr);
        table.getColumn("Departure").setCellRenderer(dtcr);
        table.getColumn("Arrival").setCellRenderer(dtcr);
        table.getColumn("Seats").setCellRenderer(dtcr);
        table.getTableHeader().setBackground(new Color(0, 0, 0, 255));
        table.getTableHeader().setForeground(new Color(212, 210, 210, 255));

        table.setRowHeight(200);
        table.setBackground(new Color(50, 81, 127, 255));
        table.setForeground(new Color(212, 210, 210, 255));
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setBounds(0, 50, 800, 600);
        add(scroll);


        addbtn = new JButton("Add Flight");
        addbtn.setForeground(new Color(212, 210, 210, 255));
        addbtn.setBackground(new Color(50, 81, 127, 255));
        addbtn.setBounds(50, 680, 100, 25);
        add(addbtn);


        updatebtn = new JButton("Update");
        updatebtn.setForeground(new Color(212, 210, 210, 255));
        updatebtn.setBackground(new Color(50, 81, 127, 255));
        updatebtn.setBounds(200, 680, 100, 25);
        add(updatebtn);

        deletebtn = new JButton("Delete Flight");
        deletebtn.setForeground(new Color(212, 210, 210, 255));
        deletebtn.setBackground(new Color(50, 81, 127, 255));
        deletebtn.setBounds(350, 680, 150, 25);
        add(deletebtn);

        refreshbtn = new JButton("Refresh Changes");
        refreshbtn.setForeground(new Color(212, 210, 210, 255));
        refreshbtn.setBackground(new Color(50, 81, 127, 255));
        refreshbtn.setBounds(550, 680, 150, 25);
        add(refreshbtn);

        if (z == 1) {
            addbtn.setVisible(false);
            updatebtn.setVisible(false);
            deletebtn.setVisible(false);
            refreshbtn.setVisible(false);

            bookbtn = new JButton("Book a Flight");
            bookbtn.setForeground(new Color(212, 210, 210, 255));
            bookbtn.setBackground(new Color(50, 81, 127, 255));
            bookbtn.setBounds(50, 680, 150, 25);
            add(bookbtn);

            bookbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    if(row == -1){
                        JOptionPane.showMessageDialog(null, "Please select a flight to book");
                    }
                    else{
                        rowFields = new String[table.getColumnCount()];
                        for(int i = 0 ; i < table.getColumnCount() ; i++) {
                            rowFields[i] = table.getValueAt(row, i).toString();
                        }
                        String n = rowFields[0];
                        String g = rowFields[1];
                        String c = rowFields[2];
                        String d = String.valueOf(c.charAt(0)) + String.valueOf(c.charAt(1));
                        String d1 = String.valueOf(c.charAt(3)) + String.valueOf(c.charAt(4));
                        String d2 = String.valueOf(c.charAt(6)) + String.valueOf(c.charAt(7)) + String.valueOf(c.charAt(8)) + String.valueOf(c.charAt(9));
                        String t = rowFields[5];
                        String t0 = String.valueOf(t.charAt(0)) + String.valueOf(t.charAt(1));
                        String t1 = String.valueOf(t.charAt(3)) + String.valueOf(t.charAt(4));
                        String t2 = rowFields[6];
                        String t3 = String.valueOf(t2.charAt(0)) + String.valueOf(t2.charAt(1));
                        String t4 = String.valueOf(t2.charAt(3)) + String.valueOf(t2.charAt(4));
                        String x = rowFields[3];
                        String y = rowFields[4];
                        int z = Integer.parseInt(rowFields[7]);

                        Flights f = new Flights(n, g, new Date(d, d1, d2), new Time(t0, t1), new Time(t3, t4), x, y, z);
                        new personDetails(f);

                        dispose();
                    }
                }
            });

            bckBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new userScreen();
                    dispose();
                }
            });
            ModernTheme.decorateFrame(this);
            setVisible(true);
            setLocationRelativeTo(null);

        } else {

            bckBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AdminGui();
                    dispose();
                }
            });
            addbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new AddFlight();
                    dispose();
                }
            });

            updatebtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row = table.getSelectedRow();
                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Please Select a row to update");
                    } else {
                        rowFields = new String[table.getColumnCount()];
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            rowFields[i] = table.getValueAt(row, i).toString();
                            System.out.println(rowFields[i]);
                        }
                        String n = rowFields[0];
                        String g = rowFields[1];
                        String c = rowFields[2];
                        String d = String.valueOf(c.charAt(0)) + String.valueOf(c.charAt(1));
                        String d1 = String.valueOf(c.charAt(3)) + String.valueOf(c.charAt(4));
                        String d2 = String.valueOf(c.charAt(6)) + String.valueOf(c.charAt(7)) + String.valueOf(c.charAt(8)) + String.valueOf(c.charAt(9));
                        String t = rowFields[5];
                        String t0 = String.valueOf(t.charAt(0)) + String.valueOf(t.charAt(1));
                        String t1 = String.valueOf(t.charAt(3)) + String.valueOf(t.charAt(4));
                        String t2 = rowFields[6];
                        String t3 = String.valueOf(t2.charAt(0)) + String.valueOf(t2.charAt(1));
                        String t4 = String.valueOf(t2.charAt(3)) + String.valueOf(t2.charAt(4));
                        String x = rowFields[3];
                        String y = rowFields[4];
                        int z = Integer.parseInt(rowFields[7]);

                        Flights f = new Flights(n, g, new Date(d, d1, d2), new Time(t0, t1), new Time(t3, t4), x, y, z);
                        UpdateFlights uf = new UpdateFlights(f);
                        dispose();
                    }
                }
            });

            deletebtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Flights f = new Flights();
                    int row = table.getSelectedRow();
                    System.out.println(row);
                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Please Select a row to Delete");
                    } else {
                        String value = table.getModel().getValueAt(row, 0).toString();
                        Filing.deleteFromFileArray(f, value);
                        JOptionPane.showMessageDialog(null, "The desired item is deleted, Refresh to see the updated list");
                    }
                }
            });

            refreshbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new FlightsList<>(0);
                    dispose();
                }
            });


            ModernTheme.decorateFrame(this);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

}
