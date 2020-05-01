public class Main {

    public static void main(String[] args) {
	// write your code here
//        int[] arr1 = {4, 2, 5, 1, 7, 3, 5, 2};
//        int[] arr2 = {9, 4, 5, 2, 3, 7, 1, 8};
//
//        ArraySort.quickSort(arr1);
//        ArraySort.quickSort(arr2);
//
//        printArray(arr1);
//        printArray(arr2);
        int n = 100000;
        UnionFind uf = new UnionFind(n);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.union(a, b);
        }
        for(int i = 0; i < n; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            uf.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("UnionFind, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
