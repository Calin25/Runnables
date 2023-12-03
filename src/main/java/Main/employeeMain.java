package Main;

import IO.JSONREADER;
import Model.Employee;

import java.util.List;
import java.util.concurrent.*;

public class employeeMain {

    public static void main(String[] args){
        List<Employee> list = JSONREADER.parseFile("employees.txt");

        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);

        ExecutorService exe = Executors.newCachedThreadPool();


        exe.submit(new SearchEmployee(list, "David"));
        exe.submit(new PrintByPosition(list,"Director"));

        scheduledexe.scheduleAtFixedRate(new PrintAllEmployees(list),1,3, TimeUnit.SECONDS);

        Callable<Employee> e = new GetHighestWage(list);
        Future<Employee> f = scheduledexe.submit(e);

        try {
            Employee x = f.get();
            System.out.println("Using Calable: Highest Paid Employee\n");
            System.out.println(x.getName() + " " + x.getAge() + " " + x.getWage() + " " + x.getPosition() + " This one");
            System.out.println("End");
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }




        exe.close();
    }
}
