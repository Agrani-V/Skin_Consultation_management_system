package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultationGUI extends JFrame {

    static JComboBox docNames;
    private JButton searchBut;
    static JComboBox date;
    static JComboBox year;
    static JComboBox startTime;
    static JComboBox endTime;
    static JComboBox month;
    private JLabel labelStartTime;
    private JLabel labelEndTime;
    private JLabel labelDate;
    private JLabel labelDoc;
    private JLabel labelMon;
    private JLabel labelYear;
    private JButton back;

    ArrayList<Doctor> doctors = WestminsterSkinConsultationManager.westminsterSkinConsultationManager.docDetails;

    static ArrayList<String> docDetails1 = new ArrayList<String>();

    ArrayList<Consultation> consultation = Consultation.consultationInfo;


    String[] dateItems = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] monthItems = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] yearItems = {"2023", "2022"};
    String[] startTimeItems = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
    String[] endTimeItems = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
    String[] doctorsNames = {};


    public ConsultationGUI() {

        setTitle("Add Consultation");
        setSize(1000, 420);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        for (int i = 0; i < doctors.size(); i++) {
            String doctor1 = doctors.get(i).getSurname();
            String doctor2 = doctors.get(i).getName();
            docDetails1.add(doctor2+" "+doctor1);}
        doctorsNames = docDetails1.toArray(doctorsNames);


        docNames = new JComboBox(doctorsNames);
        searchBut = new JButton("Search:");
        date = new JComboBox(dateItems);
        year = new JComboBox(yearItems);
        startTime = new JComboBox(startTimeItems);
        endTime = new JComboBox(endTimeItems);
        month = new JComboBox(monthItems);
        labelStartTime = new JLabel("Start Time:");
        labelEndTime = new JLabel("End Time:");
        labelDate = new JLabel("Day:");
        labelDoc = new JLabel("Doctor:");
        labelMon = new JLabel("Month:");
        labelYear = new JLabel("Year:");
        back = new JButton("Back");


        add(docNames);
        add(searchBut);
        add(date);
        add(year);
        add(startTime);
        add(endTime);
        add(month);
        add(labelStartTime);
        add(labelEndTime);
        add(labelDate);
        add(labelDoc);
        add(labelMon);
        add(labelYear);
        add (back);


        docNames.setBounds(300, 100, 100, 25);
        searchBut.setBounds(680, 260, 100, 25);
        date.setBounds(300, 150, 100, 25);
        year.setBounds(680, 150, 100, 25);
        startTime.setBounds(300, 200, 100, 25);
        endTime.setBounds(493, 200, 100, 25);
        month.setBounds(493, 150, 100, 25);
        labelStartTime.setBounds(230, 200, 65, 25);
        labelEndTime.setBounds(430, 200, 65, 25);
        labelDate.setBounds(230, 150, 50, 25);
        labelDoc.setBounds(230, 100, 50, 25);
        labelMon.setBounds(430, 150, 50, 25);
        labelYear.setBounds(620, 150, 50, 25);
        back.setBounds(850, 335, 100, 25);


        ActionHandler actHand = new ActionHandler();
        searchBut.addActionListener(actHand);
        back.addActionListener(actHand);


        }

    private class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == searchBut){
                    if(consultation.isEmpty()){
                        for (int i = 0; i < doctorsNames.length; i++){
                            if (docNames.getSelectedItem().equals(doctorsNames[i]) ) {
                                AddPatient.doctor = (String) docNames.getSelectedItem();
                                AddPatient addPatient = new AddPatient();
                                dispose();
                            }
                        }
                    }else {

                                    for (Consultation check : consultation){
                                        if(check.getDoctor().equals(docNames.getSelectedItem())){
                                            if(((check.getEndTime().getHour() < LocalTime.parse((CharSequence) endTime.getSelectedItem()).getHour()) && (check.getEndTime().getHour() < LocalTime.parse((CharSequence) startTime.getSelectedItem()).getHour())) || ((check.getStartTime().getHour() > LocalTime.parse((CharSequence) endTime.getSelectedItem()).getHour()) && (check.getStartTime().getHour() > LocalTime.parse((CharSequence) startTime.getSelectedItem()).getHour()))){
                                                AddPatient.doctor = (String) docNames.getSelectedItem();
                                                AddPatient addPatient = new AddPatient();
                                                dispose();
                                                break;
                                            }else {
                                                    NotAvailableDoc notAvailableDoc = new NotAvailableDoc();
                                                    dispose();
                                                   break;
                                            }
                                        }
                                    }
                    }
                }

                if (e.getSource() == back){
                    GUIForTheSystem guiForTheSystem = new GUIForTheSystem();
                    dispose();
                }

            }
    }
}