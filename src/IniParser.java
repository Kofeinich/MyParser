import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class IniParser extends Parser {
    private Pattern section  = Pattern.compile( "\\s*\\[([^]]*)\\]\\s*" );
    private Pattern  keyValue = Pattern.compile( "\\s*([^=]*)=(.*)" );
    private Map< String,
            Map< String,
                    String >>  entries  = new HashMap<>();

    public Pattern getSection() { return section; }

    public Pattern getKeyValue() { return keyValue; }

    public Map<String, Map<String, String>> getEntries() { return entries; }

    IniParser(File inputFile) {
        super(inputFile);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IniParser iniParser = (IniParser) o;
        return Objects.equals(section, iniParser.section) && Objects.equals(keyValue, iniParser.keyValue) && Objects.equals(entries, iniParser.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section, keyValue, entries);
    }
}
