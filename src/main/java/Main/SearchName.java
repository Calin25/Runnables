package Main;
import Model.Name;

import java.util.Iterator;
import java.util.List;

public class SearchName implements Runnable{
    List<Name> list;
    String name;

    public SearchName(List<Name>list, String nName){
        this.list = list;
        this.name = nName;
    }

    @Override
    public void run() {
        int counter = 0;
        Iterator var2 = this.list.iterator();

        while(var2.hasNext()) {
            //Cast row to type name
            Name n = (Name)var2.next();
            if (n.getName().equalsIgnoreCase(this.name)) {
                System.out.println(n.getName() + "\t" + n.getYear() + "\t" + n.getOccurrences());
                counter++;
            }
        }

        System.out.println(this.name + " was found " + counter + " times");



    }
}
