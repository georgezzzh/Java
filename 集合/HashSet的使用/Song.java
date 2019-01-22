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
    public String getTitle(){
        return this.title;
    }
    public String toString(){
        return artist+"-"+title;
    }
    //比较完hashCode之后比较equals，因为hashCode不是唯一性的标志
    public boolean equals(Object asong){
        Song s=(Song) asong;
        return getTitle().equals(s.getTitle());
    }
    //相同的字符串的hashCode相同
    public int hashCode(){
        return title.hashCode();
    }
}
