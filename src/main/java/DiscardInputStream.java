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
        return -1;
    }

    @Override
    public void close() throws IOException {
        this.inputStream.close();
    }
}
