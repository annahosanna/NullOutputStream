import java.io.IOException;
import java.io.Reader;

// Actually read data to consume it, and then discard the read data.
// I could do it this way, but I wonder if using a BufferedReader internally might have better safety

public class NullInputStreamReader extends Reader {

    private Reader reader;
    int currentOffset = 0;
    
    public NullInputStreamReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int read() throws IOException {
        char[] cbuf = new char[1];
        return this.read(cbuf,0,0);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        // I could remove this if I used a BufferedReader
        // Its an infinite loop just waiting to happen
        while (!reader.ready()) {
            // Busy wait forever
        }
        char[] buffer = new char[1024];
        int charsRead;
        while ((charsRead = reader.read(buffer)) != -1) {
            // Read characters from the input reader and discard them
            // Do nothing with the characters
        }
        // Always return -1 to indicate end of stream (no data available)
        return -1
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

}
