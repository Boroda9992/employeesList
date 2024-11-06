package pro.sky.employeesList.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeesList.Model.Employee;
import pro.sky.employeesList.Services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("max-salary")
    public Employee findMaxSalary(@RequestParam int departmentId){
        return departmentService.findMaxSalary(departmentId);
    }

    @RequestMapping("min-salary")
    public Employee findMinSalary(@RequestParam int departmentId){
        return departmentService.findMinSalary(departmentId);
    }

    @RequestMapping("dep-list")
    public List<Employee> listDepartment(@RequestParam int departmentId){
        return departmentService.listDepartment(departmentId);
    }

    @RequestMapping("all")
    public Map<Integer, List<Employee>> listAllByDepartment(){
        return departmentService.listAllByDepartment();
    }

}
