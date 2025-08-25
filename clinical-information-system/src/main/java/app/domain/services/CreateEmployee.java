package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.ports.EmployeePort;

public class CreateEmployee {
    private final EmployeePort employeePort;

    public CreateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void execute(Employee newEmployee, Employee currentUser) throws Exception {
        // Solo HR puede crear empleados
        if (currentUser.getRole() != Role.HR) {
            throw new Exception("No tiene permisos para crear empleados.");
        }

        if (employeePort.findByDocument(newEmployee.getDocumentId()) != null) {
            throw new Exception("Ya existe una persona registrada con esa cédula.");
        }

        if (employeePort.findByUserName(newEmployee.getLogin().getUsername()) != null) {
            throw new Exception("Ya existe una persona registrada con ese nombre de usuario.");
        }

        employeePort.save(newEmployee);
    }
}

