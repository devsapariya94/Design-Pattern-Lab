 interface State {
    public void pressPlay(MusicPlayer player);
    public void pressNext(MusicPlayer player);
    public void pressPrevious(MusicPlayer player);
}

 class MusicPlayer {
    private State state;

    public MusicPlayer() {
        this.state = new ReadyState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressNext() {
        state.pressNext(this);
    }

    public void pressPrevious() {
        state.pressPrevious(this);
    }
}

 class ReadyState implements State {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Playing music");
        player.setState(new PlayingState());
    }

    @Override
    public void pressNext(MusicPlayer player) {
        System.out.println("Can't skip, music is not playing");
    }

    @Override
    public void pressPrevious(MusicPlayer player) {
        System.out.println("Can't skip back, music is not playing");
    }
}

 class PlayingState implements State {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Pausing music");
        player.setState(new PausedState());
    }

    @Override
    public void pressNext(MusicPlayer player) {
        System.out.println("Skipping to next song");
    }

    @Override
    public void pressPrevious(MusicPlayer player) {
        System.out.println("Skipping back to previous song");
    }
}

 class PausedState implements State {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Resuming music");
        player.setState(new PlayingState());
    }

    @Override
    public void pressNext(MusicPlayer player) {
        System.out.println("Can't skip, music is paused");
    }

    @Override
    public void pressPrevious(MusicPlayer player) {
        System.out.println("Can't skip back, music is paused");
    }
}

public class StateMusicPlayerTest {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.pressNext();
        player.pressPrevious();
        player.pressPlay();
        player.pressPlay();
        player.pressNext();
        player.pressPrevious();
        player.pressPlay();
        player.pressPlay();
        player.pressPlay();
    }
}
