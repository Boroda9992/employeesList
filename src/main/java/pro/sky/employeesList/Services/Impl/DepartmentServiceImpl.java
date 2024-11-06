package pro.sky.employeesList.Services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Services.DepartmentService;
import pro.sky.employeesList.Services.EmployeeService;

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
    public Employee findMaxSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee ::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findMinSalary(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee ::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> listDepartment(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .toList();

    }

    @Override
    public Map<Integer, List<Employee>> listAllByDepartment() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee ::getDepartment));
    }
}
