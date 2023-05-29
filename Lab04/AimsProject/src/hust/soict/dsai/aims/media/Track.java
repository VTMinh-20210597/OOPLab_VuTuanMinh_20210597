package hust.soict.dsai.aims.media;

/**
 * @author VU TUAN MINH
 *
 */
public class Track implements Playable
{

	private String title;
	private int length;
	
	public Track() 
	{
		
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void play() 
	{
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)return true;

	    if (obj == null || getClass() != obj.getClass()) return false;

	    Track Track_i = (Track) obj;
	    return ((title.equals(Track_i.title)) && (length == Track_i.length));
	    
	}
	


}
