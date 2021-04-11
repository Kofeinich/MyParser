import java.io.File;

public abstract class Parser {
    protected File file;

    protected File getFile() {
        return file;
    }

    Parser(File inputFile){
        this.file = inputFile;
    }

    protected void show() {}
}
