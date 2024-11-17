package pro.sky.employeesList.services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);


    Employee deleteEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName, int salary, int department);



    Collection<Employee> findAll();

}
