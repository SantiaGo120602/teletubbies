package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TModel {
    private Boolean intercepting = false;
    private PositionOriginator originator;
    private CareTaker careTaker;
    private List<TPosition> checkpoints  = new ArrayList<>();
    private List<TPosition> mines  = new ArrayList<>();

    public TModel(){
        originator = new PositionOriginator();
        originator.setPosition(new TPosition(0, 0));
        careTaker = new CareTaker();
        addLastCheckPoint();

        Random random = new Random();
        for (int i = 0; i<5; i++){
            checkpoints.add(new TPosition(random.nextInt(1830 - 1 + 1) + 1, random.nextInt(830 - 1 + 1) + 1));
            mines.add(new TPosition(random.nextInt(1830 - 1 + 1) + 1, random.nextInt(830 - 1 + 1) + 1));
        }
    }

    public void addLastCheckPoint(){
        careTaker.add(originator.saveToMemento());
    }

    public void goToLastCheckPoint(){
        originator.getStateFromMemento(careTaker.pop());
    }

    public PositionOriginator getOriginator(){
        return originator;
    }

    public List<TPosition> getCheckpoints() {
        return checkpoints;
    }
    
    public List<TPosition> getMines() {
        return mines;
    }

    public Boolean getIntercepting() {
        return intercepting;
    }

    public void setIntercepting(Boolean i) {
        this.intercepting = i;
    }
}
