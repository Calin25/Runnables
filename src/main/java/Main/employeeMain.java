package Main;

import IO.JSONREADER;
import Model.Employee;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class employeeMain {

    public static void main(String[] args){
        List<Employee> list = JSONREADER.parseFile("employees.txt");

        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);

        ExecutorService exe = Executors.newCachedThreadPool();


        exe.submit(new SearchEmployee(list, "David"));
        exe.submit(new PrintByPosition(list,"Director"));

        scheduledexe.scheduleAtFixedRate(new PrintAllEmployees(list),1,3, TimeUnit.SECONDS);


        exe.close();
    }
}
