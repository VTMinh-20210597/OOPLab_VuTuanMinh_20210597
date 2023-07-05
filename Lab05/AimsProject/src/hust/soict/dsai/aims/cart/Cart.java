package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.exception.CartFullException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart 
{
	public static final int MAX_NUMBERS_ORDERED = 20;
	private float Sum = 0;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public Cart()
	{
	}
	
	public void addMedia(Media medium) throws CartFullException 
	{
		if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) 
		{
			throw new CartFullException("The cart is full.");
		} 
		else 
		{
			this.itemsOrdered.add(medium);
			System.out.println(medium.getTitle() + " has beed added to the cart.");
		}
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
		float cost = 0.0f;
		
		for (Media mediaItems: itemsOrdered) 
		{
			cost += mediaItems.getCost();
		}
		
		return cost;
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
	
	public void searchId(String id)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			Media media_i = itemsOrdered.get(i);
			if(media_i.getId().equals(id)) media_i.toString();
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

	public ObservableList<Media> getItemsOrdered() 
	{
		return itemsOrdered;
	}

	public int getSize() {
		return itemsOrdered.size();
	}
	
}
