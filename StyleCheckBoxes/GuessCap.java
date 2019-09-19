

import java.util.Scanner;
import java.io.*;
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String []states = new String[50];
    String []caps = new String[50];
    String choice="y";

    loadst(states,caps); /* get input data*/
    while(choice.toLowerCase().equals("y"))
    {
      play(states,caps);
      System.out.println("DO YOU WANT TO PLAY AGAIN? (Y/N) ");
      choice = scan.next();
    }
}


/***************************** PICK RANDOM STATE */
public static int pickst()
{
  return  (int)(Math.random() * 49) + 1;
}

/**************************** LOAD STATES FUNCTION */
public static void loadst(String states[],String caps[] )
{
   try{

        FileInputStream fstream = new FileInputStream("g:\\CS1K\\usstates.dat");
        // set the properties of a DataInputStream object
        DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String temp;
        //Read File Line By Line
       for (int i=0;i<50;i++)   {
            temp = br.readLine();
            states[i]=temp.substring(0,14);
            caps[i]=temp.substring(39,53);
        }
        //Close the input stream
        in.close();
    }
   catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }

/******************************** PLAY FUNCTION*/
public static void play(String states[],String caps[])
{
    Scanner scan = new Scanner(System.in);
    int stpick,i;
    String answer;
    stpick=pickst();
    System.out.print("THE CAPITAL OF "+ states[stpick] + "IS ? ");
    answer = scan.nextLine();
    for (i=answer.length(); i<14; i++)
		answer+=" ";
    
    if (answer.equals(caps[stpick]))
       System.out.println("You are Right!\n");
    else
       System.out.println("You are Wrong!\n");
}

    
}
