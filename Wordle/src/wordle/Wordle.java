/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordle;
import java.io.File;
import java.util.*;
/**
 *
 * @author S536061
 */
public class Wordle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        int guess = 6;
        String word = " ";
        int num = 0;
        HashMap wordmap = new HashMap<String, Integer>();
        
        HashMap nummap = new HashMap<Integer, String>();
        
        File myFile = new File("C:\\Users\\S536061\\Documents\\NetBeansProjects\\Wordle\\src\\wordle\\fiveletterwords.txt");
        Scanner scan = new Scanner(myFile);
        while(scan.hasNext()){
            word = scan.next();
            wordmap.put(word, num);
            nummap.put(num, word);
            num++;
        }
        scan.close();
        
        ///Test
        /*if(map.containsKey("abbot")){
            System.out.println("True");
        }
        System.out.println("Hello");
        System.out.println(map.size());        
        */
        
        Random rand = new Random();
        num = rand.nextInt(2500);
        word = (String) nummap.get(num);
        int multi = 0;
        //System.out.println(word);
        System.out.println("Correct letters in correct spot are shown with a 1 ");
        System.out.println("Correct letters in the wrong spot are shown with a !");
        System.out.println("Incorrect letter is shown with _");
        System.out.println("");
        //Correct spot is shown with a 1, Incorrect spot but in word is ! and wrong is _ Correct spot but same letter used again is 2
        
        //char[] char1 = word.toCharArray();
        //for(int i = 0; i < char1.length; i++){
          //  for(int j = i+1; j < char1.length; j++){
            //    if(char1[i] == char1[j]){
              //      multi++;
                    
                //}
          //  }
        //}
        Scanner input = new Scanner(System.in);
        boolean solved = false;
        while(solved != true){
            String att = input.next();
            solved = checkW(att, word);
            if(solved == true){
                System.out.println("1 1 1 1 1");
                System.out.println("You Win!!!");
            }
            else{
                letterCheck(att, word);
            }
            
        }
        
        
    }
    
    public static boolean checkW(String guess, String answer){
        if(guess.equals(answer)){
            return true;
        }
        
        return false;
    }
    
    public static void letterCheck(String guess, String answer){
        char[] ch1 = guess.toCharArray();
        char[] ch2 = answer.toCharArray();
        boolean letFlag = false;
        //Loops to check if letters in correct spots
        for(int i = 0; i < ch1.length; i++){
            for(int j = 0; j < ch2.length; j++){
                if(ch1[i] == ch2[j]){
                    if(i == j){
                        System.out.print("1 ");
                        letFlag = true;
                    }
                    else{
                        System.out.print("! ");
                        letFlag = true;
                    }
                }
                
            }
            if(letFlag != true){
                System.out.print("_ ");
            }
            letFlag = false;
            
        }
        System.out.println();
    }
    
}
