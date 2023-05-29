import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
public class CheckPolymorphism {

	public static void main(String[] args) 
	{
		ArrayList<Media> mediae = new ArrayList<Media>();
		
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("J.K. Rowling");
		authors.add("John Grisham");
		Book book = new Book(1, "Harry Potter and the Sorcerer's Stone", "Fantasy", 24.99f, authors);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Thriller", "Christopher Nolan", 148, 12.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Inception", "Thriller", "Christopher Nolan", 148, 12.99f);
		
		CompactDisc cd1 = new CompactDisc(1, "Abbey Road", "Rock", "The Beatles", 19.99f);
		CompactDisc cd2 = new CompactDisc(2, "Dark Side of the Moon", "Rock", "Pink Floyd", 14.99f);
		CompactDisc cd3 = new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", 12.99f);
		
		mediae.add(book);
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(dvd3);
		mediae.add(cd1);
		mediae.add(cd2);
		mediae.add(cd3);
		
		Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
		
		for(Media m: mediae)
		{
			System.out.println(m.toString());
		}
		
		
		
		

	}

}
