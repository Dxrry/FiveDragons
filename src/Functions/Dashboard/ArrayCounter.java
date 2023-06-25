/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author dxrry
 */


public class ArrayCounter {
    public static Map<Integer, Integer> countElements(int[] array) {
        Map<Integer, Integer> counter = new LinkedHashMap<>();

        // Count the elements
        for (int element : array) {
            counter.put(element, counter.getOrDefault(element, 0) + 1);
        }

        return counter;
    }
}
