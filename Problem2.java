class Solution{
    //Function to display the minimum and maximum in an input array in less than O(n)
    /**
     *
     * @param input
     * 1. Create the pairs in the input array
     * 2. Maintain a global maximum and minimum
     * 3. For each pair compare between them and compare minimu of two with the global minimum and maximum
     * of two with global maximum
     * Time complexity - O(1.5*N)
     * Space complexity - O(1)
     */

        static class Pair{
            int min;
            int max;
        }

        public void minMax(int[] input)
        {
            int i=0;
            Pair p = new Pair();
            if(input.length%2==0)
            {
                if(input[0]>input[1])
                {
                    p.max=input[0];
                    p.min=input[1];
                }
                else
                {
                    p.min=input[0];
                    p.max=input[1];
                }
                i = 2;
            }
            else
            {
                p.min=input[0];
                p.max=input[0];
            }
            while(i<input.length)
            {
                if(input[i]>input[i+1])
                {
                    if(input[i]>p.max)
                    {
                        p.max=input[i];
                    }
                    if(input[i+1]<p.min)
                    {
                        p.min=input[i+1];
                    }
                }
                else
                {
                    if(input[i+1]>p.max)
                    {
                        p.max=input[i+1];
                    }
                    if(input[i]<p.min)
                    {
                        p.min=input[i];
                    }
                }
                i+=2;
            }
            System.out.println("Min is "+p.min);
            System.out.println("Max is "+p.max);
        }

        public static void main(String[] args) {
            MinMaxInArray mx = new MinMaxInArray();
            mx.minMax(new int[] {2,15,8,6,4,1});
        }
    }

