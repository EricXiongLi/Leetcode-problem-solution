class ZeroEvenOdd {
    private int n;
    
    private volatile boolean needZero;
    private volatile boolean needOdd;
    private volatile boolean needEven;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition printZeroCondition = lock.newCondition();
    private final Condition printOddCondition = lock.newCondition();
    private final Condition printEvenCondition = lock.newCondition();
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        needZero = true;
        needOdd = true;
        needEven = false;
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.

    //zero odd zero even zero odd zero even
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!needZero) {
                    printZeroCondition.await();
                }
                printNumber.accept(0);
                needZero = false;
                if (needEven) {
                    printEvenCondition.signal();
                } else {
                    printOddCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            try {
                lock.lock();
                while (!needEven|| needZero) {
                    printEvenCondition.await();
                }
                printNumber.accept(i);
                needEven = false;
                needOdd = true;
                needZero = true;
                printZeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            try {
                lock.lock();
                while (!needOdd || needZero) {
                    printOddCondition.await();
                }
                printNumber.accept(i);
                needZero = true;
                needOdd = false;
                needEven = true;
                printZeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}