import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    //0: to print foo
    //1: to rpint bar
    private volatile int flag = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition fooNotPrinted = lock.newCondition();
    private final Condition barNotPrinted = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	try {
                lock.lock();
                while (flag != 0) {
                    fooNotPrinted.await();
                }
                printFoo.run();
                flag = 1;
                barNotPrinted.signalAll();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag != 1) {
                    barNotPrinted.await();
                }
                printBar.run();
                flag = 0;
                fooNotPrinted.signal();
            } finally {
                lock.unlock();
            }
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	
        }
    }
}