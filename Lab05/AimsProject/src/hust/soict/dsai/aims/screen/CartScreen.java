package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.embed.swing.*;
import javafx.scene.*;

public class CartScreen extends JFrame
{
	private Cart cart;
	private Store store;
	
	public CartScreen(Cart cart, Store store)
	{
		super();
		
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		
		JFrame frame = this;
		
		Platform.runLater(new Runnable()
				{

					@Override
					public void run() 
					{
						try 
						{
							FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
							CartScreenController controller = new CartScreenController(cart, store, frame);
							loader.setController(controller);
							Parent root = loader.load();
							fxPanel.setScene(new Scene(root));
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
			
				});
	}
	
	public static void main(String args[]) throws Exception 
	{
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("J.K. Rowling");
		authors.add("John Grisham");
		Book book = new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 24.99f, authors);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Thriller", "Christopher Nolan", 148, 12.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Thriller", "Christopher Nolan", 148, 12.99f);
		
		CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "The Beatles", 19.99f);
		CompactDisc cd2 = new CompactDisc("Dark Side of the Moon", "Rock", "Pink Floyd", 14.99f);
		CompactDisc cd3 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 12.99f);
		
		Track track1 = new Track("Abbey Road", 12);
		Track track2 = new Track("Dark Side of the Moon");
		Track track3 = new Track("Thriller", 15);
		
		Cart myCart = new Cart();
		cd2.addTrack(track1);
		cd2.addTrack(track3);
		cd2.addTrack(track2);
		myCart.addMedia(dvd1);
		myCart.addMedia(dvd2);
		myCart.addMedia(dvd3);
		myCart.addMedia(cd1);
		myCart.addMedia(cd2);
		myCart.addMedia(cd3);
		myCart.addMedia(book);
		Store myStore = new Store();

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 19.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 18.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 19.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 14.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 15.99f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "The Wachowski Brothers", 136, 17.99f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

		myStore.addMedia(dvd2);
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd3);
		myStore.addMedia(cd1);
		myStore.addMedia(cd2);
		myStore.addMedia(book);
		myStore.addMedia(dvd4);
		myStore.addMedia(dvd5);
		myStore.addMedia(dvd6);
		myStore.addMedia(dvd7);
		myStore.addMedia(dvd8);
		myStore.addMedia(dvd9);
		myStore.addMedia(dvd10);
		new CartScreen(myCart, myStore);
	}
}
