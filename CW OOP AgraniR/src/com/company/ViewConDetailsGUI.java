package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewConDetailsGUI extends JFrame {
    private JButton back;
    ArrayList<Consultation> c = Consultation.consultationInfo;
    public ViewConDetailsGUI(){
        setTitle("View Consultation Details");
        setVisible(true);
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] tableColumns ={"Patient Name", "Doctor Name", "Consultation Date", "Consultation Start Time", "Consultation End Time", "Notes", "Cost"};
        Object[][] data = new Object[c.size()][10];
        int index = 0;
        for (Consultation consultation : c){
            data[index][0] = consultation.getPatient();
            data[index][1] = consultation.getDoctor();
            data[index][2] = consultation.getDate();
            data[index][3] = consultation.getStartTime();
            data[index][4] = consultation.getEndTime();
            data[index][5] = consultation.getNotes();
            data[index][6] = consultation.getCost();
            index++;
        }

        for (Consultation consultation : c){
            System.out.println(consultation.getPatient());
            System.out.println(consultation.getDoctor());
            System.out.println(consultation.getDate());
            System.out.println(consultation.getStartTime());
            System.out.println(consultation.getEndTime());
            System.out.println(consultation.getNotes());
            System.out.println(consultation.getCost());
            index++;
        }

        back = new JButton ("Back");

        setPreferredSize (new Dimension(944, 557));

        add (back);
        back.setBounds (825, 290, 100, 25);

        DefaultTableModel tableModel = new DefaultTableModel(data, tableColumns);
        JTable doctorTable = new JTable(tableModel);
        doctorTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        doctorTable.setAutoCreateRowSorter(true);

        add(scrollPane);
        ActionHandler actHand = new ActionHandler();
        back.addActionListener(actHand);

    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == back){
                GUIForTheSystem guiForTheSystem = new GUIForTheSystem();
                dispose();
            }

        }
    }

}
