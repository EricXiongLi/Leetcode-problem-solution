class Solution {
    public int maximumSum(int[] arr) {
        int prevDeleted = 0;
        int prevNotDeleted = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            prevDeleted = Math.max(prevNotDeleted > 0 ? prevNotDeleted : num, prevDeleted + num);
            prevNotDeleted = prevNotDeleted > 0 ? prevNotDeleted + num : num;
            res = Math.max(res, Math.max(prevDeleted, prevNotDeleted));
        }
         return res;
        
    }
}

//not: 
//.  
