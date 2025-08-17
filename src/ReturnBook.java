

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import app.bolivia.swing.JCTextField;
import java.awt.HeadlessException;
import javax.swing.border.MatteBorder;
import rojerusan.RSMaterialButtonCircle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class ReturnBook extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;
	private final JPanel IssueBook, first_panel, third_panel;
	private final JCTextField txt_bookId, txt_studentId;
	private final JLabel lblIssueId, lblBookName, lblStudentName, lblIssueDate, lblDueDate, lbl_error;
	private final RSMaterialButtonCircle mtrlbtncrclIssueBook;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

        int BookId;
	public ReturnBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		IssueBook = new JPanel();
		IssueBook.setBackground(new Color(255, 255, 255));
		IssueBook.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(IssueBook);
		IssueBook.setLayout(null);
		
		first_panel = new JPanel();
		first_panel.setLayout(null);
		first_panel.setBackground(new Color(2, 43, 84));
		first_panel.setBounds(600, 0, 500, 900);
		IssueBook.add(first_panel);
		
		JLabel lbl_IssueId = new JLabel("Issue ID");
		lbl_IssueId.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_IssueId.setForeground(Color.WHITE);
		lbl_IssueId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_IssueId.setAlignmentX(0.5f);
		lbl_IssueId.setBounds(30, 300, 149, 27);
		first_panel.add(lbl_IssueId);
		
		JLabel lbl_BookName = new JLabel("Book Name");
		lbl_BookName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_BookName.setForeground(Color.WHITE);
		lbl_BookName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_BookName.setAlignmentX(0.5f);
		lbl_BookName.setBounds(30, 400, 149, 27);
		first_panel.add(lbl_BookName);
		
		JLabel lbl_StudentName = new JLabel("Student Name");
		lbl_StudentName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentName.setForeground(Color.WHITE);
		lbl_StudentName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentName.setAlignmentX(0.5f);
		lbl_StudentName.setBounds(30, 500, 149, 27);
		first_panel.add(lbl_StudentName);
		
		JLabel lbl_IssueDate = new JLabel("Issue Date");
		lbl_IssueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_IssueDate.setForeground(Color.WHITE);
		lbl_IssueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_IssueDate.setAlignmentX(0.5f);
		lbl_IssueDate.setBounds(30, 600, 149, 27);
		first_panel.add(lbl_IssueDate);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setIcon(new ImageIcon(ReturnBook.class.getResource("/Images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblBookDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookDetails.setForeground(Color.WHITE);
		lblBookDetails.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblBookDetails.setAlignmentX(0.5f);
		lblBookDetails.setBounds(100, 75, 300, 100);
		first_panel.add(lblBookDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(100, 185, 300, 4);
		first_panel.add(panel_2);
		
		lblIssueId = new JLabel("");
		lblIssueId.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueId.setForeground(Color.WHITE);
		lblIssueId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblIssueId.setAlignmentX(0.5f);
		lblIssueId.setBounds(200, 300, 200, 27);
		first_panel.add(lblIssueId);
		
		lblBookName = new JLabel("");
		lblBookName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBookName.setAlignmentX(0.5f);
		lblBookName.setBounds(200, 400, 200, 27);
		first_panel.add(lblBookName);
		
		lblStudentName = new JLabel("");
		lblStudentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblStudentName.setAlignmentX(0.5f);
		lblStudentName.setBounds(200, 500, 200, 27);
		first_panel.add(lblStudentName);
		
		lblIssueDate = new JLabel("");
		lblIssueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueDate.setForeground(Color.WHITE);
		lblIssueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblIssueDate.setAlignmentX(0.5f);
		lblIssueDate.setBounds(200, 600, 200, 27);
		first_panel.add(lblIssueDate);
		
		JLabel lbl_DueDate = new JLabel("Due Date");
		lbl_DueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DueDate.setForeground(Color.WHITE);
		lbl_DueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_DueDate.setAlignmentX(0.5f);
		lbl_DueDate.setBounds(30, 700, 149, 27);
		first_panel.add(lbl_DueDate);
		
		lblDueDate = new JLabel("");
		lblDueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDueDate.setForeground(Color.WHITE);
		lblDueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDueDate.setAlignmentX(0.5f);
		lblDueDate.setBounds(200, 700, 200, 27);
		first_panel.add(lblDueDate);
		
		lbl_error = new JLabel("Data Not Present!");
		lbl_error.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_error.setForeground(new Color(255, 255, 0));
		lbl_error.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_error.setAlignmentX(0.5f);
		lbl_error.setBounds(30, 777, 189, 27);
		lbl_error.setVisible(false);
		first_panel.add(lbl_error);
		
		third_panel = new JPanel();
		third_panel.setLayout(null);
		third_panel.setBackground(new Color(255, 255, 255));
		third_panel.setBounds(1100, 0, 500, 900);
		IssueBook.add(third_panel);
		
		JLabel lbl_StudentId_1 = new JLabel("Book ID");
		lbl_StudentId_1.setBackground(new Color(255, 255, 255));
		lbl_StudentId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentId_1.setForeground(new Color(2, 43, 84));
		lbl_StudentId_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentId_1.setAlignmentX(0.5f);
		lbl_StudentId_1.setBounds(30, 300, 150, 32);
		third_panel.add(lbl_StudentId_1);
		
		JLabel lbl_StudentName_1 = new JLabel("Student ID");
		lbl_StudentName_1.setBackground(new Color(255, 255, 255));
		lbl_StudentName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentName_1.setForeground(new Color(2, 43, 84));
		lbl_StudentName_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentName_1.setAlignmentX(0.5f);
		lbl_StudentName_1.setBounds(30, 400, 150, 32);
		third_panel.add(lbl_StudentName_1);
		
		JLabel lblIssueBook = new JLabel("Return Book");
		lblIssueBook.setIcon(new ImageIcon(ReturnBook.class.getResource("/ImagesOfLibrary/book6.png")));
		lblIssueBook.setBackground(new Color(255, 255, 255));
		lblIssueBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueBook.setForeground(new Color(2, 43, 84));
		lblIssueBook.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblIssueBook.setAlignmentX(0.5f);
		lblIssueBook.setBounds(120, 75, 250, 100);
		third_panel.add(lblIssueBook);
		
		JPanel underline_third = new JPanel();
		underline_third.setBackground(new Color(2, 43, 84));
		underline_third.setBounds(80, 189, 340, 4);
		third_panel.add(underline_third);
		
		JPanel closeWindow = new JPanel();
		closeWindow.setLayout(null);
		closeWindow.setBackground(new Color(255, 0, 0));
		closeWindow.setBounds(540, 0, 50, 42);
		third_panel.add(closeWindow);
		
		JLabel lblX = new JLabel("  X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Verdana", Font.BOLD, 30));
		lblX.setBounds(0, 0, 50, 40);
		closeWindow.add(lblX);
		
		txt_bookId = new JCTextField();
		txt_bookId.setForeground(new Color(2, 43, 84));
		txt_bookId.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(2, 43, 84)));
		txt_bookId.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_bookId.setPhColor(new Color(2, 43, 84));
		txt_bookId.setPlaceholder("Enter Book ID");
		txt_bookId.setBounds(170, 300, 300, 32);
		third_panel.add(txt_bookId);
		
		txt_studentId = new JCTextField();
		txt_studentId.setForeground(new Color(2, 43, 84));
		txt_studentId.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(2, 43, 84)));
		txt_studentId.setPlaceholder("Enter Student ID");
		txt_studentId.setPhColor(new Color(2, 43, 84));
		txt_studentId.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_studentId.setBounds(170, 400, 300, 32);
		third_panel.add(txt_studentId);
		
		mtrlbtncrclIssueBook = new RSMaterialButtonCircle();
		mtrlbtncrclIssueBook.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(returnBook()) {
					updateBookCount();
				}
			}
		});
		mtrlbtncrclIssueBook.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		mtrlbtncrclIssueBook.setText("Return Book");
		mtrlbtncrclIssueBook.setBackground(new Color(2, 43, 84));
		mtrlbtncrclIssueBook.setBounds(125, 720, 250, 80);
		third_panel.add(mtrlbtncrclIssueBook);
		
		RSMaterialButtonCircle mtrlbtncrclFind = new RSMaterialButtonCircle();
		mtrlbtncrclFind.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				getIssueBookDetails();
			}
		});
		mtrlbtncrclFind.setText("FIND");
		mtrlbtncrclFind.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		mtrlbtncrclFind.setBackground(new Color(3, 70, 137));
		mtrlbtncrclFind.setBounds(125, 583, 250, 80);
		third_panel.add(mtrlbtncrclFind);
		
		RSMaterialButtonCircle mtrlbtncrclX_1 = new RSMaterialButtonCircle();
		mtrlbtncrclX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX_1.setText("X");
		mtrlbtncrclX_1.setForeground(Color.WHITE);
		mtrlbtncrclX_1.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX_1.setBackground(new Color(2, 43, 84));
		mtrlbtncrclX_1.setBounds(440, 0, 60, 60);
		third_panel.add(mtrlbtncrclX_1);
		
		JLabel lbl_image = new JLabel("");
		lbl_image.setIcon(new ImageIcon(ReturnBook.class.getResource("/Images/icons/library-2.png")));
		lbl_image.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_image.setForeground(Color.WHITE);
		lbl_image.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_image.setAlignmentX(0.5f);
		lbl_image.setBounds(0, 179, 600, 488);
		IssueBook.add(lbl_image);
		
		RSMaterialButtonCircle backButton = new RSMaterialButtonCircle();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deshboard home = new deshboard();
				home.setVisible(true);
				dispose();
			}
		});
		backButton.setText("<");
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(new Color(2, 43, 84));
		backButton.setBounds(0, 0, 60, 60);
		IssueBook.add(backButton);
	}
				
	//Fetch Book Details from the Database and display it to panel
	public void getIssueBookDetails() {
		int bookId = Integer.parseInt(txt_bookId.getText());
		int studentID = Integer.parseInt(txt_studentId.getText());
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from issuebookdetails where book_Id = '"+bookId+"' and student_Id = '"+studentID+"' and status = 'pending'";
			PreparedStatement pst = con.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				lblIssueId.setText(rs.getString("ID"));
				lblBookName.setText(rs.getString("book_Name"));
				lblStudentName.setText(rs.getString("student_Name"));
				lblIssueDate.setText(rs.getString("issue_Date"));
				lblDueDate.setText(rs.getString("due_Date"));
				lbl_error.setVisible(false);
			}else {
				lblIssueId.setText("");
				lblBookName.setText("");
				lblStudentName.setText("");
				lblIssueDate.setText("");
				lblDueDate.setText("");
				lbl_error.setVisible(true);
			}
		}catch(SQLException e) {
		}
	}
	
	// Return the book
	public boolean returnBook() {
		boolean isReturn = false;
		int bookId = Integer.parseInt(txt_bookId.getText());
		int studentId = Integer.parseInt(txt_studentId.getText());
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update issuebookdetails set status = 'return' where book_Id = '"+bookId+"' and student_Id = '"+studentId+"'  and status = 'pending'";
			PreparedStatement pst = con.prepareStatement(sql);
			int rowCount = pst.executeUpdate();
			if(rowCount > 0) {
				JOptionPane.showMessageDialog(this, "Book Returnd successfully..");
				isReturn = true;
			}else {
				JOptionPane.showMessageDialog(this, "Book Not Returnd...");
				isReturn = false;
			}
		}catch(HeadlessException | SQLException e) {
		}
		return isReturn;
	}
	
	// Update the count of Book after issue
		public void updateBookCount() {
			BookId = Integer.parseInt(txt_bookId.getText());
			int studentId = Integer.parseInt(txt_studentId.getText());
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "update book_details set quantity = quantity + 1 where  book_id = '"+BookId+"'";
				String sql1 = "update student_details set total_issued_book = total_issued_book - 1 where studentId = '"+studentId+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				int rowCount = pst.executeUpdate();
				if(rowCount > 0) {}
				PreparedStatement pst1 = con.prepareStatement(sql1);
				int rowCount1 = pst1.executeUpdate();
				if(rowCount1 > 0) {}
			}catch(SQLException e) {
			}
		}
}