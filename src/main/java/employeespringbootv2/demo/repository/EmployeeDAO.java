package employeespringbootv2.demo.repository;

import employeespringbootv2.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDAO extends CrudRepository<Employee,Long> {



}
