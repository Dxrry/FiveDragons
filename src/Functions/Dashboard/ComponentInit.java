/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard;

/**
 *
 * @author dxrry
 */
import javax.swing.JLabel;

public class ComponentInit {
    private final JLabel[] componentsMenu;
    private final JLabel[] componentsCheckout;

    public ComponentInit(JLabel[] forMenu, JLabel[] forCheckout) {
        this.componentsMenu = forMenu;
        this.componentsCheckout = forCheckout;
    }
    
    public JLabel searchMenuLabel(String name) {
        for (JLabel component : componentsMenu) {
            if (component.getName() != null && component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }
    
    public JLabel searchCheckoutLabel(String name) {
        for (JLabel component : componentsCheckout) {
            if (component.getName() != null && component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }
}
