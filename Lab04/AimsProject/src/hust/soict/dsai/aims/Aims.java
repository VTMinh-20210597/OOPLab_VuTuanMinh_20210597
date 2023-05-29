package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

import java.util.Collections;
import java.util.Scanner;


public class Aims 
{
	public static Store store = new Store();
	public static Cart cart = new Cart();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
	}
	
	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3"); 
		
		int option = sc.nextInt();
		
		if(option == 1) storeMenu();
		else if(option == 2) UpdateMenu();
		else if(option == 3) cartMenu();
		else if(option == 0)
		{
			System.out.println("Exit Sucessfully");
			return;
		}
		else System.out.println("The task is not exist");
		
	}
	
	public static void UpdateMenu()
	{
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media in store"); 
		System.out.println("3. Add a media in store"); 
		System.out.println("4. See current store"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void storeMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int option = sc.nextInt();
		
		if(option == 1) SeeMediaDetail();
		else if(option == 2) addMediaMenu();
		else if(option == 3) playMediaMenu();
		else if(option == 4) cartMenu();
		else if(option == 0) showMenu();
		else System.out.println("The task is not exist");
		
		}
	
	public static void SeeMediaDetail()
	{
		System.out.println("Type the name of media you are looking for:");
		String Media_name = sc.nextLine();
		
		if(store.findMedia(Media_name) != null)
		{
			Media media_i = store.findMedia(Media_name); 
			media_i.toString();
			mediaDetailsMenu(media_i);
			
		}
		else 
		{
			System.out.println("This media doesnt exist");
			storeMenu();
		}
	}
	
	public static void mediaDetailsMenu(Media media) { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int option = sc.nextInt();
		
		if(option == 1) cart.addMedia(media);
		else if (option == 2)
		{
			if(media instanceof CompactDisc)
			{
				CompactDisc cd = (CompactDisc)media;
				cd.play();
			}
			else if (media instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc dvd = (DigitalVideoDisc)media;
				dvd.play();
			}
			else if (media instanceof Book)
			{
				System.out.println("This types of media can't be able to play");
			}
		}
		else storeMenu();
		}
	
	public static void addMediaMenu()
	{
		System.out.println("Type the name of media you are looking for:");
		String Media_name = sc.nextLine();
		
		if(store.findMedia(Media_name) != null)
		{
			Media media_i = store.findMedia(Media_name); 
			media_i.toString();
			cart.addMedia(media_i);
			System.out.println("This media has been added");
			
		}
		else 
		{
			System.out.println("This media doesnt exist");
			storeMenu();
		}
		
	}
	
	public static void playMediaMenu()
	{
		System.out.println("Type the name of media you are looking for:");
		String Media_name = sc.nextLine();
		
		if(store.findMedia(Media_name) != null)
		{
			Media media_i = store.findMedia(Media_name); 
			media_i.toString();
			
			if(media_i instanceof CompactDisc)
			{
				CompactDisc cd = (CompactDisc)media_i;
				cd.play();
			}
			else if (media_i instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc dvd = (DigitalVideoDisc)media_i;
				dvd.play();
			}
			else if (media_i instanceof Book)
			{
				System.out.println("This types of media can't be able to play");
			}
		}
		else 
		{
			System.out.println("This media doesnt exist");
			storeMenu();
		}
	}
	
	public static void cartMenu() 
	{ 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int option = sc.nextInt();
		
		if(option == 1)
		{
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter by id");
			System.out.println("2. Filter by title");
			System.out.println("0. Back");
			
			int option1 = sc.nextInt();
			if (option1 == 1) 
			{
				System.out.println("Enter id: ");
				int id = sc.nextInt();
				cart.searchId(id);
				cartMenu();
			} 
			else if (option1 == 2) 
			{
				System.out.println("Enter title: ");
				String title = sc.nextLine();
				title = sc.nextLine();
				cart.searchTitle(title);
				cartMenu();
			} 
			else if (option1 == 0) 
			{
				cartMenu();
			}
		}
		else if (option == 2)
		{
			System.out.println("What do you want to filter media in which order ?");
			System.out.println("-------------------------------------------------");
			System.out.println("1. Sort by Cost");
			System.out.println("2. Sort by Title");
			System.out.println("0. Back");
			System.out.println("-------------------------------------------------"); 
			System.out.println("Please choose a number: 0-1-2");
			
			int option1 = sc.nextInt();
			
			if(option1 == 1) cart.SortByPrice();
			else if(option == 2) cart.SortByTitle();
			else cartMenu();
		}
		else if (option == 3)
		{
			System.out.println("Type the name of media you are looking for:");
			String name_media = sc.nextLine();
			Media cart_item = cart.findMedia(name_media);
			
			cart.removeMedia(cart_item);
		}
		else if(option == 4)
		{
			System.out.println("Type the name of media you are looking for:");
			
			Media media_i = cart.findMedia(name_media); 
			media_i.toString();
			
			if(media_i instanceof CompactDisc)
			{
				CompactDisc cd = (CompactDisc)media_i;
				cd.play();
			}
			else if (media_i instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc dvd = (DigitalVideoDisc)media_i;
				dvd.play();
			}
			else if (media_i instanceof Book)
			{
				System.out.println("This types of media can't be able to play");
			}
			else if(option == 5)
			{
				System.out.println("An order is created");
				cart.removeAll();
			}
			else cartMenu();
		}
	}
		
	
}