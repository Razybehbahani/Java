public class Word {
    /*
    This class represents a word in the game that is comprised of any
    number of letters. Each letter is represented by a Letter object.
    The letter objects are stored in a linked list formed by objects
    of the class LinearNode.
     */
    // attributes:
    private final LinearNode<Letter> firstLetter = new LinearNode<>();

    // constructor
    public Word(Letter[] letters) {
        try {
            firstLetter.setElement(letters[0]);
            LinearNode<Letter> current = firstLetter;
            for (int i = 1; i < letters.length ; i++) {
                    current.setNext(new LinearNode(letters[i]));
                    current = current.getNext();
            }
        } catch (Exception e) {
                System.out.println("Null array element"); }
        }

        public String toString() {
            String s = "Word: "+ firstLetter.getElement().toString();
            LinearNode<Letter> current = firstLetter.getNext();
            while (current != null) {
                s += " ";
                s += current.getElement().toString();
                current = current.getNext();
//                s += " ";
            }
            s += " ";
            return s;
        }

        public boolean labelWord(Word mystery) {
        /* Takes a mystery word as a parameter and updates each of the
         letter's label attribute contained in "this" Word object with
         respect to the mystery word.
         */
            LinearNode<Letter> my_current = mystery.firstLetter;
            LinearNode<Letter> th_current = this.firstLetter;
            int my_i = 0;
            int th_i = 0;
            char th_c ;
            char my_c ;
            while (th_current != null) {
                th_c = th_current.getElement().getLetter();
                my_current = mystery.firstLetter;
                my_i = 0;
                while (my_current != null) {
                    my_c = my_current.getElement().getLetter();
                    if (my_i == th_i && my_c == th_c) {
                        th_current.getElement().setCorrect();
                        break;
                    } else if (my_i != th_i && my_c == th_c) {
                        th_current.getElement().setUsed();
                        break;
                    } else {
                        th_current.getElement().setUnused();
                        my_current = my_current.getNext();
                        my_i++;
                    }
                }
                th_current = th_current.getNext();
                th_i++;
            }
        // returns "true" if this word is identical to the mystery word.
            LinearNode<Letter> current = this.firstLetter;
            while (current != null) {
                if (current.getElement().getLabel() != 3) return false;
                else current = current.getNext();
            }
            return true;
        }


//        }

}



