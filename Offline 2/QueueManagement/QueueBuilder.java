public class QueueBuilder {

    private final QueueSystem queueSystem;

    public QueueBuilder(){
        queueSystem = new QueueSystem() ;
    }

    public void setQueue(QueueManagement queueManagement) {
        queueSystem.setQueue(queueManagement);
    }

    public void setConnectivity(Connectivity connectivity){queueSystem.setConnectivity(connectivity);}

    public void setDisplayUnitsNumber(int displayUnitsNumber){
        queueSystem.setDisplayUnitsNumber(displayUnitsNumber);
    }

    QueueSystem getQueue(){
        return this.queueSystem ;
    }
}
