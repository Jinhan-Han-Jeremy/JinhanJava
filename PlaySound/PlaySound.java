/*
 * PlaySound.java
 *
 * Created on September 27, 2007, 4:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.applet.*;
import java.net.*;


/**
 * Play a sound file from the network using the java.applet.Applet API.
 */
public class PlaySound {
    public static void main(String[  ] args) throws InterruptedException
    {

        try
           {
                long delay = 5;
                String url = "file:C:/student/funky.wav";
                AudioClip clip = Applet.newAudioClip(new URL(url));
                clip.play();
                Thread.sleep(delay);

            } catch (MalformedURLException murle) {
                System.out.println(murle);
                }


    }
}