package Main;

import Model.Name;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class PopGender implements Runnable{
    List<Name> list;
    String year;

    public PopGender(List<Name>list){
        this.list = list;
    }

    @Override
    public void run() {
        int randomYear = ThreadLocalRandom.current().nextInt(1980,2017 + 1);
        Iterator it = this.list.iterator();
        int mCount = 0;
        int fCount = 0;

        while (it.hasNext()){
            Name aName = (Name)it.next();

            if (aName.getYear() == randomYear){
                if (aName.getGender().equals("M")){
                    mCount++;
                }
                else{
                    fCount++;
                }
            }
        }

        if (mCount > fCount){
            System.out.println("Male was more popular in: " + randomYear);
        }
        else{
            System.out.println("Female was more popular in: " + randomYear);
        }

    }
}
