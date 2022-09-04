public class Editor {

    public static final Editor instance = new Editor();

    private Editor() {}

    public static Editor getInstance() {
        return instance;
    } //here

    public Parser LanguageParser (String fileName) {

        if(fileName.endsWith(".c")) {
            return new CParser();
        }
        else if(fileName.endsWith(".cpp")) {
            return new CppParser();
        }
        else if(fileName.endsWith(".py")) {
            return new PythonParser();
        }
        else
            return null;
    }
}
