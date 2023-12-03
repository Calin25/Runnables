package Main;

import Model.Employee;

import java.util.List;

public class PrintAllEmployees implements Runnable{

    List<Employee> list;
    public PrintAllEmployees(List<Employee>list){
        this.list = list;
    }

    @Override
    public void run() {
        for(Employee l : this.list){
            System.out.println(l.getName() + " " + l.getAge() + " " + l.getWage() + " " + l.getPosition());
        }
    }
}
