public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr1 = {4, 2, 5, 1, 7, 3, 5, 2};
        int[] arr2 = {9, 4, 5, 2, 3, 7, 1, 8};

        ArraySort.mergeSort(arr1);
        ArraySort.mergeSort(arr2);

        printArray(arr1);
        printArray(arr2);
    }

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
