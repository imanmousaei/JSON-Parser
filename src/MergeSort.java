import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static ArrayList<Integer> merge(ArrayList<Integer> sortedList1, ArrayList<Integer> sortedList2) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        int size1 = sortedList1.size(), size2 = sortedList2.size();
        int iterator1 = 0, iterator2 = 0;
        while (iterator1 < size1 && iterator2 < size2) {
            if (sortedList1.get(iterator1) >= sortedList2.get(iterator2)) {
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

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> elements) {
        int size = elements.size();
        if (size <= 1) {
            return elements;
        }
        int mid = size / 2;

        List<Integer> tmp = elements.subList(0, mid);
        ArrayList<Integer> list1 = new ArrayList<>(tmp);
        list1 = mergeSort(list1);

        tmp = elements.subList(mid, size);
        ArrayList<Integer> list2 = new ArrayList<>(tmp);
        list2 = mergeSort(list2);

        return merge(list1, list2);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 6, 4, 8, 2, 5, 8, 0, 3, 1, 5, 7, 8};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(mergeSort(list));
    }
}
