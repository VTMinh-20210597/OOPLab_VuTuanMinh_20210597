package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc 
{
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
		++ nbDigitalVideoDiscs;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		++ nbDigitalVideoDiscs;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		++ nbDigitalVideoDiscs;
		this.id = nbDigitalVideoDiscs;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() 
	{
		return id + ". " + "DVD - " + title + " - " + category + " - " + director
			   + " - " + length + ": " + cost + "$";
	}
	
	public boolean isMatch(String title)
	{
		if(this.title == title) return true;
		
		return false;
	}
	
	public boolean isMatch(int id)
	{
		if(this.id == id) return true;
		
		return false;
		
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
