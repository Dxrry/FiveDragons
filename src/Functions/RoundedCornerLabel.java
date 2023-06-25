/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author dxrry
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JLabel;

public class RoundedCornerLabel extends JLabel {
    private int cornerRadius;

    public RoundedCornerLabel() {
        super();
        cornerRadius = 10; // Radius sudut default
    }

    public RoundedCornerLabel(Icon image) {
        super(image);
        cornerRadius = 10; // Radius sudut default
    }

    public RoundedCornerLabel(String text) {
        super(text);
        cornerRadius = 10; // Radius sudut default
    }

    public RoundedCornerLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        cornerRadius = 10; // Radius sudut default
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        super.paintComponent(g2);
        g2.dispose();
    }
}