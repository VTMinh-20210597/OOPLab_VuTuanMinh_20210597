package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store 
{
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[5000];
	private int qtyDVDs = 0;
	
	public void addDVD(DigitalVideoDisc dvd1)
	{
		for(int i = 1; i <= qtyDVDs; ++i)
		{
			if(itemsInStore[i].isMatch(dvd1.getTitle()))
			{
				System.out.println("This DVD is exist");
				return;
			}
		}
		
		itemsInStore[++qtyDVDs] = dvd1;
		System.out.println("This DVD has been added");
		return;
	}
	
	public void removeDVD(DigitalVideoDisc dvd1)
	{
		for(int i = 1; i <= qtyDVDs; ++i)
		{
			if(itemsInStore[i].isMatch(dvd1.getTitle()))
			{
				for(int j = i; j <= qtyDVDs; ++j)
				{
					itemsInStore[j] = itemsInStore[j + 1];
				}
				
				qtyDVDs --;
				
				System.out.println("This DVD has been removed");
				return;
			}
		}
		
		System.out.println("This DVD is not exist");
		return;
	}
	
	public void print()
	{
		for(int i = 1; i <= qtyDVDs; ++i)
		{
			System.out.println(itemsInStore[i].toString());
		}
	}
}
