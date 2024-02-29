import java.io.IOException;
import java.io.FilterReader;
import java.io.Reader;

public class DiscardInputStreamReader extends FilterReader {

    private Reader reader;
    private int offset = 0;
    
    public DiscardInputStreamReader(Reader reader) {
      this.reader = reader;
    }

    @Override
    public boolean ready() throws IOException {
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
    public long skip(long n) throws IOException {
        char[] cbuf = new char[1];
        // n is long and I am ignoring the value anyway so do not even try to loop and mod it to chunks less than the size of an int
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
        if ( buffer == null ) {
            throw new IOException();
        }
        try {
          while (((this.reader != null) && (this.reader.ready() == true) && ( this.reader.read(buffer,offset,1024) != -1)) {
              offset = offset + 1024;
              // Read characters from the input stream and discard them
              // Do nothing with the characters
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        // Always return -1 to indicate end of what is currently available in the stream (but the stream is still open)
        return -1;
    }
    
    @Override
    public void close() throws IOException {
        this.reader.close();
    }

    @Override
    public void reset() throws IOException {
    }
    
    @Override
    public String toString() {
        return "DiscardInputStreamReader";
    } 
 
}
