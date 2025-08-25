package app.domain.model;

public class DiagnosticTest {
    private final Long testId;
    private String name;
    private String type;
    private double cost;

    public DiagnosticTest(Long testId, String name, String type, double cost) {
        if (testId == null) throw new IllegalArgumentException("El ID del examen no puede ser nulo.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (type == null || type.isBlank()) throw new IllegalArgumentException("El tipo no puede estar vacío.");
        if (cost < 0) throw new IllegalArgumentException("El costo no puede ser negativo.");

        this.testId = testId;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public Long getTestId() { return testId; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getCost() { return cost; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("El costo no puede ser negativo.");
        this.cost = cost;
    }
}


