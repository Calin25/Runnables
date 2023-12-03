package Main;

import Model.Employee;

import java.util.List;
import java.util.concurrent.Callable;

public class GetHighestWage implements Callable {
    List<Employee> list;

    public GetHighestWage(List<Employee> list){
        this.list = list;
    }
    @Override
    public Object call() throws Exception {
        Employee e = new Employee();
        double wage = 0;
        for (Employee x : this.list){
            if (x.getWage() > wage){
                e = x;
            }
        }

        return e;
    }
}
