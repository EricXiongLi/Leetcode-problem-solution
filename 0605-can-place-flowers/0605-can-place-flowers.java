class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            boolean isLeftPossible = i == 0 ? true : (flowerbed[i - 1] == 1 ? false : true);
            boolean isRightPossible = i == l - 1 ? true : (flowerbed[i + 1] == 1 ? false : true);
            
            if (isLeftPossible && isRightPossible && flowerbed[i] != 1) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) return true;
            }
        }
        
        return false;
        
        
    }
}

//tc: O(n)
//sc: O(1)