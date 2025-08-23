package app.domain.model;

import java.time.LocalDate;

public class Patient {
    private String documentId;
    private String fullName;
    private String birthDate; // Usa LocalDate si puedes
    private String gender;
    private String address;
    private String phone;
    private String email;
    private EmergencyContact emergencyContact;
    private MedicalInsurance insurance;

    public Patient(String documentId, String fullName, String birthDate, String gender, String address, String phone, String email, EmergencyContact emergencyContact, MedicalInsurance insurance) {
        this.documentId = documentId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.emergencyContact = emergencyContact;
        this.insurance = insurance;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public MedicalInsurance getInsurance() {
        return insurance;
    }

    public void setInsurance(MedicalInsurance insurance) {
        this.insurance = insurance;
    }
}
