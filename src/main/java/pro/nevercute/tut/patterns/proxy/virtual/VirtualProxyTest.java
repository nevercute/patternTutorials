package pro.nevercute.tut.patterns.proxy.virtual;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class VirtualProxyTest {
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("Virtual Image Proxy");
    private JMenuBar menuBar;
    private JMenu menu;
    private Map<String, String> cdMap = new HashMap<>();

    public VirtualProxyTest() throws MalformedURLException, URISyntaxException {
        cdMap.put("StormTrooper",new File("C:\\Users\\alisichkin\\Pictures\\675273.jpg").toURI().toURL().toString());
        cdMap.put("Chopper",new File("C:\\Users\\alisichkin\\Pictures\\chopper.jpg").toURI().toURL().toString());
        cdMap.put("CPU Architecture",new File("C:\\Users\\alisichkin\\Pictures\\cpu.jpg").toURI().toURL().toString());
        cdMap.put("Storm Ship",new File("C:\\Users\\alisichkin\\Pictures\\stormShip.jpg").toURI().toURL().toString());
        cdMap.put("Music Symphony",new File("C:\\Users\\alisichkin\\Pictures\\musickey.jpg").toURI().toURL().toString());

        URL initialUrl = URI.create(cdMap.get("StormTrooper")).toURL();
        menuBar = new JMenuBar();
        menu = new JMenu("Interesting covers");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for(Map.Entry<String, String> cover : cdMap.entrySet()){
            String name = cover.getKey();
            JMenuItem item = new JMenuItem(name);
            menu.add(item);
            item.addActionListener(e -> {
                try {
                    imageComponent.setIcon(new ImageProxy(getCoverURL(e.getActionCommand())));
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
                frame.repaint();
            });
        }

        Icon icon = new ImageProxy(initialUrl);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    public URL getCoverURL(String urlKey) throws URISyntaxException, MalformedURLException {
        return new URI(cdMap.get(urlKey)).toURL();
    }

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        VirtualProxyTest virtualProxyTest = new VirtualProxyTest();
    }
}
