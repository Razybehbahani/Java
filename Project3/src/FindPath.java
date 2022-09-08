public class FindPath {

    private Map pyramidMap;

    /*
    * filename contains a description of the chambers of the pyramid.
    * you need to store the address of the created Map object in instance variable pyramidMap.
    * */
    public FindPath(String fileName) {
        Map newMap = new Map(fileName);
        pyramidMap = newMap;

    }

    /*
    * This method finds a path from the entrance to all the treasure chambers that can be
    * reached by satisfying the constraints specified in the introduction.
    * The chambers along the computed path must be stored in a stack of the class DLStack.
    * */
    public DLStack path(){

    }

    public Map getMap() {
        return pyramidMap;
    }

    public boolean isDim(Chamber currentChamber) {

    }

    public Chamber bestChamber(Chamber currentChamber){

    }

}
