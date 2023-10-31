package model;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoStack = new ArrayList<Memento>();

    public void add(Memento state){
        mementoStack.add(state);
     }
  
     public Memento pop(){
        Memento memento = null;
        if (!mementoStack.isEmpty()) {
            if (mementoStack.size() > 1){
                memento = mementoStack.remove(mementoStack.size() - 1);
            }
            else {
                 memento = mementoStack.get(0);
            }
        }
        return memento;
     }
    
}
