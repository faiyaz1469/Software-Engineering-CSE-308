public interface CommunicationModule {
    String getModule();
    float getCostCommunicationModule();
}


class WiFi implements CommunicationModule{

    static float costWiFi = 5500;

    public WiFi(){
        System.out.println("=> WiFi module Added to communicate with the base station");
    }

    @Override
    public String getModule() {
        return "Module: WiFi";
    }

    @Override
    public float getCostCommunicationModule(){
        return costWiFi;
    }
}


class SimCard implements CommunicationModule{

    static float costSimCard = 500;

    public SimCard(){
        System.out.println("=> SIM card Added for communicating");
    }

    @Override
    public String getModule() {
        return "Module: Sim Card";
    }

    @Override
    public float getCostCommunicationModule(){
        return costSimCard;
    }
}
