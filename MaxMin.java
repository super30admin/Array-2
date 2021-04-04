//Time Complexity : O(n)
//Space Complexity : O(1)
//Note: The number of comparissions is reduced to 2n/3-2 from 2n by implementing the pairs
public class knapsack {
    public static void minMax(int[] val){
        //have min and max value as negative infinity and positive infinity
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //i and j denote the index of pairs
        int i=0,j=1,small=0,large=0;
        while(i<val.length && j<val.length){
            //compare i and j values and assign the small and large values accordingly 
            if(val[i]<val[j]){
                small = val[i];
                large = val[j];
            }
            else{
                small = val[j];
                large = val[i];
            }

            min = Math.min(small,large);
            max = Math.max(small,large);
            i=i+2;
            j=j+2;
        }
        //if there are still any values left at the end in case the length of input array os odd
        if(i<val.length){
            min = Math.min(val[i],min);
            max = Math.max(val[i],max);
        }
        System.out.println("Max is "+max+" Min is "+min);
    }

    public static void main(String args[])
    {
        int val[] = new int[] { 1,1,1,1,1 };
        minMax(val);

    }
}
