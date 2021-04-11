import java.io.File;

public class App {

    File iniFile = new File("settings.ini");
    IniParser iniParser = new IniParser(iniFile);
    IniParserController iniParserController = new IniParserController(iniParser);

    public static void main(String[] args) {

    }
}
