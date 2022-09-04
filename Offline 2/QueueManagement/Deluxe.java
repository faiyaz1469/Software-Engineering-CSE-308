public class Deluxe implements QueueManagement{

    private final Processor processor = new RaspberryPi();
    private final Display display = new LCDPanel();
    private final ControllerApplication controllerApplication = new X();

    @Override
    public float getCostPerDisplayUnit(){
        return processor.getCostProcessor() + display.getCostDisplay();
    }

    @Override
    public float getCostApplication(){
        return controllerApplication.getCostControllerApplication();
    }

    @Override
    public String getDisplay() {
        return "\n[ Deluxe Queue Management System ]\n" + processor.getProcessor() +"\n" + display.getDisplay() +"\n" + controllerApplication.getControllerApplication() +"\n" ;
    }
}
