import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {
    public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> sortedList1, ArrayList<T> sortedList2) {
        ArrayList<T> sortedList = new ArrayList<>();
        int size1 = sortedList1.size(), size2 = sortedList2.size();
        int iterator1 = 0, iterator2 = 0;
        while (iterator1 < size1 && iterator2 < size2) {
            if (sortedList1.get(iterator1).compareTo(sortedList2.get(iterator2)) >= 0) { // T1 >= T2
                sortedList.add(sortedList1.get(iterator1));
                iterator1++;
            }
            else {
                sortedList.add(sortedList2.get(iterator2));
                iterator2++;
            }
        }

        while (iterator1 < size1) {
            sortedList.add(sortedList1.get(iterator1));
            iterator1++;
        }

        while (iterator2 < size2) {
            sortedList.add(sortedList2.get(iterator2));
            iterator2++;
        }

        return sortedList;
    }

    public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> elements) {
        int size = elements.size();
        if (size <= 1) {
            return elements;
        }
        int mid = size / 2;

        List<T> tmp = elements.subList(0, mid);
        ArrayList<T> list1 = new ArrayList<>(tmp);
        list1 = mergeSort(list1);

        tmp = elements.subList(mid, size);
        ArrayList<T> list2 = new ArrayList<>(tmp);
        list2 = mergeSort(list2);

        return merge(list1, list2);
    }

//    public static void main(String[] args) {
//        int[] a = {1,2,2,34,2,1,6,43,231,54,21,1,54,5,76};
//
//    }

}
