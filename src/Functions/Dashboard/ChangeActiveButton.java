/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard;

import Functions.MySQL.Database;
import java.awt.Color;
import java.util.List;
/**
 *
 * @author dxrry
 */
public class ChangeActiveButton {
    
    private final Color activeColor = new java.awt.Color(255,189,36);
    private final Color activeForeground = new java.awt.Color(255, 255, 225);
        
    private final Color inActiveColor = new java.awt.Color(119, 10, 12);
    private final Color inActiveForeground = new java.awt.Color(255, 255, 255);
    
    private final MenuButtonClass[] componentsMenuButton;
    
    public Database db = new Database();
    
    public ChangeActiveButton(MenuButtonClass[] forMenuButton) {
        this.componentsMenuButton = forMenuButton;
        
        
        // Saat pertama kali set 
        List<String> allCategories = db.getMenuAllCategories();
        for (int i = 0; i < allCategories.size(); i++) {
            String categoryName = allCategories.get(i);
            componentsMenuButton[i].setText(categoryName);
        }
    }
    
    public MenuButtonClass searchMenuButton(String name) {
        for (MenuButtonClass component : componentsMenuButton) {
            if (component.getName() != null && component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }
    
    public String setActiveButton(Integer index) {
        String currentMenuCategories = "Error";
        for (MenuButtonClass component : componentsMenuButton) {
            if (component.getName() != null && component.getName().equals("menuButton" + index.toString())) {
                component.setColor(activeColor);
                component.setForeground(activeForeground);
                currentMenuCategories = component.getText();
            } else {
                component.setColor(inActiveColor);
                component.setForeground(inActiveForeground);
            }
        }
        return currentMenuCategories;
    }
}
