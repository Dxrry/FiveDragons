/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Payment;

import Components.Button;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author dxrry
 */
public class SwitchButtonPayment {
    private final Color activeColor = new java.awt.Color(255,189,36);
    
    private final Button[] componentsMenuButton;
    private final Map<String, Color> buttonColorMap;
    
    public SwitchButtonPayment(Button[] forPaymentButton) {
        this.componentsMenuButton = forPaymentButton;
        
        buttonColorMap = new HashMap<>();
        for (Button button : componentsMenuButton) {
            String name = button.getName();
            Color color = button.getBackground();
            buttonColorMap.put(name, color);
        }
    }
    
    public Button searchMenuButton(String name) {
        for (Button component : componentsMenuButton) {
            if (component.getName() != null && component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }
    
    public String setActiveButton(String GatewayName) {
        String currentMenuCategories = "Error";
        for (Button component : componentsMenuButton) {
            Color defaultButtonColor = buttonColorMap.get(component.getName());
            if (component.getName() != null && component.getName().equals("button" + GatewayName)) {
                component.setBackground(activeColor);
                currentMenuCategories = component.getText();
            } else {
                component.setBackground(defaultButtonColor);
            }
        }
        return currentMenuCategories;
    }
}
