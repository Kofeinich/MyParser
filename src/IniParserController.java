import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class IniParserController extends ParserController {

    IniParserController(Parser parser) {
        super(parser);
    }

    @Override
    protected void parsing() throws IOException {
        if (IniParser.class.equals(parser.getClass())) {
            System.out.println("U are stupid!!!");
        }
        File newFile = parser.file;
        try( BufferedReader br = new BufferedReader( new FileReader( newFile.getPath()))) {
            String line;
            String sec = null;
            while(( line = br.readLine()) != null ) {
                Matcher m = ((IniParser) parser).getSection().matcher( line );
                if( m.matches()) {
                    sec = m.group( 1 ).trim();
                }
                else if( sec != null ) {
                    m = ((IniParser) parser).getKeyValue().matcher( line );
                    if( m.matches()) {
                        String key   = m.group( 1 ).trim();
                        String value = m.group( 2 ).trim();
                        Map< String, String > kv = ((IniParser) parser).getEntries().get( sec );
                        if( kv == null ) {
                             ((IniParser) parser).getEntries().put( sec, kv = new HashMap<>());
                        }
                        kv.put( key, value );
                    }
                }
            }
        }
    }
}
