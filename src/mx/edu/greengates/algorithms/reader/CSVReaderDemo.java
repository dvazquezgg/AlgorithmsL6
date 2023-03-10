package mx.edu.greengates.algorithms.reader;

import java.io. * ;
import java.util.Scanner;
public class CSVReaderDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("csvDemo.csv"));
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",");
        //setting comma as delimiter pattern
        while (sc.hasNext()) {
            System.out.print(sc.next());
        }
        sc.close();
        //closes the scanner
    }
}