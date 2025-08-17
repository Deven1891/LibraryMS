

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import rojeru_san.complementos.RSTableMetro;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSMaterialButtonCircle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class IssuedBookList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final RSTableMetro tbl_IssueBookList;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		IssuedBookList frame = new IssuedBookList();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	DefaultTableModel model;
	public IssuedBookList() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 125, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel issuebooklist = new JPanel();
		issuebooklist.setBackground(new Color(255, 255, 255));
		issuebooklist.setBounds(0, 0, 1300, 650);
		contentPane.add(issuebooklist);
		issuebooklist.setLayout(null);
		
		JLabel lblIssueBookList = new JLabel("Issue Book List");
		lblIssueBookList.setIcon(new ImageIcon(IssuedBookList.class.getResource("/ImagesOfLibrary/book.png")));
		lblIssueBookList.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueBookList.setForeground(new Color(2, 43, 84));
		lblIssueBookList.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblIssueBookList.setBackground(Color.WHITE);
		lblIssueBookList.setAlignmentX(0.5f);
		lblIssueBookList.setBounds(540, 40, 300, 70);
		issuebooklist.add(lblIssueBookList);
		
		JPanel underline_third = new JPanel();
		underline_third.setBackground(new Color(2, 43, 84));
		underline_third.setBounds(515, 120, 340, 4);
		issuebooklist.add(underline_third);
		
		JScrollPane tbl_issuedBookList = new JScrollPane();
		tbl_issuedBookList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbl_issuedBookList.setBounds(50, 204, 1200, 400);
		issuebooklist.add(tbl_issuedBookList);
		
		tbl_IssueBookList = new RSTableMetro();
		tbl_IssueBookList.setColorFilasBackgound2(new Color(255, 255, 255));
		tbl_IssueBookList.setAltoHead(40);
		tbl_IssueBookList.setColorBordeHead(new Color(255, 255, 255));
		tbl_IssueBookList.setColorBordeFilas(new Color(226, 226, 226));
		tbl_IssueBookList.setColorSelBackgound(new Color(3, 70, 137));
		tbl_IssueBookList.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_IssueBookList.setRowMargin(0);
		tbl_IssueBookList.setRowHeight(40);
		tbl_IssueBookList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
			}
		));
		tbl_issuedBookList.setViewportView(tbl_IssueBookList);
		
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
		issuebooklist.add(backButton);
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setForeground(new Color(255, 255, 255));
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setBackground(new Color(2, 43, 84));
		mtrlbtncrclX.setBounds(1240, 0, 60, 60);
		issuebooklist.add(mtrlbtncrclX);
		
		setIssuedBookDetailsToTable();
	}
	
	//Set Issued Book Details To Table
	public void setIssuedBookDetailsToTable() {
		try {
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from issuebookdetails where status = 'pending'");
					
				while(rs.next()) {
					String studentId = rs.getString("ID");
					String bookName = rs.getString("book_Name");
					String studentName = rs.getString("student_Name");
					String issueDate = rs.getString("issue_Date");
					String dueDate = rs.getString("due_Date");
					String status = rs.getString("status");
						
					Object[] obj = {studentId,bookName,studentName,issueDate,dueDate,status};
					model = (DefaultTableModel) tbl_IssueBookList.getModel();
					model.addRow(obj);
				}
			}catch(SQLException e) {
			}
		}
}
