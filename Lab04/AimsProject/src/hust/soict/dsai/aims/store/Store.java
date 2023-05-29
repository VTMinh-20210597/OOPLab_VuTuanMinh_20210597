package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;


public class Store 
{
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addDVD(Media dvd1)
	{
		for(int i = 0; i < itemsInStore.size(); ++i)
		{
			if(itemsInStore.contains(dvd1))
			{
				System.out.println("This DVD is exist");
				return;
			}
		}
		
		itemsInStore.add(dvd1);
		System.out.println("This DVD has been added");
		return;
	}
	
	public void removeDVD(Media dvd1)
	{
		for(int i = 0; i < itemsInStore.size(); ++i)
		{
			if(itemsInStore.contains(dvd1))
			{
				itemsInStore.remove(dvd1);
				
				System.out.println("This DVD has been removed");
				return;
			}
		}
		
		System.out.println("This DVD is not exist");
		return;
	}
	
	public void print()
	{
		for(int i = 0; i < itemsInStore.size(); ++i)
		{
			Media Media_i = itemsInStore.get(i);
			System.out.println(Media_i.getTitle());
		}
	}
	
	public Media findMedia(String media)
	{
		for(int i = 0; i < itemsInStore.size(); ++i)
		{
			Media Media_i = itemsInStore.get(i);
			if(Media_i.getTitle().equals(media)) return Media_i;
		}
		
		return null;
	}
}
