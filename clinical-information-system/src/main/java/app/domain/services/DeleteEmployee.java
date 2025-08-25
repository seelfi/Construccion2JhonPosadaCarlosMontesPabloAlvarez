package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.ports.EmployeePort;

public class DeleteEmployee {
    private final EmployeePort employeePort;

    public DeleteEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void execute(String documentId, Employee currentUser) throws Exception {
        // Solo HR puede eliminar empleados
        if (currentUser.getRole() != Role.HR) {
            throw new Exception("No tiene permisos para eliminar empleados.");
        }

        if (employeePort.findByDocument(documentId) == null) {
            throw new Exception("No existe un empleado con el documento: " + documentId);
        }

        employeePort.delete(documentId);
    }
}


