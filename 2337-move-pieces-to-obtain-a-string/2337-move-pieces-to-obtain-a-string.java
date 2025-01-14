class Solution {
    public boolean canChange(String start, String target) {
        int p0 = 0, p1 = 0;
        int n1 = start.length(), n2 = target.length();

        while (p0 < n1 && p1 < n2) {
            // 跳过空格
            while (p0 < n1 && start.charAt(p0) == '_') {
                p0++;
            }
            while (p1 < n2 && target.charAt(p1) == '_') {
                p1++;
            }

            // 如果两个指针都到达末尾，说明匹配成功
            if (p0 == n1 && p1 == n2) return true;
            // 如果只有一个指针到达末尾，说明不匹配
            if (p0 == n1 || p1 == n2) return false;
            
            // 检查字符是否相同
            if (start.charAt(p0) != target.charAt(p1)) {
                return false;
            }
            
            // 检查移动方向的限制
            if (start.charAt(p0) == 'L' && p0 < p1) return false;
            if (start.charAt(p0) == 'R' && p0 > p1) return false;
            
            p0++;
            p1++;
        }

        // 继续跳过剩余的空格
        while (p0 < n1 && start.charAt(p0) == '_') p0++;
        while (p1 < n2 && target.charAt(p1) == '_') p1++;

        // 检查是否所有字符都处理完毕
        return p0 == n1 && p1 == n2;
    }
}