package employeespringbootv2.demo.service;

import employeespringbootv2.demo.entity.Employee;
import employeespringbootv2.demo.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyServiceImp implements Myservice {
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public Iterable<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employee addNewEmployee(Employee emp) {
        return employeeDAO.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeDAO.save(emp);
    }

    @Override
    public void deleteEmployeeById(Long empid) {
      employeeDAO.deleteById(empid);
    }

    @Override
    public void deleteAllEmployees() {
       employeeDAO.deleteAll();
    }
}
