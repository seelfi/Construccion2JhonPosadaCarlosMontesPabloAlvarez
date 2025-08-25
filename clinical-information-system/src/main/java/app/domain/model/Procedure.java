package app.domain.model;

public class Procedure {
    private final String procedureId;
    private String name;
    private double cost;
    private boolean requiresSpecialist;

    public Procedure(String procedureId, String name, double cost, boolean requiresSpecialist) {
        if (procedureId == null || procedureId.isBlank()) {
            throw new IllegalArgumentException("El ID del procedimiento no puede estar vacío.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo.");
        }
        this.procedureId = procedureId;
        this.name = name;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getProcedureId() { return procedureId; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }

    public void setName(String name) { this.name = name; }
    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("El costo no puede ser negativo.");
        this.cost = cost;
    }
    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }
}

