package pro.sky.employeesList.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException (String message){
        super(message);
    }
}
