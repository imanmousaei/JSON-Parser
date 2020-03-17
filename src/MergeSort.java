import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static ArrayList<Float> merge(ArrayList<Float> sortedList1, ArrayList<Float> sortedList2) {
        ArrayList<Float> sortedList = new ArrayList<>();
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

    public static ArrayList<Float> mergeSort(ArrayList<Float> elements) {
        int size = elements.size();
        if (size <= 1) {
            return elements;
        }
        int mid = size / 2;

        List<Float> tmp = elements.subList(0, mid);
        ArrayList<Float> list1 = new ArrayList<>(tmp);
        list1 = mergeSort(list1);

        tmp = elements.subList(mid, size);
        ArrayList<Float> list2 = new ArrayList<>(tmp);
        list2 = mergeSort(list2);

        return merge(list1, list2);
    }

}
