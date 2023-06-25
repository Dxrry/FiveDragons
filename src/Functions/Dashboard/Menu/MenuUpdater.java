/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard.Menu;

import Functions.Dashboard.ComponentInit;
import Functions.Dashboard.MenuButtonClass;
import Functions.MySQL.Database;
import Functions.Utils.GUIHelper;
import java.util.List;

/**
 *
 * @author dxrry
 */
public class MenuUpdater {
    public static List<Integer> updateMenu(ComponentInit componentSearch, String menuCategories, Integer currentPages, MenuButtonClass menuButtonNext, MenuButtonClass menuButtonPrev) {
        Database db = new Database();
        List<Integer> returningMenu = null;
        for (int iterVisible = 0; iterVisible < 3; iterVisible++) {
            int fixedIndex = iterVisible + 1;
            boolean isVisible = false;
            
            
            int[] allMenuIds = db.getMenuIds(menuCategories);
            List<List<Integer>> menuGrouping = MenuGrouping.groupArray(allMenuIds);
            
            menuButtonPrev.setForeground(currentPages > 0 ? new java.awt.Color(255, 255, 255) : new java.awt.Color(153,153,153));
            menuButtonNext.setForeground((menuGrouping.size() - 1) > currentPages ? new java.awt.Color(255, 255, 255) : new java.awt.Color(153,153,153));
            if (!menuGrouping.isEmpty()) {
                List<Integer> menuGroup = menuGrouping.get(currentPages);
                isVisible = (iterVisible < menuGroup.size());
                if(!menuGroup.isEmpty()) {
                    returningMenu = menuGroup;
                }
                for (int i = 0; i < menuGroup.size(); i++) {
                    Integer menuId = menuGroup.get(i);
                    Integer getMenuPrice = db.getMenuPrice(menuId);
                    
                    componentSearch.searchMenuLabel("menuName" + (i + 1)).setText(db.getMenuName(menuId));
                    componentSearch.searchMenuLabel("menuDesc" + (i + 1)).setText(db.getMenuDesc(menuId));
                    componentSearch.searchMenuLabel("menuPrice" + (i + 1)).setText(GUIHelper.splitPrice(getMenuPrice));
                    componentSearch.searchMenuLabel("menuIcon" + (i + 1)).setIcon(new javax.swing.ImageIcon(db.getMenuIcon(menuId)));
                }
            }

            String[] componentNames = {
                "menuName", "menuPrice",
                "menuIcon", "menuDesc",
                "menuBackground"
            };
            for (String componentName : componentNames) {
                componentSearch.searchMenuLabel(componentName + fixedIndex).setVisible(isVisible);
            }
        }
        return returningMenu;
    }
}
