package pro.nevercute.tut.patterns.algorythms.frame;

import javax.swing.*;
import java.awt.*;

public class FrameExample extends JFrame {
    public FrameExample(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        String msg = "I Rule!";
        graphics.drawString(msg,100, 100);
    }

    public static void main(String[] args) {
        FrameExample frame = new FrameExample("First Frame Example. Template method with interceptor method");
    }                                               
}
