class Solution {
    public int maximumSwap(int num) {
        
        List<Integer> list = new ArrayList<>();
        if (num == 0) return 0;
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        //
        int n = list.size();
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        for (int i = 1; i < n; i++) {
            if (list.get(leftMax[i - 1]) < list.get(i)) {
                leftMax[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i) < list.get(leftMax[i])) {
                int j = leftMax[i];
                int tmp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, tmp);
                break;
            }
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res *= 10;
            res += list.get(i);
        }
        return res;
    }
}