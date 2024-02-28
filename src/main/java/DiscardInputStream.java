import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Integer;

public class DiscardInputStream extends FilterInputStream {

    private InputStream inputStream;
  
    public DiscardInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        super(this.inputStream);
    }

    @Override
    public int available() throws IOException {
        return true;
    }

    @Override
    public void mark(int readlimit) {
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read(byte[] b) throws IOException {
        if ( b == null ) {
            // throw IOException;
        }
        return this.read(b, 0, 1);
    }

    @Override
    public long skip(long n) throws IOException {
        char[] cbuf = new char[1];
        int amountRead = this.read(cbuf, 0, 1);
        return 0;
    }
    
    @Override
    public int read() throws IOException {
        char[] cbuf = new char[1];
        return this.read(cbuf, 0, 1);
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
    public void reset() throws IOException {
    }
    
    @Override
    public String toString() {
        return "DiscardInputStream";
    }
}
