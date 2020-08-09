import java.util.HashSet;
import java.util.Set;

public class oddNumber {

    public static int findIt(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        for (Integer i : set) {
            a[0] = i;
        }

        return a[0];
    }

}
