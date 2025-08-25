package app.domain.model;

import java.time.LocalDate;
import java.time.Period;

public class Patient {
    private String documentId;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String phone;
    private String email;
    private EmergencyContact emergencyContact;
    private MedicalInsurance insurance;

    public Patient(String documentId, String fullName, LocalDate birthDate, Gender gender,
                   String address, String phone, String email,
                   EmergencyContact emergencyContact, MedicalInsurance insurance) {

        if (documentId == null || documentId.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }

        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age > 150) {
            throw new IllegalArgumentException("La edad del paciente no puede superar los 150 años.");
        }

        if (gender == null) {
            throw new IllegalArgumentException("El género no puede ser nulo.");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("La dirección no puede ser nula ni superar los 30 caracteres.");
        }

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos.");
        }

        if (email != null && !email.isBlank()) {
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
            }
        }

        if (emergencyContact == null) {
            throw new IllegalArgumentException("Debe tener un contacto de emergencia.");
        }

        if (insurance == null) {
            throw new IllegalArgumentException("El paciente debe tener una póliza de seguro.");
        }

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


    public String getDocumentId() { return documentId; }
    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public Gender getGender() { return gender; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public MedicalInsurance getInsurance() { return insurance; }


    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("La dirección no puede ser nula ni superar los 30 caracteres.");
        }
        this.address = address;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos.");
        }
        this.phone = phone;
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank()) {
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
            }
        }
        this.email = email;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        if (emergencyContact == null) {
            throw new IllegalArgumentException("Debe tener un contacto de emergencia.");
        }
        this.emergencyContact = emergencyContact;
    }

    public void setInsurance(MedicalInsurance insurance) {
        if (insurance == null) {
            throw new IllegalArgumentException("El paciente debe tener una póliza de seguro.");
        }
        this.insurance = insurance;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "documentId='" + documentId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContact=" + emergencyContact +
                ", insurance=" + insurance +
                '}';
    }
}

