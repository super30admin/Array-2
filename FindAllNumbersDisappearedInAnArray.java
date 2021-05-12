import java.util.*;
class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        /*
        Thought Process:
        
        My first approach was to store nums values in a hashset, then loop thorugh i=1 to n and check if 
        i is not present in the hashset, then add it to result.
        The TC was O(N) and SC was O(N)
        
        Next the question suggested to reduce the SC
        
        So my second approach was to manipulate the result list itself instead of HashSet.
        First store 1 to n in the list, then check if nums[i] is present in list, then do
        list.remove(new Integer(nums[i])) to remove the value from the list. 
        Was working but time limit exceeded. The TC was O(N) and SC was O(N)
        
        Then checked professor's approach:
        Make the indexes-1 -ve and return indexes+1 of positive values.
        
        The TC was O(N) and SC was O(1)
        Understanding this approach was tricky but coding part was very easy.
        
        
        */
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] = -1* nums[index];
        }
        
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0) res.add(i+1);
        }
        return res;
    }
}