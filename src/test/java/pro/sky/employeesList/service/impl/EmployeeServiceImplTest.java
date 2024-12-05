package pro.sky.employeesList.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.employeesList.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeesList.exceptions.EmployeeNotFoundException;
import pro.sky.employeesList.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeesList.model.Employee;
import pro.sky.employeesList.services.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.employeesList.services.impl.EmployeeServiceImpl.STORAGE_SIZE;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void clear() {
        employeeService = new EmployeeServiceImpl();
    }

    //pt1 unit-testing
    //testing addEmployee

    @Test
    public void shouldCorrectlyAddNewEmployee() {
        //given
        Employee employeeToAdd = new Employee("Petr", "Ivanov", 100000, 2);
        //when
        Employee employeeBeingAdded = employeeService.addEmployee(employeeToAdd.getFIRST_NAME(),
                employeeToAdd.getLAST_NAME(),
                employeeToAdd.getSalary(),
                employeeToAdd.getDepartment());
        //then
        Assertions.assertEquals(employeeToAdd, employeeBeingAdded);
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullExceptionWhenStorageIsFull() {
        //given
        for (int i = 0; i < STORAGE_SIZE; i++) {
            employeeService.addEmployee("Oleg" + i, "Petrov", 10000 + i, 1);
        }
        //when
        //then
        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee("Sergey", "Lishniy", 10000, 1));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenAddingExistingEmployee() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Dvoynoy", 2000, 2);
        employeeService.addEmployee(employeeToAdd.getFIRST_NAME(),
                employeeToAdd.getLAST_NAME(),
                employeeToAdd.getSalary(),
                employeeToAdd.getDepartment());
        //when
        employeeService.addEmployee(employeeToAdd.getFIRST_NAME(),
                employeeToAdd.getLAST_NAME(),
                employeeToAdd.getSalary(),
                employeeToAdd.getDepartment());
        //then
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(employeeToAdd.getFIRST_NAME(),
                        employeeToAdd.getLAST_NAME(),
                        employeeToAdd.getSalary(),
                        employeeToAdd.getDepartment()));
    }

    //testing deleteEmployee

    @Test
    public void shouldCorrectlyDeleteEmployee() {
        //given
        Employee employeeToDelete = new Employee("Petr", "Ivanov", 100000, 2);
        employeeService.addEmployee(employeeToDelete.getFIRST_NAME(),
                employeeToDelete.getLAST_NAME(),
                employeeToDelete.getSalary(),
                employeeToDelete.getDepartment());
        //when
        Employee removedEmployee = employeeService.deleteEmployee(employeeToDelete.getFIRST_NAME(),
                employeeToDelete.getLAST_NAME(),
                employeeToDelete.getSalary(),
                employeeToDelete.getDepartment());

        //then
        Assertions.assertEquals(employeeToDelete, removedEmployee);

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenTryingToDeleteEmployeeThatNotExist() {
        //given
        //when
        //then
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.deleteEmployee("Petr", "Ivanov", 100000, 2), "Employee not found!");
    }

    //testing findEmployee

    @Test
    public void shouldCorrectlyFindEmployee() {
        //given
        Employee employeeToFind = new Employee("Petr", "Ivanov", 100000, 2);
        //when
        Employee employeeBeingFound = employeeService.findEmployee(employeeToFind.getFIRST_NAME(),
                employeeToFind.getLAST_NAME(),
                employeeToFind.getSalary(),
                employeeToFind.getDepartment());
        //then
        Assertions.assertEquals(employeeToFind,
                employeeBeingFound);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenSearchingForNonExistingEmployee() {
        //given
        Employee employeeToFind = new Employee("Petr", "Ivanov", 100000, 2);
        //when
        employeeService.deleteEmployee(employeeToFind.getFIRST_NAME(),
                employeeToFind.getLAST_NAME(),
                employeeToFind.getSalary(),
                employeeToFind.getDepartment());
//        employeeService.findEmployee(employeeToFind.getFIRST_NAME(),
//        employeeToFind.getLAST_NAME(),
//        employeeToFind.getSalary(),
//        employeeToFind.getDepartment());
        //then
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> {
                    employeeService.findEmployee(employeeToFind.getFIRST_NAME(),
                            employeeToFind.getLAST_NAME(),
                            employeeToFind.getSalary(),
                            employeeToFind.getDepartment());
                }
                , "Employee not found!");
    }
}
