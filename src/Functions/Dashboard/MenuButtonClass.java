package Functions.Dashboard;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuButtonClass extends JButton {

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MenuButtonClass() {
        //  Init Color
        setColor(Color.WHITE);
        
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setContentAreaFilled(false);
        
        Insets margin = getMargin();
        setMargin(new Insets(margin.top, 25, margin.bottom, margin.right));
        setIconTextGap(25);
        
        //  Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                over = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                setBackground(color);
            }
        });
    }

    private boolean over;
    private Color color;
    private int radius = 0;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
