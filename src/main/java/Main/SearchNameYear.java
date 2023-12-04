package Main;

import Model.Name;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchNameYear implements Callable {
    List<Name> list;
    String name;
    String year;

    public SearchNameYear(List<Name>list, String sName, String sYear){
        this.list = list;
        this.name = sName;
        this.year = sYear;
    }


    @Override
    public Object call() throws Exception {
        Iterator<Name> it = this.list.iterator();

        while (it.hasNext()){
            Name aName = it.next();

            if (this.year.equals(aName.getYear()) && this.name.equals(aName.getName())){
                return aName;
            }
        }

        return null;
    }
}
