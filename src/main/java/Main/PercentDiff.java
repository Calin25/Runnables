package Main;

import Model.Name;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class PercentDiff implements Callable {
    List<Name> list;
    String name;
    int y1;
    int y2;

    //create constructor
    public PercentDiff(List<Name> list, String name, int y1, int y2){
        this.list = list;
        this.name = name;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Object call() throws Exception {
        int tot1 = 0;
        int tot2 = 0;
        //List Iterator
        Iterator var3 = this.list.iterator();

        //Check each row until no row left to check
        while(var3.hasNext()) {
            //Convert row to object type name
            Name aName = (Name)var3.next();
            //check object name against name passed in & get occurances in year 1
            if (aName.getYear() == this.y1 && aName.getName().equalsIgnoreCase(this.name)) {
                tot1 = aName.getOccurrences();
            }
            //check object name against name passed in & get occurances in year 1
            if (aName.getYear() == this.y2 && aName.getName().equalsIgnoreCase(this.name)) {
                tot2 = aName.getOccurrences();
            }
        }
        //Calculate difference
        int diff = tot1 - tot2;
        //return result
        return (double)diff / (double)tot1;
    }
}
