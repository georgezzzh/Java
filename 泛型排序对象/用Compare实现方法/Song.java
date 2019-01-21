public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private String rating;
    private String bpm;
    public int compareTo(Song two){
        return title.compareTo(two.getTitle());
    }
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
