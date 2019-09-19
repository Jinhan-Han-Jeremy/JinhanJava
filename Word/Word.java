import java.util.Scanner; 
public class Word
{
    private String text;

    /**
    Constructs a word.
    @param text the characters in this word
     */
    public Word(String text)
    {
        this.text = text;
    }

    /**
    Tests whether a letter is a vowel
    @param letter a string of length 1
    @return true if letter is a vowel
     */
    public boolean isVowel(String letter)
    {
        return "aeiouy".contains(letter.toLowerCase());
    }

    private String getVowels(String str)
    {
        String result = "";
        for(int i =0; i < str.length(); i++)
        {
            if(isVowel(str.substring(i,i+1)))
                result = result + str.substring(i,i+1);
        }
        return result;
    }

    public String getVowels()
    {
        return getVowels(text);
    }

    private String getVowelsFirst(String str)
    {
        String consonant = ""; 
        String result = ""; 
        for(int i =0; i < str.length(); i++)
        {
            if(!isVowel(str.substring(i,i+1)))
                consonant = str.substring(i,i+1);
        }
        result = getVowels(text) + consonant ;

        return result;
    }

    public  String getVowelsFirst()
    {
        return getVowelsFirst(text);
    }

    public int countVowels()
    {
        return 0;
    }

    public String longestVowelGroup()
    {
        //outrageous
        int i = 0;
        int highest = 0; // length of the longest vowel group
        String longestGroup = "";
        while (i < text.length())
        {
            int counter = 0; // length of our current vowel group
            String letter = text.substring(i, i + 1); // the ith letter
            String current = letter;
            if(isVowel(letter)){
                counter++;
                i++;
                while(i<text.length() && isVowel(text.substring(i,i+1))){
                    counter++;
                    i++;
                    current = current + text.substring(i, i+1);
                }
            }
            if (counter > highest){
                highest = counter;
                longestGroup = current;
            }
        }  
        return longestGroup;
    }

    public int countVowelGroups()
    {
        // Your work here
        return 0;
    }

    public String toString()
    {
        return text;
    }
}