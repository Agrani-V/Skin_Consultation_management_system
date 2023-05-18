package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIForTheSystem extends JFrame {

    private JButton docInfo;
    private JButton AddConsult;
    private JButton ViewConsult;
    private JButton close;

    public GUIForTheSystem() {

        setTitle("Skin Consultation");
        setSize(459, 420);
        setLayout (null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        docInfo = new JButton ("Show doctor Information");
        AddConsult = new JButton ("Add Consultation");
        ViewConsult = new JButton ("View Consultation Details");
        close = new JButton ("Close");


        setPreferredSize (new Dimension(459, 388));


        add (docInfo);
        add (AddConsult);
        add (ViewConsult);
        add (close);


        docInfo.setBounds (125, 75, 205, 35);
        AddConsult.setBounds (125, 160, 205, 35);
        ViewConsult.setBounds (125, 240, 205, 35);
        close.setBounds (330, 335, 100, 25);


        ActionHandler actHand = new ActionHandler();
        docInfo.addActionListener(actHand);
        AddConsult.addActionListener(actHand);
        ViewConsult.addActionListener(actHand);


        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        close.addActionListener(al);
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == docInfo) {
                DocInfoGUI docInfoGui = new DocInfoGUI();
                dispose();
            }

            if (e.getSource() == AddConsult) {
                ConsultationGUI consultationGUI = new ConsultationGUI();
                dispose();

            }

            if (e.getSource() == ViewConsult) {
                ViewConDetailsGUI viewConDetailsGUI = new ViewConDetailsGUI();
                dispose();
            }
        }
    }
}
