// Time Complexity : O(n)
//If n is odd then 3 * (n-1) / 2 + 2 = 3n/2 + 2;
//If n is even then  3*(n-2)/2 = 3n/2
// Space Complexity : O(1) as the result array will always have two elements Min and Max
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Group the array elements in pairs and check for the minimum and maximum among the pairs.
// This would give us 3n/2 computations.
//If the array length is odd then then leaving the first element as min or max and grouping the rest of the elements would
// give us 3n/2 + 2 computations.
public class MinMax {
    public int[] findMaxMin(int arr[]) {
        int max;
        int min;
        int i;
        int res[] = new int[2];
        if (arr.length % 2 != 0) {
            min = arr[0];
            max = arr[0];
            i = 1;
        } else {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;

        }
        while (i < arr.length) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < min)
                    min = arr[i];
                if (arr[i + 1] > max)
                    max = arr[i + 1];
            } else {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i + 1] < min)
                    min = arr[i + 1];
            }
            i = i + 2;
        }
        res[0] = max;
        res[1] = min;
        return res;

    }

    public static void main(String args[]) {
        MinMax obj = new MinMax();
        int arr[] = { 3, 5, 7, 1, 2, 9 };

        int res[] = obj.findMaxMin(arr);
        System.out.println("Max = " + res[0] + "\nMin = " + res[1]);
    }
}
