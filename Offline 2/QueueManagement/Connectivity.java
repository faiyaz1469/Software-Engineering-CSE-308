interface Connectivity {
    String getConnectivity();
    float getCostConnectivity();
}


class Broadband implements Connectivity{

    private final CommunicationModule communicationModule = new WiFi();

    static float costYearlyCommunication = 12000;

    public Broadband(){
        System.out.println("=> WiFi connectivity through broadband service Added");
    }

    @Override
    public String getConnectivity() {
        return "Connectivity: Broadband\n" + communicationModule.getModule();
    }

    @Override
    public float getCostConnectivity(){
        return costYearlyCommunication + communicationModule.getCostCommunicationModule() ;
    }
}


class MobileData implements Connectivity{

    private final CommunicationModule communicationModule = new SimCard();

    static float costYearlyCommunication = 6000;

    public MobileData(){
        System.out.println("=> Mobile data service Added");
    }

    @Override
    public String getConnectivity() {
        return "Connectivity: Mobile Data\n" + communicationModule.getModule();
    }

    @Override
    public float getCostConnectivity(){
        return costYearlyCommunication + communicationModule.getCostCommunicationModule();
    }
}
