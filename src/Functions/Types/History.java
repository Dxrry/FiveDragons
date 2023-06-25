/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Types;

/**
 *
 * @author dxrry
 */
public class History {
    
    private final Integer historyId;
    private final String menuSelected;
    private final Integer userId;
    private final String historyStatus;
    private final String historyPaymentMethode;
    private final String historyPaymentName;
    private final String historyDate;

    public History(Integer historyId, String menuSelected, Integer userId, String historyStatus, String historyDate, String historyPaymentMethode, String historyPaymentName) {
        this.historyId = historyId;
        this.menuSelected = menuSelected;
        this.userId = userId;
        this.historyStatus = historyStatus;
        this.historyDate = historyDate;
        this.historyPaymentMethode = historyPaymentMethode;
        this.historyPaymentName = historyPaymentName;
    }
    
    public Integer getHistoryID() {
        return historyId;
    }

    public String getMenuSelected() {
        return menuSelected;
    }

    public Integer getUserID() {
        return userId;
    }
    
    public String getStatus() {
        return historyStatus;
    }
    
    public String getPaymentMethode() {
        return historyPaymentMethode;
    }
    public String getPaymentName() {
        return historyPaymentName;
    }
    
    public String getDate() {
        return historyDate;
    }
}
