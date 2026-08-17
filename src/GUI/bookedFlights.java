package GUI;

import User.Invoice;
import administrator.Flights;
import ars.Filing;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bookedFlights extends JFrame {
    JButton bckBtn;
    JButton cancel;
    JButton refreshbtn;
    JScrollPane scroll;

    String[] headers = {"First Name", "Last Name", "Age", "Phone Number", "Gender", "Email", "Flight Class", "Flight Number"};

    public bookedFlights() {

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

        refreshbtn = new JButton("Refresh Changes");
        refreshbtn.setForeground(new Color(212, 210, 210, 255));
        refreshbtn.setBackground(new Color(50, 81, 127, 255));
        refreshbtn.setBounds(600, 680, 150, 25);
        add(refreshbtn);


        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(headers);
        ArrayList<Invoice> invoice = Filing.readBookedFlights();
        String[] rowData = new String[8];
        if(invoice != null) {

            for (int i = 0; i < invoice.size(); i++) {
                rowData[0] = invoice.get(i).P.getFname();
                rowData[1] = invoice.get(i).P.getLname();
                rowData[2] = invoice.get(i).P.getAge();
                rowData[3] = invoice.get(i).P.getPhNumber();
                rowData[4] = String.valueOf(invoice.get(i).P.getGender());
                rowData[5] = invoice.get(i).P.getEmail();
                rowData[6] = invoice.get(i).flightClass;
                rowData[7] = invoice.get(i).flightNumber;

                model.addRow(rowData);
            }
        }

        table.setModel(model);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("First Name").setCellRenderer(dtcr);
        table.getColumn("Last Name").setCellRenderer(dtcr);
        table.getColumn("Age").setCellRenderer(dtcr);
        table.getColumn("Phone Number").setCellRenderer(dtcr);
        table.getColumn("Gender").setCellRenderer(dtcr);
        table.getColumn("Email").setCellRenderer(dtcr);
        table.getColumn("Flight Class").setCellRenderer(dtcr);
        table.getColumn("Flight Number").setCellRenderer(dtcr);
        table.getTableHeader().setBackground(new Color(0, 0, 0, 255));
        table.getTableHeader().setForeground(new Color(212, 210, 210, 255));

        table.setRowHeight(200);
        table.setBackground(new Color(50, 81, 127, 255));
        table.setForeground(new Color(212, 210, 210, 255));
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setBounds(0, 50, 800, 600);
        add(scroll);

        cancel = new JButton("Cancel Booking");
        cancel.setForeground(new Color(212, 210, 210, 255));
        cancel.setBackground(new Color(50, 81, 127, 255));
        cancel.setBounds(50, 680, 150, 25);
        add(cancel);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userScreen();
                dispose();
            }
        });

        refreshbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new bookedFlights();
                dispose();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flights f = new Flights();
                int row = table.getSelectedRow();
                System.out.println(row);
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please Select a row to Delete");
                } else {
                    String value = table.getModel().getValueAt(row, 7).toString();
                    Invoice i = new Invoice();
                    Filing.deleteFromFileArray(i, value);
                    JOptionPane.showMessageDialog(null, "The desired item is deleted, Refresh to see the updated list");
                }
            }
        });

        ModernTheme.decorateFrame(this);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
