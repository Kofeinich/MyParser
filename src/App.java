import java.io.File;

public class App {

    public static void main(String[] args) {
        File iniFile = new File("/Users/fedorkon/IdeaProjects/IniParser/src/settings.ini");
        IniParser iniParser = new IniParser(iniFile);
        IniParserController iniParserController = new IniParserController(iniParser);
        iniParserController.parsing();
        iniParser.show();
    }
}
