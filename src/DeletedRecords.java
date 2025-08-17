import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import rojerusan.RSMaterialButtonCircle;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import rojeru_san.complementos.RSTableMetro;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DeletedRecords extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletedRecords frame = new DeletedRecords();
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
	RSTableMetro deleteStudent, deleteBook;
	DefaultTableModel model;
	public DeletedRecords() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(5, 115, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 43, 86));
		panel.setBounds(59, 60, 445, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deleted Records");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(104, 11, 245, 79);
		panel.add(lblNewLabel);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(89, 20, 5, 70);
		panel.add(panel_1_3);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBounds(70, 69, 285, 5);
		panel.add(panel_1_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 355, 750, 520);
		contentPane.add(scrollPane_1);
		
				
		deleteStudent = new RSTableMetro();
		deleteStudent.setVisible(false);
		scrollPane_1.setViewportView(deleteStudent);
		deleteStudent.setColorFilasForeground2(new Color(2, 43, 84));
		deleteStudent.setColorFilasForeground1(new Color(2, 43, 84));
		deleteStudent.setColorBordeHead(new Color(255, 255, 255));
		deleteStudent.setColorBordeFilas(new Color(163, 163, 163));
		deleteStudent.setRowHeight(40);
		deleteStudent.setColorFilasBackgound2(new Color(255, 255, 255));
		deleteStudent.setColorBackgoundHead(new Color(2, 43, 84));
		deleteStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Student Name", "Course", "Branch"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(810, 355, 750, 522);
		contentPane.add(scrollPane);
		
				
		deleteBook = new RSTableMetro();
		scrollPane.setViewportView(deleteBook);
		deleteBook.setRowHeight(40);
		deleteBook.setColorFilasForeground2(new Color(2, 43, 84));
		deleteBook.setColorFilasForeground1(new Color(2, 43, 84));
		deleteBook.setColorFilasBackgound2(Color.WHITE);
		deleteBook.setColorBordeHead(Color.WHITE);
		deleteBook.setColorBordeFilas(new Color(163, 163, 163));
		deleteBook.setColorBackgoundHead(new Color(2, 43, 84));
		deleteBook.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Book ID", "Book Name", "Author", "Quantity"
				}
			));
		
		
		RSMaterialButtonCircle mtrlbtncrclDeletedStudent = new RSMaterialButtonCircle();
		mtrlbtncrclDeletedStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearStudentTable();
				showDeleteStudents();			
				deleteBook.setVisible(false);
				deleteStudent.setVisible(true);
			}
		});
		mtrlbtncrclDeletedStudent.setText("Deleted Student");
		mtrlbtncrclDeletedStudent.setBounds(27, 122, 180, 70);
		panel.add(mtrlbtncrclDeletedStudent);
		
		RSMaterialButtonCircle mtrlbtncrclDeletedBooks = new RSMaterialButtonCircle();
		mtrlbtncrclDeletedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearBookTable();
				showDeleteBooks();
				deleteBook.setVisible(true);
				deleteStudent.setVisible(false);
			}
		});
		mtrlbtncrclDeletedBooks.setText("Deleted Books");
		mtrlbtncrclDeletedBooks.setBounds(242, 122, 180, 70);
		panel.add(mtrlbtncrclDeletedBooks);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 40, 10, 265);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(40, 315, 465, 10);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(515, 60, 10, 265);
		contentPane.add(panel_1_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(59, 40, 465, 10);
		contentPane.add(panel_1_1_1);
		
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
		mtrlbtncrclX_1.setBounds(1540, 0, 60, 60);
		contentPane.add(mtrlbtncrclX_1);
		
		RSMaterialButtonCircle backButton = new RSMaterialButtonCircle();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deshboard dsh = new deshboard();
				dsh.setVisible(true);
				dispose();
			}
		});
		backButton.setText("<");
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setForeground(new Color(2, 43, 84));
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(563, 11, 60, 60);
		contentPane.add(backButton);
		
		
	}
	
	//Show Deleted Students List
	public void showDeleteStudents()
	{
		try {
			Connection con = DBConnection.getConnection();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery("select * from delete_student");
			
			while(rs.next()) {
				int studentID = rs.getInt("student_id");
				String StudentName = rs.getString("student_name");
				String Course = rs.getString("student_course");
				String Branch = rs.getString("student_branch");
				
				Object[] obj = {studentID,StudentName,Course,Branch};
				model = (DefaultTableModel) deleteStudent.getModel();
				model.addRow(obj);				
			}
			
		}catch(SQLException e) {
			
		}
	}
	
	//Show Deleted Students List
		public void showDeleteBooks()
		{
			try {
				Connection con = DBConnection.getConnection();
				java.sql.Statement st = con.createStatement();
				java.sql.ResultSet rs = st.executeQuery("select * from delete_books");
				
				while(rs.next()) {
					int bookID = rs.getInt("bookId");
					String bookName = rs.getString("bookName");
					String author = rs.getString("bookAuthor");
					int quantity = rs.getInt("bookQuantity");
					
					Object[] obj = {bookID,bookName,author,quantity};
					model = (DefaultTableModel) deleteBook.getModel();
					model.addRow(obj);				
				}
				
			}catch(SQLException e) {
				
			}
		}
		
	//Clear Table Data
		public void clearStudentTable() {
			DefaultTableModel model1 = (DefaultTableModel) deleteStudent.getModel();
			model1.setRowCount(0);
		}
		public void clearBookTable() {
			DefaultTableModel model1 = (DefaultTableModel) deleteBook.getModel();
			model1.setRowCount(0);
		}
}
