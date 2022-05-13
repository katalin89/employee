package repository;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {
    private String JdbURL = "jdbc:mysql://localhost:3306/exemplu";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public EmployeeRepository() {
        try {
            connection = DriverManager.getConnection(JdbURL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("eroare conectare baza de date");
        }
    }

    private void executeStatement(String execute) {
        try {
            statement.execute(execute);
        } catch (SQLException exc) {
            System.out.println("Nu am reusit" + execute);
        }
    }

    public void insertEmployee(Employee employee) {
        String insertTo = "";
        insertTo += "insert into employee";
        insertTo += "(first_name,last_name,birth_date,sex,salary)";
        insertTo += "values(";
        insertTo += String.format("'%s','%s','%s','%s',%d", employee.getFirst_name(), employee.getLast_name(), employee.getBirth_day(), employee.getSex(), employee.getSalary());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeEmployeeById(int id) {
        String text = String.format("delete from employee  where  emp_id= %d", id);
        executeStatement(text);
    }

    public void updateSalary(String first_name, String last_name, int salary) {
        String update = String.format("update employee set salary=%d where first_name ='%s'and last_name='%s'", salary, first_name, last_name);
        executeStatement(update);
    }

    public void deletName(String first_name, String last_name) {
        String delete = String.format("delete from employee where first_name='%s' and last_name='%s'", first_name, last_name);
        executeStatement(delete);

    }



  private ResultSet allEmployees(){
        executeStatement("select * from employee");
        try{
            return  statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu sa executat schita");
            return  null;
        }
  }

    public List<Employee> allEmployee(){
        ResultSet set= allEmployees();
        List<Employee>employees=new ArrayList<>();
        try{
            while(set.next()){
                employees.add(new Employee(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getInt(6)));
            }
        }catch ( Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  employees;
    }
}



