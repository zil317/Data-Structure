
/**This class creates a song object with its title, artist, album, year and time */

/** create private string fields for title, artist, and album */ 
public class Song {
  private String title;
  private String artist;
  private String album;
  private int year;
  private int time;
  
  /**create a constructor for title, artist, album, year and time*/
  public Song(String title, String artist, String album, int year, int time) {
    this.title = title;
    this.artist = artist;
    this.album = album;
    this.year = year;
    this.time = time;
  }
  /**a public getter for title*/
  public String getTitle() {
    return title;
  }
  /**a public getter for artist*/
  public String getArtist() {
    return artist;
  }
  /**a public getter for album*/
  public String getAlbum() {
    return album;
  }
  /**a public getter for year*/
  public int getYear() {
    return year;
  }
  /**a public getter for time*/
  public int getTime() {
    return time;
  }
  
  /**prints the information about a song on a single line to the standard output device*/
  public void printSongRow() {
    System.out.printf("%-25s  %-25s  %-30s  %-4d  %-10s\n", getTitle(),getArtist(),getAlbum(),getYear(),secToTimeString(time));
  }
  
  /**given an integer parameter representing a time in seconds, returns the time in mm:ss or hh:mm:ss format*/
  public String secToTimeString(int time){
    int hour;
    int minute;
    int second;
    String newTime;
    
    if (time>= 3600) {
      hour=time/3600;
      minute=(time%3600)/60;
      second=time-hour*3600-minute*60;
      newTime=String.format("%02d:%02d:%02d",hour,minute,second);
    }
    else {
      if(time>= 60) {
        minute=time/60;
        second=time%60;
        newTime=String.format("%02d:%02d",minute,second);
      }
      else {
        second=time;
        newTime=String.format("%02d",second);
      }
    }
    return newTime;
  }
  
}
      
    
    
    
    
    
    
    
    
    