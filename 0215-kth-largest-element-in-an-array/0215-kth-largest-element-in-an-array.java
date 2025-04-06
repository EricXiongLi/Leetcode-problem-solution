class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickselect(list, nums.length + 1 - k);
    }


    public int quickselect(List<Integer> list, int k) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        int pivotId = new Random().nextInt(list.size());
        int pivot = list.get(pivotId);
        for (int num : list) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        if (less.size() >= k) {
            return quickselect(less, k);
        } else if (k > less.size() + equal.size()) {
            return quickselect(greater, k - less.size() - equal.size());
        } else {
            return pivot;
        }
    }
}