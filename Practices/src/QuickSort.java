import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = new int[]{3,1,2};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public void quickSort(int[] arr) {

        quickSortHelper(arr, 0, arr.length - 1);
    }

    private void quickSortHelper(int[] arr, int left, int right) {
        // sanity check
        if (left >= right ) {
            return;
        }
        int i = left;
        int k = right - 1;
        // choose pivot
        int pivotIndex = left + (int) (Math.random() * (right - left) + 1);
        int pivot = arr[pivotIndex];
        // swap pivot with last element
        swap(arr, pivotIndex, right);
        // traverse
        while (i <= k) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, k);
                k--;
            }
        }

// swap back
        swap(arr, i, right);
        quickSortHelper(arr, left, i - 1);
        quickSortHelper(arr, i + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}


