package Main;


import Model.Name;
import IO.FileIO;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static NumberFormat nf = NumberFormat.getPercentInstance();
    public static void main(String args[]){
        List<Name> list = FileIO.parseFile("CA.JSON"); // Parse File in first

        ExecutorService exe = Executors.newCachedThreadPool();

        exe.submit(new PrintNameOccurances(list, "James"));

        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);
        Future<Double> f1 = exe.submit(new Search(list, "Paul", 2000, 2017));
        nf.setMaximumFractionDigits(2);


        try {
            System.out.println("Percentage Diff " + nf.format(f1.get()));
        } catch (ExecutionException | InterruptedException var7) {
            System.out.println(var7);
        }

        int delay = 3;
        int period = 5;
        exe.submit(new PrintPopularName(list));
        scheduledexe.scheduleAtFixedRate(new PrintPopularName(list), (long)delay, (long)period, TimeUnit.SECONDS);

        exe.close();
    }
}
