package task2.mine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Timer timer;

    private final ColorInterpolatedSector interpolatedSector;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;

        timer = new Timer(timerDelay, this);
        timer.start();

        int centerX = 500;
        int centerY = 450;
        int radius = 300;
        double startAngle = 0;
        double extentAngle = 180;
        Color centerColor = Color.BLACK;
        Color edgeColor  = Color.GREEN;

        interpolatedSector = new ColorInterpolatedSector(centerX, centerY, radius, startAngle, extentAngle, centerColor, edgeColor);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        interpolatedSector.draw(g);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }
}