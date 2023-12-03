package Main;

import Model.Employee;

import java.util.Iterator;
import java.util.List;

public class PrintByPosition implements Runnable {
    List<Employee> list;
    String position;

    public PrintByPosition(List<Employee>list, String positionSearch){
        this.list = list;
        this.position = positionSearch;
    }

    @Override
    public void run() {
        Iterator var2 = this.list.iterator();
        int count = 0 ;

        while(var2.hasNext()){
            Employee e = (Employee)var2.next();
            if (e.getPosition().equalsIgnoreCase(this.position)) {
                System.out.println(e.getName()  + "\t" + e.getPosition());
                count++;
            }
        }
    }
}
