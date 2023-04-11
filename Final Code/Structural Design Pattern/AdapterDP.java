interface MediaPlayer {
    public void play(String mediaType, String fileName);
}

class BasicMediaPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter = new MediaAdapter();

    public void play(String mediaType, String fileName) {
        mediaAdapter.play(mediaType, fileName);
    }
}

class AdvancedMediaPlayer {
    public void playMP3(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }

    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    public void playAVI(String fileName) {
        System.out.println("Playing AVI file: " + fileName);
    }

    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();

    public void play(String mediaType, String fileName) {
        if(mediaType.equalsIgnoreCase("mp3")) {
            advancedMediaPlayer.playMP3(fileName);
        }
        else if(mediaType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMP4(fileName);
        }
        else if(mediaType.equalsIgnoreCase("avi")) {
            advancedMediaPlayer.playAVI(fileName);
        }
        else if(mediaType.equalsIgnoreCase("wav")) {
            advancedMediaPlayer.playWAV(fileName);
        }
        else {
            System.out.println("Unsupported media type");
        }
    }
}

public class AdapterDP {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new BasicMediaPlayer();

        mediaPlayer.play("vlc", "music1.vlc");
        mediaPlayer.play("mp3", "song.mp3");
        mediaPlayer.play("mp4", "video.mp4");
    }
}
