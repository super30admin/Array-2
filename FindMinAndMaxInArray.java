package Array2;

/*S30 Big N Problem #32 {Easy } - https://www.youtube.com/watch?v=UelwTIob75I
 
An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons

Source Link: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n) with 1.5 * (n-2) comparisions
    space complexity: o(1) as we are mutating the same matrix
    Did this code run successfully in leetcode : yes
    problems faces : no
*/
    
public class FindMinAndMaxInArray {
    
    public static void main(String[] args)
    {
        int[] a = {7,9,2,10,11,25,6,7};
        int[] mimmax = minAndMaxinArray(a);
        System.out.println(mimmax[0]+":"+mimmax[1]);
    }
    
    public static int[] minAndMaxinArray(int[] array)
    {
        int[] minmax = new int[2];
        int min;
        int max;
        int i;
        
        if(array.length%2 == 0)
        {
            min = array[0];
            max = array[1];
             i= 2;
        }
        else
        {
            min = array[0];
            max = array[0];
             i= 1;
        }
        
        while(i < array.length-1)
        {
            if(array[i] > array[i+1] )
            {
                if(array[i] > max)
                {
                    max = array[i];
                }
                if(array[i+1] < min)
                {
                    min = array[i+1];
                }
            }
            else
            {
                if(array[i+1] > max)
                {
                    max = array[i+1];
                }
                if(array[i] < min)
                {
                    min = array[i];
                }
            }
            
            i+=2;
        }
        
        minmax[0] = min;
        minmax[1] = max;
        
        return minmax;
    }

}
