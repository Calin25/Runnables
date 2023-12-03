package IO;

import Model.Employee;

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class JSONREADER {
    public static List<Employee> parseFile(String file){
        //Create List
        List<Employee> list = new ArrayList<>();

        String name;
        int age;
        double Wage;
        String position;

        try{
            FileReader fr = new FileReader(file);
            StreamTokenizer in = new StreamTokenizer(fr);

            in.ordinaryChar(45);
            //Header
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();



            while (in.ttype != StreamTokenizer.TT_EOF){
                name = in.sval;
                in.nextToken();

                age = (int)in.nval;
                in.nextToken();

                Wage = (double)in.nval;
                in.nextToken();

                position = in.sval;
                in.nextToken();

                list.add(new Employee(name,age,Wage,position));

            }
        }catch (Exception ex){
            System.out.println(ex);
        }


        return list;
    }
}
