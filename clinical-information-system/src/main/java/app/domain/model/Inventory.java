package app.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    // Colecciones en memoria (pueden cambiarse luego por repositorios/DB)
    private final Map<String, Medication> medications = new HashMap<>();
    private final Map<String, Procedure> procedures = new HashMap<>();
    private final Map<Long, DiagnosticTest> diagnosticTests = new HashMap<>();

    // ========== MEDICATION ==========
    public void addMedication(Medication medication) {
        if (medications.containsKey(medication.getMedicationId())) {
            throw new IllegalArgumentException("El medicamento ya existe en el inventario.");
        }
        medications.put(medication.getMedicationId(), medication);
    }

    public Medication getMedication(String medicationId) {
        return medications.get(medicationId);
    }

    public void updateMedicationCost(String medicationId, double newCost) {
        Medication med = medications.get(medicationId);
        if (med == null) throw new IllegalArgumentException("El medicamento no existe.");
        med.setCost(newCost);
    }

    // ========== PROCEDURE ==========
    public void addProcedure(Procedure procedure) {
        if (procedures.containsKey(procedure.getProcedureId())) {
            throw new IllegalArgumentException("El procedimiento ya existe en el inventario.");
        }
        procedures.put(procedure.getProcedureId(), procedure);
    }

    public Procedure getProcedure(String procedureId) {
        return procedures.get(procedureId);
    }

    // ========== DIAGNOSTIC TEST ==========
    public void addDiagnosticTest(DiagnosticTest test) {
        if (diagnosticTests.containsKey(test.getTestId())) {
            throw new IllegalArgumentException("El examen ya existe en el inventario.");
        }
        diagnosticTests.put(test.getTestId(), test);
    }

    public DiagnosticTest getDiagnosticTest(Long testId) {
        return diagnosticTests.get(testId);
    }
}


