//{ Driver Code Starts
// Initial Template for Java

import java.lang.*;


// } Driver Code Ends
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
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        if(arr.length == 1){
            min=arr[0];
            max=arr[0];
        }else{
            for(int i=0;i<arr.length-1;i++){
                if(arr[i] > arr[i+1]){
                  min=Math.min(min,arr[i+1]);
                  max=Math.max(max,arr[i]);
                }else{
                     min=Math.min(min,arr[i]);
                     max=Math.max(max,arr[i+1]);
                }
            
        }
     
        }
        
        return new Pair<>(min,max);
    }
}


//{ Driver Code Starts.

// class Pair<K, V> {
//     private final K key;
//     private final V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() { return key; }

//     public V getValue() { return value; }
// }

// class GFG {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t;
//         t = Integer.parseInt(br.readLine());
//         while (t-- > 0) {
//             String line = br.readLine();
//             String[] tokens = line.split(" ");

//             // Create an ArrayList to store the integers
//             ArrayList<Integer> array = new ArrayList<>();

//             // Parse the tokens into integers and add to the array
//             for (String token : tokens) {
//                 array.add(Integer.parseInt(token));
//             }

//             int[] arr = new int[array.size()];
//             int idx = 0;
//             for (int i : array) arr[idx++] = i;

//             Solution ob = new Solution();
//             Pair<Integer, Integer> pp = ob.getMinMax(arr);
//             System.out.println(pp.getKey() + " " + pp.getValue());

//             System.out.println("~");
//         }
//     }
// }

// // } Driver Code Ends