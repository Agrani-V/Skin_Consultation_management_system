package com.company;
import java.time.LocalDate;
import java.util.Date;

public class Doctor extends Person  {

    private String specialisation;

    private String medicalLicenceNumber;

    public Doctor() {
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String specialisation, String medicalLicenceNumber) {
        this.setName(name);
        this.setSurname(surname);
        this.setDateOfBirth(dateOfBirth);
        this.setMobileNumber(mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }


    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }


}
