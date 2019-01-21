public class Song {
    private String title;
    private String artist;
    private String rating;
    private String bpm;
    Song(String t,String a,String r,String b){
        title=t;
        artist=a;
        rating=r;
        bpm=b;
    }
    public String getArtist(){
        return artist;
    }
    public String getTitle(){
        return this.title;
    }
    public String toString(){
        return artist+"-"+title;
    }
}
