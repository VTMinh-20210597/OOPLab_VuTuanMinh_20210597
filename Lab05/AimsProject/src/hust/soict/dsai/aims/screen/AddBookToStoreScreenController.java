package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AddBookToStoreScreenController extends AddItemToStoreScreenController {
	private Book book;
	private ArrayList<String> authors = new ArrayList<String>();
	
	@FXML
	private TextField tfAuthors;
	
	
	public AddBookToStoreScreenController(Cart cart, Store store, JFrame stage) {
		super(cart, store, stage);
	}

	@FXML
	private void addAuthorBtnPressed() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("You can add new author");
		dialog.setContentText("Please enter author name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    authors.add(result.get());
		    if (tfAuthors.getText().length() == 0) {
		    	tfAuthors.setText(result.get());
		    } else {
		    	tfAuthors.setText(tfAuthors.getText() + ", " + result.get());
		    }
		}
	}
	
	@FXML
	@Override
	protected void addBtnPressed() 
	{
		book = new Book(this.title, this.category, this.cost, this.authors);
		for (String author: authors) book.addAuthor(author);
			store.addMedia(book);

	}
}