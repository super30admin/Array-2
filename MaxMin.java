// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on GFF : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// // 1. Iterate through the array in Pair and compare for min and max.
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

class MaxMin {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int min = arr[0];
        int max = arr[0];

        if(arr.length == 1){
            return new Pair(min, max);
        }

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                max = Math.max(arr[i], max);
                min = Math.min(arr[i+1], min);
            }else{
                max = Math.max(arr[i+1], max);
                min = Math.min(arr[i], min);
            }
        }
        return new Pair(min, max);
    }
}
