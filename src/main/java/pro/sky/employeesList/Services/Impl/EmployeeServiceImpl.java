package pro.sky.employeesList.Services.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.Exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements pro.sky.employeesList.Services.EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
    @PostConstruct
    public void initEmployees(){
        addEmployee("Ivan", "Petrov11", 50000, 1);
        addEmployee("Ivan", "Petrov12", 60000, 1);
        addEmployee("Ivan", "Petrov21", 50000, 2);
        addEmployee("Ivan", "Petrov22", 60000, 2);
        addEmployee("Ivan", "Petrov23", 70000, 2);
        addEmployee("Ivan", "Petrov31", 50000, 3);
        addEmployee("Ivan", "Petrov32", 60000, 3);
        addEmployee("Ivan", "Petrov33", 70000, 3);
        addEmployee("Ivan", "Petrov34", 80000, 3);
        addEmployee("Ivan", "Petrov41", 500000, 4);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employeeToAdd = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employeeToAdd.getFULL_NAME()))
            throw new EmployeeAlreadyAddedException("This employee already added!");
        employeeMap.put(employeeToAdd.getFULL_NAME(), employeeToAdd);
        return employeeToAdd;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName, int salary, int department) {
        Employee employeeToDelete = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employeeToDelete.getFULL_NAME())) {
            return employeeMap.remove(employeeToDelete.getFULL_NAME());
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee employeeToFind = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employeeToFind.getFULL_NAME())) {
            return employeeMap.get(employeeToFind.getFULL_NAME());
        }
        throw new EmployeeNotFoundException("Employee not found!");

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
