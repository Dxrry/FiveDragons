/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Utils;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author dxrry
 */
public class Screen {
    public static Point getCenterPoint() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Point screenCenter = new Point(screenSize.width / 2, screenSize.height / 2);
        Point centerPoint = new Point(screenCenter.x - gd.getDefaultConfiguration().getBounds().x, screenCenter.y - gd.getDefaultConfiguration().getBounds().y);
        return centerPoint;
    }
}