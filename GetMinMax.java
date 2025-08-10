// User function Template for Java
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
        // Code Here
        // compare all with max = 0 & min = Integer.MAX_VALUE & in TC o(n) & 2n comparison you can get max & min
        // for less no. of comparison, take pair i & i+1 compare bigger value just with max & lesser with min


        int max = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;

        for(  i = 0; i<arr.length-1 ; i++ ){
            if( arr[i] < arr[i+1] ){
                min = Math.min( arr[i] , min );
                max = Math.max( arr[i+1] , max );
            }
            else{
                min = Math.min( arr[i+1] , min );
                max = Math.max( arr[i] , max );
            }
        }

        if( arr.length % 2 != 0 ){

            min = Math.min( arr[i] , min );
            max = Math.max( arr[i] , max );

        }

        return new Pair(min,max);

    }
}
