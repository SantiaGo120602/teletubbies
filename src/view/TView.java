package view;

import javax.swing.*;

import model.TModel;
import model.TPosition;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TView extends JFrame{
    private JLabel personaje;
    private JLabel meta;
    private List<JLabel> checkpointLabels = new ArrayList<>();
    private List<JLabel> mineLabels = new ArrayList<>();

    public TView(TModel model) {
        setTitle("telecheckpoint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1000);

        setLayout(null);

        personaje = new JLabel(openImage("src/resources/images/jugador.jpeg", 100, 100));
        personaje.setBounds(model.getOriginator().getPosition().getX(), model.getOriginator().getPosition().getY(), 100, 100);
        add(personaje);

        meta = new JLabel(openImage("src/resources/images/goal.png", 100, 100));
        meta.setBounds(1830, 830, 100, 100);
        add(meta);

        for (int i = 0; i < model.getCheckpoints().size(); i++){
            TPosition mine = model.getMines().get(i);
            TPosition checkPoint = model.getCheckpoints().get(i);

            JLabel c = new JLabel(openImage("src/resources/images/check.png", 100, 100));
            c.setBounds(checkPoint.getX(), checkPoint.getY(), 100, 100);
            checkpointLabels.add(c);
            add(c);

            JLabel m = new JLabel(openImage("src/resources/images/mine.png", 100, 100));
            m.setBounds(mine.getX(), mine.getY(), 100, 100);
            mineLabels.add(m);
            add(m);
        }

        JLabel fondo = new JLabel(openImage("src/resources/images/fondo.jpg", 2000, 1000));
        fondo.setBounds(0, 0, 2000, 1000);
        add(fondo);

        setLocationRelativeTo(null);
    }

    public void displayWinMessage() {
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private ImageIcon openImage(String path, int width, int length){
        ImageIcon icon = null;
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));
            icon = new ImageIcon(originalImage.getScaledInstance(width, length, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }

    public JLabel getPersonaje() {
        return personaje;
    }

    public List<JLabel> getCheckpointLabels() {
        return checkpointLabels;
    }

    public List<JLabel> getMineLabels() {
        return mineLabels;
    }

    public JLabel getMeta() {
        return meta;
    }
}
