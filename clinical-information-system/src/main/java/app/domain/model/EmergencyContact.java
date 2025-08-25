package app.domain.model;

public class EmergencyContact {
    private String firstName;
    private String lastName;
    private String relationship;
    private String phone;

    public EmergencyContact(String firstName, String lastName, String relationship, String phone) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("El nombre del contacto no puede estar vacío.");
        }

        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("El apellido del contacto no puede estar vacío.");
        }

        if (relationship == null || relationship.isBlank()) {
            throw new IllegalArgumentException("La relación con el paciente no puede estar vacía.");
        }

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos numéricos.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.phone = phone;
    }

    // Getters y setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.lastName = lastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        if (relationship == null || relationship.isBlank()) {
            throw new IllegalArgumentException("La relación no puede estar vacía.");
        }
        this.relationship = relationship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos numéricos.");
        }
        this.phone = phone;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}


