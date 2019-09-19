

import java.util.Scanner;
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      int blocks;
      Scanner scan = new Scanner(System.in);

      System.out.println ( "Please enter the number or blocks: ");
      blocks = scan.nextInt();

      Hanoi(blocks, 1, 2, 3);

}
/*This function tells how to move the blocks in the
tower of Hanoi game */
public static void Hanoi(int numberOfBlocks, int startPole, int destPole, int openPole)
{
	  int n = numberOfBlocks;
      if( numberOfBlocks > 0 )
      {
             // openPole and destPole are swapped
             Hanoi(numberOfBlocks - 1, startPole, openPole, destPole);

             System.out.print("Moving " + n + " from " + startPole);
             System.out.println( " to " + destPole );

             // openPole and startPole are swapped
             Hanoi(numberOfBlocks - 1, openPole, destPole, startPole);
      }
}

}


