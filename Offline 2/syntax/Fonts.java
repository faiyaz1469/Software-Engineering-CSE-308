interface Fonts {
    String getFonts();
    String getStyle();
    String getColor();
    float getFontSize();
}

class CourierNew implements Fonts{

    private static final String font = "Courier New";
    private static final String style = "Normal";
    private static final String color = "Black";
    private static final float size = 12;

    @Override
    public String getFonts() {
        return "Font: " + font;
    }

    @Override
    public String getStyle(){
        return "Style: " + style;
    }

    @Override
    public String getColor(){
        return "Color: " + color;
    }

    @Override
    public float getFontSize(){
        return size;
    }

}

class Monaco implements Fonts{

    private static final String font = "Monaco";
    private static final String style = "Bold";
    private static final String color = "Blue";
    private static final float size = 14;

    @Override
    public String getFonts() {
        return "Font: " + font;
    }

    @Override
    public String getStyle(){
        return "Style: " + style;
    }

    @Override
    public String getColor(){
        return "Color: " + color;
    }

    @Override
    public float getFontSize(){
        return size;
    }
}

class Consolas implements Fonts{

    private static final String font = "Consolas";
    private static final String style = "Italic";
    private static final String color = "Red";
    private static final float size = 16;

    @Override
    public String getFonts() {
        return "Font: " + font;
    }

    @Override
    public String getStyle(){
        return "Style: " + style;
    }

    @Override
    public String getColor(){
        return "Color: " + color;
    }

    @Override
    public float getFontSize(){
        return size;
    }
}
