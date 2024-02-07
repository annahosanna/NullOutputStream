import java.io.IOException;
import java.io.Reader;

public class NullInputStreamReader extends Reader {

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        // Always return -1 to indicate end of stream (no data available)
        return -1;
    }

    @Override
    public void close() throws IOException {
        // No resources to close
    }
}
