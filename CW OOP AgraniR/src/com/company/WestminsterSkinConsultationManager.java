package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;


public class WestminsterSkinConsultationManager implements Serializable,  SkinConsultationManager{

    Doctor doctor = new Doctor();
    Person person = new Person();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Doctor> docDetails = new ArrayList<Doctor>();

    static WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();


    int count = 0;


    @Override
    public void addingADoctor(){

        try {

            boolean run = true;
            while (run && count<10) {
                System.out.println("Name of the doctor: ");
                person.setName(scanner.next());
                String name = person.getName();

                System.out.println("Surname of the doctor: ");
                person.setSurname(scanner.next());
                String surname = person.getSurname();

                System.out.println("Doctor's date of birth (YYYY-MM-DD): ");
                person.setDateOfBirth(LocalDate.parse(scanner.next()));
                LocalDate dateOfBirth = person.getDateOfBirth();

                System.out.println("Doctor's contact number: ");
                person.setMobileNumber(scanner.next());
                String mobileNumber = person.getMobileNumber();

                System.out.println("Specialisation of the doctor: ");
                doctor.setSpecialisation(scanner.next());
                String specialisation = doctor.getSpecialisation();

                System.out.println("Doctor's medical licence number: ");
                doctor.setMedicalLicenceNumber(scanner.next());
                String medicalLicenceNumber = doctor.getMedicalLicenceNumber();

                Doctor doctorInfo = new Doctor(name, surname, dateOfBirth, mobileNumber, specialisation, medicalLicenceNumber);
                docDetails.add(doctorInfo);

                count++;

                System.out.println("Do you need to add another doctor? (yes/no)");
                String input = scanner.next();
                input = input.toLowerCase();
                if (input.equals("no")) {
                    run = false;
                }else if(input.equals("yes")){
                    run = true;
                    if (count>=10){
                        System.out.println("We have reached our maximum number of doctors that can be allocated.");
                    }
                }else{
                        System.out.println("You have entered an invalid value...");
                        System.out.println("Therefore you're redirected to the main menu considering security regulations.");
                        run = false;
                     }

                }

        }catch(Exception e){
            System.out.println("Please enter a valid input, you're redirected to the main menu");
        }


    }

    @Override
    public void deletingADoctor() {

        System.out.println("Enter the medical licence number of the doctor :  ");
        String licenceNumber = scanner.next();
        for (int i = 0; i < docDetails.size(); i++){
            if(licenceNumber.equals(docDetails.get(i).getMedicalLicenceNumber())){
                System.out.println("The doctor matched with " + docDetails.get(i).getMedicalLicenceNumber() + " has been deleted.");
                docDetails.remove(i);
                System.out.println("The total number of doctors in the centre is " + docDetails.size() + " now.");
                count--;
            }
        }
        System.out.println("There is no doctor matches this licence number.");



    }

    @Override
    public void printingTheDoctors() {

        System.out.println("Here is the doctor's information:");
        System.out.println("---------------------------------");
        System.out.println("\n");

        ArrayList<String> docDetails1 = new ArrayList<String>();
        for (int i = 0; i < docDetails.size(); i++) {
            String doctor1 = docDetails.get(i).getSurname();
            docDetails1.add(doctor1);
        }
//        System.out.println(docDetails1);
        Collections.sort(docDetails1);
//        System.out.println(docDetails1);

        for (String r : docDetails1) {
            for (int k = 0; k < docDetails.size(); k++){
                if (r == docDetails.get(k).getSurname()){
                    System.out.println("Name: "+ docDetails.get(k).getName());
                    System.out.println("Surname: "+ docDetails.get(k).getSurname());
                    System.out.println("Medical Licence Number: "+ docDetails.get(k).getMedicalLicenceNumber());
                    System.out.println("Date Of Birth: "+ docDetails.get(k).getDateOfBirth());
                    System.out.println("Contact Number: "+ docDetails.get(k).getMobileNumber());
                    System.out.println("Doctor's specialisation: "+ docDetails.get(k).getSpecialisation());
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                }
            }

        }

    }

    @Override
    public void savingInAFile() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("List of the doctors");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(docDetails);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            System.out.println("Data saved successfully!");
        }

    }

    @Override
    public void loadingDataFile() {

            try {
                FileInputStream fileInputStream = new FileInputStream("List of the doctors");
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

                docDetails = (ArrayList) inputStream.readObject();

                inputStream.close();
                fileInputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }finally {
                System.out.println("Data loaded successfully!");
            }
            count = docDetails.size();

    }

    @Override
    public void menu() {
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎                           SKIN CONSULTATION CENTRE                             ∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎                                                                                ∎");
        System.out.println("∎                  * Press 1 for adding a doctor.                                ∎");
        System.out.println("∎                  * Press 2 for deleting a doctor.                              ∎");
        System.out.println("∎                  * Press 3 for printing the doctors' list.                     ∎");
        System.out.println("∎                  * Press 4 for saving details in a file.                       ∎");
        System.out.println("∎                  * Press 5 for loading the previous data.                      ∎");
        System.out.println("∎                  * Press 6 for the GUI.                                        ∎");
        System.out.println("∎                  * Press 7 for exiting from the system.                        ∎");
        System.out.println("∎                                                                                ∎");
        System.out.println("∎                                                                                ∎");
        System.out.println("∎                                                                                ∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("What is your preference? ");

        Scanner scanner1 = new Scanner(System.in);
        String inputs = scanner1.next();
        if (inputs.equals("1")){
            if (count==10){
                System.out.println("We have reached our maximum number of doctors that can be allocated.");
                westminsterSkinConsultationManager.menu();
            }else {
                westminsterSkinConsultationManager.addingADoctor();
                westminsterSkinConsultationManager.menu();
            }


        } else if (inputs.equals("2")) {
            westminsterSkinConsultationManager.deletingADoctor();
            westminsterSkinConsultationManager.menu();


        } else if (inputs.equals("3")) {
            westminsterSkinConsultationManager.printingTheDoctors();
            westminsterSkinConsultationManager.menu();


        } else if (inputs.equals("4")) {
            westminsterSkinConsultationManager.savingInAFile();
            westminsterSkinConsultationManager.menu();


        } else if (inputs.equals("5")) {
            westminsterSkinConsultationManager.loadingDataFile();
            westminsterSkinConsultationManager.menu();


        } else if (inputs.equals("6")) {
            GUIForTheSystem guiForTheSystem = new GUIForTheSystem();
            westminsterSkinConsultationManager.menu();

        } else if (inputs.equals("7")) {
            System.out.println("Are you sure about exiting the system? (yes/no)");
            String inputs2 = scanner1.next();
            inputs2 = inputs2.toLowerCase();
            if (inputs2.equals("yes")){
                System.out.println("You have successfully exited from the system.");
                System.exit(0);
            } else if (inputs2.equals("no")) {
                System.out.println("You're redirected to the main menu.");
                westminsterSkinConsultationManager.menu();
            }else {
                System.out.println("Please enter a valid input, You're redirected to the main menu.");
                westminsterSkinConsultationManager.menu();
            }

        } else {
            System.out.println("Please enter a valid input! " +
                    "You're redirected to the main menu.");
            westminsterSkinConsultationManager.menu();
        }


    }

    public static void main(String[] args) {
    westminsterSkinConsultationManager.menu();

    }

}
