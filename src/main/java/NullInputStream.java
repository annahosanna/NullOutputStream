import java.io.IOException;
import java.io.InputStream;

public class NullInputStream extends InputStream {

    @Override
    public int read() throws IOException {
        // Always return -1 to indicate end of stream (no data available)
        return -1;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        // Always return 0 to indicate end of stream (no data available)
        return 0;
    }

    @Override
    public long skip(long n) throws IOException {
        // Always skip 0 bytes
        return 0;
    }

    @Override
    public int available() throws IOException {
        // No bytes available
        return 0;
    }

    @Override
    public void close() throws IOException {
        // No resources to close
    }
}
