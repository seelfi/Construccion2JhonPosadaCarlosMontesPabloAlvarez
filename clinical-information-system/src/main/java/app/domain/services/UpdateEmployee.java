package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.ports.EmployeePort;

public class UpdateEmployee {
    private final EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void execute(Employee employee, Employee currentUser) throws Exception {
        // Solo HR puede actualizar empleados
        if (currentUser.getRole() != Role.HR) {
            throw new Exception("No tiene permisos para actualizar empleados.");
        }

        if (employeePort.findByDocument(employee.getDocumentId()) == null) {
            throw new Exception("No existe un empleado con ese documento.");
        }

        employeePort.update(employee);
    }
}



