import java.util.ArrayList;
import java.util.List;

public class problem1 {
    public static void main(String args[])
    {
        int[] input={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(input));
    }

    // Time complexity : O(n)
    // Space Complexity : O(1) , I do take a aux buffer, but not sure if that is counted as extra space or not.
    // Did it run on leetcode: Yes
    // Any problem : Yes, the problem i faced was to make it in O(1) time, still unsure about if my solution uses O(1) or not.
    // Another problem was I made 1 assumption and that lead to the code throwing an error the first time, not bug free code

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>(nums.length);
        int n=nums.length;
        if(nums.length==0)
            return new ArrayList<Integer>();
        
        int[] occurences = new int[nums.length+1];
        for(int i=0;i<n;i++)
            occurences[nums[i]]+=1;
        
        for(int i=1;i<=n;i++)
            if(occurences[i]==0)
                result.add(i);

        return result;
    }
}