package app.domain.model;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private Long id;
    private String fullName;
    private String documentId;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
    private Role role;
    private Login login;

    public Employee(String fullName, Long id, String documentId, String email, String phone,
                    String address, LocalDate birthDate, Role role, Login login) {

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }

        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }

        if (documentId == null || documentId.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El correo del empleado no puede estar vacío.");
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío.");
        }

        if (phone.length() > 10) {
            throw new IllegalArgumentException("El teléfono del empleado no puede tener más de 10 dígitos.");
        }

        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono del empleado solo debe contener números.");
        }

        if (address != null && address.length() > 30) {
            throw new IllegalArgumentException("La dirección no puede tener más de 30 caracteres.");
        }

        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age > 150) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede tener más de 150 años.");
        }

        if (role == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }

        if (login == null) {
            throw new IllegalArgumentException("Las credenciales de login no pueden ser nulas.");
        }


        this.fullName = fullName;
        this.id = id;
        this.documentId = documentId;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.role = role;
        this.login = login;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
