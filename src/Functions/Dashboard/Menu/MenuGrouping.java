/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.Dashboard.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dxrry
 */

public class MenuGrouping {
    public static List<List<Integer>> groupArray(int[] array) {
        List<List<Integer>> groups = new ArrayList<>();

        int groupSize = 3;
        int currentIndex = 0;

        while (currentIndex < array.length) {
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < groupSize && currentIndex < array.length; i++) {
                group.add(array[currentIndex]);
                currentIndex++;
            }
            groups.add(group);
        }

        return groups;
    }
}

