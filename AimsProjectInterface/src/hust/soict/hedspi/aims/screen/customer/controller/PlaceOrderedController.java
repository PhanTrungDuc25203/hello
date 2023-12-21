package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlaceOrderedController {
	private Store store;
	private Cart cart;
	
	public PlaceOrderedController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	public void setData(Cart cart) {
		this.cart = cart;
		totalCostOrderedlbl.setText(String.format(" %.2f"+" $", cart.totalCost()));
    }
	
    @FXML
    private ResourceBundle resources;


    @FXML
    private GridPane gridPane;
    
    @FXML
    private Label totalCostOrderedlbl;
    
    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    void btnCancelPressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		CartController cartController = new CartController(store, cart);
    		fxmlLoader.setController(cartController);
    		Parent root = fxmlLoader.load();
    		cartController.setData(cart);
    		
    		
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cart");
    		stage.show();	
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) throws IOException {
    	
    	if(cart.getItemOrdered().size() == 0) {
    		JOptionPane.showMessageDialog(null, "There is nothing to buy", "Are you sure?", JOptionPane.INFORMATION_MESSAGE);
    	} else {
    		JOptionPane.showMessageDialog(null, "Thank you for visiting", "Good-bye", JOptionPane.INFORMATION_MESSAGE);
        	//System.out.println(cart.getItemOrdered().toString());
        	cart.removeAllMediaInCart2();
        	
        	final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
    		fxmlLoader.setController(viewStoreController);
    		Parent root = fxmlLoader.load();
    		viewStoreController.setData();
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}
    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'PlaceOrdered.fxml'.";
        assert btnPlaceOrder != null : "fx:id=\"btnPlaceOrder\" was not injected: check your FXML file 'PlaceOrdered.fxml'.";
        

        final String ITEMORDERED_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/ItemsPlaceOrdered.fxml";
        int column = 0;
        int row = 1;
        for(int i=0; i<cart.getItemOrdered().size(); i++) {
        	try {
        		FXMLLoader fxmlLoader = new FXMLLoader();
        		fxmlLoader.setLocation(getClass().getResource(ITEMORDERED_FXML_FILE_PATH));
        		ItemsPlaceOrderedController itemPlaceOrederedController = new ItemsPlaceOrderedController(store, cart);
        		fxmlLoader.setController(itemPlaceOrederedController);
        		Pane pane = new Pane();
        		pane = fxmlLoader.load();
        		itemPlaceOrederedController.setData(cart.getItemOrdered().get(i));
        		gridPane.add(pane, column++, row);
        		if(column == 1) {
        			column = 0;
        			row++;
        		}
        		GridPane.setMargin(pane, new Insets(20, 10, 10, 10));
        	} catch(IOException e){
        		e.printStackTrace();
        	}
        }
    }

}
