import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DiscardBufferedInputStream extends FilterInputStream {

    private inputStream
  
    public DiscardBufferedInputStream(InputStream inputStream) {
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
}
