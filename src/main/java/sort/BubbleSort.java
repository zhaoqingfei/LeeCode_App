package sort;

/**
 * 冒泡排序
 */
public class BubbleSort extends SortUtil  {

    public static void main(String[] args) {
        printArray(arr, "排序前");
        sort(arr);
        printArray(arr, "排序后");
    }


    static void sort(int arr[]) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n -1; i++) {  // 注意这里i的边界条件为 n-1
            boolean swaped = false;
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }


    }



}
