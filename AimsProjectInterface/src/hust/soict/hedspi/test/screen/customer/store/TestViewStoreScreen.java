package hust.soict.hedspi.test.screen.customer.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		viewStoreController.setData();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		DigitalVideoDisc dvdList[] = {
				new DigitalVideoDisc(1001,"Avenger: Cilvil War","Action",534.95f,"Marvel Studio",164),
				new DigitalVideoDisc(1002,"Avenger: Spiderman: No way home","Action",254.95f,"Marvel Studio",154),
				new DigitalVideoDisc(1003,"Avenger: Infinity War","Action",123.95f,"Marvel Studio",300),
				new DigitalVideoDisc(1004,"Lion King","Animation",59.95f,"Roger Allers",104),
				new DigitalVideoDisc(1005,"Alien Conquer","Science Fiction",222.95f,"George Lucas",487),
				new DigitalVideoDisc(1006,"Aladin","Animation",151.95f,"Group of makers",123),
				new DigitalVideoDisc(1007,"Cinderella","Animation",20.13f,"Group of makers",200),
				new DigitalVideoDisc(1008,"Avenger: End game","Action",123.95f,"Marvel Studio",300),
		};
		List<String> authors1 = List.of("Nam Cao");
		List<String> authors2 = List.of("Dale Carnegie");
		List<String> authors3 = List.of("Jennifer Kahnweiler");
		List<String> authors4 = List.of("Nguyễn Hữu Đa");
		List<String> authors5 = List.of("Ban Hà Bằng", "Nguyễn Đức Nghĩa");
		List<String> authors6 = List.of("Nguyễn Thùy Dung", "Phan Trung Dũng","Hà Duy Bách");
		List<String> authors7 = List.of("Nguyễn Thị Hải Yến", "Ngọ Doãn Ngọc");
		List<String> authors8 = List.of("Đồng Gang Thép", "Hoàng Trí Thanh");
		Book bookList[] = {
				new Book(2001, "Vo Nhat", "Truyện ngắn", 10.00f, authors1),
				new Book(2002, "Đac nhan tam", "Tham khảo", 500.00f, authors2),
				new Book(2003, "Suc manh cua su tham lang", "Tham khảo", 900.00f, authors3),
				new Book(2004, "Tho và Rua", "Dân gian", 6.00f, authors4),
				new Book(2005, "Lap trinh C++", "Lập trình", 20.00f, authors5),
				new Book(2006, "Nuoc mat", "Tham khảo", 133.00f, authors6),
				new Book(2007, "Thanh Giong", "Dân gian", 21.00f, authors7),
				new Book(2008, "Lap trinh Huong doi tuong", "Lập trình", 20.00f, authors8),
				new Book(2007, "So Dua", "Dân gian", 18.00f, authors7),
		};
		List<Track> trackList1 = new ArrayList<Track>();
		 	trackList1.add(new Track("Alone", 200));
		 	trackList1.add(new Track("Alone II", 200));
		 	trackList1.add(new Track("Faded", 300));
		 	trackList1.add(new Track("Unity", 400));
		 	trackList1.add(new Track("i'm on my way", 500));
		List<Track> trackList2 = new ArrayList<Track>();
			trackList2.add(new Track("Lover", 200));
			trackList2.add(new Track("Hello", 200));
		List<Track> trackList3 = new ArrayList<Track>();
		 	trackList3.add(new Track("Tàu anh qua núi", 200));
		 	trackList3.add(new Track("Sầu tím điệp hồng", 200));
		 	trackList3.add(new Track("Hồng nhan", 300));
		List<Track> trackList4 = new ArrayList<Track>();
		 	trackList4.add(new Track("Thunder", 200));
		 	trackList4.add(new Track("My Heart", 200));
		 	trackList4.add(new Track("Waiting for love", 300));
		 	trackList4.add(new Track("The night", 400));
		List<Track> trackList5 = new ArrayList<Track>();
		 	trackList5.add(new Track("Quên người đã quá yêu", 200));
		 	trackList5.add(new Track("Breakfast", 365));
		 	trackList5.add(new Track("Bán duyên", 300));
		 	trackList5.add(new Track("Duyên phận", 400));
		CompactDisc compactDiscList[] = {
			new CompactDisc(3001, "Alan Walker", "EDM", 142.90f, "Alan Walker", trackList1),
			new CompactDisc(3002, "Taylor Swift", "Pop", 230.23f, "Taylor Swift", trackList2),
			new CompactDisc(3003, "Golden Music", "Bolero", 14.00f, "Artist1", trackList3),
			new CompactDisc(3004, "NCS", "EDM", 320.0f, "Avicii", trackList4),
			new CompactDisc(3004, "Nhac Viet 2020", "Pop", 187.0f, "Huy Cận", trackList5),
			};
		store.addMedia(dvdList);
		store.addMedia(bookList);
		store.addMedia(compactDiscList);

		launch(args);
	}
}
