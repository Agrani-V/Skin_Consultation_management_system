package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DocInfoGUI extends JFrame {

    ArrayList<Doctor> d1 = WestminsterSkinConsultationManager.westminsterSkinConsultationManager.docDetails;

    private JButton component1;
    private JButton component2;

    public DocInfoGUI(){

        setTitle("View Doctor Details");
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] tableColumns = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical Licence No", "Specialisation"};
        Object[][] data = new Object[d1.size()][6];
        int index = 0;
        for (Doctor doctor : d1) {
            data[index][0] = doctor.getName();
            data[index][1] = doctor.getSurname();
            data[index][2] = doctor.getDateOfBirth();
            data[index][3] = doctor.getMobileNumber();
            data[index][4] = doctor.getMedicalLicenceNumber();
            data[index][5] = doctor.getSpecialisation();
            index++;
        }


        component1 = new JButton ("Sort Ascending");
        component2 = new JButton ("Back");

        setPreferredSize (new Dimension (944, 557));

        add (component1);
        add (component2);
        component1.setBounds (645, 290, 100, 25);
        component2.setBounds (505, 290, 100, 25);


        DefaultTableModel tableModel = new DefaultTableModel(data, tableColumns);
        JTable doctorTable = new JTable(tableModel);
        doctorTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(doctorTable);

        add(scrollPane);

        ActionHandler actHand = new ActionHandler();
        component1.addActionListener(actHand);
        component2.addActionListener(actHand);



    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == component1){
                SortDocInfo sortDocInfo = new SortDocInfo();
                dispose();
            }

            if (e.getSource() == component2){
                GUIForTheSystem guiForTheSystem = new GUIForTheSystem();
                dispose();
            }

        }
    }

}
