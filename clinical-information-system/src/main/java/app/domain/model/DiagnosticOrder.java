package app.domain.model;

public class DiagnosticOrder {
    private final long itemNumber;              // Número ítem dentro de la orden
    private final ClinicalOrder clinicalOrder;  // Referencia a la orden clínica
    private final Long testId;                  // Id que apunta a DiagnosticTest (Inventory)
    private final int quantity;
    private final boolean requiresSpecialist;
    private final String specialistTypeId;      // Si requiere especialista

    public DiagnosticOrder(long itemNumber, ClinicalOrder clinicalOrder, Long testId, int quantity,
                           boolean requiresSpecialist, String specialistTypeId) {
        if (clinicalOrder == null) {
            throw new IllegalArgumentException("La orden clínica no puede ser nula.");
        }
        if (testId == null) {
            throw new IllegalArgumentException("El ID del examen es obligatorio.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0.");
        }
        if (requiresSpecialist && (specialistTypeId == null || specialistTypeId.isBlank())) {
            throw new IllegalArgumentException("Debe indicar el tipo de especialista si el examen lo requiere.");
        }

        this.itemNumber = itemNumber;
        this.clinicalOrder = clinicalOrder;
        this.testId = testId;
        this.quantity = quantity;
        this.requiresSpecialist = requiresSpecialist;
        this.specialistTypeId = specialistTypeId;
    }

    public long getItemNumber() { return itemNumber; }
    public ClinicalOrder getClinicalOrder() { return clinicalOrder; }
    public Long getTestId() { return testId; }
    public int getQuantity() { return quantity; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
}
