package pro.nevercute.tut.patterns.command;

public class StereoOnForCD {

    public void on(){
        System.out.println("Stereo On For CD is on");
    }

    public void off(){
        System.out.println("Stereo On For CD is off");
    }

    public void setCd(){
        System.out.println("CD is Turned On");
    }

    public void setDvd(){
        System.out.println("DVD is Turned On");
    }

    public void setRadio(){
        System.out.println("Radio is Turned On");
    }

    public void setVolume(int volume){
        System.out.println("Volume is: "+volume);
    }
}
