package HW9.tasks;

import java.util.Optional;

public class USB {
    private String version;

    USB(String version){
        this.version = version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion(){
        return version;
    }
}
