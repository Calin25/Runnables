package IO;

import Model.Name;

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<Name> parseFile(String file){
        List<Name> list = new ArrayList<>();

        String timeZone;
        String gender; //could use a char instead of a String
        int year;
        String name;
        int occurrences;

        try{

            FileReader fr = new FileReader(file);
            StreamTokenizer in = new StreamTokenizer(fr);

            in.ordinaryChar(45);
            //
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();

            in.nextToken();

            while (in.ttype != StreamTokenizer.TT_EOF) {

                timeZone = in.sval;
                in.nextToken();

                timeZone += ((char) in.ttype);

                in.nextToken();

                timeZone += in.nval;


                in.nextToken();
                gender = in.sval;

                in.nextToken();
                year = (int) in.nval;//year


                in.nextToken();
                name = in.sval;

                in.nextToken();
                occurrences = (int) in.nval; //births

                in.nextToken();

                list.add(new Name(timeZone, gender, year, name, occurrences));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

        return list;

    }




}
