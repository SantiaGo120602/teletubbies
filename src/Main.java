import javax.swing.SwingUtilities;

import controller.TController;
import view.TView;

public class Main {
    public static void main(String[] args) {

        TController controller = new TController();

        SwingUtilities.invokeLater(() -> {
            TView frame = controller.getView();
            frame.setVisible(true);
        });
    }
}
