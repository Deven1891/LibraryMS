

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojerusan.RSMaterialButtonCircle;
import app.bolivia.swing.JCTextField;
import java.awt.HeadlessException;
import rojeru_san.complementos.RSTableMetro;


public final class Manage_Books extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel manageBooks;
	private JCTextField  txt_bookId, txt_bookName, txt_authorName, txt_quantity;
	private final RSMaterialButtonCircle btnAdd, btnUpdate, btnDelete;
	private final RSTableMetro tbl_bookDetails;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					Manage_Books frame = new Manage_Books();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manage_Books() {
				
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		manageBooks = new JPanel();
		manageBooks.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(manageBooks);
		manageBooks.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 43, 84));
		panel.setBounds(0, 0, 580, 900);
		manageBooks.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		lblEnterBookId.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEnterBookId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId.setForeground(Color.WHITE);
		lblEnterBookId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId.setBounds(104, 128, 149, 32);
		panel.add(lblEnterBookId);
		
		txt_bookId = new JCTextField();
		txt_bookId.setBounds(114, 165, 290, 32);
		panel.add(txt_bookId);
		txt_bookId.setText(setBookID());
		
		JLabel lblEnterBookName = new JLabel("Enter Book Name");
		lblEnterBookName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookName.setForeground(Color.WHITE);
		lblEnterBookName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookName.setAlignmentX(0.5f);
		lblEnterBookName.setBounds(104, 232, 149, 32);
		panel.add(lblEnterBookName);
		
		txt_bookName = new JCTextField();
		txt_bookName.setBounds(117, 270, 290, 32);
		panel.add(txt_bookName);
		
		JLabel lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthorName.setForeground(Color.WHITE);
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthorName.setAlignmentX(0.5f);
		lblAuthorName.setBounds(104, 329, 149, 32);
		panel.add(lblAuthorName);
		
		txt_authorName = new JCTextField();
		txt_authorName.setBounds(117, 367, 290, 32);
		panel.add(txt_authorName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setAlignmentX(0.5f);
		lblQuantity.setBounds(104, 434, 149, 32);
		panel.add(lblQuantity);
		
		txt_quantity = new JCTextField();
		txt_quantity.setBounds(117, 472, 290, 32);
		panel.add(txt_quantity);
		
		JLabel lblEnterBookId_1 = new JLabel("");
		lblEnterBookId_1.setIcon(new ImageIcon(Manage_Books.class.getResource("/Images/AddNewBookIcons/icons8_Contact_26px.png")));
		lblEnterBookId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1.setForeground(Color.WHITE);
		lblEnterBookId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1.setAlignmentX(0.5f);
		lblEnterBookId_1.setBounds(61, 123, 32, 42);
		panel.add(lblEnterBookId_1);
		
		JLabel lblEnterBookId_1_1 = new JLabel("");
		lblEnterBookId_1_1.setIcon(new ImageIcon(Manage_Books.class.getResource("/Images/AddNewBookIcons/icons8_Moleskine_26px.png")));
		lblEnterBookId_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_1.setForeground(Color.WHITE);
		lblEnterBookId_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_1.setAlignmentX(0.5f);
		lblEnterBookId_1_1.setBounds(61, 224, 32, 42);
		panel.add(lblEnterBookId_1_1);
		
		JLabel lblEnterBookId_1_2 = new JLabel("");
		lblEnterBookId_1_2.setIcon(new ImageIcon(Manage_Books.class.getResource("/Images/AddNewBookIcons/icons8_Collaborator_Male_26px.png")));
		lblEnterBookId_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_2.setForeground(Color.WHITE);
		lblEnterBookId_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_2.setAlignmentX(0.5f);
		lblEnterBookId_1_2.setBounds(61, 323, 32, 42);
		panel.add(lblEnterBookId_1_2);
		
		JLabel lblEnterBookId_1_3 = new JLabel("");
		lblEnterBookId_1_3.setIcon(new ImageIcon(Manage_Books.class.getResource("/Images/AddNewBookIcons/icons8_Unit_26px.png")));
		lblEnterBookId_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_3.setForeground(Color.WHITE);
		lblEnterBookId_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_3.setAlignmentX(0.5f);
		lblEnterBookId_1_3.setBounds(61, 429, 32, 42);
		panel.add(lblEnterBookId_1_3);
		
		
		btnAdd = new RSMaterialButtonCircle();
		btnAdd.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(addBook() == true) {
					clearTable();
					setBookDetailsToTable();
					txt_bookId.setText(setBookID());
					txt_bookName.setText("");
					txt_authorName.setText("");
					txt_quantity.setText("");
				}
			}
		});
		btnAdd.setText("Add");
		btnAdd.setForeground(new Color(2, 43, 84));
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 25));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(30, 600, 140, 60);
		panel.add(btnAdd);

		
		
		btnUpdate = new RSMaterialButtonCircle();
		btnUpdate.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(updateBook() == true) {
					clearTable();
					setBookDetailsToTable();
					txt_bookId.setText(setBookID());
					txt_bookName.setText("");
					txt_authorName.setText("");
					txt_quantity.setText("");
				}
			}
		});
		btnUpdate.setText("update");
		btnUpdate.setForeground(new Color(2, 43, 84));
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 25));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(200, 600, 140, 60);
		panel.add(btnUpdate);
		
		
		btnDelete = new RSMaterialButtonCircle();
		btnDelete.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(deleteRecord() == true) {
					clearTable();
					setBookDetailsToTable();
					txt_bookId.setText(setBookID());
					txt_bookName.setText("");
					txt_authorName.setText("");
					txt_quantity.setText("");
				}
			}
		});
		btnDelete.setText("Delete");
		btnDelete.setForeground(new Color(2, 43, 84));
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 25));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(370, 600, 140, 60);
		panel.add(btnDelete);
		
		RSMaterialButtonCircle backButton = new RSMaterialButtonCircle();
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				deshboard desh = new deshboard();
				desh.setVisible(true);
				dispose();
			}
		});
		backButton.setText("<");
		backButton.setForeground(new Color(2, 43, 84));
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(new Color(255, 255, 255));
		backButton.setBounds(0, 0, 60, 60);
		panel.add(backButton);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(580, 0, 1020, 900);
		manageBooks.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		scrollPane_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(126, 201, 811, 357);
		panel_2.add(scrollPane_1);
		
		tbl_bookDetails = new RSTableMetro();
		tbl_bookDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbl_bookDetails.setColorBordeFilas(new Color(255, 255, 255));
		tbl_bookDetails.setColorBordeHead(new Color(255, 255, 255));
		tbl_bookDetails.setColorFilasForeground2(new Color(2, 43, 84));
		tbl_bookDetails.setColorFilasForeground1(new Color(2, 43, 84));
		tbl_bookDetails.setColorSelBackgound(new Color(2, 43, 84));
		tbl_bookDetails.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_bookDetails.setSelectionBackground(new Color(2, 43, 84));
		tbl_bookDetails.setRowMargin(0);
		tbl_bookDetails.setRowHeight(40);
		tbl_bookDetails.setAltoHead(30);
		tbl_bookDetails.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Book Name", "Author", "Quantity"
			}
		));
		scrollPane_1.setViewportView(tbl_bookDetails);
		
		JLabel lblManageBooks = new JLabel("Manage Books");
		lblManageBooks.setIcon(new ImageIcon(Manage_Books.class.getResource("/ImagesOfLibrary/book2.png")));
		lblManageBooks.setBackground(new Color(255, 255, 255));
		lblManageBooks.setHorizontalAlignment(SwingConstants.LEFT);
		lblManageBooks.setForeground(new Color(2, 43, 84));
		lblManageBooks.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblManageBooks.setAlignmentX(0.5f);
		lblManageBooks.setBounds(427, 38, 289, 72);
		panel_2.add(lblManageBooks);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(2, 43, 84));
		panel_3.setBackground(new Color(2, 43, 84));
		panel_3.setBounds(427, 121, 289, 4);
		panel_2.add(panel_3);
		
		RSMaterialButtonCircle mtrlbtncrclX_1 = new RSMaterialButtonCircle();
		mtrlbtncrclX_1.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX_1.setText("X");
		mtrlbtncrclX_1.setForeground(new Color(255, 255, 255));
		mtrlbtncrclX_1.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX_1.setBackground(new Color(2, 43, 84));
		mtrlbtncrclX_1.setBounds(960, 0, 60, 60);
		panel_2.add(mtrlbtncrclX_1);
		
		
		
		setBookDetailsToTable();
	}
	
	// To Set The book details into the table
	DefaultTableModel model;
	public void setBookDetailsToTable() {
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_details");
			
			while(rs.next()) {
				int bookID;
                                bookID = rs.getInt("book_id");
				String Bookname;
                                Bookname = rs.getString("book_name");
				String author = rs.getString("author");
				int Quantity;
                                Quantity = rs.getInt("quantity");
				
				Object[] obj = {bookID,Bookname,author,Quantity};
				model = (DefaultTableModel) tbl_bookDetails.getModel();
				model.addRow(obj);
			}
		}catch(SQLException e) {
		}
	}
	
	//	Add book
	String bookName,authorName;
	int bookId,quantity;
	public boolean addBook() {
		boolean addBook = false;
		bookId = Integer.parseInt(txt_bookId.getText());
		bookName = txt_bookName.getText();
		authorName = txt_authorName.getText();
		quantity = Integer.parseInt(txt_quantity.getText());
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into book_details values('"+bookId+"','"+bookName+"','"+authorName+"','"+quantity+"')";
			PreparedStatement pst = con.prepareStatement(sql);
			
			int rowCount = pst.executeUpdate();
			if(rowCount > 0) {
				JOptionPane.showMessageDialog(this, "Record Inserted SuccessFullt");
				addBook = true;
			}else {
				JOptionPane.showMessageDialog(this, "Record Not Inserted");
			}
		}catch(HeadlessException | SQLException e) {
		}
		return addBook;
	}
	
	//	Clear Table
	public void clearTable() {
		DefaultTableModel model1;
                model1 = (DefaultTableModel) tbl_bookDetails.getModel();
		model1.setRowCount(0);
	}
	
	// Update Book Record
	public boolean updateBook() {
		boolean isUpdate = false;
		bookId = Integer.parseInt(txt_bookId.getText());
		bookName = txt_bookName.getText();
		authorName = txt_authorName.getText();
		quantity = Integer.parseInt(txt_quantity.getText());
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update book_details set book_name = '"+bookName+"',author = '"+authorName+"',quantity='"+quantity+"' where book_id = '"+bookId+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			int rowCount = pst.executeUpdate();
			if(rowCount > 0) {
				isUpdate = true;
				JOptionPane.showMessageDialog(this, "Book Updated...");
			}
			else {
				JOptionPane.showMessageDialog(this, "Book Not Updated...");
			}
		}catch(HeadlessException | SQLException e) {
		}
		return isUpdate;
	}
	
	// Set BookId Already
	public String setBookID() {
		int lastID = 0;
		String lastid = "";
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select book_id from book_details order by book_id desc limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				lastID += rs.getInt("book_id");
			}
			lastID+=1;
			lastid = Integer.toString(lastID);
		}catch(SQLException e) {
		}
		return lastid;
	}
	
	//	Delete Record
	public boolean deleteRecord() {
		boolean isDelete = false;
		bookId = Integer.parseInt(txt_bookId.getText());
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ptst = con.prepareStatement("delete from book_details where book_id = '"+bookId+"'");
			int rowCount = ptst.executeUpdate();
			if(rowCount > 0) {
				isDelete = true;
				JOptionPane.showMessageDialog(this, "Record Deleted Successfully...");
			}
			else {
				JOptionPane.showMessageDialog(this, "Record Not Deleted Somthing want wrong!");
			}
		}catch(HeadlessException | SQLException e) {
		}
		return isDelete;
	}
}
