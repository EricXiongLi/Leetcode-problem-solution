class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        int maxDefense = properties[0][1], n = properties.length, maxAttack = properties[0][0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            maxDefense = Math.max(maxDefense, properties[i][1]);
            maxAttack = Math.max(maxAttack, properties[i][0]);
            if (maxAttack > properties[i][0] && maxDefense > properties[i][1]) {
                res++;
            }
        }
        return res;
        
    }
}

//tc: O(nlogn)
//sc: O(1)