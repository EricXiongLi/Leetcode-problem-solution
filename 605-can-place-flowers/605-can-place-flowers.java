class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int N = flowerbed.length;
        for (int i = 0; i <= N - 1; i++) {
            if (flowerbed[i] == 0 && (i - 1 == -1 || flowerbed[ i -1] == 0) && (i + 1 == N  || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n <= 0) return true;
            }
        }
        return n <= 0 ? true : false;
    }
}