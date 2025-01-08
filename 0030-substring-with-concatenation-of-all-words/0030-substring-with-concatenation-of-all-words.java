class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        Map<String, Integer> dic = new HashMap<>();
        int l = words[0].length();
        List<Integer> res = new ArrayList<>();

        for (String word : words) {
            dic.put(word, dic.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < l; i++) {
            int left = i;
            Map<String, Integer> seen = new HashMap<>();
            int cnt = 0;
            for (int j = left; j <= s.length() - l; j+=l) {
                String sub = s.substring(j, j + l);
                if (dic.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    cnt++;
                    while (seen.get(sub) > dic.get(sub)) {
                        String leftSub = s.substring(left, left + l);
                        seen.put(leftSub, seen.get(leftSub) - 1);
                        cnt--;
                        left += l;
                    }
                } else {
                    seen.clear();
                    cnt=0;
                    left = j + l;
                }

                if (cnt == words.length) res.add(left);
            }
        }

        return res;
    }
}