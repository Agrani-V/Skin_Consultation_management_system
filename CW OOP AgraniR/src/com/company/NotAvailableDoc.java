package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import static com.company.ConsultationGUI.*;

public class NotAvailableDoc extends JFrame {


    private JLabel notAvailable;
    private JButton book2;

    private JButton back;

    ArrayList<Consultation> consultation = Consultation.consultationInfo;
    ArrayList<String> availableDoctors = new ArrayList<String>();
    ArrayList<Doctor> d1 = WestminsterSkinConsultationManager.westminsterSkinConsultationManager.docDetails;


    public NotAvailableDoc(){
        setTitle("Notice");
        setSize(700, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        notAvailable = new JLabel ("The doctor you've searched for is unavailable. " +
                "\n You can have a consultation with another random doctor.");
        book2 = new JButton ("Agree");
        back = new JButton ("Back");


        add (notAvailable);
        add (book2);
        add (back);


        book2.setBounds (200, 110, 100, 20);
        back.setBounds (335, 110, 100, 20);
        notAvailable.setBounds (35, 40, 600, 25);


        ActionHandler actHand = new ActionHandler();
        back.addActionListener(actHand);
        book2.addActionListener(actHand);

    }
    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == back){
                ConsultationGUI consultationGUI = new ConsultationGUI();
                dispose();
            }

            if (e.getSource() == book2){

                for (String doctor: docDetails1){
                    for (Consultation check : consultation){
                        if (!doctor.contains(check.getDoctor())){
                            availableDoctors.add(doctor);
                        }
                    }
                }


                for (Consultation check : consultation){
                    if(((check.getEndTime().getHour() < LocalTime.parse((CharSequence) endTime.getSelectedItem()).getHour()) && (check.getEndTime().getHour() < LocalTime.parse((CharSequence) startTime.getSelectedItem()).getHour())) || ((check.getStartTime().getHour() > LocalTime.parse((CharSequence) endTime.getSelectedItem()).getHour()) && (check.getStartTime().getHour() > LocalTime.parse((CharSequence) startTime.getSelectedItem()).getHour()))){
                        availableDoctors.add(check.getDoctor());
                    }
                }

                Random rand = new Random();
                System.out.println(availableDoctors.size());
                int randInt = rand.nextInt(availableDoctors.size()+1);
                AddPatient.doctor = availableDoctors.get(rand.nextInt(availableDoctors.size()));

                AddPatient.runnable = false;

                AddPatient addPatient = new AddPatient();
                dispose();

            }

        }

    }
}
