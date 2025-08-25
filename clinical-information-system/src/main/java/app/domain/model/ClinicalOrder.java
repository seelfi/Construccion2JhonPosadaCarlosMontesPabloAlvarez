package app.domain.model;

import java.time.LocalDateTime;

public class ClinicalOrder {
    private final long orderId;
    private Patient patient;
    private Employee employee;
    private LocalDateTime dateCreation;
    private DiagnosticTest diagnosticTest;

    public ClinicalOrder(Long orderId, Patient patient, Employee employee,
                         LocalDateTime dateCreation, DiagnosticTest diagnosticTest) {
        if (orderId == null) {
            throw new IllegalArgumentException("El ID de la orden no puede ser nulo.");
        }
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }
        if (employee == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        if (employee.getRole() != Role.DOCTOR) {
            throw new IllegalArgumentException("Solo un médico puede generar una orden clínica.");
        }
        if (dateCreation == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ser nula.");
        }
        if (diagnosticTest == null) {
            throw new IllegalArgumentException("Debe asociarse un examen diagnóstico a la orden.");
        }

        this.orderId = orderId;
        this.patient = patient;
        this.employee = employee;
        this.dateCreation = dateCreation;
        this.diagnosticTest = diagnosticTest;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public DiagnosticTest getDiagnosticTest() {
        return diagnosticTest;
    }

    public void setDiagnosticTest(DiagnosticTest diagnosticTest) {
        this.diagnosticTest = diagnosticTest;
    }

    public boolean isCreatedByDoctor(Employee doctor) {
        return this.employee.equals(doctor);
    }

    public boolean isForPatient(Patient patient) {
        return this.patient.equals(patient);
    }
}
