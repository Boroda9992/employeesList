package pro.sky.employeesList.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.Exceptions.EmployeeNotFoundException;
import pro.sky.employeesList.Exceptions.EmployeeStorageIsFullException;
import pro.sky.employeesList.Services.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("employee")
public class EmployeeListController {

    private final EmployeeService employeeService;

    public EmployeeListController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        return employeeService.addEmployee(firstName, lastName);
    }


    @GetMapping("remove")
    public Employee deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> listEmployees() {
        return employeeService.listEmployees();
    }
}
