package view;

import model.Employee;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Scanner;

public class ViewEmployee {
    private EmployeeRepository employeeRepository;

    public  ViewEmployee(){
        employeeRepository=new EmployeeRepository();
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a afisa toate angajatii ");
        System.out.println("Apasa tasta  2 pentru a insera un angajat nou ");
        System.out.println("Apasa tasta  3 pentru  a sterge un angajat din baza de date ");
        System.out.println("Apasa tasta  4 pentru a schimba salariul ");
        System.out.println("Apasa tasta 5  pentru a sterge dupa numele angajatului ");


    }

    public  void play(){
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        int alegere=0;
        while (run==true){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:showEmployees();
                break;
                case 2:insertAngajat();
                break;

                case 3:stergeAngajat();
                break;
                case 4:updateSalar();
                break;
                case 5:stergeDupaNume();
            break;
            }
        }
    }
    public  void  showEmployees(){
        List<Employee>list=employeeRepository.allEmployee();
        for(Employee e:list){
            System.out.println(e.toString());
        }
    }

    public  void  insertAngajat(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id ul angajatului");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introducet numele de familie al angajatului");
        String first_name= scanner.nextLine();
        System.out.println("Introduceti last_nameul ");
        String last_name=scanner.nextLine();
        System.out.println("Introduceti data nasterii");
        String birth_day= scanner.nextLine();
        System.out.println("Introduceti genul angajatului");
        String sex= scanner.nextLine();
        System.out.println("Introduceti salarul");
        int salar=Integer.parseInt(scanner.nextLine());
        Employee employee=new Employee(1,first_name,last_name,birth_day,sex,salar);
        employeeRepository.insertEmployee(employee);


    }

    public  void  stergeAngajat(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id ul angajatului care doriti s-l stergeti");
        int id=Integer.parseInt(scanner.nextLine());
        employeeRepository.stergeEmployeeById(id);
        System.out.println("S-a sters");

    }

    public  void updateSalar(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti first_name");
        String first_name=scanner.nextLine();
        System.out.println("Introduceti last_name");
        String last_name=scanner.nextLine();
        System.out.println("Inroducet salarul nou");
        int salar=Integer.parseInt(scanner.nextLine());
        employeeRepository.updateSalary(first_name,last_name,salar);
    }
    public  void  stergeDupaNume(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introsuceti first_name");
        String first_name=scanner.nextLine();
        System.out.println("Introduceti last_name");
        String last_name=scanner.nextLine();
        employeeRepository.deletName(first_name,last_name);
    }
}
