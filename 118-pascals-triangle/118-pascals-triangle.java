class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> tmp = new ArrayList<>();
      tmp.add(1);
      res.add(tmp);
      for (int i = 1; i <= numRows - 1; i++) {
        List<Integer> level = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
          if (j == 0) {
            level.add(1);
          } else if (j == i){
            level.add(1);
          } else {
            level.add(res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
          }
        }
        res.add(level);
      }
      return res;
    }
}