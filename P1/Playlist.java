/* 
CSE 17 
Zihan Liu 
Program #1  DEADlINE: September 22, 2016
Program: MP3 Player
*/

/**This class creates a playlist with song information that user inputted*/

import java.util.*;

/**create a private string data field name, a private array of Song objects called songs, and a print int field numSongs*/
public class Playlist {
  
  private String name;
  private Song[] songs;
  private int numSongs;
  
  //a public named integer constant DEFAULT_CAPACITY
  public static final int DEFAULT_CAPACITY=10;
  
  /**intializes songs to the size to the DEFAULT_CAPACITY and sets numSongs to 0*/
  public Playlist(String name) {
    this.name = name;
    songs = new Song[DEFAULT_CAPACITY];
    numSongs=0;
  }
  
  /**initializes songs to the size specified by the parameter and sets numSongs to 0*/
  public Playlist(String name, int capacity) {
    this.name = name;
    songs = new Song[capacity];
    numSongs=0;
  }
  
  /**a public getter for name called getName*/
  public String getName() {
    return name;
  }
  
  /**given an integer position, returns the song at that position*/
  public Song getSong(int position) {
    if(position>numSongs){
      return null;
    }
      else{
        return songs[position-1];
      }
  }
  
  /**returns the number of songs currently in the playlist*/
  public int getNumSongs() {
    return numSongs;
  }
  
  /**returns the integer that is total number of seconds of all songs currently in the playlist*/
  public int getTotalTime() {
    int totalTime=0;
    for(int i=0; i<numSongs; i++) {
      totalTime= totalTime+songs[i].getTime();
    }
    return totalTime;
  }
   
  /**if the exisiting array has room for an additional song, then it is added in the next avaliable position.
    * if the list is full, then nothing happens*/
  public void addSong(Song song) {
    
    if (numSongs<DEFAULT_CAPACITY) {
      songs[numSongs] = song;
      numSongs++;
    }
  }
  
  /**outputs the name of the playlist, its total time in hh:mm:ss format, a line of the form "contains x songs"
    * and then a sequence of lines with detailed information about each song*/
  public void printList() {
    System.out.printf("%-5.25s\n", name);
    int x=getTotalTime();
    Song asong = new Song("title","all","qwe",1234,x);
    System.out.printf("Total time: %-5.10s\n", asong.secToTimeString(x));
    System.out.println("Contain "+numSongs+" songs");
    
    for(int i=0;i<numSongs;i++) {
      System.out.print(i+1+"   ");
      songs[i].printSongRow();
    }
  }
  /**ask user to provide a name for the playlist
    * create a playlist object with the default capacity 
    * enter a loop where it asks the user to enter a numeric command (>0 and <=3) and then process the commands*/
  public static void main(String[] arguments) {
    
    Scanner scan = new Scanner(System.in);
    String title; String artist; String album; int year;int time; String name;
    Playlist newPlaylist = null;

    
    System.out.println("Name your playlist: ");
    name=scan.next();
    scan.nextLine();
    newPlaylist = new Playlist(name);                 
                         
    
    boolean incorrectinput = true;
    
    while(incorrectinput) {
      
      System.out.println("Command [1=Add, 2=Sort,3=Print, 0=quit]?");
      
      int x=scan.nextInt();
      scan.nextLine();
      //if user enters any integer that is other than 0 to 3, print error message and ask for a new input
      while(x<0||x>3) {
        System.out.println("invalid command. Try again.");
        x=scan.nextInt();
        if(x>=0 && x<=3){
          break;
        }
      }
      //if user enters 1, add a song
        if(x==1) {
          
          System.out.println("Add a song");
          System.out.println("Song title?");
          title=scan.nextLine();
          
          System.out.println("Artist?");
          artist=scan.nextLine();
         
          System.out.println("Album?");
          album=scan.nextLine();
          
          System.out.println("Year?");
          year=scan.nextInt();
          scan.nextLine();
          
          System.out.println("Time (seconds)?");
          time=scan.nextInt();
          scan.nextLine();
          
          
          Song newSong = new Song(title, artist,album,year,time);
          newPlaylist.addSong(newSong);
         }
        
        //if user enters 3, print out the playlist
        if (x==3) {
          newPlaylist.printList();
        }
        
        //if user enters 2, sort the playlist chronologically by the year the song was published
        if(x==2) {
          for (int i=1; i<newPlaylist.numSongs;i++){
            Song currentSong = newPlaylist.songs[i];
            int currentSongYear= newPlaylist.songs[i].getYear();
            int currentMinIndex=i;
            int k;
          
            for(k=i-1;k>=0 && newPlaylist.songs[k].getYear() >currentSongYear;k--){
              newPlaylist.songs[k+1] = newPlaylist.songs[k];
            }
            newPlaylist.songs[k+1]=currentSong;
          } 
        }

        //if user enters 0, exit the loop
        if(x==0) {
          incorrectinput=false;
        } 
    }
  }  
}

    
            
  
  
  
  
  
  
  
  
  
  
    