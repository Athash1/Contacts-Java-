import java.util.List;
import java.util.Objects;


class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        int n1 = 0;
        int n2 = 0;
        Integer number = elem;
        for (Integer a :
                list1) {
            if (Objects.equals(a, number)) {
                n1 += 1;
            }
        }
        for (Integer b :
                list2) {
            if (Objects.equals(b, number)) {
                n2 += 1;
            }
        }
        if (Objects.equals(n1,n2)) {
            return true;
        }
        return false;
    }
}