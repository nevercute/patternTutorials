package pro.nevercute.tut.patterns.algorythms.applet;

import java.applet.Applet;
import java.awt.*;

public class AppletExample extends Applet {
    String message;

    public void init(){
        message = "Hello world, I'm alive";
        repaint();
    }

    public void start(){
        message = "Now I'm starting...";
        repaint();
    }

    public void stop(){
        message = "And here I'm being stopped...";
        repaint();
    }

    public void destroy(){
        
    }

    public void paint(Graphics g){
        g.drawString(message, 100,100);
    }
}
