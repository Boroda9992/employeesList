package pro.sky.employeesList.Services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.Exceptions.EmployeeNotFoundException;
import pro.sky.employeesList.Exceptions.EmployeeStorageIsFullException;
import pro.sky.employeesList.Services.EmployeeService;

import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employeesList.size() == employeeCapacity)
            throw new EmployeeStorageIsFullException("Employee storage is full!");
        if (employeesList.contains(new Employee(firstName, lastName)))
            throw new EmployeeAlreadyAddedException("This employee already added!");
        employeesList.add(new Employee(firstName, lastName));
        return employeeToAdd;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employeeToDelete = new Employee(firstName, lastName);
        if (employeesList.contains(employeeToDelete)) {
            employeesList.remove(employeeToDelete);
            return employeeToDelete;
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employeesList.contains(employeeToFind)) {
            return employeeToFind;
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Collection<Employee> listEmployees() {
        return Collections.unmodifiableList(employeesList);
    }
}
