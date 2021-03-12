package sort;

/**
 * 快速排序
 * O(nlogN)
 */
public class QuickSort extends SortUtil {

    public static void main(String[] args) {
        System.out.println("adsadsfa");
        printArray(arr, "排序前");
        quickSort(arr, 0, arr.length - 1 );
        printArray(arr, "排序后");

    }


    static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];  // 选取最右边的左为基准值
        int index = begin;  // 较小元素交换的位置

        for (int i = begin; i < end; i++) {
            // 如查当前元素小于基准值  和index进行交换
            if (arr[i] < pivot) {
                swap(arr, index++, i);
            }
        }
        swap(arr, index, end);
        return index;

    }


    static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int pivot = partition(arr, begin, end);
            quickSort(arr, begin, pivot-1);
            quickSort(arr, pivot + 1, end);
        }
    }


}
