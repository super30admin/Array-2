class Compute 
{
    public static void getMinMax(long a[], long n)  
    {
        //Write your code here
        if(a==null || a.length == 0)
        {
            System.out.println(0);
            System.out.println(0);
        }
        
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        for(int i=0;i<n-1;i++)
        {
            if(a[i]<a[i+1])
            {
                max = Math.max(max,a[i+1]);
                min = Math.min(min,a[i]);
            }
            if(a[i]>a[i+1])
            {
                max = Math.max(max,a[i]);
                min = Math.min(min,a[i+1]);
            }
        }
        
        System.out.println("Min:"+min );
        System.out.println("Max:"+max );
    }
    
    public static void main(String args[])
    {
        long arr[] = {3, 2, 1, 56, 10000, 167};
        
        getMinMax(arr,arr.length);
    }
}