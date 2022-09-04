public class Optimal implements QueueManagement{

    private final Processor processor = new ArduinoMega();
    private final Display display = new LEDMatrix();
    private final ControllerApplication controllerApplication = new Y();

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
        return "\n[ Optimal Queue Management System ]\n" + processor.getProcessor() +"\n" + display.getDisplay() +"\n"+ controllerApplication.getControllerApplication() +"\n" ;
    }
}
