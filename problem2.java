import java.util.List;

public class problem2 {
    public static void main(String args[])
    {
        int[] input={4};
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        if(input.length==0)
            System.out.println("0");
        
        for(int i=0;i<input.length;i++)
        {
            if(input[i]>max)
                max=input[i];
            
            if(input[i]<min)
                min=input[i];         
        }
        System.out.println("MAX IS "+max+"  MIN IS "+min);
    }

    // Time complexity : O(n)
    // Space Complexity : O(1)
    // Did it run on leetcode: Should Run
    // Any problem : Cannot think of possibility of 2*(N-2)  comparisons. I am thinking of 2*N comparisons
}