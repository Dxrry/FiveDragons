/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard.Checkout;
import Functions.Dashboard.ArrayCounter;
import Functions.Dashboard.ComponentInit;
import Functions.Dashboard.MenuButtonClass;
import Functions.MySQL.Database;
import Functions.Utils.GUIHelper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dxrry
 */
public class CheckoutUpdater {
    
    public static int[] updateCheckout(int[] menuSelected, int menuId, int currentCheckoutPages, ComponentInit componentSearch, MenuButtonClass checkoutButtonPrev, MenuButtonClass checkoutButtonNext) {
        int currentSize = menuSelected.length;
        int[] newArray = Arrays.copyOf(menuSelected, currentSize + 1);

        newArray[currentSize] = menuId;
        if (menuId != 0) {
            menuSelected = newArray;
        }
        
        Database db = new Database();

        Map<Integer, Integer> counter = ArrayCounter.countElements(menuSelected);
        CheckoutGrouping check = new CheckoutGrouping();
        Integer totalPrice = calculateTotalPrice(counter, db);

        componentSearch.searchCheckoutLabel("checkoutTotalPriceLabel").setText(GUIHelper.splitPrice(totalPrice));
        List<Map<Integer, Integer>> checkReal = check.Group(counter);
        updateButtonColors(checkoutButtonPrev, checkoutButtonNext, currentCheckoutPages, checkReal.size());
        
        if (currentCheckoutPages > (checkReal.size() - 1) && currentCheckoutPages != 0) {
            return menuSelected;
        }
        updateCheckoutComponents(componentSearch, checkReal, currentCheckoutPages, counter, db);
        return menuSelected;
    }
    
    private static Integer calculateTotalPrice(Map<Integer, Integer> counter, Database db) {
        return counter.entrySet().stream()
                .mapToInt(entry -> {
                    Integer menuId = entry.getKey();
                    Integer quantity = entry.getValue();
                    Integer menuPrice = db.getMenuPrice(menuId);
                    return menuPrice * quantity;
                })
                .sum();
    }
    
    private static void updateButtonColors(MenuButtonClass checkoutButtonPrev, MenuButtonClass checkoutButtonNext, int currentCheckoutPages, int checkRealSize) {
        checkoutButtonPrev.setForeground(currentCheckoutPages > 0 ? new java.awt.Color(255, 255, 255) : new java.awt.Color(153,153,153));
        checkoutButtonNext.setForeground(checkRealSize > currentCheckoutPages + 1 ? new java.awt.Color(255, 255, 255) : new java.awt.Color(153,153,153));
    }
    
    private static void updateCheckoutComponents(ComponentInit componentSearch, List<Map<Integer, Integer>> checkReal, int currentCheckoutPages, Map<Integer, Integer> counter, Database db) {
        for (int iterVisible = 0; iterVisible < 2; iterVisible++) {
            int fixedIndex = iterVisible + 1;
            boolean isVisible = false;

            if (!checkReal.isEmpty() && checkReal.size() > currentCheckoutPages) {
                Map<Integer, Integer> getCurrentCheckout = checkReal.get(currentCheckoutPages);
                Integer[] currentCheckoutKeys = getCurrentCheckout.keySet().toArray(Integer[]::new);
                isVisible = iterVisible < currentCheckoutKeys.length;

                for (int i = 0; i < currentCheckoutKeys.length; i++) {
                    Integer checkoutCurrentSelected = currentCheckoutKeys[i];
                    Integer getMenuPrice = db.getMenuPrice(checkoutCurrentSelected);
                    String value = counter.get(checkoutCurrentSelected).toString();

                    componentSearch.searchCheckoutLabel("checkoutQty" + (i + 1)).setText(value);
                    componentSearch.searchCheckoutLabel("checkoutName" + (i + 1)).setText(db.getMenuName(checkoutCurrentSelected));
                    componentSearch.searchCheckoutLabel("checkoutPrice" + (i + 1)).setText(GUIHelper.splitPrice(getMenuPrice));
                    componentSearch.searchCheckoutLabel("checkoutIcon" + (i + 1)).setIcon(new javax.swing.ImageIcon(db.getCheckoutIcon(checkoutCurrentSelected)));
                }
            }
            String[] componentNames = {
                "checkoutIcon", "checkoutName",
                "checkoutPrice", "checkoutBackground",
                "checkoutQty"
            };
            for (String componentName : componentNames) {
                componentSearch.searchCheckoutLabel(componentName + fixedIndex).setVisible(isVisible);
            }
        }
    }
}


