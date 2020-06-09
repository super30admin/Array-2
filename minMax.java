// Time Complexity :O(1.5 n) n is the length of the array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3,9,8,5,2,1,0};
        System.out.println("[Max,Min]"+minMax(array));
    }
    
    public static List<Integer> minMax(int[] array){
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<array.length-1;i = i+2){
            int cMin = 0; int cMax = 0;
            if(array[i]>array[i+1]){
                cMax = array[i];
                cMin = array[i+1];
            }
            else{
                cMax = array[i+1];
                cMin = array[i];
            }
            
            if(cMin<min) min = cMin;
            if(cMax>max) max = cMax;
        }
        
        if(array.length % 2 != 0){
            if(array[array.length-1]>max) max = array[array.length-1];
            if(array[array.length-1]<min) min = array[array.length-1];
        }
        
        result.add(max);
        result.add(min);
        return result;
    }
    
}