package sort;

/**
 * 选择排序
 */
public class SelectSort extends SortUtil {


    public static void main(String[] args) {

        printArray(arr, "排序前");
        sort(arr);
        printArray(arr, "排序后");

    }

    static void sort(int arr[]) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 从后面没有排序的中选择出最小的
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }

    }







}
