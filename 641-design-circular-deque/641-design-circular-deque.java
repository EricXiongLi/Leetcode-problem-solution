class MyCircularDeque {
    int[] a;
    int front, rear, size, capacity;
    
    public MyCircularDeque(int k) {
        a = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (--front < 0) front += capacity;
        size++;
        if (size == 1) rear = front;
        a[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (++rear >= capacity) rear -= capacity;
        size++;
        a[rear] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
       front = (front + 1) % capacity;
        size--;
        return true;
        
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (--rear < 0) rear += capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : a[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : a[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */