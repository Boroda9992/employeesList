package pro.sky.employeesList.Services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.Exceptions.EmployeeNotFoundException;
import pro.sky.employeesList.Exceptions.EmployeeStorageIsFullException;
import pro.sky.employeesList.Services.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employeeToAdd.getFullName()))
            throw new EmployeeAlreadyAddedException("This employee already added!");
        employeeMap.put(employeeToAdd.getFullName(), employeeToAdd);
        return employeeToAdd;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employeeToDelete = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employeeToDelete.getFullName())) {
            return employeeMap.remove(employeeToDelete.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employeeToFind.getFullName())) {
            return employeeMap.get(employeeToFind.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
