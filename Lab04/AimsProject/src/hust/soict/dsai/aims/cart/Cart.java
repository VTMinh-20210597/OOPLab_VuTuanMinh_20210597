package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart 
{
	public static final int MAX_NUMBERS_ORDERED = 20;
	private float Sum = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Cart()
	{
	}
	
	public void addMedia(Media media_i)
	{
		if(itemsOrdered.size() == MAX_NUMBERS_ORDERED)
		{
			System.out.println("This Cart is full");
			return;
		}
		
		itemsOrdered.add(media_i);
		
		System.out.println("This media has been added");
		return;
	}
	
	public void removeMedia(Media media_i)
	{
		if(itemsOrdered.remove(media_i))
		{
			System.out.println("This media has been deleted");
			return;
		}
		
		System.out.println("This media doesnt exist");
		return;
	}
	
	public float totalCost()
	{
		for(int i = 1; i <= itemsOrdered.size(); ++i)
		{
			Media item_Ordered_i = itemsOrdered.get(i);
			Sum += item_Ordered_i.getCost();
		}
		
		return Sum;
	}
	
	public void PrintDisc()
	{
		System.out.println("Names of discs in cart: ");
		for(int i = 0; i < itemsOrdered.size(); ++i)
		{
			Media Media_i = itemsOrdered.get(i);
			System.out.println(Media_i.getTitle());
		}
	}
	
	public void SortByPrice()
	{
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		
		for(Media m: itemsOrdered)
		{
			System.out.println(m.toString());
		}
	}
	
	public void SortByTitle()
	{
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		
		for(Media m: itemsOrdered)
		{
			System.out.println(m.toString());
		}
	}
	
	public void searchId(int id)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			Media media_i = itemsOrdered.get(i);
			if(media_i.getId() == id) media_i.toString();
		}
		
	}
	
	public void searchTitle(String title)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			Media media_i = itemsOrdered.get(i);
			if(media_i.getTitle().equals(title)) media_i.toString();
		}
		
	}
	
	public Media findMedia(String title)
	{
		for(int i = 0; i < itemsOrdered.size(); ++i)
		{
			Media media_i = itemsOrdered.get(i);
			if(media_i.getTitle().equals(title)) return media_i;
		}
		
		return null;
	}
	
	public void removeAll()
	{
		itemsOrdered.clear();
	}
	
	
}
