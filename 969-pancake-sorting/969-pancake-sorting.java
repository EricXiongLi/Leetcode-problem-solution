class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int N = arr.length;
        List<Integer> ans = new ArrayList();
        for (int pos = N - 1; pos >= 0; pos--) {
            int i = 0;
            while (i < pos && arr[i] != pos + 1) {
                i++;
            }
            if (i != pos) {
                if (i != 0) {
                    reverse(arr, 0, i);
                ans.add(i + 1);
                } 
                reverse(arr, 0, pos);
                ans.add(pos + 1);
            }
        }
        return ans;
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

//tc: O(n ^ 2)
//sc: O(1)