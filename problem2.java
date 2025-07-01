// Time Complexity : O(n) // 1.5n-2 comparison
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - instead of iterating one at a time and using 2 comparisons, I iterate two at a time and use 3 comparisons. On an average there are 3 comparisons for every 2 elements as compared to 2 comparisons for every element in the array.

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
        int min, max;
        int i;
        if (arr.length % 2 == 0) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        } else {
            min = max = arr[0];
            i = 1;
        }
        while (i < arr.length - 1) {
            int a = arr[i];
            int b = arr[i + 1];
            if (a < b) {
                if (a < min) min = a;
                if (b > max) max = b;
            } else {
                if (b < min) min = b;
                if (a > max) max = a;
            }
            i += 2;
        }
        return new Pair<>(min, max);
    }
}
