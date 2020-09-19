package sample;

import java.time.LocalTime;

public class Highscore implements Comparable{
    private String username;
    private LocalTime time;

    public Highscore(String username, LocalTime time) {
        this.username = username;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return username + " - " + time.toString();
    }

    @Override
    public int compareTo(Object o) {
        Highscore hs = (Highscore) o;
        if (time.isBefore(hs.time)) return -1;
        if (time.isAfter(hs.time)) return 1;
        return username.compareTo(hs.username);
    }
}
