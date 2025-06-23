// Time Complexity : O(N) We go through the array once, comparing elements in pairs, so it's still linear.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode / GFG : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Instead of comparing each element individually with min and max, we compare elements in pairs
// and only compare the smaller with min and the larger with max.
// This brings down the number of comparisons to roughly 1.5 * n instead of 2 * n.

// User function Template for Java
/*
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

Java users need to return result in Pair class
For Example -> return new Pair(minimum,maximum)
*/

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int n = arr.length;

        // Initialize min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Traverse in pairs
        for (int i = 0; i < n; i = i + 2) {
            if (i + 1 == n) {
                // If odd number of elements, last element left out
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            } else if (arr[i] < arr[i + 1]) {
                // Compare pair and update min and max accordingly
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            }
        }

        // Return result as a Pair (as per problem specification)
        return new Pair(min, max);
    }
}
