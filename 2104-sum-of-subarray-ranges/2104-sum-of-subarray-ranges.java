class Solution {
    
    //1: max: 1, min: 3     -2
    //2: max: 2, min:2    0
    //3: max: 3, min: 1 =>  6
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[] smallerL = new long[n];
        long[] smallerR = new long[n];
        long[] greaterL = new long[n];
        long[] greaterR = new long[n];
        Arrays.fill(smallerL, -1);
        Arrays.fill(smallerR, n);
        Arrays.fill(greaterL, -1);
        Arrays.fill(greaterR, n);
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            smallerL[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
            while (!stack2.isEmpty() && nums[stack2.peek()] < nums[i]) {
                stack2.pop();
            }
            greaterL[i] = stack2.isEmpty() ? -1 : stack2.peek();
            stack2.push(i);
        }
        stack.clear();
        stack2.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            smallerR[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
            while (!stack2.isEmpty() && nums[stack2.peek()] <= nums[i]) {
                stack2.pop();
            }
            greaterR[i] = stack2.isEmpty() ? n : stack2.peek();
            stack2.push(i);
        }
        // System.out.println(Arrays.toString(smallerL));
        // System.out.println(Arrays.toString(smallerR));
        // System.out.println(Arrays.toString(greaterL));
        // System.out.println(Arrays.toString(greaterR));
        long res = 0;
        for (int i = 0; i < n; i++) {
            long temp = nums[i] * ((greaterR[i] - i) * (i - greaterL[i]) - (smallerR[i] - i) * (i - smallerL[i]));
            res += temp;
        }
        //1: max: 
        return res;

    }
}