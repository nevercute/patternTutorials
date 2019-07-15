    package pro.nevercute.tut.patterns.complex.mvc;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;

public class BeatModelImpl implements BeatModel, MetaEventListener {
    private Sequencer sequencer;
    private List<BeatObserver> beatObservers = new ArrayList<>();
    private List<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm = 90;
    private Sequence sequence;
    private Track  track;

    @Override
    public void init() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void off() {
        sequencer.stop();
        setBPM(0);
    }

    @Override
    public void on() {
        setBPM(90);
        sequencer.start();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return this.bpm;
    }

    @Override
    public void beatEvent() {
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if(i >= 0){
            beatObservers.remove(i);
        }
    }

    @Override
    public void notifyBeatObservers() {
        beatObservers.forEach(e -> e.updateBeat());
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if(i >= 0)
            bpmObservers.remove(i);
    }

    @Override
    public void notifyBPMObservers() {
        bpmObservers.forEach(e -> e.updateBPM());
    }

    @Override
    public void meta(MetaMessage meta) {
        if(meta.getType() == 47){
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void setUpMidi(){
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart(){
        int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try{
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

    }

    public void makeTracks(int[] list){
        for(int i = 0; i < list.length; i++){
            int key = list[i];

            if(key != 0){
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }
}
