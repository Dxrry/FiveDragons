/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author dxrry
 */
public class GUIHelper {
    public static int objToInt(Object number) {
        int numberToBeConvert = (int) number;
        return numberToBeConvert;
    }
    public static String objToStr(Object number) {
        String numberToBeConvert = Integer.toString((int) number);
        return numberToBeConvert;
    }
    public static String splitPrice(Integer valueToBeConvert) {
        if (valueToBeConvert >= 1000000) {
            return "Rp " + (valueToBeConvert / 1000000) + "Jt";
        } else if (valueToBeConvert >= 1000) {
            return "Rp " + (valueToBeConvert / 1000) + "k";
        } else {
            return String.valueOf(valueToBeConvert);
        }
    }
    public static String priceIdr(Integer valueToBeConvert) {
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedValue1 = rupiahFormat.format((long) valueToBeConvert);
        return formattedValue1;
    }
}
