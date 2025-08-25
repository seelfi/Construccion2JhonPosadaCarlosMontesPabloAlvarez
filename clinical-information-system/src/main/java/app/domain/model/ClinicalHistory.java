package app.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClinicalHistory {
    private final Patient patient;
    private final List<ClinicalNote> attentionRecords;
    private final Long historyId;

    public ClinicalHistory(Patient patient, List<ClinicalNote> attentionRecords, Long historyId) {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }
        if (attentionRecords == null) {
            throw new IllegalArgumentException("La lista de registros de atención no puede ser nula.");
        }
        if (historyId == null || historyId <= 0) {
            throw new IllegalArgumentException("El ID de la historia clínica no puede ser nulo.");
        }

        this.patient = patient;
        this.attentionRecords = new ArrayList<>(attentionRecords);
        this.historyId = historyId;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<ClinicalNote> getAttentionRecords() {
        return Collections.unmodifiableList(attentionRecords);
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void addRegister(ClinicalNote register) {
        if (register == null) {
            throw new IllegalArgumentException("No se puede agregar un registro de atención nulo.");
        }
        this.attentionRecords.add(register);
    }
}
