public class QueueSystem {

    private QueueManagement queueManagement ;
    private Connectivity connectivity;
    private int displayUnitsNumber;

    public void setQueue(QueueManagement queueManagement) {
        this.queueManagement = queueManagement;
    }

    public void setConnectivity(Connectivity connectivity){this.connectivity = connectivity;} //return

    public void setDisplayUnitsNumber(int displayUnitsNumber){
        this.displayUnitsNumber = displayUnitsNumber;
    }

    public int getDisplayUnitsNumber(){ return displayUnitsNumber;}

    public float getCostOfSystem(){
        return queueManagement.getCostPerDisplayUnit()*getDisplayUnitsNumber() + queueManagement.getCostApplication() + connectivity.getCostConnectivity();
    }

    @Override
    public String toString(){
        return queueManagement.getDisplay() + connectivity.getConnectivity() +"\n" + "Display Units Number: " + getDisplayUnitsNumber() + "\n" + "Total cost of the System: " + getCostOfSystem();
    }

}
