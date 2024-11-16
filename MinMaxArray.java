/*
Time Complexity: O(n) as traversing the array

Space Complexity: O(1)

The solution cleared all test cases on Geeks For Geeks
 */

//{ Driver Code Starts
// Initial Template for Java

// } Driver Code Ends
// User function Template for Java
// User function Template for Java


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

//Java users need to return result in Pair class
//For Example -> return new Pair(minimum,maximum)


class MinMaxArray {
    public Pair<Long, Long> getMinMax(int[] arr) {
        // Code Here

        int n = arr.length;
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(int i = 0; i < n-1; i += 2)
        {
            if(i+1 < arr.length)
            {
                if(arr[i] < arr[i+1])
                {
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i+1]);
                }
                else
                {
                    min = Math.min(min, arr[i+1]);
                    max = Math.max(max, arr[i]);
                }
            }
        }

        if (n % 2 != 0) {
            min = Math.min(min, arr[n - 1]);
            max = Math.max(max, arr[n - 1]);
        }

        return new Pair<>(min, max);
    }
}

