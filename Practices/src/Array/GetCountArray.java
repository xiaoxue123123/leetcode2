package Array;

public class GetCountArray {

    public int[] countArray(int[] array) {
        int[] indexArray = initialIndexArray(array); // indices of each position
        int[] countArray = new int[array.length]; // result
        int[] helper = new int[array.length];
        mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
        return countArray;
    }

    private int[] initialIndexArray(int[] array) {
        int[] indices = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        return indices;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, indexArray, countArray, helper, 0, mid);
        mergeSort(array, indexArray, countArray, helper, mid + 1, right);
        merge(array, indexArray, countArray, helper, left, mid, right);
    }

    private void copyArray(int[] indexArray, int[] helper, int left, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = indexArray[i];
        }
    }

    private void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
        // copy当前操作(left to right)的indices
        copyArray(indexArray, helper, left, right);
        int l = left;
        int r = mid + 1;
        int cur = left;
        while (l <= mid) {
            // 谁小移谁
            if (r > right || array[helper[l]] <= array[helper[r]]) {
                // 
                countArray[helper[l]] += (r - mid - 1);
                indexArray[cur++] = helper[l++];
            } else {
                indexArray[cur++] = helper[r++];
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[]{4,1,3,2};
//        int[] countArray = new int[4];
//        int[] helper = new int[4];
//        int[] indexArray = new int[]{0,1,2,3};
        GetCountArray s = new GetCountArray();
//        s.merge(array, indexArray, countArray,helper,2,2,3);

    }
}
