import com.opencsv.CSVReader;
import util.IBIO;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        ArrayList<String[]> data = readFile("csvDemo.csv");
        String value = "Agarwal";
        int pos = search(data, value);
        System.out.println(value + " found at: " + pos);

        do{
            value  = IBIO.input("Enter the value for searching: ");
            pos = search(data, value);
            IBIO.output(value + " found at: " + pos);
        }while(!value.equals("exit"));

    }

    private static int search(ArrayList<String[]> data, String string) {
        for(int i = 0; i < data.size(); i++) {
            String[] row = data.get(i);
            for (int j = 0; j < row.length; j++) {
                if(row[j].equals(string)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    private static ArrayList<String[]> readFile(String filename){
        ArrayList<String[]> data = new ArrayList<String[]>();
        CSVReader reader = null;
        try {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader(filename));
            String[] nextLine;
            //reads one line at a time
            while ((nextLine = reader.readNext()) != null) {
                data.add(nextLine);
                for (String token: nextLine) {
                    System.out.print(token + " ");
                }
                System.out.print("\n");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private static String[] convertListToArray(ArrayList<String> list){
        String[] array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }
}