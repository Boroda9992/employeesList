package pro.sky.employeesList.Services;

import org.springframework.stereotype.Service;
import pro.sky.employeesList.Model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public interface EmployeeService {
    int employeeCapacity = 9;
    List<Employee> employeesList = new ArrayList<>(employeeCapacity);

    Employee addEmployee (String firstName, String lastName);
    Employee deleteEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
    Collection<Employee> listEmployees ();

}
