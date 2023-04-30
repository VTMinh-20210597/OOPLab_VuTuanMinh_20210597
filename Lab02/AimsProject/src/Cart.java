
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
}
