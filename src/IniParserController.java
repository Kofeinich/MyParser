import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class IniParserController implements ParserController {
    IniParser parser;

    IniParserController(IniParser parser) {
        this.parser = parser;
    }

    @Override
    public void parsing() {
        File newFile = parser.getFile();
        try( BufferedReader br = new BufferedReader( new FileReader( newFile.getPath()))) {
            String line;
            String sec = null;
            while(( line = br.readLine()) != null ) {
                Matcher m = parser.getSection().matcher( line );
                if( m.matches()) {
                    sec = m.group( 1 ).trim();
                }
                else if( sec != null ) {
                    m = parser.getKeyValue().matcher( line );
                    if( m.matches()) {
                        String key   = m.group( 1 ).trim();
                        String value = m.group( 2 ).trim();
                        Map< String, String > kv = parser.getEntries().get( sec );
                        if( kv == null ) {
                             parser.getEntries().put( sec, kv = new HashMap<>());
                        }
                        kv.put( key, value );
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
