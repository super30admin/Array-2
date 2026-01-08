import java.util.ArrayList;
import java.util.Arrays;

public class MinMaxFinder {
    public static void findMinMax(ArrayList<Integer> arr, ArrayList<Integer> result) {
        int n = arr.size();
        int mini, maxi, i;

        // Initialize min and max
        if (n % 2 == 1) {
            mini = maxi = arr.get(0);
            i = 1;
        } else {
            if (arr.get(0) < arr.get(1)) {
                mini = arr.get(0);
                maxi = arr.get(1);
            } else {
                mini = arr.get(1);
                maxi = arr.get(0);
            }
            i = 2;
        }

        // Process elements in pairs
        while (i < n - 1) {
            if (arr.get(i) < arr.get(i + 1)) {
                mini = Math.min(mini, arr.get(i));
                maxi = Math.max(maxi, arr.get(i + 1));
            } else {
                mini = Math.min(mini, arr.get(i + 1));
                maxi = Math.max(maxi, arr.get(i));
            }
            i += 2;
        }

        result.add(mini);
        result.add(maxi);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 4, 1, 9));
        ArrayList<Integer> result = new ArrayList<>();
        findMinMax(arr, result);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}