package domain;

public class Paper {
    public static String citesPrefix="https://e.glgoo.top/scholar?";
    private String title;
    private Integer citesCount;
    private Integer year;
    private String citesId;
    private String author;
    //期刊的名称
    private String letter;

    @Override
    public String toString() {
        return "Paper{" +
                "title='" + title + '\'' +
                ", citesCount=" + citesCount +
                ", year=" + year +
                ", citesId='" + citesId + '\'' +
                ", author='" + author + '\'' +
                ", letter='" + letter + '\'' +
                '}';
    }

    public static String getCitesPrefix() {
        return citesPrefix;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCitesCount() {
        return citesCount;
    }

    public Integer getYear() {
        return year;
    }

    public String getCitesId() {
        return citesId;
    }

    public String getAuthor() {
        return author;
    }

    public String getLetter() {
        return letter;
    }

    public static void setCitesPrefix(String citesPrefix) {
        Paper.citesPrefix = citesPrefix;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCitesCount(Integer citesCount) {
        this.citesCount = citesCount;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setCitesId(String citesId) {
        this.citesId = citesId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Paper(){}
    public Paper(String title, Integer citesCount, Integer year, String citesId, String author, String letter) {
        this.title = title;
        this.citesCount = citesCount;
        this.year = year;
        this.citesId = citesId;
        this.author = author;
        this.letter = letter;
    }
}
