import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main{

    public static void ReadNamesFR(String NamesArray[]) throws FileNotFoundException{
        FileInputStream FileStream = new FileInputStream("names.txt");
        Scanner scnr = new Scanner(FileStream);
        int i=0;
        while(scnr.hasNextLine()){
            NamesArray[i] = scnr.nextLine();
            i++;
        }
    }

    public static void ReadMLFR(int mlArray[]) throws FileNotFoundException{
        FileInputStream FileStream = new FileInputStream("ml.txt");
        Scanner scnr = new Scanner(FileStream);
        int i=0;
        while(scnr.hasNextInt()){
            mlArray[i] = scnr.nextInt();
            i++;
        }
    }
    public static void ReadNumbersDrank(int NumbersDrankArray[][]) throws FileNotFoundException{
        FileInputStream FileStream = new FileInputStream("numbersDrank.txt");
        Scanner scnr = new Scanner(FileStream);
        int i=0;
        int j = 0;
        while(scnr.hasNextInt()){
            NumbersDrankArray[i][j] = scnr.nextInt();
           j++;
           if(j==3){
            i++;
            j=0;
           }
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        String NamesArray[] = new String[3];
        int mlArray[] = new int[3];
        int[][] NumbersDrankArray = new int[3][3];
        ReadNamesFR(NamesArray);
        ReadMLFR(mlArray);
        ReadNumbersDrank(NumbersDrankArray);
        for(int i=0;i<3;i++){
            System.out.println(NamesArray[i]);
            System.out.println(mlArray[i]);
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(NumbersDrankArray[i][j] + " ");
            }
            System.out.println();
        }
        Double person1Drank =0.0, person2Drank = 0.0, person3Drank = 0.0;
        System.out.println();
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                if(j==0){
                    person1Drank += NumbersDrankArray[i][j]*mlArray[j];
                }
                else if(j==1){
                    person2Drank += NumbersDrankArray[i][j]*mlArray[j];
                }
                else{
                    person3Drank += NumbersDrankArray[i][j]*mlArray[j];
                }

            }
            if(j==0){
                System.out.println(NamesArray[j]+" drank "+ person1Drank/1000 +" Lit of Coca Cola :D");
            }
            else if(j==1){
                 System.out.println(NamesArray[j]+" drank "+ person2Drank/1000 +" Lit of Coca Cola :D");
            }
            else{
                 System.out.println(NamesArray[j]+" drank "+ person3Drank/1000 +" Lit of Coca Cola :D");
            }
        }

        double MAX = person1Drank;
        System.out.println();
        if(person1Drank>person2Drank && person1Drank>person3Drank){
              System.out.println(NamesArray[0]+" drank the most");
        }
        else if(person2Drank>person1Drank && person2Drank>person3Drank){
            System.out.println(NamesArray[1]+" drank the most");
        }
        else{
            System.out.println(NamesArray[2]+" drank the most");
        }
    }
}
