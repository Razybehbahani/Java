public class WordLL {
    /*
    It stores a mystery word and all word guesses tried so far from newest to the oldest.
    It keeps a history of the past word guesses in a linked structure.
     */

    // attributes:
    private Word mysteryWord;
    private LinearNode<Word> history;
//    private LinearNode<Word> firstNode = new LinearNode<>();
//    private final LinearNode<Word> firstNode = new LinearNode<>();
//
    public WordLL(Word mystery) {
        // Initialize an empty history, when we don't specify an element, it is empty
        this.history = new LinearNode<>();
        // & set the mysteryWord attribute to the parameter mystery
        this.mysteryWord = mystery;
    }

    public boolean tryWord(Word guess) {
        /*
        Takes a Word as an argument to test against this games' mystery word.
        Updates the label of all the letters contained within Word guss, using LabelWord
         */
        LinearNode<Word> firstNode = new LinearNode<>(guess);
//        firstNode.setElement(guess)
        if (this.history.getElement() == null) {
            history = firstNode;
        }
        else {
            firstNode.setNext(this.history);
            history = firstNode;
        }
        // returns true if guess is identical to the mystery word
        return (firstNode.getElement().labelWord(mysteryWord));
    }

    public String toString() {
        // Creates a String representation of the past guesses from newest to oldest.
        String s = "";
//        for (Word w in history)
        LinearNode<Word> currentNode;
        currentNode = this.history;
//        s += currentNode.getElement().toString() + "\n";
        while (currentNode.getNext() != null) {
            s += currentNode.getElement().toString() + "\n";
            currentNode = currentNode.getNext();
        }
        s += currentNode.getElement().toString() + "\n";
        return s;
    }


}
