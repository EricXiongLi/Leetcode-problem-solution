class MyCircularQueue {
    int[] a;
    int front, rear, size;
    public MyCircularQueue(int k) {
        a = new int[k];
        front = 0;
        rear = - 1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % a.length;
            a[rear] = value;
            size++;
            return true;
        } else return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            size--;
            return true;
        } else return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : a[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : a[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == a.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */