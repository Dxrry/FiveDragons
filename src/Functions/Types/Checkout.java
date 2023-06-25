/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Types;

/**
 *
 * @author dxrry
 */
public class Checkout {
    
    private final Integer checkoutMenuId;
    private final Integer checkoutMenuQty;

    public Checkout(Integer menuId) {
        this.checkoutMenuId = menuId;
        this.checkoutMenuQty = 1;
    }
    
    public Integer getCheckoutMenuId() {
        return checkoutMenuId;
    }
    
    public Integer getCheckoutMenuQty() {
        return checkoutMenuQty;
    }
    
}