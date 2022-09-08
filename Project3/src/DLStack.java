public class DLStack<T> implements DLStackADT<T> {

    private DoubleLinkedNode<T> top;
    private int numItem;

    public DLStack() {
        top = null;
        numItem = 0;
    }

    // Adds the given dataItem to the top of the stack
    public void push(T dataItem) {
        DoubleLinkedNode<T> temp = new DoubleLinkedNode<T>(dataItem);
        temp.setNext(top.getNext());
        top.setNext(temp);
        temp.setPrevious(top);
        top = temp;
        numItem ++;
    }

    // Removes and returns the data item at the top of the stack
    public T pop() throws EmptyStackException {
        if (numItem == 0) throw new EmptyStackException("Empty stack");
        DoubleLinkedNode<T> temp = top;
        top = top.getPrevious();
        top.setNext(temp.getNext());
        numItem --;
        return temp.getElement();
    }


    // Removes and returns the k-th data item from the top of the stack
    public T pop(int k) throws InvalidItemException {
        if (k > numItem || k <= 0) throw new InvalidItemException("invalid k");
        DoubleLinkedNode<T> temp = top;
        for (int i = 0; i < k ; i++) temp = temp.getPrevious();
        temp.getNext().setPrevious(temp.getPrevious());
        temp.getPrevious().setNext(temp.getNext());
        numItem --;
        return temp.getElement();
    }

    // returns the dataItem at the top of the stack without removing it
    public T peek() throws EmptyStackException {
        if (numItem == 0) throw new EmptyStackException("Empty stack");
        return top.getElement();
    }


    public boolean isEmpty() {
        return (numItem == 0);
    }

    @Override
    public int size() {
        return numItem;
    }

    @Override
    public DoubleLinkedNode<T> getTop() {
        return top;
    }

    @Override
    public String toString() {
        String s = "[" ;
        for (int i = 0; i < numItem-1 ; i++) s = s + " " + pop();
        s = s + pop() + "]";
        return s;
    }


}
