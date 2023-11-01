package Model;

public class Movie {
private Long id;
private String title;
private String director;
private String rleaseYear;
private Enum genre;
private int runtime;

    public Movie(String title, String director, String rleaseYear, Enum genre, int runtime) {
        this.title = title;
        this.director = director;
        this.rleaseYear = rleaseYear;
        this.genre = genre;
        this.runtime = runtime;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRleaseYear() {
        return rleaseYear;
    }

    public void setRleaseYear(String rleaseYear) {
        this.rleaseYear = rleaseYear;
    }

    public Enum getGenre() {
        return genre;
    }

    public void setGenre(Enum genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rleaseYear='" + rleaseYear + '\'' +
                ", genre=" + genre +
                ", runtime=" + runtime +
                '}';
    }
}
