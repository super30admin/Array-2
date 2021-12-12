public class MinMax {
    /*
        TC:O(n)
        SC:O(1)

     */

    public void minMax(int nums[]){
        if(nums==null || nums.length==0) return;

        int n=nums.length;
        int end=0;
        boolean isOdd=false;
        if(n%2==0){
            end=n-1;
        }
        else{
            end=n-2;
            isOdd=true;
        }

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<=end;i+=2){
            int n1=nums[i];
            int n2=nums[i+1];
            if(n1<n2){
                min=Math.min(min,n1);
                max=Math.max(max,n2);
            }
            else{
                min=Math.min(min,n2);
                max=Math.max(max,n1);
            }
        }

        if(isOdd){
            min=Math.min(nums[n-1],min);
            max=Math.min(nums[n-1],max);
        }

        System.out.println("Min " + min);
        System.out.println("Max " + max);
    }

    public static void main(String args[]){
        MinMax m=new MinMax();
        int num[]=new int[]{5,3,6,7,9,8,15,2,-1,0,25,20};
        m.minMax(num);
    }
}
