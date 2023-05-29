package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable
{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private int DiscLength;
	

	public CompactDisc(int id, String title, String category, String artist, float cost) 
	{
		this.id = id;
		this.title = title;
		this.category = category;
		this.artist = artist;
		this.cost = cost;
	}



	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track_name)
	{
		if(tracks.contains(track_name))
		{
			System.out.println("This track already exists");
			return;
		}
		
		tracks.add(track_name);
		System.out.println("This track has been added");
	}
	
	public void removeTrack(Track track_name)
	{
		if(!tracks.contains(track_name))
		{
			System.out.println("This track doesn't exist");
			return;
		}
		
		tracks.remove(track_name);
		return;
	}
	
	public int getLength()
	{
		for(int i = 0; i < tracks.size(); ++i)
		{
			Track track_i = tracks.get(i);
			DiscLength += track_i.getLength();
			
		}
		
		return DiscLength;
	}
	
	public void play() 
	{
		System.out.println("Playing CompactDisc: " + this.getTitle());
		System.out.println("CompactDisc length: " + this.getLength());
		
		for(int i = 0; i < tracks.size(); ++i)
		{
			Track track_i = tracks.get(i);
			track_i.play();
		}
		
	}



	@Override
	public String toString() {
		return "CompactDisc [artist=" + artist + ", tracks=" + tracks + ", DiscLength=" + DiscLength + ", length="
				+ length + ", director=" + director + ", id=" + id + ", title=" + title + ", category=" + category
				+ ", cost=" + cost + "]";
	}
	
	

}
