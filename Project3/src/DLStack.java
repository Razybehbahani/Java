public class DLStack<T> implements DLStackADT<T> {

    private DoubleLinkedNode<T> top ;//= new DoubleLinkedNode<>();
    private int numItem;

    public DLStack() {
        // Creates an empty stack
        top = null;
        numItem = 0;
    }

    // Adds the given dataItem to the top of the stack
    public void push(T dataItem) {
        if ( numItem == 0 ) {
            // at first define it as an empty DLinkeNode then specify its value
            top = new DoubleLinkedNode<>();
            top.setElement(dataItem);
            top.setNext(null);
            top.setPrevious(null);
        } else {
            DoubleLinkedNode<T> temp = new DoubleLinkedNode<T>(dataItem);
            temp.setPrevious(getTop());
            temp.setNext(null);
            getTop().setNext(temp);
            top = temp;
        }
        numItem++;
    }

    // Removes and returns the data item at the top of the stack
    public T pop() throws EmptyStackException{

        if (numItem == 0) throw new EmptyStackException("No item to pop");
        else {
            DoubleLinkedNode<T> temp = getTop();
            top = temp.getPrevious();
            if (numItem != 1){
                top.setNext(null);
            }
            numItem--;
            return temp.getElement();
        }
    }

    // Removes and returns the k-th data item from the top of the stack
    public T pop(int k) throws InvalidItemException {
        if (k > numItem || k <= 0 || numItem == 0) throw new InvalidItemException("invalid k");
        else {
            DoubleLinkedNode<T> temp = getTop();
            if (numItem == 1 && k == 1) {
                top = null;
                numItem = 0;
            } else if (numItem > 1 && k == 1) {
                temp.getPrevious().setNext(null);
                top = temp.getPrevious();
                numItem--;
            } else if (numItem > 1 && k < numItem) {
                for (int i = 1; i < k; ++i) {
                    temp = temp.getPrevious();
                }
                temp.getNext().setPrevious(temp.getPrevious());
                temp.getPrevious().setNext(temp.getNext());
                numItem--;
            } else if (numItem > 1 && k == numItem) {
                for (int i = 1; i < k; ++i) temp = temp.getPrevious();
                temp.getNext().setPrevious(null);
                numItem--;
            }
            return temp.getElement();
        }
    }

    // returns the dataItem at the top of the stack without removing it
    public T peek() throws EmptyStackException {
        if (numItem == 0) throw new EmptyStackException("Empty stack");
        else return getTop().getElement();
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
        DoubleLinkedNode<T> current = top;
        if (numItem > 1) {
            for (int i = 0; i < numItem ; i++) {
                s = s + current.toString();
                current = current.getPrevious();
                if (i != numItem) s = s + " ";
            }}
        else if (numItem == 1) s = s + current.toString();

        s = s + "]";
        return s;
    }


}
