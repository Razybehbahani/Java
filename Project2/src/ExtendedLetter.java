public class ExtendedLetter extends Letter {

    // attributes
    private String content;
    private int family;
    private boolean related;
    private static final int SINGLETON = -1;
    private static final char c= 'c';

    // constructor
    public ExtendedLetter (String s) {
        super(c);
        content = s;
        related = false;
        family = SINGLETON;
    }

    public ExtendedLetter(String s, int fam) {
        super(c);
        content = s;
        related = false;
        family = fam;
    }

    //getters
    public String getContent() {
        return content;
    }

    public int getFamily() {
        return family;
    }

    public boolean isRelated() {
        return related;
    }


   // setters
    public void setContent(String content) {
        this.content = content;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public void setRelated(boolean related) {
        this.related = related;
    }

    // methods
    public boolean equals(Object other){
        if (other instanceof ExtendedLetter) {
            if (this.getFamily() == ((ExtendedLetter) other).getFamily()) this.setRelated(true);
            if (this.getContent() == ((ExtendedLetter) other).getContent()) return true;
        }
        return false;
    }

    public String toString(){
        String s = "";
        if (isUnused() && isRelated()) s += "." + getContent() + ".";
        else {
            s += decorator() + getContent() + decorator();
        }
        return s;
    }

    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        if (codes  == null) {
            for (int i=0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i]);
            }
        } else {
            for (int i=0; i < content.length; i++) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}
