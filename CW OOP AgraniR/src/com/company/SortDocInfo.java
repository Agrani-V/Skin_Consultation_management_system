package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SortDocInfo extends JFrame {

    private JButton back;
    ArrayList<Doctor> d1 = WestminsterSkinConsultationManager.westminsterSkinConsultationManager.docDetails;

    public SortDocInfo(){

        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ArrayList<String> docDetails1 = new ArrayList<String>();
        for (int i = 0; i < d1.size(); i++) {
            String doctor1 = d1.get(i).getSurname();
            docDetails1.add(doctor1);
        }
//        System.out.println(docDetails1);
        Collections.sort(docDetails1);
//        System.out.println(docDetails1);

        String[] tableColumns = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical Licence No", "Specialisation"};
        Object[][] data = new Object[d1.size()][6];
        int index = 0;
        for (String r : docDetails1) {
            for (int k = 0; k < d1.size(); k++){
                if (r == d1.get(k).getSurname()){
                    data[index][0] = d1.get(k).getName();
                    data[index][1] = d1.get(k).getSurname();
                    data[index][2] = d1.get(k).getDateOfBirth();
                    data[index][3] = d1.get(k).getMobileNumber();
                    data[index][4] = d1.get(k).getMedicalLicenceNumber();
                    data[index][5] = d1.get(k).getSpecialisation();
                    index++;
                }
            }

        }

        back = new JButton ("Back");

        setPreferredSize (new Dimension(944, 557));

        add (back);
        back.setBounds (505, 290, 100, 25);


        DefaultTableModel tableModel = new DefaultTableModel(data, tableColumns);
        JTable doctorTable = new JTable(tableModel);
        doctorTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(doctorTable);

        add(scrollPane);

        ActionHandler actHand = new ActionHandler();
        back.addActionListener(actHand);


    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == back){
                DocInfoGUI docInfoGui = new DocInfoGUI();
                dispose();
            }

        }
    }



}
