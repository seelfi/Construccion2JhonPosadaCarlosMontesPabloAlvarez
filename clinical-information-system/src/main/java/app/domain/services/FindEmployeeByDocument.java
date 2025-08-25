package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.ports.EmployeePort;

public class FindEmployeeByDocument {
    private final EmployeePort employeePort;

    public FindEmployeeByDocument(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee execute(String documentId, Employee currentUser) throws Exception {
        // Solo HR puede consultar empleados
        if (currentUser.getRole() != Role.HR) {
            throw new Exception("No tiene permisos para consultar empleados.");
        }

        Employee employee = employeePort.findByDocument(documentId);
        if (employee == null) {
            throw new Exception("Empleado no encontrado con el documento: " + documentId);
        }

        return employee;
    }
}

