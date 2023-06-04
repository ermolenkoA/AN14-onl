package HW9.tasks;

import java.util.Optional;

public class Computer {
    private Optional<Soundcard> soundcard;

    Computer(Optional<Soundcard> soundcard){
        this.soundcard = soundcard;
    }
    Computer(){}
    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }
    public void setSoundcard(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }
}
