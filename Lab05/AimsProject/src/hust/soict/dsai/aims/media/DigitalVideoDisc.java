package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable
{
	private static int nbDigitalVideoDiscs = 0;	
	
	public DigitalVideoDisc(String title) {
		this.title = title;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = "DVD" + Integer.toString(nbDigitalVideoDiscs);
	}
	
	public boolean isMatchTitle(String title)
	{
		if(this.title == title) return true;
		
		return false;
	}
	
	public boolean isMatchId(String id)
	{
		if(this.id.equals(id)) return true;
		
		return false;
		
	}
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public void play() 
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public String toString() {
		return "DigitalVideoDisc [length=" + length + ", director=" + director + ", id=" + id + ", title=" + title
				+ ", category=" + category + ", cost=" + cost + "]";
	}
	
	
	
}
