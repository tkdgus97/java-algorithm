package javastudy;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        LocalTime t = LocalTime.parse(
            LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:00")));
        System.out.println(t.getSecond());
    }
}



class Audio {
    final static String color = "WHITE";
    int volume;

    void volumeUp() {
        this.volume += 1;
    }

    void volumeDown() {
        this.volume -= 1;
    }
    public String getColor() {
        return color;
    }
}
