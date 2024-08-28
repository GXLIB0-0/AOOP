
class AudioDecoder {
    public void decodeAudio(String audioFile) {
        System.out.println("Decoding audio: " + audioFile);
    }

    public void playAudio() {
        System.out.println("Playing audio...");
    }

    public void stopAudio() {
        System.out.println("Stopping audio...");
    }
}


class VideoPlayer {
    public void playVideo(String videoFile) {
        System.out.println("Playing video: " + videoFile);
    }

    public void stopVideo() {
        System.out.println("Stopping video...");
    }

    public void pauseVideo() {
        System.out.println("Pausing video...");
    }
}

// Subsystem: SubtitleManager
class SubtitleManager {
    public void loadSubtitles(String subtitleFile) {
        System.out.println("Loading subtitles: " + subtitleFile);
    }

    public void showSubtitles() {
        System.out.println("Showing subtitles...");
    }

    public void hideSubtitles() {
        System.out.println("Hiding subtitles...");
    }
}


class MediaPlayerFacade {
    private AudioDecoder audioDecoder;
    private VideoPlayer videoPlayer;
    private SubtitleManager subtitleManager;

    public MediaPlayerFacade() {
        this.audioDecoder = new AudioDecoder();
        this.videoPlayer = new VideoPlayer();
        this.subtitleManager = new SubtitleManager();
    }

    public void playMedia(String audioFile, String videoFile, String subtitleFile) {
        System.out.println("Starting media playback...");
        audioDecoder.decodeAudio(audioFile);
        videoPlayer.playVideo(videoFile);
        subtitleManager.loadSubtitles(subtitleFile);
        subtitleManager.showSubtitles();
        audioDecoder.playAudio();
    }

    public void pauseMedia() {
        System.out.println("Pausing media playback...");
        videoPlayer.pauseVideo();
        audioDecoder.stopAudio();
    }

    public void stopMedia() {
        System.out.println("Stopping media playback...");
        videoPlayer.stopVideo();
        subtitleManager.hideSubtitles();
        audioDecoder.stopAudio();
    }
}


public class MediaPlayerClient {
    public static void main(String[] args) {
        MediaPlayerFacade mediaPlayer = new MediaPlayerFacade();
        mediaPlayer.playMedia("song.mp3", "movie.mp4", "subtitles.srt");
        
        // Simulate user pausing media
        mediaPlayer.pauseMedia();
        
        // Simulate user stopping media
        mediaPlayer.stopMedia();
    }
}
