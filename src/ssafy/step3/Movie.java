package ssafy.step3;

public class Movie {
    int id;
    String title;
    String director;
    String genre;
    int runningTime;

    public Movie() {
    }

    public Movie(int id, String title, String director, String genre, int runningTime) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return id + "  | " + title + "   | " + director + "   | " + genre + "    | " + runningTime;
    }
}