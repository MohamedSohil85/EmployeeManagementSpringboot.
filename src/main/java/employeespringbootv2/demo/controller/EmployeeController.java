package employeespringbootv2.demo.controller;

import employeespringbootv2.demo.entity.Employee;
import employeespringbootv2.demo.service.MyServiceImp;
import employeespringbootv2.demo.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    Myservice service;

    @RequestMapping(value = "/allEmployees",method = RequestMethod.GET)
    public Iterable<Employee>getAllEmployees(){
        return service.getEmployees();
    }
    @RequestMapping(value = "addEmployee",method = RequestMethod.POST)
    public Employee saveNewEmployee(@RequestBody Employee employee)throws Exception{
               getAllEmployees().forEach(employee1 -> {
                   if(employee1.equals(employee))
                       try {
                           throw new Exception("Employee already exists !");
                       } catch (Exception e) {
                           e.printStackTrace();
                       }

               });
                return service.addNewEmployee(employee);
    }
    @RequestMapping(value = "/getEmployeeById/{id}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Long id) throws Exception {
        Optional<Employee>employee=service.getEmployeeById(id);
        if(!employee.isPresent())
        {
            throw new Exception("Couldn't find the Employee with this Id");
        }
        return employee.get();
    }
    @RequestMapping(value = "/deleteEmployeeById/{id}",method = RequestMethod.DELETE)
        public void deleteEmployeeById(@PathVariable Long id)throws Exception{
            Optional<Employee>employee=service.getEmployeeById(id);

            if (!employee.isPresent()){
                throw new Exception("Employee not found !");
        }
       service.deleteEmployeeById(id);

    }
    @RequestMapping(value = "/deleteAllEmployees",method = RequestMethod.DELETE)
    public void deleteEmployees(){
        service.deleteAllEmployees();
    }
    @RequestMapping(value = "/updateEmployee/{id}",method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee emp) throws Exception{
        Optional<Employee>employee=service.getEmployeeById(id);
        if(!employee.isPresent()){
            throw new Exception("Employee not found !");
        }else {
            emp.setName(employee.get().getName());
            emp.setFirstname(employee.get().getFirstname());
            emp.setSalary(employee.get().getSalary());
            emp.setId(employee.get().getId());
            return service.updateEmployee(emp);
        }
    }
}
