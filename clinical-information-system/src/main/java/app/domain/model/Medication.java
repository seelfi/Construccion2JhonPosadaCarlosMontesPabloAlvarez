package app.domain.model;

public class Medication {
    private final String medicationId;
    private String name;
    private double cost;

    public Medication(String medicationId, String name, double cost) {
        if (medicationId == null || medicationId.isBlank()) {
            throw new IllegalArgumentException("El ID del medicamento no puede estar vacío.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del medicamento no puede estar vacío.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("El costo del medicamento no puede ser negativo.");
        }
        this.medicationId = medicationId;
        this.name = name;
        this.cost = cost;
    }

    public String getMedicationId() {
        return medicationId;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.name = name;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo.");
        }
        this.cost = cost;
    }
}

