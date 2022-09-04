interface Parser {
    void parseLanguage();
}


class CParser implements Parser {

    private static final Fonts font = new CourierNew();

    @Override
    public void parseLanguage() {
        System.out.println("\n# C Language Parser");
        System.out.println(font.getFonts() + "\n" + font.getStyle() + "\n" + font.getColor() + "\n" + "Size: " + font.getFontSize());
    }
}


class CppParser implements Parser {

    private static final Fonts font = new Monaco();

    @Override
    public void parseLanguage() {
        System.out.println("\n# CPP Language Parser");
        System.out.println(font.getFonts() + "\n" + font.getStyle() + "\n" + font.getColor() + "\n" + "Size: " + font.getFontSize());
    }
}


class PythonParser implements Parser {

    private static final Fonts font = new Consolas();

    @Override
    public void parseLanguage() {
        System.out.println("\n# Python Language Parser");
        System.out.println(font.getFonts() + "\n" + font.getStyle() + "\n" + font.getColor() + "\n" + "Size: " + font.getFontSize());
    }
}


