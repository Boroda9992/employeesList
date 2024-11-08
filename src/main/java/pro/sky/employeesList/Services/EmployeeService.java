package pro.sky.employeesList.Services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);


    Employee deleteEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName, int salary, int department);



    Collection<Employee> findAll();

}
