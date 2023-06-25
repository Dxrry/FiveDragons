/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard;

import Functions.MenuFunctions;
import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author dxrry
 */
public class AddCheckoutItems {
    private final Dictionary<String, List<Dictionary<String, Object>>> listMenuCheckout;
    private final int pageSize;
    private final MenuFunctions menuFunctions;
    private int totalPages;
    private int currentPages;
    
    public AddCheckoutItems() {
        listMenuCheckout = new Hashtable<>();
        this.menuFunctions = new MenuFunctions();
        pageSize = 2;
    }
    
    public void getItems(String itemsCategories) {
        // Membuat objek Dictionary untuk menuOne
        List<Dictionary<String, Object>> foodMenu = new ArrayList<>();
        foodMenu.add(createMenuItem("Burger", "Burger Special", 15000));
        foodMenu.add(createMenuItem("Kebab", "Kebab Dark Brown", 10000));
        foodMenu.add(createMenuItem("HotDog", "Hotdog Dark Brown", 20000));
        foodMenu.add(createMenuItem("Sosis", "Sosis Dark Brown", 20000));
        foodMenu.add(createMenuItem("Spagetti", "Spagetti Dark Brown", 15000));
        foodMenu.add(createMenuItem("Pizza", "Pizza Papperoni", 10000));
        foodMenu.add(createMenuItem("XXXXXXXX", "Limited Edition", 50000));

        // Menambahkan menuOne dan menuTwo ke listMenu
        listMenuCheckout.put("checkoutMenu", foodMenu);
    }
    
    public Integer getTotalPages(String itemsType) {
        List<Dictionary<String, Object>> foodMenu = listMenuCheckout.get(itemsType);
        int totalPages = (int) Math.ceil(foodMenu.size() / (double) pageSize);
        return totalPages;
    }
    
    // Metode bantu untuk membuat objek Dictionary dari data menu
    private static Dictionary<String, Object> createMenuItem(String name, String desc, int price) {
        Dictionary<String, Object> menuItem = new Hashtable<>();
        menuItem.put("name", name);
        menuItem.put("desc", desc);
        menuItem.put("price", price);
        return menuItem;
    }
    
//    public static void main(String[] args) {
//        MenuFunctions menuFunctions = new MenuFunctions();
//        List<Dictionary<String, Object>> menuItem = menuFunctions.fetchMenuAll("menuDrinks");
//        
//        System.out.println(menuItem.get(0));
//        Field[] fields = initComponents.class.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//        System.out.println(Arrays.toString(fields));
//        System.out.println(fields);
//    }
}
