package pro.sky.employeesList.services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.model.Employee;

import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {
    int getEmployeeSalarySum (int departmentId);
    Employee getEmployeeWithMaxSalary(int departmentId);
    Employee getEmployeeWithMinSalary(int departmentId);
    List<Employee> getAllEmployeesByDepartmentId(int departmentId);
    Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartmentId();

}
