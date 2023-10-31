package model;

public class Memento {
    private TPosition position;

    public Memento(TPosition position) {
        this.position = position;
    }

    public TPosition getPosition() {
        return position;
    }
}
