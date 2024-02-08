import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader
    
// Pass in something like an InputSteamReader

public class NullInputStreamReader extends Reader {

    private BufferedReader reader;
    // int currentOffset = 0;
    // int readLength = 1;
    
    public NullInputStreamReader(Reader reader) {
      BufferedReader this.reader = new BufferedReader(reader);
    }
    
    @Override
    public int read() throws IOException {
        char[] cbuf = new char[1];
        return this.read(cbuf,0,1);
    }

    // Read from buffer
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        char[] buffer = new char[1024];
        int charsRead;
        try {
          while ((charsRead = this.reader.read(buffer)) != -1) {
              // Read characters from the input reader and discard them
              // Do nothing with the characters
          }
          // Always return -1 to indicate end of stream (no data available)
        } catch (Exception e) {
          e.printStackTrace();
        }
        return -1;
    }

    publiic readLine() throws IOException {
      try ( 
        while ((this.reader != null) && (line = this.reader.readLine()) != null) {
          // Do nothing with line
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
    
    @Override
    public void close() throws IOException {
        this.reader.close();
    }

    @Override
    public String toString() {
      return "NullInputStringReader";
    }
 
}
