package pro.nevercute.tut.patterns.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private ImageIcon imageIcon;
    private URL url;
    private boolean retrieving = false;
    private HasImageIcon hasImageIcon;
    private NoImageIcon noImageIcon;
    private ImageIconState imageIconState;

    public ImageProxy(URL url){
        this.url = url;
        this.hasImageIcon = new HasImageIcon(this);
        this.noImageIcon = new NoImageIcon(this);
        this.imageIconState = noImageIcon;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageIconState.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return imageIconState.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return imageIconState.getIconHeigth();
    }

    public boolean isRetrieving() {
        return this.retrieving;
    }

    public void setRetrieving(boolean retrieving){
        this.retrieving = retrieving;
    }

    public URL getUrl() {
        return url;
    }

    public HasImageIcon getHasImageIcon() {
        return hasImageIcon;
    }

    public NoImageIcon getNoImageIcon() {
        return noImageIcon;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    public void setImageIconState(ImageIconState imageIconState){
        this.imageIconState = imageIconState;
    }
}
