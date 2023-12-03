package Main;

import Model.Employee;

import java.util.List;

public class SearchEmployee implements Runnable{
    String eName;
    List<Employee> list;

    public SearchEmployee(List<Employee> list, String name){
        this.list = list;
        this.eName = name;
    }

    @Override
    public void run() {
        for (Employee e : list){
            if (e.getName().equals(this.eName)){
                System.out.println(e.getName() + " " + e.getAge() + " " + e.getWage() + " " + e.getPosition());
                break;
            }
        }
    }
}
