package sort;

public class MergeSort extends SortUtil {


    public static void main(String[] args) {
        printArray(arr, "排序前");
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr, "排序后");

    }


    public static void mergeSort(int[] arr, int left, int right) {

        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);


    }

    private static void merge(int[] arr, int left, int mid, int right) {

        // 创建一个临时数组
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k ++] = arr[j++];
        }

        // 复制数组
        for (int h = 0; h < temp.length; h++) {
            arr[left + h] = temp[h];
        }


    }


}
