package pro.nevercute.tut.patterns.proxy.virtual;

import java.awt.*;

interface ImageIconState {
    int getIconWidth();
    int getIconHeigth();
    void paintIcon(Component c, Graphics g, int x, int y);
}
