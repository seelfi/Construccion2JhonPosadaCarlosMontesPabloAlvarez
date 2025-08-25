package app.domain.model;

public class MedicationOrder {
    private final long itemNumber;              // Número de ítem en la orden
    private final ClinicalOrder clinicalOrder;  // Referencia a la orden clínica
    private final String medicationId;          // ID de catálogo (Medication en Inventory)
    private final String dose;
    private final String duration;

    public MedicationOrder(long itemNumber, ClinicalOrder clinicalOrder, String medicationId, String dose, String duration) {
        if (clinicalOrder == null) {
            throw new IllegalArgumentException("La orden clínica no puede ser nula.");
        }
        if (medicationId == null || medicationId.isBlank()) {
            throw new IllegalArgumentException("El ID del medicamento es obligatorio.");
        }
        if (dose == null || dose.isBlank()) {
            throw new IllegalArgumentException("La dosis es obligatoria.");
        }
        if (duration == null || duration.isBlank()) {
            throw new IllegalArgumentException("La duración es obligatoria.");
        }

        this.itemNumber = itemNumber;
        this.clinicalOrder = clinicalOrder;
        this.medicationId = medicationId;
        this.dose = dose;
        this.duration = duration;
    }

    public long getItemNumber() {
        return itemNumber;
    }

    public ClinicalOrder getClinicalOrder() {
        return clinicalOrder;
    }

    public String getMedicationId() {
        return medicationId;
    }

    public String getDose() {
        return dose;
    }

    public String getDuration() {
        return duration;
    }
}



