import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private volatile int i = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition printFizzBuzzCondition = lock.newCondition();
    private final Condition printFizzCondition = lock.newCondition();
    private final Condition printBuzzCondition = lock.newCondition();
    private final Condition printICondition = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (i <= n && !(i % 3 == 0 && i % 5 != 0)) {
                    printFizzCondition.await();
                }
                if (i > n) break;
                printFizz.run();
                i++;
                signalNext();
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (i <= n && !(i % 5 == 0 && i % 3 != 0)) {
                    printBuzzCondition.await();
                }
                if (i > n) break;
                printBuzz.run();
                i++;
                signalNext();
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (i <= n && !(i % 3 == 0 && i % 5 == 0)) {
                    printFizzBuzzCondition.await();
                }
                if (i > n) break;
                printFizzBuzz.run();
                i++;
                signalNext();
            } finally {
                lock.unlock();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (i <= n && !(i % 3 != 0 && i % 5 != 0)) {
                    printICondition.await();
                }
                if (i > n) break;
                printNumber.accept(i);
                i++;
                signalNext();
            } finally {
                lock.unlock();
            }
        }
    }

    private void signalNext() {
        if (i > n) {
            printFizzBuzzCondition.signalAll();
            printFizzCondition.signalAll();
            printBuzzCondition.signalAll();
            printICondition.signalAll();
        } else if (i % 3 == 0 && i % 5 == 0) {
            printFizzBuzzCondition.signal();
        } else if (i % 3 == 0) {
            printFizzCondition.signal();
        } else if (i % 5 == 0) {
            printBuzzCondition.signal();
        } else {
            printICondition.signal();
        }
    }
}
