/**
 * Write a description of class RandomWalk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class StringScrambler
{
    
    
    public String scramble(String word)
    {
        if (word.length() < 2){
            return word;
        }
        String lastLetter = word.substring(word.length()-1, word.length());
        String firstLetter = word.substring(0,1);
        int index = randomInt(1, word.length()-2);
        int index2 = randomInt(2, word.length()-1);
        String swapOne = word.substring(index, index+1);
        String swapTwo = word.substring(index2, index2+1);
        String middle = word.substring(index+1, index2);
        word = firstLetter + swapTwo + middle + swapOne+ lastLetter;
        return word;
    }

    /**
    Returns a random integer between begin and pastEnd - 1
    @param begin the lower bound (inclusive)
    @param end the upper bound (exclusive)
     */
    public int randomInt(int begin, int pastEnd)
    {
        return begin + (int)((pastEnd - begin) * Math.random());
    }

    /**
    Scrambles all words of length > 3 in a given sentence, after stripping off 
    white space and punctuation marks (except for '). Do not look inside this
    method. If you do, be sure to avert your eyes from the split method call, or permanent eye damage may occur.
    @param sentence a string consisting of one or more words
    @return the string witht the words scrambled
     */
    public String scrambleSentence(String sentence)
    {
        String result = "";
        for (String w : sentence.split("[\\s\\p{Punct}&&[^']]+"))
        {
            String r;
            if (w.length() > 3) r = scramble(w);
            else r = w;
            result = result + r + " ";
        }

        return result;
    }

}
/**
 * 
 public class RandomWalk
{
    public static void main(String[] args){
        Picture vacuum = new Picture("roomba_big.png");
        vacuum.translate(200, 200);
        vacuum.draw();
        double distance = 5;
        for (int i = 1; i <= 3000; i++){
            double angle = 360 * Math.random();
            double dx = distance * Math.cos(angle);
            double dy = distance * Math.sin(angle);
            vacuum.translate(dx,dy);
            Ellipse circle = new Ellipse(vacuum.getX() + 50, vacuum.getY()+50, 10, 10);
            circle.fill();
        }
    }
}
**/