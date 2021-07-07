import java.util.ArrayList;
import java.util.List;

// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] a) {
        
         List<Integer> list = new ArrayList<Integer>();
      //  Approach -1
      /* 
        
        for(int i = 0; i < a.length; i++) {
            
            
            while(a[i] != i+1 && a[i] != a[a[i] -1]) {
                
                swap(a, i , a[i]-1);
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            
            if(a[i] != i+1) list.add(i+1);
        }
        
        
        return list;
        
    }
    
    private void swap(int[] a, int i, int j) {
        
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    */
        for(int i=0;i<a.length;i++)
        {
            int index=Math.abs(a[i]);
            
            if(a[index-1]>0)
                a[index-1]*=-1;
        }
        
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
                list.add(i+1);
        }
        return list;
    }
    
}

