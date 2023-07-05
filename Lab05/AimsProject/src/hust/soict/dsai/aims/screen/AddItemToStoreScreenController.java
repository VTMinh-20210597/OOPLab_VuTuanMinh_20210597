package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class AddItemToStoreScreenController {
	protected Store store;
	protected Cart cart;
	private JFrame frame;
	
	protected String title;
	protected String category;
	protected float cost;
	
	
	@FXML
	protected TextField tfTitle;
	
	@FXML
	protected TextField tfCategory;
	
	@FXML
	protected TextField tfCost;
	
	
	public AddItemToStoreScreenController(Cart cart, Store store, JFrame frame) {
		super();
		this.store = store;
		this.cart = cart;
		this.frame = frame;
	}
	
	
	@FXML
	public void initialize() {
		
		tfTitle.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				title = newValue;
			}
			
		});
		
		tfCategory.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				category = newValue;
			}
			
		});
		
		tfCost.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					Float number = Float.parseFloat(newValue);
					cost = number;
				} catch (NumberFormatException e) {
					cost = 0f;
				}
			}
			
		});
	}
	
	@FXML
	protected void viewStore() {
		new StoreScreen(cart, store);
	    frame.setVisible(false);
	}
	
	@FXML
	protected void viewCart() {
		new CartScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	protected void addBookToStore() {
		new AddBookToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	protected void addCDToStore() {
		new AddCDToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	protected void addDVDToStore() {
		new AddDVDToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	protected abstract void addBtnPressed();

}