class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();

        for (int c : candies) {
            res.add(c + extraCandies >= max ? true : false);
        }
        return res;
    }
}