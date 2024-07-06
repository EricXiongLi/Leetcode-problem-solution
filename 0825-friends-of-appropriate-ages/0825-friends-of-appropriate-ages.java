class Solution {
    public int numFriendRequests(int[] ages) {
        //1. y > 0.5x + 7
        //2. y <= x
        //3. redundant
        //0.5x + 7 < x => 0.5x > 7 => x > 14
        //person number with age i: [1, 2,3 ,4 5]
        //[sum1, sum2, sum3, sum4, sum5]: the number of person whose age is lower tha sum[i]
        int[] ageNum = new int[121];
        int[] ageSum = new int[121];
        for (int age : ages) {
            ageNum[age]++;
        }
        
        for (int i = 1; i< 121; i++) {
            ageSum[i] = ageSum[i - 1] + ageNum[i];
        }
        
        int res = 0;
        for (int age : ages) {
            if (age > 14) {
                 int lower = age/2 + 7, upper = age;
                int numInBetween = ageSum[upper] - ageSum[lower];
                res += numInBetween;
                res--;
            }
           
        }
        
        return res;
    }
}

//tc: O(N)
//sc: O(1)