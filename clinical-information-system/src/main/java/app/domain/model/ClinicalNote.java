package app.domain.model;

import java.time.LocalDateTime;
import java.util.*;

public class ClinicalNote {

    private final String patientDocumentId;      // Clave principal en el diccionario
    private final LocalDateTime date;            // Subclave
    private final String consultationReason;
    private final String symptomatology;
    private final String diagnosis;
    private final String doctorDocumentId;

    private final List<MedicationOrder> medications;
    private final List<ProcedureOrder> procedures;
    private final List<DiagnosticTest> diagnostics;

    public ClinicalNote(String patientDocumentId,
                        LocalDateTime date,
                        String consultationReason,
                        String symptomatology,
                        String diagnosis,
                        String doctorDocumentId,
                        List<MedicationOrder> medications,
                        List<ProcedureOrder> procedures,
                        List<DiagnosticTest> diagnostics) {

        if (patientDocumentId == null || patientDocumentId.isBlank()) {
            throw new IllegalArgumentException("La cédula del paciente no puede estar vacía.");
        }

        if (date == null) {
            throw new IllegalArgumentException("La fecha de atención no puede ser nula.");
        }

        if (consultationReason == null || consultationReason.isBlank()) {
            throw new IllegalArgumentException("El motivo de consulta no puede estar vacío.");
        }

        if (symptomatology == null || symptomatology.isBlank()) {
            throw new IllegalArgumentException("La sintomatología no puede estar vacía.");
        }

        if (diagnosis == null || diagnosis.isBlank()) {
            throw new IllegalArgumentException("El diagnóstico no puede estar vacío.");
        }

        if (doctorDocumentId == null || !doctorDocumentId.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("La cédula del médico debe tener entre 1 y 10 dígitos numéricos.");
        }


        boolean hasDiagnostics = diagnostics != null && !diagnostics.isEmpty();
        boolean hasTreatments = (medications != null && !medications.isEmpty()) ||
                (procedures != null && !procedures.isEmpty());

        if (hasDiagnostics && hasTreatments) {
            throw new IllegalArgumentException("No se pueden registrar medicamentos o procedimientos cuando hay ayuda diagnóstica solicitada.");
        }

        // Asignaciones
        this.patientDocumentId = patientDocumentId;
        this.date = date;
        this.consultationReason = consultationReason;
        this.symptomatology = symptomatology;
        this.diagnosis = diagnosis;
        this.doctorDocumentId = doctorDocumentId;
        this.medications = medications != null ? medications : Collections.emptyList();
        this.procedures = procedures != null ? procedures : Collections.emptyList();
        this.diagnostics = diagnostics != null ? diagnostics : Collections.emptyList();
    }

    // Getters
    public String getPatientDocumentId() {
        return patientDocumentId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public String getSymptomatology() {
        return symptomatology;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDoctorDocumentId() {
        return doctorDocumentId;
    }

    public List<MedicationOrder> getMedications() {
        return Collections.unmodifiableList(medications);
    }

    public List<ProcedureOrder> getProcedures() {
        return Collections.unmodifiableList(procedures);
    }

    public List<DiagnosticTest> getDiagnostics() {
        return Collections.unmodifiableList(diagnostics);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("cedulaPaciente", patientDocumentId);
        map.put("fecha", date.toString());
        map.put("motivoConsulta", consultationReason);
        map.put("sintomatologia", symptomatology);
        map.put("diagnostico", diagnosis);
        map.put("cedulaMedico", doctorDocumentId);
        map.put("medicamentos", medications);
        map.put("procedimientos", procedures);
        map.put("ayudasDiagnosticas", diagnostics);
        return map;
    }

    @Override
    public String toString() {
        return "ClinicalNote{" +
                "paciente='" + patientDocumentId + '\'' +
                ", fecha=" + date +
                ", motivoConsulta='" + consultationReason + '\'' +
                ", sintomatologia='" + symptomatology + '\'' +
                ", diagnostico='" + diagnosis + '\'' +
                ", medico='" + doctorDocumentId + '\'' +
                '}';
    }
}



