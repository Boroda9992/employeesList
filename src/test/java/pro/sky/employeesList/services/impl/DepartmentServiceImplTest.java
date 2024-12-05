package pro.sky.employeesList.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeesList.model.Employee;
import pro.sky.employeesList.services.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final Map<String, Employee> employees = new HashMap<>(){{
       put("Ivan1Petrov1", new Employee("Ivan1", "Petrov1", 110000, 1));
       put("Ivan2Petrov2", new Employee("Ivan2", "Petrov2", 120000, 1));
       put("Ivan3Petrov3", new Employee("Ivan3", "Petrov3", 130000, 1));
    }};

    //getEmployeeSalarySum
    @Test
    public void shouldCorrectlyCalculateSalarySum (){
        //given
        int departmentId = 1;
        int expectedSum = 360000;

        Mockito.when(employeeService.findAll()).thenReturn(employees.values());

        //when
        int actualSum = departmentService.getEmployeeSalarySum(departmentId);

        //then
        Assertions.assertEquals(expectedSum, actualSum);

    }

    //getEmployeeWithMaxSalary

    @Test
    public void shouldCorrectlyFindEmployeeWithMaxSalary (){
        //given
        int departmentId = 1;
        Employee expectedEmployee = employees.get("Ivan3Petrov3");

        Mockito.when(employeeService.findAll()).thenReturn(employees.values());

        //when
        Employee actualEmployee = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        Assertions.assertEquals(expectedEmployee, actualEmployee);

    }

    //getEmployeeWithMinSalary

    @Test
    public void shouldCorrectlyFindEmployeeWithMinSalary (){
        //given
        int departmentId = 1;
        Employee expectedEmployee = employees.get("Ivan1Petrov1");

        Mockito.when(employeeService.findAll()).thenReturn(employees.values());

        //when
        Employee actualEmployee = departmentService.getEmployeeWithMinSalary(departmentId);

        //then
        Assertions.assertEquals(expectedEmployee, actualEmployee);

    }

    //getAllEmployeesByDepartmentId

    @Test
    public void shouldCorrectlyFindEmployeesByDepartmentId (){
        //given
        int departmentId = 1;
        Collection<Employee> expectedEmployees = new ArrayList<>(employees.values());

        Mockito.when(employeeService.findAll()).thenReturn(employees.values());

        //when
        List<Employee> actualEmployees = departmentService.getAllEmployeesByDepartmentId(departmentId);

        //then
        Assertions.assertEquals(expectedEmployees, actualEmployees);

    }

    //getAllEmployeesGroupedByDepartmentId

    @Test
    public void shouldCorrectlyGetAllEmployeesGroupedByDepartmentId (){
        //given
        Map<Integer,List<Employee>> expectedEmployees = new HashMap<>(){{
            put(1, new ArrayList<>(employees.values()));
        }};
        Mockito.when(employeeService.findAll()).thenReturn(employees.values());

        //when
        Map<Integer,List<Employee>> actualEmployees = departmentService.getAllEmployeesGroupedByDepartmentId();

        //then
        Assertions.assertEquals(expectedEmployees, actualEmployees);

    }

}