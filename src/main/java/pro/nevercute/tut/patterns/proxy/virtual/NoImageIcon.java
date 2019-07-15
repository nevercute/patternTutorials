package pro.nevercute.tut.patterns.proxy.virtual;

import javax.swing.*;
import java.awt.*;

public class NoImageIcon implements ImageIconState {
    private ImageProxy imageProxy;
    private Thread retrievalThread;

    public NoImageIcon(ImageProxy imageProxy){
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeigth() {
        return 600;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading cover, please wait . . .", x+300, y+190);
        if(!imageProxy.isRetrieving()){
            imageProxy.setRetrieving(true);
            retrievalThread = new Thread(() -> {
                try{
                    imageProxy.setImageIcon(new ImageIcon(imageProxy.getUrl(),"Cover"));
                    c.repaint();
                }catch (Exception e){
                    e.printStackTrace();
                    imageProxy.setRetrieving(false);
                    g.drawString("An error occured while loading image . . .", x+300, y+190);
                }
            });
            retrievalThread.start();
            imageProxy.setImageIconState(imageProxy.getHasImageIcon());
        }
    }
}
