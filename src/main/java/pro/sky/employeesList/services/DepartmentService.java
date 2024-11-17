package pro.sky.employeesList.services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.model.Employee;

import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {
    Employee findMaxSalary (int departmentId);
    Employee findMinSalary (int departmentId);
    List<Employee> listDepartment (int departmentId);
    Map<Integer, List<Employee>> listAllByDepartment();

}
