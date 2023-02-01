import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        int random = new Random().nextInt(looks.length);

        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[random].getClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        final MainFrame mainFrame = new MainFrame();
        if(!mainFrame.isVisible()) {
            mainFrame.setVisible(true);
        }
    }
}