interface ControllerApplication {
    String getControllerApplication();
    float getCostControllerApplication();
}


class X implements ControllerApplication{

    static float costApplicationX = 150000;

    public X(){
        System.out.println("=> Application X Added to control the display units over the Internet");
    }

    @Override
    public String getControllerApplication() {
        return "Web-based Controller Application: X";
    }

    @Override
    public float getCostControllerApplication(){
        return costApplicationX;
    }
}


class Y implements ControllerApplication{

    static float costApplicationY = 100000;

    public Y(){
        System.out.println("=> Application Y Added to control the display units over the Internet");
    }

    @Override
    public String getControllerApplication() {
        return "Web-based Controller Application: Y";
    }

    @Override
    public float getCostControllerApplication(){
        return costApplicationY;
    }
}


class Z implements ControllerApplication{

    static float costApplicationZ = 50000;

    public Z(){
        System.out.println("=> Application Z Added to control the display units over the Internet");
    }

    @Override
    public String getControllerApplication() {
        return "Web-based Controller Application: Z";
    }

    @Override
    public float getCostControllerApplication(){
        return costApplicationZ;
    }
}
