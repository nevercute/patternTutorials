package pro.nevercute.tut.patterns.proxy.virtual;

import java.awt.*;

public class HasImageIcon implements ImageIconState {
    private ImageProxy imageIcon;

    public HasImageIcon(ImageProxy imageIcon){
        this.imageIcon = imageIcon;
    }

    @Override
    public int getIconWidth() {
        return imageIcon.getImageIcon().getIconWidth();
    }

    @Override
    public int getIconHeigth() {
        return imageIcon.getImageIcon().getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageIcon.getImageIcon().paintIcon(c, g, x, y);
    }
}
