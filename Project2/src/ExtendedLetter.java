public class ExtendedLetter extends Letter {
    private static final int SINGLETON = -1;
    private static final char c = 'c';
    /*
    This class is a subclass of Letter and extends the functionality.
    Instead of relying on a single char to represent the content of a Letter object,
     objects of this class will use a String instance variable and will further
     introduce the concept of being related to other ExtendedLetter objects.
     */
    private final String content;
    private final int family;
    private boolean related;

    public ExtendedLetter(String s) {
        super(c);
        content = s;
        related = false;
        family = SINGLETON;
    }

    public ExtendedLetter(String s, int fam) {
        super(c);
        content = s;
        related = false;
        // family is a positive number which
        //indicates that any ExtendedLetter object with the same value in instance
        //variable family will be consider related to this ExtendedLetter object
        family = fam;
    }

    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        if (codes == null) {
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);
            }
        } else {
            for (int i = 0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }

    public String getContent() {
        return content;
    }

    public int getFamily() {
        return family;
    }


    public boolean isRelated() {
        return related;
    }

    public void setRelated(boolean related) {
        this.related = related;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter)) return false;
        else {
            if (this.getFamily() == (((ExtendedLetter) other).getFamily())) this.setRelated(true);
            return this.getContent().equals(((ExtendedLetter) other).getContent());
        }
    }

    @Override
    public String toString() {
        // gives a String representation of this ExtendedLetter object
        String s = "";
        if (isUnused() && isRelated()) s += "." + getContent() + ".";
        else {
            s += decorator() + getContent() + decorator();
        }
        return s;
    }
}
