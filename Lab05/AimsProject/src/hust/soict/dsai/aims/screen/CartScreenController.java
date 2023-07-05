package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.screen.MediaStore;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CartScreenController 
{
	private Cart cart;
	private FilteredList<Media> FilteredCart;
	private boolean filterByID = true;
	private Store store;
	private JFrame frame;
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	public CartScreenController(Cart cart, Store store, JFrame frame)
	{
		super();
		this.cart = cart;
		this.store = store;
		this.frame = frame;
	}
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private TextField tfFilter;

    @FXML
    private Label lbCost;
	
	@FXML
	private void initialize()
	{
		FilteredCart = new FilteredList<Media>(this.cart.getItemsOrdered(), s -> true);
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
		
		tblMedia.setItems(this.cart.getItemsOrdered());

		
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener <Media>()
				{
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue)
					{
						if(newValue != null)
						{
							updateButtonBar(newValue);
						}
					}
				}
				);
		
		tfFilter.textProperty().addListener(new ChangeListener<String> () {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
		
		lbCost.setText(Double.toString((double) Math.floor(this.cart.totalCost() * 100) / 100));
		
		
		

	}
	
	private void updateButtonBar(Media media) 
	{
		if (media == null) 
		{
			btnRemove.setVisible(false);
			btnPlay.setVisible(false);
		} 
		else 
		{
			btnRemove.setVisible(true);
			if (media instanceof Playable) 
			{
				btnPlay.setVisible(true);
			} else 
			{
				btnPlay.setVisible(false);
			}
		}
	}
	
	@FXML
	private void playButtonPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		try 
		{
			((Playable)media).play();
		} 
		catch (PlayerException e) 
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void removeButtonPressed(ActionEvent event) 
	{
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		this.cart.removeMedia(media);
		lbCost.setText(Double.toString((double) Math.floor(this.cart.totalCost() * 100) / 100));
	} 
	
	private void showFilteredMedia(String filter) 
	{
		if (filter == null || filter.length() == 0) 
		{
			FilteredCart.setPredicate(s -> true);
		} 
		else 
		{
			if (filterByID) 
			{
				try 
				{
					FilteredCart.setPredicate(s -> (s.getId()).equals(filter));
	
					
				} 
				catch (NumberFormatException e) {}
			} 
			else 
			{
				FilteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filter));
			}
		}
	}
	
	@FXML
	private void setFilterByID() 
	{
		this.filterByID = true;
	}
	
	@FXML
	private void placeOrderPressed(ActionEvent event) 
	{	
		if (this.cart.getSize() > 0) 
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Order Status");
			alert.setHeaderText("Success");
			alert.setContentText("Your order has been placed.");
			alert.showAndWait();
			this.cart.removeAll();
			lbCost.setText(String.valueOf(this.cart.totalCost()));
		} 
		else 
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Order Status");
			alert.setHeaderText("Failed to place order");
			alert.setContentText("Your cart is empty");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void viewStore()
	{
		new StoreScreen(this.cart, this.store);
		frame.setVisible(false);
	}
	
	@FXML
	private void addDVDToStore() {
		new AddDVDToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	private void addBookToStore() {
		new AddBookToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	@FXML
	private void addCDToStore() {
		new AddCDToStoreScreen(cart, store);
		frame.setVisible(false);
	}
	
	

}
