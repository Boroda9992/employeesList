package pro.sky.employeesList.Model;


import java.util.Objects;

public class Employee {


    private final String FIRST_NAME;
    private final String LAST_NAME;

    public Employee(String firstName, String lastName) {
        FIRST_NAME = firstName;
        LAST_NAME = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(FIRST_NAME, employee.FIRST_NAME) && Objects.equals(LAST_NAME, employee.LAST_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIRST_NAME, LAST_NAME);
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }
}
