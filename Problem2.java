// Time Complexity : O(2*(N - 2)) where n is the number of elements
// Space Complexity : O(1) since no extra space is required
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// in this we are dividing the elements in pairs (0,1) (2,3) and so on and for each pair we have three comparisons for n/2 elements
// 1) to find the localmax and localmin in the pair
// 2) to check the localmax is the global max
// 3) to check the localmin is the global min
// if the last element doesnt have pair we check that element with both global max and global min 
public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 43, 5, 7, 8, 9, 0, 4, 89, 346 };
        int[] out = maxMin(arr);

        for (int i : out)
            System.out.println(i);
    }

    private static int[] maxMin(int arr[]) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i = i + 2) {
            int tempMax, tempMin;
            // update locally
            if (arr[i] >= arr[i - 1]) {
                tempMin = arr[i - 1];
                tempMax = arr[i];
            } else {
                tempMin = arr[i];
                tempMax = arr[i - 1];
            }
            // update globally
            max = Math.max(tempMax, max);
            min = Math.min(tempMin, min);
        }

        if (arr.length % 2 != 0) {
            max = Math.max(max, arr[arr.length - 1]);
            min = Math.min(min, arr[arr.length - 1]);

        }
        return new int[] { max, min };
    }
}
