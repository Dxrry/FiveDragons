/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author dxrry
 */
import java.util.*;

public final class MenuFunctions {
    
    private final Dictionary<String, List<Dictionary<String, Object>>> listMenu;
    private final int pageSize;
    
    public MenuFunctions() {
        listMenu = new Hashtable<>();
        generateMenuFood();
        generateMenuDrinks();
        pageSize = 3;
    }

    public void generateMenuFood() {
        // Membuat objek Dictionary untuk menuOne
        List<Dictionary<String, Object>> foodMenu = new ArrayList<>();
        foodMenu.add(createMenuItem("Burger", "Burger Special", 15000));
        foodMenu.add(createMenuItem("Kebab", "Kebab Dark Brown", 10000));
        foodMenu.add(createMenuItem("HotDog", "Hotdog Isi Pler", 20000));
        foodMenu.add(createMenuItem("Sosis", "Sosis Dark Brown", 20000));
        foodMenu.add(createMenuItem("Spagetti", "Spagetti Dark Brown", 15000));
        foodMenu.add(createMenuItem("Pizza", "Pizza Papperoni", 10000));
        foodMenu.add(createMenuItem("XXXXXXXX", "Limited Edition", 50000));

        // Menambahkan menuOne dan menuTwo ke listMenu
        listMenu.put("menuFood", foodMenu);
    }
    
    public void generateMenuDrinks() {
        // Membuat objek Dictionary untuk menuOne
        List<Dictionary<String, Object>> drinksMenu = new ArrayList<>();
        drinksMenu.add(createMenuItem("Boba", "Cappucino", 15000));
        drinksMenu.add(createMenuItem("Capcin", "Coklat", 10000));
        drinksMenu.add(createMenuItem("Taro", "Strawberry", 20000));
        drinksMenu.add(createMenuItem("Jus 1", "Grape", 15000));
        drinksMenu.add(createMenuItem("Jus 2", "Acccccccccccc", 10000));
        drinksMenu.add(createMenuItem("Jus 3", "Acccccccccccc", 20000));
        drinksMenu.add(createMenuItem("Jus 4", "Acccccccccccc", 20000));
        drinksMenu.add(createMenuItem("Jus 5", "Acccccccccccc", 15000));
        drinksMenu.add(createMenuItem("Jus 6", "Acccccccccccc", 10000));
        drinksMenu.add(createMenuItem("Jus 7", "Acccccccccccc", 20000));
        drinksMenu.add(createMenuItem("Jus 8", "Acccccccccccc", 20000));

        // Menambahkan drinksMenuOne dan drinksMenuTwo ke drinksMenu
        listMenu.put("menuDrinks", drinksMenu);
    }
    
    public Dictionary<String, List<Dictionary<String, Object>>> fetchMenu(String menuCategories, int currentPage) {
        List<Dictionary<String, Object>> foodMenu = listMenu.get(menuCategories);
        int totalPages = (int) Math.ceil(foodMenu.size() / (double) pageSize);
        if (currentPage < 1 || currentPage > totalPages) {
            return null;
        }
        
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, foodMenu.size());
        int totalIndex = (endIndex - startIndex);
        
        List<Dictionary<String, Object>> newListMenuFresh = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            Dictionary<String, Object> menuItem = foodMenu.get(i);
            newListMenuFresh.add(createMenuItem((String) menuItem.get("name"), (String) menuItem.get("desc"), (int) menuItem.get("price")));
        }
        if(totalIndex < 3) {
            for (int iterNull = 1; iterNull <= (3 - totalIndex); iterNull++) {
                newListMenuFresh.add(createMenuItem((String) "null", (String) "null", (int) 0));
            }
        }
        Dictionary<String, List<Dictionary<String, Object>>> newListMenu = new Hashtable<>();
        newListMenu.put("menuFood", newListMenuFresh);
        return newListMenu;
    }
    
    public List<Dictionary<String, Object>> fetchMenuAll(String menuCategories) {
        List<Dictionary<String, Object>> foodMenu = listMenu.get(menuCategories);
        return foodMenu;
    }
    
    public Integer getTotalPages(String itemsType) {
        List<Dictionary<String, Object>> foodMenu = listMenu.get(itemsType);
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

    /**
     *
     * @param menuKey
     * @return
     */
    public List<Dictionary<String, Object>> getMenuByKey(String menuKey) {
        List<Dictionary<String, Object>> menuItems = listMenu.get(menuKey);
        if (menuItems != null) {
            return menuItems;
        }
        return null;
    }
    public String getItemsName(String menuKey, int itemIndex) {
        List<Dictionary<String, Object>> menuItems = listMenu.get(menuKey);
        if (menuItems != null && itemIndex >= 0 && itemIndex < menuItems.size()) {
            Dictionary<String, Object> menuItem = menuItems.get(itemIndex);
            return (String) menuItem.get("name");
        }

        return "Error !";
    }
    public Object getItemsPrice(String menuKey, int itemIndex) {
        List<Dictionary<String, Object>> menuItems = listMenu.get(menuKey);
        if (menuItems != null && itemIndex >= 0 && itemIndex < menuItems.size()) {
            Dictionary<String, Object> menuItem = menuItems.get(itemIndex);
            return (Object) menuItem.get("price");
        }

        return "Error !";
    }
    public String getItemsDesc(String menuKey, int itemIndex) {
        List<Dictionary<String, Object>> menuItems = listMenu.get(menuKey);
        if (menuItems != null && itemIndex >= 0 && itemIndex < menuItems.size()) {
            Dictionary<String, Object> menuItem = menuItems.get(itemIndex);
            return (String) menuItem.get("desc");
        }

        return "Error !";
    }
}