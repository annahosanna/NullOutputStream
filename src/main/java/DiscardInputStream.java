import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DiscardInputStream extends FilterInputStream {

    private InputStream inputStream;
  
    public DiscardInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        super(this.inputStream);
    }

    @Override
    public int read() throws IOException {
        // Read and discard all bytes - one at a time - returning -1 to indicate end of stream
        while ((this.inputStream.available() > 0) && (this.inputStream.read() != -1)) {
            // Do not do anything
        }
        return -1;
    }
    
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        char[] buffer = new char[1024];
        try {
          while ((this.inputStream.available() > 0) && ( this.inputStream.read(buffer) != -1)) {
              // Read characters from the input stream and discard them
              // Do nothing with the characters
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        // Always return -1 to indicate end of stream (no data available)
        return -1;
    }
    
    @Override
    public void close() throws IOException {
        this.inputStream.close();
    }

    @Override
    public String toString() {
        return "DiscardInputStream";
    }
}
