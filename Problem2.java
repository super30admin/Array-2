// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, it ran locally
// Any problem you faced while coding this : NONE


public class Problem2 {

    public int[] minMaxArray(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i : arr) {
            if (i >= max) {
                max = i;
            } else {
                min = i;
            }
        }

        return new int[]{min, max};
    }

}
