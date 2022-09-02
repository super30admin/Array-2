public class FindMaxMin {
        static class Res {
            int min;
            int max;
        }
    
        static Res findMaxMin(int nums[]) {
            Res res = new Res();
            int len = nums.length;
            int startIx;
            
            if (len % 2 == 0) {
                res.min = Math.min(nums[0], nums[1]);
                res.max = Math.max(nums[0], nums[1]);
                startIx = 2;
            }else {
                res.min = nums[0];
                res.max = nums[0];
                startIx = 1;
            }
            while (startIx < len - 1) {
                int tempMin = Math.min(nums[startIx], nums[startIx + 1]);
                int tempMax = Math.max(nums[startIx], nums[startIx + 1]);
                if (tempMin < res.min){
                    res.min = tempMin;
                }
                if (tempMax > res.max){
                    res.max = tempMax;
                }
                startIx += 2;
            }
    
            return res;
        }
    }
    
