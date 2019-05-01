package employeespringbootv2.demo.service;

import employeespringbootv2.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service("service")
public interface Myservice {

    public Iterable<Employee> getEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public Employee addNewEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public void deleteEmployeeById(Long empid);
    public void deleteAllEmployees();
}
