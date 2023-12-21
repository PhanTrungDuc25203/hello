package hust.soict.hedspi.aims.screen.customer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
	private Media media;
	private Cart cart;
	private Store store;
	private ViewStoreController viewStoreController;
    public ItemController(Store store, Cart cart, ViewStoreController viewStoreController) {
		// TODO Auto-generated constructor stub
    	this.store = store;
    	this.cart = cart;
    	this.viewStoreController= viewStoreController;
	}

	public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost()+ " $");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 0));
    		
    	}
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {	
    	cart.addMedia(this.media);
    	JOptionPane.showMessageDialog(null, "Added to Cart successfully", media.getTitle(), JOptionPane.INFORMATION_MESSAGE);
//    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	viewStoreController.getNewItemInCartLabel();
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	media.playDialog();
    }

    @FXML
    void initialize() {
        assert btnAddToCart != null : "fx:id=\"btnAddToCart\" was not injected: check your FXML file 'Item.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'Item.fxml'.";
        assert lblCost != null : "fx:id=\"lblCost\" was not injected: check your FXML file 'Item.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'Item.fxml'.";

    }
}
