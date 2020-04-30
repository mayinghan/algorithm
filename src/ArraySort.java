import java.util.*;

public class ArraySort {
    public static void mergeSort(int[] arr) {
        //mergeTopDown(arr, 0, arr.length - 1);
        mergeBottomUp(arr);
    }

    private static void mergeTopDown(int[] arr, int l, int r) {
        if(l >= r) return;

        int mid = l + (r - l) / 2;
        mergeTopDown(arr, l, mid);
        mergeTopDown(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void mergeBottomUp(int[] arr) {
        int n = arr.length;

        // merge from size of 1,2,4,8
        for(int size = 1; size <= n; size += size) {
            for(int i = 0; i + size< n; i += size + size) {
                // merge arr[i...i+size-1] and arr[i+size...i+2*size-1]
                merge(arr, i, i + size -1, Math.min(i + size * 2 - 1, n - 1));
            }
        }
    }

    // merge arr[l .. mid] and arr[mid+1 .. r]
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r -l + 1];
        if(arr[mid] < arr[mid + 1]) return;
        for(int i = l; i <= r; i++) {
            tmp[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++) {
            if(i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if(j > r) {
                arr[k] = tmp[i - l];
                i++;
            } else if(tmp[i - l] < tmp[j - l]) {
                arr[k] = tmp[i - l];
                i++;
            } else {
                arr[k] = tmp[j - l];
                j++;
            }
        }
    }

    public static void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int s, int e) {
        if(s > e) return;
        int pivot = partition(arr, s, e);
        quick(arr, s, pivot - 1);
        quick(arr, pivot + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
        Random random = new Random();
        int rand = s + random.nextInt(e-s+1);
        int pivot=arr[rand];
        swap(arr, s, rand);
        int l = s, r = e;
        while(l < r) {
            while(l < r && arr[r]>= pivot) r--;
            while(l < r && arr[l] <= pivot) l++;
            if(l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, l, s);
        return l;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
