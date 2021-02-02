// Time Complexity :O(n)=O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
    // Finding the min and max in pairs as it reduxed the number of comparisons.
class minmax
{
        public int[] findminmax(int[] arr)
        {
            int max,min;
                if(arr.length%2==0)
                {
                    if(arr[0]>arr[1])
                    {
                        max=arr[0];
                        min=arr[1];
                    }
                    else
                    {
                        max=arr[1];
                        min=arr[0];
                    }
                }
                else
                {
                    max=arr[0];
                    min=arr[0];
                }

                int i=1;
                while(i<arr.length-1)
                {
                    if(arr[i]>arr[i+1])
                    {
                        if(arr[i]>max)
                             max=arr[i];
                            
                        if(arr[i+1]<min)
                             min=arr[i+1];

                    }
                    else
                    {
                        if(arr[i+1]>max)
                             max=arr[i+1];
                            
                        if(arr[i]<min)
                             min=arr[i];
                    }
                    i+=2;
                }
                return new int[]{max,min};
        }
        public static void main(String args[])
        {
            minmax obj= new minmax();
            int[] arr= new int[]{100,2,300,459,45,1,190};
            System.out.println("max is :"+obj.findminmax(arr)[0] + " min is :"+obj.findminmax(arr)[1]);

        }
}