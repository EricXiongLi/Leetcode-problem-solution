class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] count = new int[1001];
        int[] res = new int[n1];
        for (int num: arr1) {
            count[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            while (count[num] > 0) {
                res[index] = num;
                index++;
                count[num]--;
            }
        }
        
        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                res[index] = i;
                index++;
                count[i]--;
            }
        }
        
        return res;
        
    }
}