package UserInterface;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    private static final int SPLASH_WIDTH = 600;
    private static final int SPLASH_HEIGHT = 500;

    public static void show() {
        JFrame frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.setSize(SPLASH_WIDTH, SPLASH_HEIGHT);
        frmSplash.setLocationRelativeTo(null);

        JLabel lblSplash = new JLabel("Cargando...", SwingConstants.CENTER);
        lblSplash.setFont(new Font("Arial", Font.BOLD, 20));
        frmSplash.add(lblSplash, BorderLayout.CENTER);

        JProgressBar prbLoading = new JProgressBar(0, 100);
        prbLoading.setStringPainted(true);
        frmSplash.add(prbLoading, BorderLayout.SOUTH);

        frmSplash.setVisible(true);

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoading.setValue(i);
        }

        frmSplash.setVisible(false);
        frmSplash.dispose();
    }
}
