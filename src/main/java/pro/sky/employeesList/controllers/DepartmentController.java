package pro.sky.employeesList.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeesList.model.Employee;
import pro.sky.employeesList.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @RequestMapping("{departmentId}/employees")
    public List<Employee> listDepartment(@PathVariable int departmentId){
        return departmentService.getAllEmployeesByDepartmentId(departmentId);
    }

    @RequestMapping("employees")
    public Map<Integer, List<Employee>> listAllByDepartment(){
        return departmentService.getAllEmployeesGroupedByDepartmentId();
    }

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("{departmentId}/salary/max")
    public Employee findMaxSalary(@PathVariable int departmentId){
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @RequestMapping("{departmentId}/salary/sum")
    public int getEmployeeSalarySum(@PathVariable int departmentId){
        return departmentService.getEmployeeSalarySum(departmentId);
    }

    @RequestMapping("{departmentId}/salary/min")
    public Employee findMinSalary(@PathVariable int departmentId){
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }





}
