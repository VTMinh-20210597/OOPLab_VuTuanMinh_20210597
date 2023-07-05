package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame
{
	private Store store;
	private Cart cart;
	
	JPanel createNorth(Cart cart, Store store)
	{
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar(cart, store));
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar(Cart cart, Store store)
	{
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new AddBookListener());
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new AddCDListener());
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new AddDVDListener());
		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		viewStore.addActionListener(new ActionListener()
		{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					new StoreScreen(cart, store);
					dispose();
						
				}
			
		});
		
		JMenuItem viewCart = new JMenuItem("View cart");
		
		menu.add(viewCart);
		viewCart.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CartScreen(cart, store);
				dispose();
				
			}
	
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
	}
	
	JPanel createHeader()
	{
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		
		JButton CartView = new JButton("View cart");
		CartView.setPreferredSize(new Dimension(100, 50));
		CartView.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter(Cart cart, Store store)
	{
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < 9; ++i)
		{
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Cart cart, Store store)
	{
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(cart, store), BorderLayout.NORTH);
		cp.add(createCenter(cart, store), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	
	
	public static void main(String[] args)
	{
		Store myStore = new Store();
		
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
		cd2.addTrack(track1);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 19.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 18.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 19.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 14.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 15.99f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "The Wachowski Brothers", 136, 17.99f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

		//Try adding DVDs
//		myStore.addMedia(dvd2, 5);
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
		
		Cart myCart = new Cart();
		new StoreScreen(myCart, myStore);
	}
	
	private class ViewCartListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new CartScreen(cart, store);
			dispose();
		}
		
	}
	
	private class AddDVDListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new AddDVDToStoreScreen(cart, store);
			dispose();
		}
		
	}
	
	private class AddBookListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AddBookToStoreScreen(cart, store);
			dispose();
		}
		
	}
	
	private class AddCDListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AddCDToStoreScreen(cart, store);
			dispose();
		}
		
	}
		
}
