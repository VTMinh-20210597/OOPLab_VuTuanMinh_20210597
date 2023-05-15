package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart 
{
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	private float Sum = 0;
	
	public Cart()
	{
		this.qtyOrdered  = 0;
	}
	
	
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(qtyOrdered == MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full");
			return;
		}
		else if (qtyOrdered < MAX_NUMBERS_ORDERED)
		{
			qtyOrdered ++;
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("The disc has been added");
			return;
			
		}
		
		return;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
	{
		int NumDVDs = dvdList.length;
		
		if(NumDVDs + qtyOrdered > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full");
			return;
		}
		
		for(int i = qtyOrdered + 1; i <= NumDVDs + qtyOrdered + 1; ++i)
		{
			itemsOrdered[i] = dvdList[i - qtyOrdered];
		}
		
		qtyOrdered += NumDVDs;
		
		System.out.println("The list of discs have been added");
		
		return;
		
		
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	{
		if(qtyOrdered + 2 > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full");
			return;
		}
		
		itemsOrdered[++qtyOrdered] = dvd1;
		itemsOrdered[++qtyOrdered] = dvd2;
		
		System.out.println("The discs have been added");
		
		return;
		
		
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for(int i = 1; i <= qtyOrdered; i++)
		{
			if(itemsOrdered[i] == disc)
			{
				
				DigitalVideoDisc Swap = itemsOrdered[qtyOrdered];
				itemsOrdered[qtyOrdered] = itemsOrdered[i];
				itemsOrdered[i] = Swap;
				--qtyOrdered;
				System.out.println("The disc has been removed");
				return;
			}
		}
		
		System.out.println("The discs is not found");
		return;
	}
	
	public float totalCost()
	{
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			Sum += itemsOrdered[i].getCost();
		}
		
		return Sum;
	}
	
	public void PrintDisc()
	{
		System.out.println("Names of discs in cart: ");
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			System.out.println(itemsOrdered[i].getTitle());
		}
	}
	
	
	public void print()
	{
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			System.out.println(itemsOrdered[i].toString());
		}
		
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			Sum += itemsOrdered[i].getCost();
		}
			
		
		System.out.println("Total Cost: " + Sum);
	}
	
	
	public void SearchByTitle(String Title)
	{
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			if(itemsOrdered[i].isMatch(Title))
			{
				System.out.println(itemsOrdered[i].toString());
				return;
			}
			
			System.out.println("The title can not be found");
		}
	}
	
	public void SearchByID(int Id)
	{
		for(int i = 1; i <= qtyOrdered; ++i)
		{
			if(itemsOrdered[i].isMatch(Id))
			{
				System.out.println(itemsOrdered[i].toString());
				return;
			}
			
			System.out.println("The Id can not be found");
		}
	}
	
	
}
