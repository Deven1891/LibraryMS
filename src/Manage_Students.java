

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojerusan.RSMaterialButtonCircle;
import app.bolivia.swing.JCTextField;
import rojerusan.RSComboMetro;
import rojeru_san.complementos.RSTableMetro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

public final class Manage_Students extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel manageStudents;
	private JCTextField txt_studentId, txt_studentName;
	private RSComboMetro cmb_course, cmb_branch;
	private RSTableMetro tbl_studentDetails;

	/**
	 * Launch the application.
     * @param args
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					Manage_Students frame = new Manage_Students();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	int studentId;
	String studentName, course, branch;
	DefaultTableModel model;
	@SuppressWarnings("unchecked")
	public Manage_Students() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		manageStudents = new JPanel();
		manageStudents.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(manageStudents);
		manageStudents.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(2, 43, 84));
		panel.setBounds(0, 0, 580, 900);
		manageStudents.add(panel);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID");
		lblEnterStudentId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterStudentId.setForeground(Color.WHITE);
		lblEnterStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterStudentId.setAlignmentX(0.5f);
		lblEnterStudentId.setBounds(104, 128, 149, 27);
		panel.add(lblEnterStudentId);
		
		txt_studentId = new JCTextField();
		txt_studentId.setText((String) null);
		txt_studentId.setBounds(114, 166, 290, 32);
		txt_studentId.setText(setStudentID());
		panel.add(txt_studentId);
		
		JLabel lblEnterStudentName = new JLabel("Enter Student Name");
		lblEnterStudentName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterStudentName.setForeground(Color.WHITE);
		lblEnterStudentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterStudentName.setAlignmentX(0.5f);
		lblEnterStudentName.setBounds(104, 232, 149, 27);
		panel.add(lblEnterStudentName);
		
		txt_studentName = new JCTextField();
		txt_studentName.setText((String) null);
		txt_studentName.setBounds(117, 270, 290, 32);
		panel.add(txt_studentName);
		
		JLabel lblCourseName = new JLabel("Select Course");
		lblCourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCourseName.setAlignmentX(0.5f);
		lblCourseName.setBounds(104, 329, 149, 27);
		panel.add(lblCourseName);
		
		JLabel lbl_branch = new JLabel("Select Branch");
		lbl_branch.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_branch.setForeground(Color.WHITE);
		lbl_branch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_branch.setAlignmentX(0.5f);
		lbl_branch.setBounds(104, 434, 149, 27);
		panel.add(lbl_branch);
		
		JLabel lblEnterBookId_1 = new JLabel("");
		lblEnterBookId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1.setForeground(Color.WHITE);
		lblEnterBookId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1.setAlignmentX(0.5f);
		lblEnterBookId_1.setBounds(61, 123, 32, 42);
		panel.add(lblEnterBookId_1);
		
		JLabel lblEnterBookId_1_1 = new JLabel("");
		lblEnterBookId_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_1.setForeground(Color.WHITE);
		lblEnterBookId_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_1.setAlignmentX(0.5f);
		lblEnterBookId_1_1.setBounds(61, 224, 32, 42);
		panel.add(lblEnterBookId_1_1);
		
		JLabel lblEnterBookId_1_2 = new JLabel("");
		lblEnterBookId_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_2.setForeground(Color.WHITE);
		lblEnterBookId_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_2.setAlignmentX(0.5f);
		lblEnterBookId_1_2.setBounds(61, 323, 32, 42);
		panel.add(lblEnterBookId_1_2);
		
		JLabel lblEnterBookId_1_3 = new JLabel("");
		lblEnterBookId_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterBookId_1_3.setForeground(Color.WHITE);
		lblEnterBookId_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterBookId_1_3.setAlignmentX(0.5f);
		lblEnterBookId_1_3.setBounds(61, 429, 32, 42);
		panel.add(lblEnterBookId_1_3);
		
		RSMaterialButtonCircle btnAdd = new RSMaterialButtonCircle();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addStudent() == true) {
					clearTable();
					setStudentDetailsToTable();
					txt_studentId.setText(setStudentID());
					txt_studentName.setText("");
					cmb_course.setSelectedItem(0);
					cmb_branch.setSelectedItem(0);
				}
				else
				{
					JOptionPane.showConfirmDialog(btnAdd, "Hello");
				}
			}
		});
		btnAdd.setText("Add");
		btnAdd.setForeground(new Color(2, 43, 84));
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 25));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(46, 600, 140, 60);
		panel.add(btnAdd);
		
		RSMaterialButtonCircle btnUpdate = new RSMaterialButtonCircle();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateStudent() == true) {
					clearTable();
					setStudentDetailsToTable();
					txt_studentId.setText(setStudentID());
					txt_studentName.setText("");
					cmb_course.setSelectedItem(0);
					cmb_branch.setSelectedItem(0);
				}
			}
		});
		btnUpdate.setText("update");
		btnUpdate.setForeground(new Color(2, 43, 84));
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 25));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(216, 600, 140, 60);
		panel.add(btnUpdate);
		
		RSMaterialButtonCircle btnDelete = new RSMaterialButtonCircle();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteStudent() == true) {
					clearTable();
					setStudentDetailsToTable();
					txt_studentId.setText(setStudentID());
					txt_studentName.setText("");
					cmb_course.setSelectedItem(0);
					cmb_branch.setSelectedItem(0);
				}
			}
		});
		btnDelete.setText("Delete");
		btnDelete.setForeground(new Color(2, 43, 84));
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 25));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(386, 600, 140, 60);
		panel.add(btnDelete);
		
		cmb_course = new RSComboMetro();
		cmb_course.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cmb_course.setModel(new DefaultComboBoxModel<>(new String[] {"MCA", "BCA", "BScIT", "BBA", "BCom", "BA"}));
		cmb_course.setColorArrow(new Color(2, 43, 84));
		cmb_course.setColorFondo(new Color(255, 255, 255));
		cmb_course.setColorBorde(new Color(255, 255, 255));
		cmb_course.setForeground(new Color(0, 0, 0));
		cmb_course.setBounds(117, 367, 290, 32);
		panel.add(cmb_course);
		
		cmb_branch = new RSComboMetro();
		cmb_branch.setModel(new DefaultComboBoxModel<>(new String[] {"IT", "Management", "Electronics", "Mechanical", "Sivil"}));
		cmb_branch.setForeground(Color.BLACK);
		cmb_branch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cmb_branch.setColorFondo(Color.WHITE);
		cmb_branch.setColorBorde(Color.WHITE);
		cmb_branch.setColorArrow(new Color(2, 43, 84));
		cmb_branch.setBounds(117, 472, 290, 32);
		panel.add(cmb_branch);
		
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
		panel.add(backButton);				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 784, 351, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBackupstudent = new JLabel("BackUp Student");
		lblBackupstudent.setBounds(27, 11, 300, 49);
		panel_1.add(lblBackupstudent);
		lblBackupstudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backupStudent();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(2, 43, 84));
				panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
				lblBackupstudent.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(255, 255, 255));
				lblBackupstudent.setForeground(new Color(2, 43, 84));
			}
		});
		lblBackupstudent.setIcon(new ImageIcon(Manage_Students.class.getResource("/ImagesOfLibrary/download-100.png")));
		lblBackupstudent.setForeground(new Color(2, 43, 84));
		lblBackupstudent.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblBackupstudent.setBackground(new Color(255, 255, 255));
		lblBackupstudent.setAlignmentX(0.5f);
		
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(2, 43, 84));
				lblBackupstudent.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(255, 255, 255));
				lblBackupstudent.setForeground(new Color(2, 43, 84));
			}
		});
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(580, 0, 1020, 900);
		manageStudents.add(panel_2);
		
		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setIcon(new ImageIcon(Manage_Students.class.getResource("/ImagesOfLibrary/book4.png")));
		lblManageStudents.setHorizontalAlignment(SwingConstants.LEFT);
		lblManageStudents.setForeground(new Color(2, 43, 84));
		lblManageStudents.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblManageStudents.setBackground(Color.WHITE);
		lblManageStudents.setAlignmentX(0.5f);
		lblManageStudents.setBounds(427, 28, 365, 73);
		panel_2.add(lblManageStudents);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(2, 43, 84));
		panel_3.setBounds(431, 113, 379, 4);
		panel_2.add(panel_3);
		
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
		mtrlbtncrclX_1.setBounds(960, 0, 60, 60);
		panel_2.add(mtrlbtncrclX_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		scrollPane_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(80, 193, 811, 357);
		panel_2.add(scrollPane_1);
		
		tbl_studentDetails = new RSTableMetro();
		tbl_studentDetails.setColorBordeFilas(new Color(163, 163, 163));
		tbl_studentDetails.setFuenteHead(new Font("Tahoma", Font.BOLD, 20));
		tbl_studentDetails.setRowMargin(0);
		tbl_studentDetails.setRowHeight(40);
		tbl_studentDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbl_studentDetails.setColorFilasBackgound2(new Color(255, 255, 255));
		tbl_studentDetails.setColorBordeHead(new Color(255, 255, 255));
		tbl_studentDetails.setColorFilasForeground2(new Color(2, 43, 84));
		tbl_studentDetails.setColorFilasForeground1(new Color(2, 43, 84));
		tbl_studentDetails.setColorSelBackgound(new Color(3, 70, 137));
		tbl_studentDetails.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_studentDetails.setAltoHead(40);
		tbl_studentDetails.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Student Name", "Course", "Branch"
			}
		));
		scrollPane_1.setViewportView(tbl_studentDetails);
		
		setStudentDetailsToTable();
	}
	
	//Set Student Details To Table
	public void setStudentDetailsToTable() {
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student_details");
			
			while(rs.next()) {
				int studentID = rs.getInt("studentId");
				String StudentName = rs.getString("studentName");
				String Course = rs.getString("course");
				String Branch = rs.getString("branch");
					
				Object[] obj = {studentID,StudentName,Course,Branch};
				model = (DefaultTableModel) tbl_studentDetails.getModel();
				model.addRow(obj);
			}
		}catch(SQLException e) {
		}
	}
	
	// Add Student Details To Database
	String student_name, student_course, student_branch;
	int student_id;
	public boolean addStudent() {
		boolean isAdded = false;
		student_id = Integer.parseInt(txt_studentId.getText());
		student_name = txt_studentName.getText();
		student_course = cmb_course.getSelectedItem().toString();
		student_branch = cmb_branch.getSelectedItem().toString();
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into student_details values('"+student_id+"','"+student_name+"','"+student_course+"','"+student_branch+"',0)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			int rowCount = pst.executeUpdate();
			if(rowCount > 0) {
				JOptionPane.showMessageDialog(this, "Record Inserted SuccessFully");
				isAdded = true;
			}else {
				JOptionPane.showMessageDialog(this, "Record Not Inserted");
			}
		}catch(HeadlessException | SQLException e) {
		}
		return isAdded;
	}
	
	
	//	Clear Table
	public void clearTable() {
		DefaultTableModel model1 = (DefaultTableModel) tbl_studentDetails.getModel();
		model1.setRowCount(0);
	}
	
	// Delete Student Details to Database
	public boolean deleteStudent() {
		boolean isDelete = false;
		studentId = Integer.parseInt(txt_studentId.getText());
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ptst = con.prepareStatement("delete from student_details where studentId = '"+studentId+"'");
			int rowCount = ptst.executeUpdate();
			if(rowCount > 0) {
				isDelete = true;
				JOptionPane.showMessageDialog(this, "Student Deleted Successfully...");
			}
			else {
				JOptionPane.showMessageDialog(this, "Student Not Deleted, Somthing want wrong!");
			}
		}catch(HeadlessException | SQLException e) {
		}
		return isDelete;
	}
	
	// Update Student Record
		public boolean updateStudent() {
			boolean isUpdate = false;
			studentId = Integer.parseInt(txt_studentId.getText());
			studentName = txt_studentName.getText();
			course = "" + cmb_course.getSelectedItem();
			branch = "" + cmb_branch.getSelectedItem();
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "update student_details set studentName = '"+studentName+"', course = '"+course+"', branch = '"+branch+"' where studentId = '"+studentId+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				int rowCount = pst.executeUpdate();
				if(rowCount > 0) {
					isUpdate = true;
					JOptionPane.showMessageDialog(this, "Student Data Updated...");
				}
				else {
					JOptionPane.showMessageDialog(this, "Student Data Not Updated...");
				}
			}catch(HeadlessException | SQLException e) {
			}
			return isUpdate;
		}
	
	// Set StudentId Already
		public String setStudentID() {
			int lastID = 0;
			String lastid = "";
			try {
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String sql = "select studentId from student_details order by studentId desc limit 1";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					lastID += rs.getInt("studentId");
				}
				lastID+=1;
				lastid = Integer.toString(lastID);
			}catch(SQLException e) {
			}
			return lastid;
		}
		
	//BackUp Student Details
		public void backupStudent()
		{
			String path="";
			JFileChooser j = new JFileChooser();
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int x = j.showSaveDialog(this);
			if(x==JFileChooser.APPROVE_OPTION)
			{
				path = j.getSelectedFile().getPath();
			}
			Document doc = new Document();
			try
			{
				PdfWriter.getInstance(doc, new FileOutputStream(path+"StudentDetails.pdf"));
				doc.open();
				PdfPTable tbl = new PdfPTable(4);
				tbl.addCell("StudentId");
				tbl.addCell("StudentName");
				tbl.addCell("Course");
				tbl.addCell("Branch");
				for(int i=0; i<tbl_studentDetails.getRowCount(); i++)
				{
					String id = tbl_studentDetails.getValueAt(i, 0).toString();
					String snm = tbl_studentDetails.getValueAt(i, 1).toString();
					String course = tbl_studentDetails.getValueAt(i, 2).toString();
					String branch = tbl_studentDetails.getValueAt(i, 3).toString();
					tbl.addCell(id);
					tbl.addCell(snm);
					tbl.addCell(course);
					tbl.addCell(branch);
				}
				doc.add(tbl);
				JOptionPane.showMessageDialog(null, "PDF Generated");
			}
			catch(Exception el)
			{
				JOptionPane.showMessageDialog(null, "Something went wrong");
			}
			doc.close();
		}
}
