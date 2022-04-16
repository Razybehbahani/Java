public class Dice {
    // attributes
    private int value;
    // constructors
    public Dice() {
        value = -1;
    }
    public Dice(int val) {
        value = val;
    }
    // methods
    public void roll(){
        value = RandomNumber.getRandomNumber(1,6);
    }
    public int getValue() {
        return value;
    }
}
