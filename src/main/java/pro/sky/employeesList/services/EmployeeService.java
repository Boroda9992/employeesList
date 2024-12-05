package pro.sky.employeesList.services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.exceptions.EmployeeNotFoundException;
import pro.sky.employeesList.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeesList.model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee deleteEmployee(String firstName, String lastName, int salary, int department) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName, int salary, int department) throws EmployeeNotFoundException;

    Collection<Employee> findAll();

}
