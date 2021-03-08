// Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
// Time Complexity = O(n)
// Space Complexity = O(1)
public class Problem2 {
    public int minmax(int [] array) {
        int max = 0;
        int min = array[0];
        for(int i=0; i<array.length; i++ ) {
           if(array[i]>max) {
              max = array[i];
           }
           if(array[i]<min) {
                min = array[i];
            }  
        }
        return max;
     }
}
