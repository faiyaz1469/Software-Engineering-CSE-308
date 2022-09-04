interface Processor {
    String getProcessor();
    float getCostProcessor();
}


class ATMega32 implements Processor{

    static float costATMega32 = 1000;

    public ATMega32(){
        System.out.println("=> ATMega32 Added for receiving and processing data from web-based control unit");
    }

    @Override
    public String getProcessor() {
        return "Processor: ATMega32";
    }

    @Override
    public float getCostProcessor(){
        return costATMega32;
    }
}


class ArduinoMega implements Processor{

    static float costArduino = 2000;

    public ArduinoMega(){
        System.out.println("=> Arduino Mega Added for receiving and processing data from web-based control unit");
    }

    @Override
    public String getProcessor() {
        return "Processor: Arduino Mega";
    }

    @Override
    public float getCostProcessor(){
         return costArduino;
    }
}


class RaspberryPi implements Processor{

    static float costRaspberryPi = 3000;
    public  RaspberryPi(){
        System.out.println("=> Raspberry Pi Added for receiving and processing data from web-based control unit");
    }

    @Override
    public String getProcessor() {
        return "Processor: Raspberry Pi";
    }

    @Override
    public float getCostProcessor(){
        return costRaspberryPi;
    }
}
