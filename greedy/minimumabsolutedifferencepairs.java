package greedy;

public class minimumabsolutedifferencepairs {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 7};
        int[] arr2 = {2, 3, 6, 5};

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            minDiff += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println("Minimum Absolute Difference: " + minDiff);
    }
}
