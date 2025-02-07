/*Time Complexity: O(n) only traversing the array once (but reducing the comparisions by making pair comparisions)
 * Space Complexity: O(1)
 * Leetcode: yes
 * Any Issues: no
 */
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
public class MinMax {
        public Pair<Integer, Integer> getMinMax(int[] arr) {
            // Code Here
            int maximum = Integer.MIN_VALUE;
            int minimum = Integer.MAX_VALUE;
            int i = 0;
            while(i < arr.length-1)
            {
                if(arr[i] < arr[i+1])
                {
                    maximum = Math.max(maximum, arr[i+1]);
                    minimum = Math.min(minimum, arr[i]);
                }
                else
                {
                    maximum = Math.max(arr[i], maximum);
                    minimum = Math.min(arr[i+1], minimum);
                }
                i++;
            }
            if(i==arr.length-1)
                {
                     maximum = Math.max(arr[i], maximum);
                    minimum = Math.min(arr[i], minimum);
                }
            Pair<Integer, Integer> p = new Pair<>(minimum, maximum);
            return p;
        }
    }
