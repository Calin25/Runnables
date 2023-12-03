package Main;

import Model.Employee;

import java.util.List;

public class HighestPaidEmployee implements Runnable {
    List<Employee>list;

    public HighestPaidEmployee(List<Employee> list){
        this.list = list;
    }


    @Override
    public void run() {
        double wage = 0;
        Employee newEmployee = new Employee();

        for (Employee e : this.list){
            if (e.getAge() > wage){
                newEmployee = e;
            }
        }

        System.out.println("Highest Paid Employee: ");
        System.out.println(newEmployee.getName() + " " + newEmployee.getAge() + " " + newEmployee.getWage() + " " + newEmployee.getPosition());

    }
}
