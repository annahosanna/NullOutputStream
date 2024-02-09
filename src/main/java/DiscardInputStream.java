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
        while (this.inputStream.available() > 0) {
            this.inputStream.read();
        }
        return -1;
    }

    public int read() throws IOException {
        char[] buffer = new char[1024];
        int charsRead;
        while ((charsRead = this.inputStream.read(buffer)) != -1) {
            // Read characters from the input reader and discard them
            // Do nothing with the characters
        }
        // Always return -1 to indicate end of stream (no data available)
        return -1;
    }

    public int discardRead() throws IOException {
        char[] buffer = new char[1024];
        int charsRead;
        while ((charsRead = this.inputStream.read(buffer)) != -1) {
            // Read characters from the input reader and discard them
            // Do nothing with the characters
        }
        // Always return -1 to indicate end of stream (no data available)
        return -1;
    }
    
    @Override
    public int read(byte[] byteArray, int offset, int length) throws IOException {
        // Read and discard bytes into the buffer, returning -1 to indicate end of stream
        // This basically means any call to this function, regardless of the argument will return -1
        while (length > 0) {
            int bytesRead = this.inputStream.read(byteArray, offset, length);
            if (bytesRead == -1) {
                return -1;
            }
            offset += bytesRead;
            length -= bytesRead;
        }
        return bytesRead;
    }

    @Override
    public void close() throws IOException {
        this.inputStream.close();
    }
}
