import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String...args){


        File file = new File("name.csv");

        try(Reader reader = new FileReader(file.getAbsolutePath()))
         {
             char [] buffer =  new char[4];
             int read = reader.read(buffer);

             StringBuilder text =  new StringBuilder();
             do{

                 text.append(String.copyValueOf(buffer));
                 read = reader.read(buffer);

             }while (read != -1);
             List<Person> lista = addToList(text.toString());
             System.out.println(text);

        } catch(IOException e){
            System.out.println(e.getMessage());

        }


    }

    public static List<Person> addToList(String allText){
        List<Person> lista = new ArrayList<>();
        String [] lis = allText.split("\n");

        for (String line : lis){
            String [] per = line.split(",");
            Person person =  new Person(per[0],per[1],per[2]);

            lista.add(person);
        }
    return lista;

    }

    private static void writeToFile(File file) throws IOException{

        if(file.exists()){
            file.createNewFile();

        }
        try (FileOutputStream fos =  new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject( new Person("2","Sergiu","Plesca"));



        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
