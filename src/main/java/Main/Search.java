package Main;

import Model.Name;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class Search implements Callable {

    List<Name> list;
    String name;
    int y1;
    int y2;

    public Search(List<Name> list, String name, int y1, int y2) {
        this.name = name;
        this.list = list;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Object call() throws Exception {
        int tot1 = 0;
        int tot2 = 0;
        Iterator var3 = this.list.iterator();

        while(var3.hasNext()) {
            Name aName = (Name)var3.next();
            if (aName.getYear() == this.y1 && aName.getName().equalsIgnoreCase(this.name)) {
                tot1 = aName.getOccurrences();
            }

            if (aName.getYear() == this.y2 && aName.getName().equalsIgnoreCase(this.name)) {
                tot2 = aName.getOccurrences();
            }
        }

        int diff = tot1 - tot2;
        return (double)diff / (double)tot1;
    }
}
