/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Toast.UI;

import Components.Toast.Notifications;
import Components.Toast.ToastClientProperties;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

public class ToastNotificationPanel extends JPanel {

    protected JWindow window;
    protected JLabel labelIcon;
    protected JTextArea textArea;

    private Notifications.Type type;

    public ToastNotificationPanel() {
        installDefault();
    }

    private void installPropertyStyle() {
        String key = getKey();
        String outlineColor = toTextColor(getDefaultColor());
        String outline = convertsKey(key, "outlineColor", outlineColor);
        putClientProperty(FlatClientProperties.STYLE, "" +
                "background:" + convertsKey(key, "background", "@background") + ";" +
                "outlineColor:" + outline + ";" +
                "effectColor:" + convertsKey(key, "effectColor", outline));
    }

    private String convertsKey(String key, String value, String defaultValue) {
        return "if($Toast." + key + "." + value + ", $Toast." + key + "." + value + ", if($Toast." + value + ", $Toast." + value + ", " + defaultValue + "))";
    }

    @Override
    public void updateUI() {
        setUI(new ToastPanelUI());
        removeDialogBackground();
    }

    private void removeDialogBackground() {
        if (window != null) {
            Color bg = getBackground();
            window.setBackground(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), 0));
            window.setSize(getPreferredSize());
        }
    }

    private void installDefault() {
        labelIcon = new JLabel();
        textArea = new JTextArea("Hello my name\nRaven");
        textArea.setOpaque(false);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        textArea.setCursor(Cursor.getDefaultCursor());
        putClientProperty(ToastClientProperties.TOAST_ICON, labelIcon);
        putClientProperty(ToastClientProperties.TOAST_COMPONENT, textArea);
    }

    public void set(Notifications.Type type, String message) {
        this.type = type;
        labelIcon.setIcon(getDefaultIcon());
        textArea.setText(message);
        installPropertyStyle();
    }

    public void setDialog(JWindow window) {
        this.window = window;
        removeDialogBackground();
    }

    public Color getDefaultColor() {
        if (null == type) {
            return Color.decode("#d32f2f");
        } else return switch (type) {
            case SUCCESS -> Color.decode("#2e7d32");
            case INFO -> Color.decode("#0288d1");
            case WARNING -> Color.decode("#ed6c02");
            default -> Color.decode("#d32f2f");
        };
    }

    private String toTextColor(Color color) {
        return "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
    }

    public Icon getDefaultIcon() {
        String key = getKey();
        Icon icon = UIManager.getIcon("Toast." + key + ".icon");
        if (icon != null) {
            return icon;
        }
        FlatSVGIcon svgIcon = new FlatSVGIcon("Components/Toast/SVG/" + key + ".svg");
        FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
        colorFilter.add(new Color(150, 150, 150), getDefaultColor());
        svgIcon.setColorFilter(colorFilter);
        return svgIcon;
    }

    public String getKey() {
        if (null == type) {
            return "error";
        } else return switch (type) {
            case SUCCESS -> "success";
            case INFO -> "info";
            case WARNING -> "warning";
            default -> "error";
        };
    }
}
