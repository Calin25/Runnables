package Main;

import Model.Name;

import java.util.Iterator;
import java.util.List;

public class PrintNameOccurances implements Runnable{

    List<Name> list;
    String name;

    public PrintNameOccurances(List<Name> list, String name) {
        this.list = list;
        this.name = name;
    }
    @Override
    public void run() {
        int counter = 0;
        Iterator var2 = this.list.iterator();

        while(var2.hasNext()) {
            Name n = (Name)var2.next();
            if (n.getName().equalsIgnoreCase(this.name)) {
                System.out.println(n.getName() + "\t" + n.getYear() + "\t" + n.getOccurrences());
                ++counter;
            }
        }

        System.out.println(this.name + " was found " + counter + " times");

    }
}
