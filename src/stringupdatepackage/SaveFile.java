package stringupdatepackage;

import java.io.File;

public interface SaveFile {
    int MAX_INT = Integer.MAX_VALUE;
    double MAX_DOUBLE = Double.MAX_VALUE;
    long MAX_LONG = Long.MAX_VALUE;
    float MAX_FLOAT = Float.MAX_VALUE;
    short MAX_SHORT = Short.MAX_VALUE;
    byte MAX_BYTE = Byte.MAX_VALUE;

    void writeFile(File file);
    void readFile(File file);
    
}
