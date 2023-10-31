package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.TModel;
import model.TPosition;
import view.TView;

public class TController implements KeyListener{
    private TView view;
    private TModel model;
    int intersected = -1;

    public TController() {
        this.model = new TModel();
        this.view = new TView(model);
        view.addKeyListener(this);
        view.setFocusable(true);
    }

    public TView getView() {
        return view;
    }

    public TModel getModel() {
        return model;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int x = 0;
        int y = 0;
        switch (keyCode) {
            case KeyEvent.VK_W:
                y = -10;
                break;
            case KeyEvent.VK_A:
                x = -10;
                break;
            case KeyEvent.VK_S:
                y = 10;
                break;
            case KeyEvent.VK_D:
                x = 10;
                break;
        }
        x = model.getOriginator().getPosition().getX() + x;
        y = model.getOriginator().getPosition().getY() + y;
        if (x >= 0 && x <= 1830 && y >= 0 && y <= 830){
            updateModel(new TPosition(x, y));
        }
    }

    public void updateModel(TPosition newPosition){
        model.getOriginator().setPosition(newPosition);
        updateView();

        Rectangle playerBounds = view.getPersonaje().getBounds();

        if (playerBounds.intersects(view.getMeta().getBounds())){
            view.displayWinMessage();
        }

        for (int i = 0; i < view.getMineLabels().size(); i++){
            Rectangle mineBounds = view.getMineLabels().get(i).getBounds();
            Rectangle checkpointBounds = view.getCheckpointLabels().get(i).getBounds();

            if (playerBounds.intersects(mineBounds)){
                model.goToLastCheckPoint();
                updateView();
            } else if (playerBounds.intersects(checkpointBounds)){
                if (!model.getIntercepting()){
                    model.setIntercepting(true);
                    model.addLastCheckPoint();
                    intersected = i;
                    updateView();
                }
            } else if (intersected == i){
                model.setIntercepting(false);
                intersected = -1;
            }
        }
    }
    
    public void updateView(){
        view.getPersonaje().setBounds(model.getOriginator().getPosition().getX(), model.getOriginator().getPosition().getY(), 100, 100);
    }


}
