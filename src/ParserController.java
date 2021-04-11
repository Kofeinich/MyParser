import java.io.File;
import java.io.IOException;

public abstract class ParserController {
    protected File file;
    protected Parser parser;

    protected ParserController(Parser parser){
        this.file = parser.getFile();
        this.parser = parser;
    }

    protected void parsing() throws IOException {}
}
