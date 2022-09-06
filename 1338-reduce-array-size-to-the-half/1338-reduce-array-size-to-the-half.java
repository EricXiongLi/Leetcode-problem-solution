class Solution {
    public int minSetSize(int[] arr) {
        //{<3, 4>, <5, 2>, <2, 2>, <7, 1>}
        //<
        Map<Integer, Integer> hm = new HashMap<>();
        int maxCount = 0;
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, hm.get(num));
        }
        int[] buckets = new int[maxCount + 1];
        for (int freq : hm.values()) {
            buckets[freq]++;
        }
        System.out.println(Arrays.toString(buckets));
        int count = 0;
        int toRemove = arr.length / 2;
        for (int i = maxCount; i >=0; i--) {
                while (buckets[i] >0) {
                    count++;
                    toRemove -= i;
                    buckets[i]--;
                    if (toRemove <= 0) {
                        return count;
                    }
                    
                }
        }
        return count;
    }
}