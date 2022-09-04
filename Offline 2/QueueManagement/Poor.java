public class Poor implements QueueManagement{

    private final Processor processor = new ATMega32();
    private final Display display = new LEDMatrix();
    private final ControllerApplication controllerApplication = new Z();

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
        return "\n[ Poor Queue Management System ]\n" + processor.getProcessor() +"\n" + display.getDisplay() +"\n"+ controllerApplication.getControllerApplication() +"\n" ;

    }
}
