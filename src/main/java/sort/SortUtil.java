package sort;

public abstract class SortUtil {

    static int[] arr = new int[]{12, 8, 10, 3, 18, 11, 6};

    /***
     * 交换元素
     * @param arr
     * @param i
     * @param j
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 输出数组
     * @param arr
     * @param msg
     */
    static void printArray(int[] arr, String msg) {
        System.out.print(msg + ":");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
