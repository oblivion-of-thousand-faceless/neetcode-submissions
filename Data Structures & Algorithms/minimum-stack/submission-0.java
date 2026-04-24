class MinStack {
    private int[] data;
    private int[] mins;
    private int topIndex;
    private int capacity;

    public MinStack() {
        capacity = 10;
        data = new int[capacity];
        mins = new int[capacity];
        topIndex = -1;
    }

    public void push(int val) {
        if (topIndex == capacity - 1) {
            resize();
        }
        topIndex++;
        data[topIndex] = val;
        
        if (topIndex == 0) {
            mins[topIndex] = val;
        } else {
            mins[topIndex] = Math.min(val, mins[topIndex - 1]);
        }
    }

    public void pop() {
        if (topIndex >= 0) {
            topIndex--;
        }
    }

    public int top() {
        return data[topIndex];
    }

    public int getMin() {
        return mins[topIndex];
    }

    private void resize() {
        capacity *= 2;
        int[] newData = new int[capacity];
        int[] newMins = new int[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        System.arraycopy(mins, 0, newMins, 0, mins.length);
        data = newData;
        mins = newMins;
    }
}