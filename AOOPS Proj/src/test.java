import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MediaPlayerFacadeTest {

    private MediaPlayerFacade mediaPlayer;
    private TestOutputStream testOutputStream;

    
    public void setUp() {
        
        mediaPlayer = new MediaPlayerFacade();
        testOutputStream = new TestOutputStream();
        System.setOut(testOutputStream.getPrintStream());
    }

    
    public void testPlayMedia() {
        mediaPlayer.playMedia("song.mp3", "movie.mp4", "subtitles.srt");

        String output = testOutputStream.getOutput();
        assertTrue(output.contains("Starting media playback..."));
        assertTrue(output.contains("Decoding audio: song.mp3"));
        assertTrue(output.contains("Playing video: movie.mp4"));
        assertTrue(output.contains("Loading subtitles: subtitles.srt"));
        assertTrue(output.contains("Showing subtitles..."));
        assertTrue(output.contains("Playing audio..."));
    }

    
    public void testPauseMedia() {
        mediaPlayer.pauseMedia();

        String output = testOutputStream.getOutput();
        assertTrue(output.contains("Pausing media playback..."));
        assertTrue(output.contains("Pausing video..."));
        assertTrue(output.contains("Stopping audio..."));
    }

    
    public void testStopMedia() {
        mediaPlayer.stopMedia();

        String output = testOutputStream.getOutput();
        assertTrue(output.contains("Stopping media playback..."));
        assertTrue(output.contains("Stopping video..."));
        assertTrue(output.contains("Hiding subtitles..."));
        assertTrue(output.contains("Stopping audio..."));
    }
}
