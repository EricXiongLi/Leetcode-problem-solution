class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftSmaller = 0, leftGreater = 0;
            int rightGreater = 0, rightSmaller = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftSmaller++;
                } else if (rating[j] > rating[i]) {
                    leftGreater++;
                }
            }
            for (int k = n - 1; k > i; k--) {
                if (rating[k] < rating[i]) {
                    rightSmaller++;
                } else if (rating[k] > rating[i]) {
                    rightGreater++;
                }
            }
            res += leftSmaller * rightGreater + leftGreater * rightSmaller;
        }
        
        return res;
    }
}