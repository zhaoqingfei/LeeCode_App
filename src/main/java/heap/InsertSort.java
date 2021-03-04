package heap;

public class InsertSort {


    public static void main(String[] args) {

    }


    static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }


}
