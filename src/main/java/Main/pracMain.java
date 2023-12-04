package Main;

import IO.FileIO;
import Model.Name;


import java.sql.SQLSyntaxErrorException;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.*;

public class pracMain {
    //Number formatter
    static NumberFormat nf = NumberFormat.getPercentInstance();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Name> list = FileIO.parseFile("CA.txt");
        ExecutorService exe = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);

        //Callable
        //Search list for james in years 2001 & 2017 & get difference
        Future<Double> f1 = exe.submit(new Search(list, "Calvin", 2001, 2017));
        nf.setMaximumFractionDigits(2);


        try {
            System.out.println("Percentage Diff " + nf.format(f1.get()));
        } catch (ExecutionException | InterruptedException var7) {
            System.out.println(var7);
        }

       // exe.submit(new SearchName(list, "Zack"));

        //set delay & period
        int delay = 3;
        int period = 5;

        //exe.submit(new PrintPopularName(list));
        //prints most popular male & femal name of a random generated year
        //scheduledexe.scheduleAtFixedRate(new PrintPopularName(list), (long)delay, (long)period, TimeUnit.SECONDS);

        //exe.submit(new PopGender(list));
        //scheduledexe.scheduleAtFixedRate(new PopGender(list),2,2,TimeUnit.SECONDS);


        try{
            Future<Name> v = exe.submit(new SearchNameYear(list,"James","1910"));
            Name n = v.get();
            if (n == null){
                System.out.println("No Values to Display");
                System.out.println("Try A differnt Name or Year");
            }
            else
                System.out.println(n.getName() + " " + n.getYear() + " " + n.getOccurrences());
        }catch (ExecutionException ex){
            System.out.println(ex);
        }

        exe.close();

    }
}
