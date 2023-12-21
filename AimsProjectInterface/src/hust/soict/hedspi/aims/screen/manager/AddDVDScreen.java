package hust.soict.hedspi.aims.screen.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDVDScreen extends AddItemToStoreScreen {

	private static final long serialVersionUID = 1L;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDVDScreen frame = new AddDVDScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddDVDScreen() {	
		JLabel dvdDirector = new JLabel("Director");
		dvdDirector.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdDirector.setBounds(31, 227, 174, 40);
		getContentPane().add(dvdDirector);
		
		JLabel dvdLength = new JLabel("Length");
		dvdLength.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdLength.setBounds(31, 277, 174, 40);
		getContentPane().add(dvdLength);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(255, 227, 357, 40);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(255, 277, 357, 40);
		getContentPane().add(textField_5);
		
		getResetButton().addActionListener(new ResetAllItemAddFormActionListener());
		getAddButton().addActionListener(new AddNewItemToStoreActionListener());
	}
	
	/**
	 * RESET BUTTON's action
	 */
	private class ResetAllItemAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			getTextField().setText("");
			getTextField_1().setText("");
			getTextField_2().setText("");
			getTextField_3().setText("");
			textField_4.setText("");
			textField_5.setText("");
			
			getAddButton().setEnabled(true);
		}
	}
	
	/**
	 * ADD BUTTON's action
	 */
	private class AddNewItemToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String tempStringID = getTextField().getText();
			int tempID = Integer.parseInt(tempStringID);
			String tempTitle = getTextField_1().getText();
			String tempCategory = getTextField_2().getText();
			String tempStringCost = getTextField_3().getText();
			float tempCost = Float.parseFloat(tempStringCost);
			String tempDirector = textField_4.getText();
			String tempStringLength = textField_5.getText();
			int tempLength = Integer.parseInt(tempStringLength);
			DigitalVideoDisc newDiscToStore = new DigitalVideoDisc(tempID, tempTitle, tempCategory, tempCost, tempDirector, tempLength);
			StoreManagerScreen.store.addMedia(newDiscToStore);
			StoreManagerScreen.store.print();
			
			
			System.out.format("%10s%30s%20s%10s",newDiscToStore.getId(),newDiscToStore.getTitle(),newDiscToStore.getCategory(), newDiscToStore.getCost());
			System.out.println(newDiscToStore.toString());
			System.out.println();
			
			
			getAddButton().setEnabled(false);;
		}
	}
}
