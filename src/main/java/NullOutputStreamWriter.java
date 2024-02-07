import java.io.*;

public class NullOutputStreamWriter extends OutputStreamWriter {

    public NullOutputStreamWriter() {
        super(new NullOutputStream());
    }

    // Override other constructors as needed
    
    @Override
    public void write(int c) throws IOException {
        // Do nothing, as we are discarding the output
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        // Do nothing, as we are discarding the output
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        // Do nothing, as we are discarding the output
    }

    @Override
    public void close() throws IOException {
        // No need to close anything
    }

    @Override
    public void flush() throws IOException {
        // No need to flush anything
    }
}
