import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Utility class for capturing system output
class TestOutputStream {
    private ByteArrayOutputStream outputStream;

    public TestOutputStream() {
        outputStream = new ByteArrayOutputStream();
    }

    public PrintStream getPrintStream() {
        return new PrintStream(outputStream);
    }

    public String getOutput() {
        return outputStream.toString();
    }
}
