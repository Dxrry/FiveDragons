package Functions.Dashboard.Checkout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckoutGrouping {
    
    public List<Map<Integer, Integer>> Group(Map<Integer, Integer> args) {
        Map<Integer, Integer> map = new LinkedHashMap<>(args);
        int groupSize = 2;
        List<Map<Integer, Integer>> groups = groupMapElements(map, groupSize);
        return groups;
    }

    private static List<Map<Integer, Integer>> groupMapElements(Map<Integer, Integer> map, int groupSize) {
        List<Map<Integer, Integer>> groups = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        int numGroups = (int) Math.ceil((double) entries.size() / groupSize);
        for (int i = 0; i < numGroups; i++) {
            int startIdx = i * groupSize;
            int endIdx = Math.min(startIdx + groupSize, entries.size());
            Map<Integer, Integer> group = new LinkedHashMap<>(); // Menggunakan LinkedHashMap untuk mempertahankan urutan

            for (int j = startIdx; j < endIdx; j++) {
                Map.Entry<Integer, Integer> entry = entries.get(j);
                group.put(entry.getKey(), entry.getValue());
            }

            groups.add(group);
        }

        return groups;
    }
}
