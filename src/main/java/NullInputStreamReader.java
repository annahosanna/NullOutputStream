import java.io.IOException;
import java.io.Reader;

// Do I actually need to read data from the stream in order to consume data.
// in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

// Based on the output stream requirements:
// If cbuf is null, a NullPointerException is thrown.
// If off is negative, or len is negative, or off+len is greater than the length of the array cbuf, then an IndexOutOfBoundsException is thrown.
// However if any of those conditions are true -1 is probably ok

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
