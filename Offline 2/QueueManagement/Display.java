interface Display {
    String getDisplay();
    float getCostDisplay();
}

class LCDPanel implements Display{

    static float costLCD = 10000;

    public LCDPanel(){
        System.out.println("=> LCD Panel Added for Display");
    }

    @Override
    public String getDisplay() {
        return "Display: LCD Panel";
    }

    @Override
    public float getCostDisplay(){
        return costLCD;
    }
}


class LEDMatrix implements Display{

    static float costLED = 500;

    public LEDMatrix(){
        System.out.println("=> LED Matrix Added for Display");
    }

    @Override
    public String getDisplay() {
        return "Display: LED Matrix";
    }

    @Override
    public float getCostDisplay(){
        return costLED;
    }
}