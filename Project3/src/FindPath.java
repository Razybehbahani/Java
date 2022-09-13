import java.io.IOException;
import java.util.Stack;

public class FindPath {

    private Map pyramidMap;

    /*
     * filename contains a description of the chambers of the pyramid.
     * you need to store the address of the created Map object in instance variable pyramidMap.
     * */
    public FindPath(String fileName) {
        try {
            Map newMap = new Map(fileName);
            pyramidMap = newMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* Both of the methods path bellow are passing map#1-5*/

    /*
     * This method finds a path from the entrance to all the treasure chambers that can be
     * reached by satisfying the constraints specified in the introduction.
     * The chambers along the computed path must be stored in a stack of the class DLStack.
     * */
//    public DLStack path() {
//        DLStack stack = new DLStack();
//        DLStack TreasurePath = new DLStack();
//        int foundTreasure = 0;
//        int N = pyramidMap.getNumTreasures();
//        boolean on = true;
//        Chamber current;
//        Chamber Enter = pyramidMap.getEntrance();
//        stack.push(Enter);
//        TreasurePath.push(Enter);
//        Enter.markPushed();
//        while (!stack.isEmpty()) {
//            current = (Chamber) stack.peek();
//            if (current.isTreasure()) foundTreasure++;
//            if (foundTreasure == N) break;
//            else {
//                current = bestChamber(current);
//                if (current != null) {
//                    on = true;
//                    stack.push(current);
//                    TreasurePath.push(current);
//                    current.markPushed();
//                } else {
//                    current = (Chamber) stack.pop();
//                    current.markPopped();
//                    if (current.isTreasure()) on = false;
//                    if (on) TreasurePath.pop();
//                }
//            }
//        }
//        if (foundTreasure < N) return stack;
//        else return TreasurePath;
//    }


    public DLStack path() {
        DLStack stack = new DLStack();
        DLStack TreasurePath = new DLStack();
        int foundTreasure = 0;
        int N = pyramidMap.getNumTreasures();
        boolean on = true;
        Chamber current = pyramidMap.getEntrance();
        if (current.isTreasure()) foundTreasure++;
        stack.push(current);
        TreasurePath.push(current);
        current.markPushed();
        while (!stack.isEmpty()) {
            current = (Chamber) stack.peek();
            if (foundTreasure == N) break;
            else {
                current = bestChamber(current);
                if (current != null) {
                    on = true;
                    if (current.isTreasure()) foundTreasure++;
                    stack.push(current);
                    TreasurePath.push(current);
                    current.markPushed();
                } else {
                    current = (Chamber) stack.pop();
                    current.markPopped();
                    if (current.isTreasure()) on = false;
                    if (on) TreasurePath.pop();
                }
            }
        }
        if (foundTreasure < N) return stack;
        else return TreasurePath;
    }


    public Map getMap() {
        return pyramidMap;
    }

    /*
     * Returns true if currentChamber is dim (viz. not null, not sealed, not lighted, one of its neighbors is lighted)
     * returns false otherwise
     * */
    public boolean isDim(Chamber currentChamber) throws InvalidNeighbourIndexException {
        boolean condition = false;
        if (currentChamber != null ) {
            for (int n = 0; n <= 5; n++) {
                if (currentChamber.getNeighbour(n) != null &&
                        currentChamber.getNeighbour(n).isLighted()) condition = true;
            }
            if (!currentChamber.isSealed() &&
                    !currentChamber.isLighted() &&
                    condition) return true;
        }
        return false;
    }

    /*
     * from currentChamber program moves to an adjacent unmarked treasure chamber if any;
     * so the method will return the neighboring unmarked treasure chamber with smallest index.
     * otherwise from currentChamber program prefers to move ot an unmarked lighted chamber if any;
     * so the method will return the neighboring unmarked lighted chamber with smallest index,
     * otherwise the program will move to an unmarked dim chamber
     * if there is no unmarked treasure, lightened or dim chamber, the method returns null
     * */
    public Chamber bestChamber(Chamber currentChamber) {
        if (currentChamber != null) {
            for (int n = 0; n <= 5; ++n) {
                if (currentChamber.getNeighbour(n) != null && !currentChamber.getNeighbour(n).isMarked() && currentChamber.getNeighbour(n).isTreasure())
                    return currentChamber.getNeighbour(n);
            }
            for (int n = 0; n <= 5; ++n) {
                if (currentChamber.getNeighbour(n) != null && !currentChamber.getNeighbour(n).isMarked() && currentChamber.getNeighbour(n).isLighted())
                    return currentChamber.getNeighbour(n);
            }
            for (int n = 0; n <= 5; ++n) {
                if (currentChamber.getNeighbour(n) != null && !currentChamber.getNeighbour(n).isMarked() && isDim(currentChamber.getNeighbour(n)))
                    return currentChamber.getNeighbour(n);
            }
        }
        return null;
    }

}
