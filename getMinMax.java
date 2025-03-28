// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -.
// Any problem you faced while coding this : No.

// Approach:
// 1. Compare each pair of elements and determine the local min and max.
// 2. Update the global min and max by comparing them with the local min and max.
// 3. If the array has an odd length, handle the last element separately.
// 4. Return the minimum and maximum values as a Pair.


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

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int z = arr.length / 2;

        for (int i = 0; i < 2 * z; i += 2) {
            int localMax = arr[i];
            int localMin = arr[i + 1];

            if (arr[i] < arr[i + 1]) {
                localMax = arr[i + 1];
                localMin = arr[i];
            }

            max = Math.max(max, localMax);
            min = Math.min(min, localMin);
        }

        if (arr.length % 2 == 1) {
            max = Math.max(max, arr[arr.length - 1]);
            min = Math.min(min, arr[arr.length - 1]);
        }

        return new Pair<>(min, max);
    }
}

public class getMinMax {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 5, 1, 8, 7, 2, 6};
        Pair<Integer, Integer> result = solution.getMinMax(arr);
        System.out.println("Min: " + result.getKey() + ", Max: " + result.getValue());
    }
}
