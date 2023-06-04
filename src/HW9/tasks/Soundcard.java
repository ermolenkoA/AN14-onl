package HW9.tasks;

import java.util.Optional;

public class Soundcard {
    private Optional<USB> usb;

    Soundcard(Optional<USB> usb){
        this.usb = usb;
    }
    Soundcard(){}
    public Optional<USB> getUSB() {
        return usb;
    }
    public void setUSB(Optional<USB> usb) {
        this.usb = usb;
    }
}
