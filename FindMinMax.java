public class FindMinMax
{
    
    public static class Pair{
        int min;
        int max;
        Pair()
        {
            this.min=Integer.MAX_VALUE;
            this.max=Integer.MIN_VALUE;
        }
    }
    public static Pair getMinMax(int [] nums)
    {
        int n=nums.length;
        int i;
		Pair p = new Pair();
		if(n==1){
		    p.min=nums[0];
		    p.max=nums[0];
		    return p;
		}
		if(n%2==0)
		{
		    if(nums[0]>nums[1])
		    {
		        p.min=nums[1];
		        p.max=nums[0];
		    }
		    else{
		         p.min=nums[1];
		        p.max=nums[0];
		    }
		    i=2;
		}
		else{
		    p.min=nums[0];
		    p.max=nums[0];
		    i=1;
		}
		
		while(i< n-1)
		{
		    if(nums[i]>nums[i+1])
		    {
		        if(nums[i]>p.max)
		        {p.max=nums[i];
		        }
		        if(nums[i+1]<p.min)
		        {p.min=nums[i+1];
		        }
		    }
		    else{
		         if(nums[i+1]>p.max)
		        {p.max=nums[i+1];
		        }
		        if(nums[i]<p.min)
		        {p.min=nums[i];
		        }
		    }
		    i+=2;
		    
		}
		return p;
		
    }
	public static void main(String[] args) {
	    int nums[] = {1666,26,65,1288,5467};
	    Pair res = getMinMax(nums); 
		System.out.println(res.min+" "+res.max);
	}
}

//tc: O(n)
//sc: O(1)