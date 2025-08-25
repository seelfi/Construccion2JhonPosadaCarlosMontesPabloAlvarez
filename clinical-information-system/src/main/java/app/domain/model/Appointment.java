package app.domain.model;

import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Employee doctor;
    private LocalDateTime date;
    private String reason;

    public Appointment(Patient patient, Employee doctor, LocalDateTime date, String reason) {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no puede ser nulo.");
        }

        if (doctor.getRole() != Role.DOCTOR) {
            throw new IllegalArgumentException("Solo se pueden asignar empleados con rol DOCTOR a una cita.");
        }

        if (date == null || date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la cita debe ser en el futuro.");
        }

        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("El motivo de la cita no puede estar vacío.");
        }

        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.reason = reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
