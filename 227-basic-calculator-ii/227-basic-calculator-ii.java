class Solution {
    //[1, 2, 5, 3, 6, 4, 2]
    //[+, *, /, +, /, *]
    //
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int curNum = 0;
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> opeStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else {
                numStack.offer(curNum);
                opeStack.offer(c);
                curNum = 0;
            }
        }
        numStack.offer(curNum);
        while (numStack.size() > 1) {
            while (!opeStack.isEmpty()) {
                char curOpe = opeStack.poll();
                if ((curOpe == '+' || curOpe == '-') && !opeStack.isEmpty() && (opeStack.peekFirst() == '*' || opeStack.peekFirst() == '/'))  {
                    char secondOpe = opeStack.poll();
                    int firstNum = numStack.poll(), secondNum = numStack.poll(), thirdNum = numStack.poll();
                    int temp = operate(secondNum, secondOpe, thirdNum);
                    numStack.offerFirst(temp);
                    numStack.offerFirst(firstNum);
                    opeStack.offerFirst(curOpe);
                } else {
                    
                    int firstNum = numStack.poll();
                    int secondNum = numStack.poll();
                    int curRes = operate(firstNum, curOpe, secondNum);
                    numStack.offerFirst(curRes);
                }
            }
        }
        return numStack.poll();
    }
    
    private int operate(int i, char c, int j) {
        if (c == '+') return i + j;
        if (c == '-') return i - j;
        if (c == '*') return i * j;
        if (c == '/') return i / j;
        return -1;
    }
}