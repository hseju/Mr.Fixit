import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;
public class Main {

    public static void main(String [] args) throws FileNotFoundException {

        File file = new File("Spider-Man.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> myWords = new ArrayList<>();  //this array will store all the unique words
        ArrayList<Integer> freqs = new ArrayList<>();  // this array will store the number of times the unique words repeat

        //reading each word from the source file
         while(scan.hasNext()){

            String word = scan.next(); // scan through each word in the text file line by line
             word = word.replaceAll("[!?.;,]", "");  // replace all the special characters with null strings
             //digits will not be inlcuded in this as this just for the words

            int index = myWords.indexOf(word.toLowerCase());

            if(index==-1){
                myWords.add(word.toLowerCase());
                index = myWords.indexOf(word.toLowerCase());
                freqs.add(index,1);

            }else{
                //index = myWords.indexOf(word.toLowerCase());
                int valueOfRepeatedWord = freqs.get(index);
                freqs.set(index,valueOfRepeatedWord+1);
            }
        }//end of while loop


        //looping through the freqs array and finding out at what index does the maximum count occurs
         int init = freqs.get(0);
         System.out.println("Number of unique words: " + myWords.size()); //print number of unique words
         int indexAtMaxCount=0;

          for(int j=0; j<freqs.size(); j++){
            if(freqs.get(j)>init){
                 init = freqs.get(j);
                indexAtMaxCount = j;
             }
            System.out.println(freqs.get(j) + " - " + myWords.get(j));
          }//end of for loop


          System.out.println("The word that occurs most often is : " + myWords.get(indexAtMaxCount) + " counting " + init + " times");
    }//end of main class
}//end of class
