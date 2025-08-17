

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import rojeru_san.complementos.RSTableMetro;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSMaterialButtonCircle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class DefaulterList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final RSTableMetro tbl_DefaulterList;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		DefaulterList frame = new DefaulterList();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	DefaultTableModel model;
	public DefaulterList() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 125, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel defaulterList = new JPanel();
		defaulterList.setBackground(new Color(255, 255, 255));
		defaulterList.setBounds(0, 0, 1300, 650);
		contentPane.add(defaulterList);
		defaulterList.setLayout(null);
		
		JLabel lblDefaulterList = new JLabel("Defaulter List");
		lblDefaulterList.setIcon(new ImageIcon(DefaulterList.class.getResource("/ImagesOfLibrary/book5.png")));
		lblDefaulterList.setHorizontalAlignment(SwingConstants.LEFT);
		lblDefaulterList.setForeground(new Color(2, 43, 84));
		lblDefaulterList.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblDefaulterList.setBackground(Color.WHITE);
		lblDefaulterList.setAlignmentX(0.5f);
		lblDefaulterList.setBounds(540, 40, 300, 70);
		defaulterList.add(lblDefaulterList);
		
		JPanel underline_third = new JPanel();
		underline_third.setBackground(new Color(2, 43, 84));
		underline_third.setBounds(500, 110, 340, 4);
		defaulterList.add(underline_third);
		
		JScrollPane tbl_defaulterList = new JScrollPane();
		tbl_defaulterList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbl_defaulterList.setBounds(50, 180, 1200, 400);
		defaulterList.add(tbl_defaulterList);
		
		tbl_DefaulterList = new RSTableMetro();
		tbl_DefaulterList.setColorFilasForeground2(new Color(2, 43, 84));
		tbl_DefaulterList.setColorFilasForeground1(new Color(2, 43, 84));
		tbl_DefaulterList.setColorFilasBackgound2(new Color(255, 255, 255));
		tbl_DefaulterList.setAltoHead(40);
		tbl_DefaulterList.setColorSelBackgound(new Color(5, 85, 165));
		tbl_DefaulterList.setColorBordeHead(new Color(255, 255, 255));
		tbl_DefaulterList.setColorBordeFilas(new Color(226, 226, 226));
		tbl_DefaulterList.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_DefaulterList.setRowMargin(0);
		tbl_DefaulterList.setRowHeight(40);
		tbl_DefaulterList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
			}
		));
		tbl_defaulterList.setViewportView(tbl_DefaulterList);
		
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
		defaulterList.add(backButton);
		
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
		defaulterList.add(mtrlbtncrclX);
		
		setIssuedBookDetailsToTable();
	}
	
	//Set Issued Book Details To Table
	public void setIssuedBookDetailsToTable() {
		long l1 = System.currentTimeMillis();
		Date toDaysDate = new Date(l1);
		
		
		try {
				Connection con = DBConnection.getConnection();
				String sql = "select * from issuebookdetails where due_Date < '"+toDaysDate+"' and status = 'pending'";
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
					
				while(rs.next()) {
					String studentId = rs.getString("ID");
					String bookName = rs.getString("book_Name");
					String studentName = rs.getString("student_Name");
					String issueDate = rs.getString("issue_Date");
					String dueDate = rs.getString("due_Date");
					String status = rs.getString("status");
						
					Object[] obj = {studentId,bookName,studentName,issueDate,dueDate,status};
					model = (DefaultTableModel) tbl_DefaulterList.getModel();
					model.addRow(obj);
				}
			}catch(SQLException e) {
			}
		}
}
