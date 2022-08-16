class Solution {
    public boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0) return false;
        if (x < 0) return false;
        int reverseNum = 0;
        while (reverseNum < x) {
            int lastDigit = x % 10;
            x = x/10;
            reverseNum = reverseNum * 10 + lastDigit;
        }
        return reverseNum == x || reverseNum / 10 == x;
    }
}