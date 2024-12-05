package pro.sky.employeesList.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.model.Employee;
import pro.sky.employeesList.services.DepartmentService;
import pro.sky.employeesList.services.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public int getEmployeeSalarySum(int departmentId) {
        return employeeService.findAll()
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }

    @Override
    public List<Employee> getAllEmployeesByDepartmentId(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .toList();

    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartmentId() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
