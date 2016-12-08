import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");

        System.out.println(map.get(0));
        map.remove(2);

        Set<Integer> keys = map.keySet();
        Collection<String> values = map.values();

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (String val : values) {
            System.out.println(val);
        }

        String[] arrayVals = values.toArray(new String[]{});
        for (int i = 0; i < arrayVals.length; i++) {
            String val = arrayVals[i];

            System.out.println(val);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("val");
        list.remove("val");

        if (list.contains("val")) {
            System.out.println("Contains");
        }

        int idx = list.indexOf("val");
        if (idx != -1) {
            System.out.println(list.get(idx));
        }

        int lastIndexOf = list.lastIndexOf("val");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.size());

        list.set(0, "vdla");
    }
}
