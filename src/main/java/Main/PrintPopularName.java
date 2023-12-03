package Main;

import Model.Name;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class PrintPopularName implements Runnable{

    List<Name> list;
    public PrintPopularName(List<Name> nList){
        this.list = nList;
    }
    @Override
    public void run() {

        int randomYear = ThreadLocalRandom.current().nextInt(1910, 2018);
        Optional var10000 = this.list.stream().filter((n) -> {
            return n.getYear() == randomYear && n.getGender().equals("F");
        }).findFirst();
        PrintStream var10001 = System.out;
        var10000.ifPresent(var10001::println);
        var10000 = this.list.stream().filter((n) -> {
            return n.getYear() == randomYear && n.getGender().equals("M");
        }).findFirst();
        var10001 = System.out;
        var10000.ifPresent(var10001::println);

    }
}
