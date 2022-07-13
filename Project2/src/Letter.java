public class Letter {
    private static final int UNSET = 0;
    private static final int UNUSED = 1;
    private static final int USED = 2;
    private static final int CORRECT = 3;
    /*
    This class represents a single letter that will be used in the game.
    Each game letter also has an accompanying integer label which indicates
    whether it is used, unused, or correct with respect to the mystery word.
     */
    private char letter;
    private int label;

    // constructor
    public Letter(char c) {
        letter = c;
        label = UNSET;
    }

    // as the label and letter are private vars., to access
    // their values we need to define getter method. for assigning
    // label we define separate methods and the letter value is
    // defined at constructing a letter.

    public static Letter[] fromString(String s) {
        Letter[] char_array = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char_array[i] = new Letter(s.charAt(i));
        }
        return char_array;
    }

    public char getLetter() {
        return letter;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this.getClass().equals(otherObject.getClass())) {
            return (this.getLetter() == ((Letter) otherObject).getLetter());
        }
        return false;
    }

    public String decorator() {
        if (getLabel() == USED) return "+";
        else if (getLabel() == UNUSED) return "-";
        else if (getLabel() == CORRECT) return "!";
        return " ";
    }

    public String toString() {
        return decorator() + getLetter() + decorator();
    }

    public void setUnused() {
        setLabel(UNUSED);
    }

    public void setUsed() {
        setLabel(USED);
    }

    public void setCorrect() {
        setLabel(CORRECT);
    }

    public boolean isUnused() {
        return (getLabel() == UNUSED);
    }
}
