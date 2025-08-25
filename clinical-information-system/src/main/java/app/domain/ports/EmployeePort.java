package app.domain.ports;

import app.domain.model.Employee;
import java.util.List;

public interface EmployeePort {
    Employee findByDocument(String documentId) throws Exception;
    Employee findByUserName(String username) throws Exception;
    void save(Employee employee) throws Exception;
    void delete(String documentId) throws Exception;
    void update(Employee employee) throws Exception;
    List<Employee> findAll() throws Exception;
}
