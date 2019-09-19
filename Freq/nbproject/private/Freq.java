/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freq;

/**
 *
 * @author gscott
 */
import java.util.*;
public class Freq {
    private static final Integer ONE = new Integer(1);
    public static void main(String args[]) {
        String [] words = {"if","it","is","to","be","it","is","up","to","me","to","delegate"};
          Map m = new HashMap();
         // Initialize frequency table from command line
         for (int i=0; i<words.length; i++)
         {
           Integer freq = (Integer) m.get(words[i]);   // key is a string
           m.put(words[i], (freq==null ? ONE : new Integer( freq.intValue() + 1)));
                }  // value is Integer
        System.out.println( m.size()+" distinct words detected:");
        System.out.println(m);           }   }

