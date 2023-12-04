package Main;

import Model.Name;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class PopName implements Runnable{

    List<Name> list;
    public PopName(List<Name> nList){
        this.list = nList;
    }
    @Override
    public void run() {
        //Generate random number/year
        int randomYear = ThreadLocalRandom.current().nextInt(1910, 2018);

        //filter through the list & return if the year matches the random generated year & if the gender is female
        Optional var10000 = this.list.stream().filter((n) -> {
            return n.getYear() == randomYear && n.getGender().equals("F");
        }).findFirst();
        //Print to console
        PrintStream var10001 = System.out;
        var10000.ifPresent(var10001::println);
        //filter through the list & if year matches random number & gender is male
        var10000 = this.list.stream().filter((n) -> {
            return n.getYear() == randomYear && n.getGender().equals("M");
        }).findFirst();
        //Print to console
        var10001 = System.out;
        var10000.ifPresent(var10001::println);

    }
}
