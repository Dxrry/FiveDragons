/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Types;

/**
 *
 * @author dxrry
 */
public class Menu {
    
    private final Integer menuId;
    private final String menuName;
    private final String menuDesc;
    private final Integer menuPrice;
    private final byte[] menuIcon;

    public Menu(Integer menuId, String menuName, String menuDesc, Integer menuPrice, byte[] menuIcon) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuPrice = menuPrice;
        this.menuIcon = menuIcon;
    }
    
    public Integer getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }
    
    public Integer getMenuPrice() {
        return menuPrice;
    }
    
    public byte[] getMenuIcon() {
        return menuIcon;
    }
}
