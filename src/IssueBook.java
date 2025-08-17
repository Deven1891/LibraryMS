

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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import app.bolivia.swing.JCTextField;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.border.MatteBorder;
import rojerusan.RSMaterialButtonCircle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IssueBook extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;
	private final JPanel IssueBook, first_panel, second_panel, third_panel;
	private JCTextField txt_bookId, txt_studentId;
	private JLabel lblBookId, lblBookName, lblAuthor, lblQuantity, lblStudentId, lblStudentName, lblCourseName, lblBranch, lblNoData, lblNoData1;
	private final RSDateChooser date_IssueDate, date_DueDate;
	private final RSMaterialButtonCircle mtrlbtncrclIssueBook;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	int BookId, StudentID;
	public IssueBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		IssueBook = new JPanel();
		IssueBook.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(IssueBook);
		IssueBook.setLayout(null);
		
		first_panel = new JPanel();
		first_panel.setForeground(new Color(2, 43, 84));
		first_panel.setLayout(null);
		first_panel.setBackground(new Color(2, 43, 84));
		first_panel.setBounds(0, 0, 500, 900);
		IssueBook.add(first_panel);
		
		JLabel lbl_BookId = new JLabel("Book ID");
		lbl_BookId.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_BookId.setForeground(Color.WHITE);
		lbl_BookId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_BookId.setAlignmentX(0.5f);
		lbl_BookId.setBounds(30, 300, 149, 27);
		first_panel.add(lbl_BookId);
		
		JLabel lbl_BookName = new JLabel("Book Name");
		lbl_BookName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_BookName.setForeground(Color.WHITE);
		lbl_BookName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_BookName.setAlignmentX(0.5f);
		lbl_BookName.setBounds(30, 400, 149, 27);
		first_panel.add(lbl_BookName);
		
		JLabel lbl_Author = new JLabel("Author");
		lbl_Author.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Author.setForeground(Color.WHITE);
		lbl_Author.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_Author.setAlignmentX(0.5f);
		lbl_Author.setBounds(30, 500, 149, 27);
		first_panel.add(lbl_Author);
		
		JLabel lbl_Quantity = new JLabel("Quantity");
		lbl_Quantity.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Quantity.setForeground(Color.WHITE);
		lbl_Quantity.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_Quantity.setAlignmentX(0.5f);
		lbl_Quantity.setBounds(30, 600, 149, 27);
		first_panel.add(lbl_Quantity);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setIcon(new ImageIcon(IssueBook.class.getResource("/Images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblBookDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookDetails.setForeground(Color.WHITE);
		lblBookDetails.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblBookDetails.setAlignmentX(0.5f);
		lblBookDetails.setBounds(100, 75, 300, 100);
		first_panel.add(lblBookDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(100, 185, 300, 4);
		first_panel.add(panel_2);
		
		lblBookId = new JLabel("");
		lblBookId.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBookId.setAlignmentX(0.5f);
		lblBookId.setBounds(200, 300, 200, 27);
		first_panel.add(lblBookId);
		
		lblBookName = new JLabel("");
		lblBookName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBookName.setAlignmentX(0.5f);
		lblBookName.setBounds(200, 400, 200, 27);
		first_panel.add(lblBookName);
		
		lblAuthor = new JLabel("");
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblAuthor.setAlignmentX(0.5f);
		lblAuthor.setBounds(200, 500, 200, 27);
		first_panel.add(lblAuthor);
		
		lblQuantity = new JLabel("");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblQuantity.setAlignmentX(0.5f);
		lblQuantity.setBounds(200, 600, 200, 27);
		first_panel.add(lblQuantity);
		
		lblNoData = new JLabel("Invalid Data!");
		lblNoData.setVisible(false);
		lblNoData.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoData.setForeground(new Color(220, 233, 56));
		lblNoData.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNoData.setAlignmentX(0.5f);
		lblNoData.setBounds(30, 689, 149, 27);
		first_panel.add(lblNoData);
		
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
		backButton.setForeground(new Color(2, 43, 84));
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(0, 0, 60, 60);
		first_panel.add(backButton);
		
		second_panel = new JPanel();
		second_panel.setLayout(null);
		second_panel.setBackground(new Color(3, 64, 124));
		second_panel.setBounds(510, 0, 500, 900);
		IssueBook.add(second_panel);
		
		JLabel lbl_StudentId = new JLabel("Student ID");
		lbl_StudentId.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentId.setForeground(Color.WHITE);
		lbl_StudentId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentId.setAlignmentX(0.5f);
		lbl_StudentId.setBounds(30, 300, 149, 27);
		second_panel.add(lbl_StudentId);
		
		JLabel lbl_StudentName = new JLabel("Student Name");
		lbl_StudentName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentName.setForeground(Color.WHITE);
		lbl_StudentName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentName.setAlignmentX(0.5f);
		lbl_StudentName.setBounds(30, 400, 149, 27);
		second_panel.add(lbl_StudentName);
		
		JLabel lbl_CourseName = new JLabel("Course Name");
		lbl_CourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CourseName.setForeground(Color.WHITE);
		lbl_CourseName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_CourseName.setAlignmentX(0.5f);
		lbl_CourseName.setBounds(30, 500, 149, 27);
		second_panel.add(lbl_CourseName);
		
		JLabel lbl_Branch = new JLabel("Branch");
		lbl_Branch.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Branch.setForeground(Color.WHITE);
		lbl_Branch.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_Branch.setAlignmentX(0.5f);
		lbl_Branch.setBounds(30, 600, 149, 27);
		second_panel.add(lbl_Branch);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setIcon(new ImageIcon(IssueBook.class.getResource("/Images/AddNewBookIcons/icons8_Student_Registration_100px_2.png")));
		lblStudentDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentDetails.setForeground(Color.WHITE);
		lblStudentDetails.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblStudentDetails.setAlignmentX(0.5f);
		lblStudentDetails.setBounds(75, 75, 325, 100);
		second_panel.add(lblStudentDetails);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(75, 189, 325, 4);
		second_panel.add(panel_2_1);
		
		lblStudentId = new JLabel("");
		lblStudentId.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblStudentId.setAlignmentX(0.5f);
		lblStudentId.setBounds(241, 300, 200, 27);
		second_panel.add(lblStudentId);
		
		lblStudentName = new JLabel("");
		lblStudentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblStudentName.setAlignmentX(0.5f);
		lblStudentName.setBounds(241, 400, 200, 27);
		second_panel.add(lblStudentName);
		
		lblCourseName = new JLabel("");
		lblCourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblCourseName.setAlignmentX(0.5f);
		lblCourseName.setBounds(241, 500, 200, 27);
		second_panel.add(lblCourseName);
		
		lblBranch = new JLabel("");
		lblBranch.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranch.setForeground(Color.WHITE);
		lblBranch.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBranch.setAlignmentX(0.5f);
		lblBranch.setBounds(241, 600, 200, 27);
		second_panel.add(lblBranch);
		
		lblNoData1 = new JLabel("Invalid Data!");
		lblNoData1.setVisible(false);
		lblNoData1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoData1.setForeground(new Color(220, 233, 56));
		lblNoData1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNoData1.setAlignmentX(0.5f);
		lblNoData1.setBounds(30, 689, 149, 27);
		second_panel.add(lblNoData1);
		
		third_panel = new JPanel();
		third_panel.setLayout(null);
		third_panel.setBackground(new Color(255, 255, 255));
		third_panel.setBounds(1010, 0, 590, 900);
		IssueBook.add(third_panel);
		
		JLabel lbl_StudentId_1 = new JLabel("Book ID");
		lbl_StudentId_1.setBackground(new Color(255, 255, 255));
		lbl_StudentId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentId_1.setForeground(new Color(2, 43, 84));
		lbl_StudentId_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentId_1.setAlignmentX(0.5f);
		lbl_StudentId_1.setBounds(30, 300, 149, 32);
		third_panel.add(lbl_StudentId_1);
		
		JLabel lbl_StudentName_1 = new JLabel("Student ID");
		lbl_StudentName_1.setBackground(new Color(255, 255, 255));
		lbl_StudentName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_StudentName_1.setForeground(new Color(2, 43, 84));
		lbl_StudentName_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_StudentName_1.setAlignmentX(0.5f);
		lbl_StudentName_1.setBounds(30, 400, 149, 32);
		third_panel.add(lbl_StudentName_1);
		
		JLabel lbl_CourseName_1 = new JLabel("Issue Date");
		lbl_CourseName_1.setBackground(new Color(255, 255, 255));
		lbl_CourseName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CourseName_1.setForeground(new Color(2, 43, 84));
		lbl_CourseName_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_CourseName_1.setAlignmentX(0.5f);
		lbl_CourseName_1.setBounds(30, 500, 149, 32);
		third_panel.add(lbl_CourseName_1);
		
		JLabel lbl_Branch_1 = new JLabel("Due Date");
		lbl_Branch_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Branch_1.setForeground(new Color(2, 43, 84));
		lbl_Branch_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl_Branch_1.setAlignmentX(0.5f);
		lbl_Branch_1.setBounds(30, 600, 149, 32);
		third_panel.add(lbl_Branch_1);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setIcon(new ImageIcon(IssueBook.class.getResource("/ImagesOfLibrary/book1.png")));
		lblIssueBook.setBackground(new Color(255, 255, 255));
		lblIssueBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueBook.setForeground(new Color(2, 43, 84));
		lblIssueBook.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblIssueBook.setAlignmentX(0.5f);
		lblIssueBook.setBounds(180, 75, 235, 100);
		third_panel.add(lblIssueBook);
		
		JPanel underline_third = new JPanel();
		underline_third.setBackground(new Color(2, 43, 84));
		underline_third.setBounds(125, 189, 340, 4);
		third_panel.add(underline_third);
		
		txt_bookId = new JCTextField();
		txt_bookId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!txt_bookId.getText().equals("")) {
					getBookDetails();
				}else {
					lblBookId.setText("");
					lblBookName.setText("");
					lblAuthor.setText("");
					lblQuantity.setText("");
					lblNoData.setVisible(false);
				}
			}
		});
		txt_bookId.setForeground(new Color(2, 43, 84));
		txt_bookId.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(2, 43, 84)));
		txt_bookId.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_bookId.setPhColor(new Color(2, 43, 84));
		txt_bookId.setPlaceholder("Enter Book ID");
		txt_bookId.setBounds(220, 300, 295, 32);
		third_panel.add(txt_bookId);
		
		txt_studentId = new JCTextField();
		txt_studentId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!txt_studentId.getText().equals("")) {
					getStudentDetails();
				}else {
					lblStudentId.setText("");
					lblStudentName.setText("");
					lblCourseName.setText("");
					lblBranch.setText("");
					lblNoData1.setVisible(false);
				}
			}
		});
		txt_studentId.setForeground(new Color(2, 43, 84));
		txt_studentId.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(2, 43, 84)));
		txt_studentId.setPlaceholder("Enter Student ID");
		txt_studentId.setPhColor(new Color(2, 43, 84));
		txt_studentId.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_studentId.setBounds(215, 400, 300, 32);
		third_panel.add(txt_studentId);
		
		date_IssueDate = new RSDateChooser();
		date_IssueDate.setColorDiaActual(new Color(2, 43, 84));
		date_IssueDate.setForeground(new Color(2, 43, 84));
		date_IssueDate.setColorButtonHover(new Color(2, 43, 84));
		date_IssueDate.setColorForeground(new Color(2, 43, 84));
		date_IssueDate.setColorBackground(new Color(2, 43, 84));
		date_IssueDate.setFuente(new Font("SansSerif", Font.BOLD, 15));
		date_IssueDate.setPlaceholder("Select Issue Date");
		date_IssueDate.setBounds(220, 500, 295, 32);
		third_panel.add(date_IssueDate);
		
		date_DueDate = new RSDateChooser();
		date_DueDate.setColorDiaActual(new Color(2, 43, 84));
		date_DueDate.setForeground(new Color(2, 43, 84));
		date_DueDate.setColorButtonHover(new Color(2, 43, 84));
		date_DueDate.setPlaceholder("Select Due Date");
		date_DueDate.setColorBackground(new Color(2, 43, 84));
		date_DueDate.setColorForeground(new Color(2, 43, 84));
		date_DueDate.setFuente(new Font("SansSerif", Font.BOLD, 15));
		date_DueDate.setBounds(220, 600, 295, 32);
		third_panel.add(date_DueDate);
		
		mtrlbtncrclIssueBook = new RSMaterialButtonCircle();
		mtrlbtncrclIssueBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!lblQuantity.getText().equals("0")) {
					if(isAlreadyIssued() == false) {
						if(issueBook() == true) {
							JOptionPane.showMessageDialog(IssueBook, "Book Issued Successfully...");
							updateIssuedBookCount();
							updateBookCount();
						}else {
							JOptionPane.showMessageDialog(IssueBook, "Book Not Issued, Something want wrong...");
						}
					}else {
						JOptionPane.showMessageDialog(IssueBook, "Book Already Issue To this student..");
					}
				}else {
					JOptionPane.showMessageDialog(IssueBook, "Book is not Available.");
				}
				
				
			}
		});
		mtrlbtncrclIssueBook.setFont(new Font("Dubai Medium", Font.BOLD, 23));
		mtrlbtncrclIssueBook.setText("Issue Book");
		mtrlbtncrclIssueBook.setBackground(new Color(2, 43, 84));
		mtrlbtncrclIssueBook.setBounds(175, 720, 250, 80);
		third_panel.add(mtrlbtncrclIssueBook);
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setBounds(530, 0, 60, 60);
		third_panel.add(mtrlbtncrclX);
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setForeground(new Color(255, 255, 255));
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setBackground(new Color(2, 43, 84));
	}
	// Fetch Book Details from database and display it to BookDetails Panel
	public void getBookDetails(){
		BookId = Integer.parseInt(txt_bookId.getText());
		
		try {
			Connection con = DBConnection.getConnection();
			java.sql.PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = '"+BookId+"'");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				lblBookId.setText(rs.getString("book_id"));
				lblBookName.setText(rs.getString("book_name"));
				lblAuthor.setText(rs.getString("author"));
				lblQuantity.setText(rs.getString("quantity"));
			}else {
				lblNoData.setVisible(true);
			}
		}catch(SQLException e) {
		}
	}
	
	// Fetch Student Details from database and display it to StudentDetails Panel
		public void getStudentDetails(){
			StudentID = Integer.parseInt(txt_studentId.getText());
			
			try {
				Connection con = DBConnection.getConnection();
				java.sql.PreparedStatement pst = con.prepareStatement("select * from student_details where studentId = '"+StudentID+"'");
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					lblStudentId.setText(rs.getString("studentId"));
					lblStudentName.setText(rs.getString("studentName"));
					lblCourseName.setText(rs.getString("course"));
					lblBranch.setText(rs.getString("branch"));
				}else {
					lblNoData1.setVisible(true);
				}
			}catch(SQLException e) {
			}
		}
		
	//Insert issue book details to database
		public boolean issueBook() {
			boolean isIssued =false;
			
			BookId = Integer.parseInt(txt_bookId.getText());
			StudentID = Integer.parseInt(txt_studentId.getText());
			String bookName = lblBookName.getText();
			String studentName = lblStudentName.getText();
			
			java.util.Date issueDate = date_IssueDate.getDatoFecha();
			java.util.Date dueDate = date_DueDate.getDatoFecha();
			
			long l1 = issueDate.getTime();
			long l2 = dueDate.getTime();
			
			Date sqlIssueDate = new Date(l1);
			Date sqlDueDate = new Date(l2);
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "insert into issuebookdetails(book_Id, book_Name, student_Id, student_Name, issue_Date, due_Date, status) "
								+ "values('"+BookId+"','"+bookName+"','"+StudentID+"','"+studentName+"','"+sqlIssueDate+"','"+sqlDueDate+"','pending')";
				java.sql.PreparedStatement pst = con.prepareStatement(sql);
				
				int rowCount = pst.executeUpdate();
                                isIssued = rowCount > 0;
			}catch(SQLException e) {
			}
			return isIssued;
			
		}
		
	// Update the count of Book after issue
		public void updateBookCount() {
			BookId = Integer.parseInt(txt_bookId.getText());
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "update book_details set quantity = quantity - 1 where  book_id = '"+BookId+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				int rowCount = pst.executeUpdate();
				if(rowCount > 0) {
					int initCount = Integer.parseInt(lblQuantity.getText()) - 1;
					lblQuantity.setText(Integer.toString(initCount));
				}
			}catch(NumberFormatException | SQLException e) {
			}
		}
		
		// Update total book issued by the student
				public void updateIssuedBookCount() {
					StudentID = Integer.parseInt(txt_studentId.getText());
					
					try {
						Connection con = DBConnection.getConnection();
						String sql = "update student_details set total_issued_book = total_issued_book + 1 where  studentId = '"+StudentID+"'";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.executeUpdate();
					}catch(SQLException e) {
					}
				}
		
		//Checking whether the book is already assign or not
		public boolean isAlreadyIssued() {
			boolean isalreadyIssued = false;
			BookId = Integer.parseInt(txt_bookId.getText());
			StudentID = Integer.parseInt(txt_studentId.getText());
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "select * from issuebookdetails where book_Id = '"+BookId+"' and student_Id = '"+StudentID+"' and status = 'pending'";
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
                                isalreadyIssued = rs.next();
			}catch(SQLException e) {
			}
			return isalreadyIssued;
		}
}
