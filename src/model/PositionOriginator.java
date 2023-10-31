package model;

public class PositionOriginator {
    private TPosition position;

    public TPosition getPosition() {
        return position;
    }

    public void setPosition(TPosition position) {
        this.position = position;
    }
    
    public Memento saveToMemento(){
        return new Memento(position);
    }

    public void getStateFromMemento(Memento memento){
        position = memento.getPosition();
     }
}
