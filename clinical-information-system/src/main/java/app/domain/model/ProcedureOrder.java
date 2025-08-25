package app.domain.model;

public class ProcedureOrder {
    private final long itemNumber;
    private final ClinicalOrder clinicalOrder;
    private final String procedureId;
    private final int quantity;
    private final String frequency;
    private final boolean requiresSpecialist;
    private final String specialistTypeId;

    public ProcedureOrder(long itemNumber, ClinicalOrder clinicalOrder, String procedureId, int quantity, String frequency,
                          boolean requiresSpecialist, String specialistTypeId) {
        if (clinicalOrder == null) {
            throw new IllegalArgumentException("La orden clínica no puede ser nula.");
        }
        if (procedureId == null || procedureId.isBlank()) {
            throw new IllegalArgumentException("El ID del procedimiento es obligatorio.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
        if (frequency == null || frequency.isBlank()) {
            throw new IllegalArgumentException("La frecuencia es obligatoria.");
        }
        if (requiresSpecialist && (specialistTypeId == null || specialistTypeId.isBlank())) {
            throw new IllegalArgumentException("Debe indicar el tipo de especialista si el procedimiento lo requiere.");
        }

        this.itemNumber = itemNumber;
        this.clinicalOrder = clinicalOrder;
        this.procedureId = procedureId;
        this.quantity = quantity;
        this.frequency = frequency;
        this.requiresSpecialist = requiresSpecialist;
        this.specialistTypeId = specialistTypeId;
    }

    public long getItemNumber() { return itemNumber; }
    public ClinicalOrder getClinicalOrder() { return clinicalOrder; }
    public String getProcedureId() { return procedureId; }
    public int getQuantity() { return quantity; }
    public String getFrequency() { return frequency; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
}



