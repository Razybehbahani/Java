public class Word {
    /*
    This class represents a word in the game that is comprised of any
    number of letters. Each letter is represented by a Letter object.
    The letter objects are stored in a linked list formed by objects
    of the class LinearNode.
     */
    private final LinearNode<Letter> firstLetter = new LinearNode<>();


    public Word(Letter[] letters) {
        try {
            firstLetter.setElement(letters[0]);
            LinearNode<Letter> current = firstLetter;
            for (int i = 1; i < letters.length; i++) {
                current.setNext(new LinearNode(letters[i]));
                current = current.getNext();
            }
        } catch (Exception e) {
            System.out.println("Null array element");
        }
    }

    @Override
    public String toString() {
        String s = "Word: " + firstLetter.getElement().toString();
        LinearNode<Letter> current = firstLetter.getNext();
        while (current != null) {
            s += " ";
            s += current.getElement().toString();
            current = current.getNext();
        }
        s += " ";
        return s;
    }


    public boolean labelWord(Word mystery) {
        /* Takes a mystery word as a parameter and updates each of the
         letter's label attribute contained in "this" Word object with
         respect to the mystery word.
         Be careful about the equal function as it changes the labels for `this`
         */
        LinearNode<Letter> mys_curr = mystery.firstLetter;
        LinearNode<Letter> this_curr = this.firstLetter;
        int mys_iter = 0;
        int this_iter = 0;
        Object this_content;
        Object mys_content;
        while (this_curr != null) {
            this_content = this_curr.getElement();
            mys_curr = mystery.firstLetter;
            mys_iter = 0;
            while (mys_curr != null) {
                mys_content = mys_curr.getElement();
                if ((mys_iter == this_iter) && (this_content.equals(mys_content))) {
                    this_curr.getElement().setCorrect();
                    break;
                } else if ((mys_iter != this_iter) && (this_content.equals(mys_content))) {
                    this_curr.getElement().setUsed();
                    break;
                } else {
                    this_curr.getElement().setUnused();
                    mys_curr = mys_curr.getNext();
                    mys_iter++;
                }
            }
            this_curr = this_curr.getNext();
            this_iter++;
        }
        // returns "true" if this word is identical to the mystery word.
        LinearNode<Letter> current = this.firstLetter;
        while (current != null) {
            if (current.getElement().getLabel() != 3) return false;
            else current = current.getNext();
        }
        return true;
    }

}



