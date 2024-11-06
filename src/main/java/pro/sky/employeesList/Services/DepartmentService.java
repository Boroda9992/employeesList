package pro.sky.employeesList.Services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;

import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {
    Employee findMaxSalary (int departmentId);
    Employee findMinSalary (int departmentId);
    List<Employee> listDepartment (int departmentId);
    Map<Integer, List<Employee>> listAllByDepartment();

}
