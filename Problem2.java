  public static int[] mains(int[] arr) {

            if(arr==null || arr.length==0)
            {
                return new int[0];
            }
             int min = 0;
             int max = 0;

            for(int i=0;i<arr.length;i+=2)
            {
                if(arr.length%2 == 1)
                {
                   max = Math.max(arr[arr.length-1],max);
                   min = Math.min(arr[arr.length-1],min);
                }else{
                    if(arr[i]>arr[i+1])
                    {
                        max = Math.max(arr[i],max);
                        min = Math.min(arr[i+1],min);
                    }
                    else{
                        max = Math.max(arr[i+1],max);
                        min = Math.min(arr[i],min);
                    }
                }

            }
            return new int[]{max,min};
        }
//runtime: O(n)
//space: O(1)

//for every 2 elements we have 3 comparisions so that would we less than 2*(n-2) comparisions
