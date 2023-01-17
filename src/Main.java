import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1=new Album("Moosa","sidhu moosewala");
        album1.addSongsToAlbum("295",4.40);
        album1.addSongsToAlbum("lastRide",5.40);
        album1.addSongsToAlbum("so High",3.20);

        Album album2=new Album("Arijit's songs","Arijit Singh");
        album2.addSongsToAlbum("kesariya",5.0);
        album2.addSongsToAlbum("Jeena Jeena",3.13);
        album2.addSongsToAlbum("Gerua",6.0);

        System.out.println(album1.findSong("295"));

        LinkedList<Song> myplayList=new LinkedList<>();
        album1.addToPlaylistFromAlbum("295",myplayList);
        album2.addToPlaylistFromAlbum(2,myplayList);
        album1.addToPlaylistFromAlbum("lastRide",myplayList);
        album2.addToPlaylistFromAlbum("kesariya",myplayList);
//        Song sample=new Song("sub",6.0);
//        System.out.println(sample);

        play(myplayList);


    }
    public static void play(LinkedList<Song> playList)
    {
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();
        boolean isForward=false;
        if(playList.size()>0)
        {
            System.out.println("currently playing: ");
            System.out.println(itr.next());
            isForward=true;
        }
        else {
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit=false;
        while(!quit)
        {
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    if(isForward==false)
                    {
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext())
                    {
                    System.out.println(itr.next());
                    }
                else {
                    System.out.println("end of the playlist");
                    isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true)
                    {
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious())
                    {
                    System.out.println(itr.previous());
                    }
                else {
                        System.out.println("you are at the start of the list");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true)
                    {
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else {
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    itr.remove();
                    System.out.println("current song is deleted");
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }
    public static void printSongs(LinkedList<Song> playList)
    {
        for(Song song:playList)
        {
            System.out.println(song);
        }
        return;
    }
    public static void printMenu()
    {
        System.out.println("select your choices");
        System.out.println("1 - play next song");
        System.out.println("2 - play previous song");
        System.out.println("3 - repeat the song");
        System.out.println("4 - show menu again");
        System.out.println("5 - delete the current song");
        System.out.println("6 - print all song in the playlist");
        System.out.println("7 - Exit");

        return;
    }
}