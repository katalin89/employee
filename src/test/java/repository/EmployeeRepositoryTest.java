package repository;

import model.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    public void insert() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1, "Raducu", "Daniel", "1995-01-01", "M", 3000);
        employeeRepository.insertEmployee(employee);
    }

    @Test
    public void stergeById() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        int id = 1;
        employeeRepository.stergeEmployeeById(id);
    }


    @Test
    public void updateSalary() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        int id = 1;
        employeeRepository.updateSalary("Raducu", "Daniel", 9999);
    }

    @Test
    public void deleteName() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.deletName("Raducu", "Daniel");
    }

    @Test
    public void allEmp() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        List<Employee> list = employeeRepository.allEmployee();


        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }
}