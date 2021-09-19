import java.util.Arrays;

public class IterationMergeSort {
    public static void main(String[] args) {
        int[] nums = {1, 9, 8, 5, 6, 7, 4, 3, 2};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int len = arr.length;
        while (mergeSize < len) {
            int L = 0;
            while (L < len) {
                int M = L + mergeSize - 1;
                if (M >= len) {
                    break;
                }
                int R = Math.min(M + mergeSize, len - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > len / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
