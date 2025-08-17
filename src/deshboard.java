import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.Component;
import rojeru_san.complementos.RSTableMetro;
import rojerusan.RSMaterialButtonCircle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import rojerusan.RSButtonMetro;

public final class deshboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private RSTableMetro bookDetailsTable, studentDetailsTable;
	private JLabel lblBookCard, lblStudentCard, lblIssueBookCard, lblDefaulterCard, lblAdminName;
	private JPanel superpanel;
	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					deshboard frame = new deshboard();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Color mouseEnterBackColor = new Color(255,255,255);
	Color mouseEnterLabelColor = new Color(2, 43, 84);

	Color mouseExitBackColor = new Color(2, 43, 84);
	Color mouseExitLabelColor = new Color(255,255,255);
	DefaultTableModel model;

	public deshboard() {		
		setBackground(new Color(102, 102, 102));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelhead = new JPanel();
		panelhead.setBounds(0, 0, 1600, 70);
		panelhead.setBackground(new Color(2, 43, 84));
		contentPane.add(panelhead);
		panelhead.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_menu.png")));
		lblNewLabel_1.setBounds(10, 17, 30, 33);
		panelhead.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Maharaja Sayaji Raav Central Library");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(66, 22, 470, 33);
		panelhead.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(48, 14, 5, 40);
		panelhead.add(panel);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome,");
		lblWelcomeAdmin.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/male_user_50px.png")));
		lblWelcomeAdmin.setForeground(Color.WHITE);
		lblWelcomeAdmin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblWelcomeAdmin.setBounds(1200, 9, 144, 51);
		panelhead.add(lblWelcomeAdmin);
		
		RSMaterialButtonCircle windowExit = new RSMaterialButtonCircle();
		windowExit.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		windowExit.setText("X");
		windowExit.setForeground(new Color(2, 43, 84));
		windowExit.setFont(new Font("Dialog", Font.BOLD, 35));
		windowExit.setBackground(Color.WHITE);
		windowExit.setBounds(1540, 5, 60, 60);
		panelhead.add(windowExit);
		
		lblAdminName = new JLabel();
		lblAdminName.setText(Loginpage.Name);
		lblAdminName.setForeground(Color.WHITE);
		lblAdminName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblAdminName.setBounds(1346, 9, 144, 51);
		panelhead.add(lblAdminName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(2, 43, 84));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(0, 70, 340, 830);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel home_page = new JPanel();
		home_page.setBackground(new Color(2, 43, 84));
		home_page.setBounds(0, 60, 340, 60);
		panel_1.add(home_page);
		home_page.setLayout(null);
		
		JLabel lblhomepage = new JLabel("  Home Page");
		lblhomepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				home_page.setBackground(mouseEnterBackColor);
				lblhomepage.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				home_page.setBackground(mouseExitBackColor);
				lblhomepage.setForeground(mouseExitLabelColor);
			}
		});
		lblhomepage.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/home_24px.png")));
		lblhomepage.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblhomepage.setForeground(new Color(255, 255, 255));
		lblhomepage.setBounds(50, 16, 152, 27);
		home_page.add(lblhomepage);
		
		JPanel deshboard = new JPanel();
		deshboard.setBorder(null);
		deshboard.setLayout(null);
		deshboard.setBackground(new Color(2, 43, 84));
		deshboard.setBounds(-1, 120, 340, 60);
		panel_1.add(deshboard);
		
		JLabel lbldashboard = new JLabel("  Dashboard");
		lbldashboard.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Library_26px_1.png")));
		lbldashboard.setForeground(Color.WHITE);
		lbldashboard.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lbldashboard.setBounds(52, 22, 144, 27);
		deshboard.add(lbldashboard);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Features");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(10, 202, 83, 27);
		panel_1.add(lblNewLabel_2_1_1);
		
		JPanel manage_books = new JPanel();
		manage_books.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manage_Books bk = new Manage_Books();
				bk.setVisible(true);
				dispose();
			}
		});
		manage_books.setBorder(null);
		manage_books.setLayout(null);
		manage_books.setBackground(new Color(2, 43, 84));
		manage_books.setBounds(0, 248, 340, 60);
		panel_1.add(manage_books);
		
		JLabel lblmanagebooks = new JLabel("  Manage Books");
		lblmanagebooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				manage_books.setBackground(new Color(255,255,255));
				lblmanagebooks.setForeground(new Color(2, 43, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				manage_books.setBackground(new Color(2, 43, 84));
				lblmanagebooks.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Manage_Books mb = new Manage_Books();
				mb.setVisible(true);
				dispose();
			}
		});
		lblmanagebooks.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Book_26px.png")));
		lblmanagebooks.setForeground(Color.WHITE);
		lblmanagebooks.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblmanagebooks.setBounds(52, 22, 172, 27);
		manage_books.add(lblmanagebooks);
		
		JPanel manage_student = new JPanel();
		manage_student.setLayout(null);
		manage_student.setBorder(null);
		manage_student.setBackground(new Color(2, 43, 84));
		manage_student.setBounds(0, 306, 340, 60);
		panel_1.add(manage_student);
		
		JLabel lblmanagestudents = new JLabel("  Manage Students");
		lblmanagestudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				manage_student.setBackground(mouseEnterBackColor);
				lblmanagestudents.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				manage_student.setBackground(mouseExitBackColor);
				lblmanagestudents.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Manage_Students manageStudent = new Manage_Students();
				manageStudent.setVisible(true);
				dispose();
			}
		});
		lblmanagestudents.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Read_Online_26px.png")));
		lblmanagestudents.setForeground(Color.WHITE);
		lblmanagestudents.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblmanagestudents.setBounds(52, 22, 194, 27);
		manage_student.add(lblmanagestudents);
		
		JPanel issue_book = new JPanel();
		issue_book.setLayout(null);
		issue_book.setBorder(null);
		issue_book.setBackground(new Color(2, 43, 84));
		issue_book.setBounds(0, 364, 340, 60);
		panel_1.add(issue_book);
		
		JLabel lblissuebook = new JLabel("  Issue Book");
		lblissuebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				issue_book.setBackground(mouseEnterBackColor);
				lblissuebook.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				issue_book.setBackground(mouseExitBackColor);
				lblissuebook.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				IssueBook issueBook = new IssueBook();
				issueBook.setVisible(true);
				dispose();
			}
		});
		lblissuebook.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Sell_26px.png")));
		lblissuebook.setForeground(Color.WHITE);
		lblissuebook.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblissuebook.setBounds(52, 22, 194, 27);
		issue_book.add(lblissuebook);
		
		JPanel return_book = new JPanel();
		return_book.setLayout(null);
		return_book.setBorder(null);
		return_book.setBackground(new Color(2, 43, 84));
		return_book.setBounds(0, 423, 340, 60);
		panel_1.add(return_book);
		
		JLabel lblreturnbook = new JLabel("  Return Book");
		lblreturnbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				return_book.setBackground(mouseEnterBackColor);
				lblreturnbook.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_book.setBackground(mouseExitBackColor);
				lblreturnbook.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReturnBook returnbk = new ReturnBook();
				returnbk.setVisible(true);
				dispose();
			}
		});
		lblreturnbook.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Return_Purchase_26px.png")));
		lblreturnbook.setForeground(Color.WHITE);
		lblreturnbook.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblreturnbook.setBounds(52, 22, 172, 27);
		return_book.add(lblreturnbook);
		
		JPanel view_record = new JPanel();
		view_record.setLayout(null);
		view_record.setBorder(null);
		view_record.setBackground(new Color(2, 43, 84));
		view_record.setBounds(0, 481, 340, 60);
		panel_1.add(view_record);
		
		JLabel lblviewrecords = new JLabel("  View Records");
		lblviewrecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				view_record.setBackground(mouseEnterBackColor);
				lblviewrecords.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				view_record.setBackground(mouseExitBackColor);
				lblviewrecords.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				IssuedBookDetails  var = new IssuedBookDetails();
				var.setVisible(true);
				dispose();
			}
		});
		lblviewrecords.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_View_Details_26px.png")));
		lblviewrecords.setForeground(Color.WHITE);
		lblviewrecords.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblviewrecords.setBounds(52, 22, 194, 27);
		view_record.add(lblviewrecords);
		
		JPanel viewIssuedBooks = new JPanel();
		viewIssuedBooks.setLayout(null);
		viewIssuedBooks.setBorder(null);
		viewIssuedBooks.setBackground(new Color(2, 43, 84));
		viewIssuedBooks.setBounds(0, 539, 340, 60);
		panel_1.add(viewIssuedBooks);
		
		JLabel lblviewissuedbooks = new JLabel("  View Issued Books");
		lblviewissuedbooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				viewIssuedBooks.setBackground(mouseEnterBackColor);
				lblviewissuedbooks.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				viewIssuedBooks.setBackground(mouseExitBackColor);
				lblviewissuedbooks.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				IssuedBookList ibl = new IssuedBookList();
				ibl.setVisible(true);
				dispose();
			}
		});
		lblviewissuedbooks.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Books_26px.png")));
		lblviewissuedbooks.setForeground(Color.WHITE);
		lblviewissuedbooks.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblviewissuedbooks.setBounds(52, 22, 194, 27);
		viewIssuedBooks.add(lblviewissuedbooks);
		
		JPanel default_list = new JPanel();
		default_list.setLayout(null);
		default_list.setBorder(null);
		default_list.setBackground(new Color(2, 43, 84));
		default_list.setBounds(0, 598, 340, 60);
		panel_1.add(default_list);
		
		JLabel lbldefaultlist = new JLabel("  Default List");
		lbldefaultlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				default_list.setBackground(mouseEnterBackColor);
				lbldefaultlist.setForeground(mouseEnterLabelColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				default_list.setBackground(mouseExitBackColor);
				lbldefaultlist.setForeground(mouseExitLabelColor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaulterList dl = new DefaulterList();
				dl.setVisible(true);
				dispose();
			}
		});
		lbldefaultlist.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Conference_26px.png")));
		lbldefaultlist.setForeground(Color.WHITE);
		lbldefaultlist.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lbldefaultlist.setBounds(52, 22, 172, 27);
		default_list.add(lbldefaultlist);
		
		JPanel logout = new JPanel();
		logout.setLayout(null);
		logout.setBorder(null);
		logout.setBackground(new Color(2, 43, 84));
		logout.setBounds(0, 656, 340, 60);
		panel_1.add(logout);
		
		JLabel lbllogout = new JLabel("  Logout");
		lbllogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Loginpage login = new Loginpage();
				login.setVisible(true);
				dispose();
			}
		});
		lbllogout.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbllogout.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Exit_26px_2.png")));
		lbllogout.setForeground(Color.WHITE);
		lbllogout.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lbllogout.setBounds(52, 11, 278, 38);
		logout.add(lbllogout);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(339, 70, 1260, 830);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(2, 43, 84));
		panel_4.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 0, 0)));
		panel_4.setBounds(35, 65, 260, 140);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblBookCardImage = new JLabel("  10");
		lblBookCardImage.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Book_Shelf_50px.png")));
		lblBookCardImage.setForeground(new Color(255, 255, 255));
		lblBookCardImage.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblBookCardImage.setBounds(150, 55, 50, 50);
		panel_4.add(lblBookCardImage);
		
		lblBookCard = new JLabel("0");
		lblBookCard.setForeground(Color.WHITE);
		lblBookCard.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblBookCard.setBounds(10, 55, 100, 44);
		panel_4.add(lblBookCard);
		
		JLabel lblNewLabel_3 = new JLabel("No of Books");
		lblNewLabel_3.setForeground(new Color(2, 43, 84));
		lblNewLabel_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3.setBounds(35, 30, 146, 24);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("No of Students");
		lblNewLabel_3_2.setForeground(new Color(2, 43, 84));
		lblNewLabel_3_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(353, 30, 146, 24);
		panel_3.add(lblNewLabel_3_2);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 51, 204)));
		panel_4_1.setBackground(new Color(2, 43, 84));
		panel_4_1.setBounds(353, 65, 260, 140);
		panel_3.add(panel_4_1);
		
		JLabel lblStudentCardImage = new JLabel("  10");
		lblStudentCardImage.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_People_50px.png")));
		lblStudentCardImage.setForeground(new Color(255, 255, 255));
		lblStudentCardImage.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblStudentCardImage.setBounds(150, 55, 50, 50);
		panel_4_1.add(lblStudentCardImage);
		
		lblStudentCard = new JLabel("0");
		lblStudentCard.setForeground(Color.WHITE);
		lblStudentCard.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblStudentCard.setBounds(10, 50, 100, 44);
		panel_4_1.add(lblStudentCard);
		
		JLabel lblNewLabel_3_3 = new JLabel("Issued Books");
		lblNewLabel_3_3.setForeground(new Color(2, 43, 84));
		lblNewLabel_3_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(668, 30, 146, 24);
		panel_3.add(lblNewLabel_3_3);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 0, 0)));
		panel_4_2.setBackground(new Color(2, 43, 84));
		panel_4_2.setBounds(668, 65, 260, 140);
		panel_3.add(panel_4_2);
		
		JLabel lblIssueBookCardImage = new JLabel("  10");
		lblIssueBookCardImage.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_Sell_50px.png")));
		lblIssueBookCardImage.setForeground(new Color(255, 255, 255));
		lblIssueBookCardImage.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblIssueBookCardImage.setBounds(150, 55, 50, 50);
		panel_4_2.add(lblIssueBookCardImage);
		
		lblIssueBookCard = new JLabel("0");
		lblIssueBookCard.setForeground(Color.WHITE);
		lblIssueBookCard.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblIssueBookCard.setBounds(10, 55, 100, 44);
		panel_4_2.add(lblIssueBookCard);
		
		JLabel lblNewLabel_3_4 = new JLabel("Defaulter List");
		lblNewLabel_3_4.setForeground(new Color(2, 43, 84));
		lblNewLabel_3_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_3_4.setBounds(979, 30, 146, 24);
		panel_3.add(lblNewLabel_3_4);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 51, 204)));
		panel_4_3.setBackground(new Color(2, 43, 84));
		panel_4_3.setBounds(979, 65, 260, 140);
		panel_3.add(panel_4_3);
		
		JLabel lblDefaulterCardImage = new JLabel("  10");
		lblDefaulterCardImage.setIcon(new ImageIcon(deshboard.class.getResource("/Images/adminIcons/icons8_List_of_Thumbnails_50px.png")));
		lblDefaulterCardImage.setForeground(new Color(255, 255, 255));
		lblDefaulterCardImage.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblDefaulterCardImage.setBounds(135, 55, 50, 50);
		panel_4_3.add(lblDefaulterCardImage);
		
		lblDefaulterCard = new JLabel("0");
		lblDefaulterCard.setForeground(Color.WHITE);
		lblDefaulterCard.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblDefaulterCard.setBounds(10, 51, 100, 44);
		panel_4_3.add(lblDefaulterCard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 253, 953, 250);
		panel_3.add(scrollPane);
		
		studentDetailsTable = new RSTableMetro();
		studentDetailsTable.setColorSelBackgound(new Color(2, 43, 84));
		studentDetailsTable.setColorBackgoundHead(new Color(2, 43, 84));
		studentDetailsTable.setAltoHead(30);
		studentDetailsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Student Name", "Course", "Branch", "TotalBookIssued"
			}
		));
		scrollPane.setViewportView(studentDetailsTable);
		studentDetailsTable.setRowMargin(0);
		studentDetailsTable.setRowHeight(40);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 550, 953, 250);
		panel_3.add(scrollPane_1);
		
		bookDetailsTable = new RSTableMetro();
		bookDetailsTable.setColorBackgoundHead(new Color(2, 43, 84));
		bookDetailsTable.setColorSelBackgound(new Color(2, 43, 84));
		bookDetailsTable.setRowMargin(0);
		bookDetailsTable.setRowHeight(40);
		bookDetailsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Book Name", "Author", "Quantity"
			}
		));
		bookDetailsTable.setAltoHead(30);
		scrollPane_1.setViewportView(bookDetailsTable);
		
		superpanel = new JPanel();
		superpanel.setVisible(false);
		superpanel.setBounds(1036, 253, 200, 399);
		panel_3.add(superpanel);
		superpanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("For SuperAdmin");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(2, 43, 84)));
		lblNewLabel_2.setForeground(new Color(2, 43, 84));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(10, 23, 164, 41);
		superpanel.add(lblNewLabel_2);
		
		RSButtonMetro buttonMetro = new RSButtonMetro();
		buttonMetro.setBackground(new Color(255, 255, 255));
		buttonMetro.setIcon(new ImageIcon(deshboard.class.getResource("/ImagesOfLibrary/icons8-delete-100-2.png")));
		buttonMetro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDelete usdel = new userDelete();
				usdel.setVisible(true);
				dispose();
			}
		});
		buttonMetro.setBounds(135, 80, 50, 50);
		superpanel.add(buttonMetro);
		
		JLabel lblNewLabel_4 = new JLabel("UserDelete");
		lblNewLabel_4.setForeground(new Color(2, 43, 84));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 88, 104, 31);
		superpanel.add(lblNewLabel_4);
		
		RSButtonMetro buttonMetro_1 = new RSButtonMetro();
		buttonMetro_1.setIcon(new ImageIcon(deshboard.class.getResource("/ImagesOfLibrary/icons8-delete-100-2.png")));
		buttonMetro_1.setBackground(new Color(255, 255, 255));
		buttonMetro_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeletedRecords delRcd = new DeletedRecords();
				delRcd.setVisible(true);
				dispose(); 
			}
		});
		buttonMetro_1.setBounds(135, 175, 50, 50);
		superpanel.add(buttonMetro_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("DeletedRecords");
		lblNewLabel_4_1.setForeground(new Color(2, 43, 84));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(10, 176, 127, 50);
		superpanel.add(lblNewLabel_4_1);
		
		checkSuperUser();
		setStudentDetailsToTable();
		setBookDetailsToTable();
		setDataToCard();
	}
	
	

	
	//Set Issued Book Details To Table
	public void setStudentDetailsToTable() {		
		try {
				Connection con = DBConnection.getConnection();
				String sql = "select * from student_details";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
						
				while(rs.next()) {
					String studentId = rs.getString("studentId");
					String studentName = rs.getString("studentName");
					String course = rs.getString("course");
					String branch = rs.getString("branch");
					String total_issued_book = rs.getString("total_issued_book");
						
					Object[] obj = {studentId,studentName,course,branch,total_issued_book};
					model = (DefaultTableModel) studentDetailsTable.getModel();
					model.addRow(obj);
				}
			}catch(SQLException e) {
			}
	}
	
	// Set Book Details to table
	public void setBookDetailsToTable() {		
		try {
				Connection con = DBConnection.getConnection();
				String sql = "select * from book_details";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
						
				while(rs.next()) {
					String bookId = rs.getString("book_id");
					String bookName = rs.getString("book_name");
					String author = rs.getString("author");
					String quantity = rs.getString("quantity");
						
					Object[] obj = {bookId,bookName,author,quantity};
					model = (DefaultTableModel) bookDetailsTable.getModel();
					model.addRow(obj);
				}
			}catch(SQLException e) {
			}
	}
	
	// set value to card
	public void setDataToCard() {
		
		long l1 = System.currentTimeMillis();
		Date todayDate = new Date(l1);
		
		Statement st;
		ResultSet rs;
		try {
			Connection con = DBConnection.getConnection();
			st = con.createStatement();
			
			//get Book Count
			rs = st.executeQuery("select * from book_details");
			rs.last();
			lblBookCard.setText(Integer.toString(rs.getRow()));
			
			//get Student Count
			rs = st.executeQuery("select * from student_details");
			rs.last();
			lblStudentCard.setText(Integer.toString(rs.getRow()));
			
			//get Issue Book Count
			rs = st.executeQuery("select * from issuebookdetails where status = 'pending'");
			rs.last();
			lblIssueBookCard.setText(Integer.toString(rs.getRow()));
			
			//get Defaulter List Count
			rs = st.executeQuery("select * from issuebookdetails where due_Date < '"+todayDate+"' and status = 'pending' ");
			rs.last();
			lblDefaulterCard.setText(Integer.toString(rs.getRow()));
		}catch(SQLException e) {
		}
	}
	
	//check the user has a super or not
	public boolean checkSuperUser() {
		
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin_ms where usrName='"+Loginpage.Name+"' and superUser='super'");
			if(rs.next()) {
				superpanel.setVisible(true);
				return true;
			}
			else {
				superpanel.setVisible(false);
				return false;
			}
		}catch(Exception e) {}
		
		return false;
	}
	
}
