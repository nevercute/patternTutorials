package pro.nevercute.tut.patterns.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageNoStateProxy implements Icon {
    private Thread retrievalThread;
    private URL imageUrl;
    private boolean retrieve;
    private ImageIcon imageIcon;

    public ImageNoStateProxy(URL url){
        this.imageUrl = url;
        this.retrieve = false;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if(imageIcon != null){
            imageIcon.paintIcon(c, g, x, y);
        }
        else{
            g.drawString("Loading cover, please wait . . .", x+300, y+190);
            if(!retrieve){
                retrieve = true;
                retrievalThread = new Thread(() -> {
                    try{
                        imageIcon = new ImageIcon(imageUrl,"Cover");
                        c.repaint();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if(imageIcon != null){
            return imageIcon.getIconWidth();
        }
        else{
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if(imageIcon != null){
            return imageIcon.getIconHeight();
        }
        else{
            return 600;
        }
    }
}
