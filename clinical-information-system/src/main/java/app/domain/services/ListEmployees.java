package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.Role;
import app.domain.ports.EmployeePort;
import java.util.List;

public class ListEmployees {
    private final EmployeePort employeePort;

    public ListEmployees(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public List<Employee> execute(Employee currentUser) throws Exception {
        // Solo HR puede listar empleados
        if (currentUser.getRole() != Role.HR) {
            throw new Exception("No tiene permisos para listar empleados.");
        }

        return employeePort.findAll();
    }
}
