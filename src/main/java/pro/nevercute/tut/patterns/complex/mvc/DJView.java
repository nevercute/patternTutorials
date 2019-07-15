package pro.nevercute.tut.patterns.complex.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
    //view
    private BeatModel model;
    private Controller controller;
    private JFrame viewFrame;
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    //control
    private JFrame controlViewFrame;
    private JPanel controlViewPanel;
    private JLabel bpmLabel;
    private JTextField bpmTextField;
    private JButton setBPMButton;
    private JButton increaseBPMButton;
    private JButton decsreaseBPMButton;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;

    public DJView(Controller controller, BeatModel model){
        this.model = model;
        this.controller = controller;
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    public void enableStopMenuItem(){
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem(){
        stopMenuItem.setEnabled(false);
    }

    public void enableStartMenuItem(){
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem(){
        startMenuItem.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == setBPMButton){
            int bpm = Integer.parseInt(bpmTextField.getText().equals("") ? "0" : bpmTextField.getText());
            controller.setBPM(bpm);
        } else if (e.getSource() == increaseBPMButton){
            controller.increaseBPM();
        } else if(e.getSource() == decsreaseBPMButton){
            controller.decreaseBPM();
        }
    }

    @Override
    public void updateBeat() {
        beatBar.setValue(100);
    }

    @Override
    public void updateBPM() {
        int bpm = model.getBPM();
        if(bpm == 0){
            bpmOutputLabel.setText("offline...");
        } else{
            bpmOutputLabel.setText("Current BPM: "+model.getBPM());
        }
    }

    public void createView(){
        viewPanel = new JPanel(new GridLayout(1,2));
        viewFrame = new JFrame();
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(320,240));
        bpmOutputLabel = new JLabel("offline",SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(1,2));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void createControls(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlViewFrame = new JFrame("BPM Control");
        controlViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlViewFrame.setSize(new Dimension(320, 240));

        controlViewPanel = new JPanel(new GridLayout(1,2));

        menuBar = new JMenuBar();
        menu = new JMenu("Control menu");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener((ActionEvent e) -> controller.start());
        
        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem);
        stopMenuItem.addActionListener((ActionEvent e) -> controller.stop());

        JMenuItem exit = new JMenuItem("Exit");
        menu.add(exit);
        exit.addActionListener((ActionEvent e) -> {controller.stop(); System.exit(0);});

        menuBar.add(menu);
        controlViewFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(20, 80));
        setBPMButton.addActionListener(this);
        increaseBPMButton = new JButton("+");
        decsreaseBPMButton = new JButton("-");
        increaseBPMButton.addActionListener(this);
        decsreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.add(increaseBPMButton);
        buttonPanel.add(decsreaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1,2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);

        JPanel insideControlPanel = new JPanel(new GridLayout(3,1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlViewPanel.add(insideControlPanel);

        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlViewFrame.getRootPane().setDefaultButton(setBPMButton);
        controlViewFrame.getContentPane().add(controlViewPanel, BorderLayout.CENTER);

        controlViewFrame.pack();
        controlViewFrame.setVisible(true);
    }
}
