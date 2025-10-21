class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        List<Integer> numsList = new ArrayList<>();
for (int num : nums) {
    numsList.add(num);
}
return quickselect(numsList, n - k + 1);
    }

    public int quickselect(List<Integer> nums, int k) {
        List<Integer> less = new ArrayList<Integer>(), equal = new ArrayList<>(), greater = new ArrayList<>();
        int random = new Random().nextInt(nums.size());
        int pivot = nums.get(random);
        
        for (int num : nums) {
            if (num == pivot) {
                equal.add(num);
            } else if (num < pivot) {
                less.add(num);
            } else {
                greater.add(num);
            }
        }
        if (k <= less.size()) {
            return quickselect(less, k);
        } else if (k > less.size() + equal.size()) {
            return quickselect(greater, k - less.size() - equal.size());
        } else {
            return pivot;
        }
    }
    
}