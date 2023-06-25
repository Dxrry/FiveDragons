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
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuTextField extends JTextField {

    private boolean over;
    private Color color;
    private int radius = 0;

    public MenuTextField() {
        // Init Color
        setColor(Color.WHITE);

        setHorizontalAlignment(SwingConstants.LEFT);

        setOpaque(false);
        setBorder(new EmptyBorder(5, 25, 5, 5));
        

        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setCursor(new Cursor(Cursor.TEXT_CURSOR));
                over = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                over = false;
                repaint();
            }
        });

        // Add focus listener
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                over = true;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                over = false;
                repaint();
            }
        });
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setForeground(color);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Paint Border
        g2.setColor(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        // Border set 2 Pix
        g2.setColor(getForeground());
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        super.paintComponent(grphcs);
    }
}
