class FooBar {
    private int n;
    Lock lock = new ReentrantLock();
    Condition fooCondition = lock.newCondition();
    Condition barCondition = lock.newCondition();
    boolean shouldFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!shouldFoo) {
                    fooCondition.await();
                }
                printFoo.run();
                shouldFoo = !shouldFoo;
                barCondition.signal();
            } catch(Exception e) {
            } finally {
                lock.unlock();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.


            try {
                lock.lock();
                while (shouldFoo) {
                    barCondition.await();
                }
                printBar.run();
                shouldFoo = !shouldFoo;
                fooCondition.signal();
            } catch(Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }
}