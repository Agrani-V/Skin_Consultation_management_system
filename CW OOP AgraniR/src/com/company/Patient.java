package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Person{
    private String patientId;

    public static ArrayList<Patient> patientInfo = new ArrayList<>();


    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientId){
        this.setName(name);
        this.setSurname(surname);
        this.setDateOfBirth(dateOfBirth);
        this.setMobileNumber(mobileNumber);
        this.setPatientId(patientId);

    }

    public Patient(){

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }


}
