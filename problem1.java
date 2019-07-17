 import java.util.*;
public class problem1 {

    public static List<Integer> disappear(int[] arr) {
        List<Integer> l1 = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++) {
            int val = Math.abs(arr[i])-1;
            if(arr[val]>0) {
                arr[i] = -arr[val];
            }
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>0) {
                l1.add(i+1);
            }
        }
        return l1;
        
    }
    public static void main(String[] args) {
        int[] arr = {4,2,3,7,8,2,3,1};
        System.out.println(disappear(arr));
    }
} 