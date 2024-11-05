package pro.sky.employeesList.Services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

}
