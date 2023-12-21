package hust.soict.hedspi.aims.screen.customer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemsPlaceOrderedController {
	private Media media;
	private Store store;

	private Cart cart;

	public ItemsPlaceOrderedController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label itemOrderedCategorylbl;

    @FXML
    private Label itemOrderedCostlbl;

    @FXML
    private Label itemOrderedTitlelbl;

    @FXML
    void initialize() {
        assert itemOrderedCategorylbl != null : "fx:id=\"itemOrderedCategorylbl\" was not injected: check your FXML file 'ItemsPlaceOrdered.fxml'.";
        assert itemOrderedCostlbl != null : "fx:id=\"itemOrderedCostlbl\" was not injected: check your FXML file 'ItemsPlaceOrdered.fxml'.";
        assert itemOrderedTitlelbl != null : "fx:id=\"itemOrderedTitlelbl\" was not injected: check your FXML file 'ItemsPlaceOrdered.fxml'.";

    }

	public void setData(Media media) {
    	this.media = media;
    	itemOrderedTitlelbl.setText(media.getTitle());
    	itemOrderedCategorylbl.setText(media.getCategory());
    	itemOrderedCostlbl.setText(String.format(" %.2f"+" $", media.getCost()));
    }

}
