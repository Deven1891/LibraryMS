

import java.awt.EventQueue;
import java.sql.*;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import rojeru_san.componentes.RSDateChooser;
import rojerusan.RSMaterialButtonCircle;
import rojeru_san.complementos.RSTableMetro;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

public final class IssuedBookDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Issued_Book_Details;
	private final JScrollPane tbl_issuedBookDetails;
	private final RSTableMetro tbl_details;
	private RSDateChooser date_fromDate, date_toDate;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					IssuedBookDetails frame = new IssuedBookDetails();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DefaultTableModel model;
	public IssuedBookDetails() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		Issued_Book_Details = new JPanel();
		Issued_Book_Details.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Issued_Book_Details);
		Issued_Book_Details.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(2, 43, 84));
		panel1.setBounds(0, 0, 1600, 300);
		Issued_Book_Details.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblViewAllRecord = new JLabel("Issued Book Details");
		lblViewAllRecord.setIcon(new ImageIcon(IssuedBookDetails.class.getResource("/Images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblViewAllRecord.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewAllRecord.setForeground(Color.WHITE);
		lblViewAllRecord.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblViewAllRecord.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblViewAllRecord.setBounds(600, 10, 400, 100);
		panel1.add(lblViewAllRecord);
		
		JPanel underLine = new JPanel();
		underLine.setBounds(580, 120, 440, 5);
		panel1.add(underLine);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueDate.setForeground(new Color(255, 255, 255));
		lblIssueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblIssueDate.setBackground(Color.WHITE);
		lblIssueDate.setAlignmentX(0.5f);
		lblIssueDate.setBounds(70, 223, 149, 32);
		panel1.add(lblIssueDate);
		
		date_fromDate = new RSDateChooser();
		date_fromDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		date_fromDate.setPlaceholder("Select Issue Date");
		date_fromDate.setFuente(new Font("SansSerif", Font.BOLD, 15));
		date_fromDate.setForeground(new Color(2, 43, 84));
		date_fromDate.setColorForeground(new Color(2, 43, 84));
		date_fromDate.setColorDiaActual(new Color(2, 43, 84));
		date_fromDate.setColorButtonHover(new Color(5, 85, 165));
		date_fromDate.setColorBackground(new Color(2, 43, 84));
		date_fromDate.setBounds(253, 223, 295, 32);
		panel1.add(date_fromDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDueDate.setForeground(new Color(255, 255, 255));
		lblDueDate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDueDate.setAlignmentX(0.5f);
		lblDueDate.setBounds(650, 223, 149, 32);
		panel1.add(lblDueDate);
		
		date_toDate = new RSDateChooser();
		date_toDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		date_toDate.setPlaceholder("Select Due Date");
		date_toDate.setFuente(new Font("SansSerif", Font.BOLD, 15));
		date_toDate.setForeground(Color.RED);
		date_toDate.setColorForeground(new Color(2, 43, 84));
		date_toDate.setColorDiaActual(new Color(2, 43, 84));
		date_toDate.setColorButtonHover(new Color(5, 85, 165));
		date_toDate.setColorBackground(new Color(2, 43, 84));
		date_toDate.setBounds(825, 223, 295, 32);
		panel1.add(date_toDate);
		
		RSMaterialButtonCircle btnSearch = new RSMaterialButtonCircle();
		btnSearch.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
					clearTable();
					search();
				}else {
					JOptionPane.showMessageDialog(Issued_Book_Details, "Please Select a Date.");
				}
				
			}
		});
		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		btnSearch.setBackground(new Color(5, 85, 165));
		btnSearch.setBounds(1148, 213, 175, 56);
		panel1.add(btnSearch);
		
		RSMaterialButtonCircle mtrlbtncrclAll = new RSMaterialButtonCircle();
		mtrlbtncrclAll.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				clearTable();
				setIssuedBookDetailsToTable();
				date_fromDate.setDatoFecha(null);
				date_toDate.setDatoFecha(null);
			}
		});
		mtrlbtncrclAll.setText("All");
		mtrlbtncrclAll.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		mtrlbtncrclAll.setBackground(new Color(5, 85, 165));
		mtrlbtncrclAll.setBounds(1370, 213, 175, 56);
		panel1.add(mtrlbtncrclAll);
		
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
		panel1.add(backButton);
		
		RSMaterialButtonCircle mtrlbtncrclX_1 = new RSMaterialButtonCircle();
		mtrlbtncrclX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX_1.setText("X");
		mtrlbtncrclX_1.setForeground(new Color(2, 43, 84));
		mtrlbtncrclX_1.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX_1.setBackground(new Color(255, 255, 255));
		mtrlbtncrclX_1.setBounds(1540, 0, 60, 60);
		panel1.add(mtrlbtncrclX_1);
		
		JLabel BackUpFile = new JLabel("BackUp");
		BackUpFile.setBounds(1312, 143, 278, 63);
		panel1.add(BackUpFile);
		BackUpFile.setBackground(new Color(255, 255, 255));
		BackUpFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackUpFile.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BackUpFile.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				backUpData();
			}	
		});
		BackUpFile.setIcon(new ImageIcon(IssuedBookDetails.class.getResource("/ImagesOfLibrary/download-100.png")));
		BackUpFile.setForeground(Color.WHITE);
		BackUpFile.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		BackUpFile.setAlignmentX(0.5f);
		
		JPanel panel_table = new JPanel();
		panel_table.setBackground(new Color(255, 255, 255));
		panel_table.setBounds(0, 300, 1600, 600);
		Issued_Book_Details.add(panel_table);
		panel_table.setLayout(null);
		
		tbl_issuedBookDetails = new JScrollPane();
		tbl_issuedBookDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbl_issuedBookDetails.setBounds(200, 83, 1200, 489);
		panel_table.add(tbl_issuedBookDetails);
		
		tbl_details = new RSTableMetro();
		tbl_details.setColorFilasForeground1(new Color(2, 43, 84));
		tbl_details.setColorFilasForeground2(new Color(2, 43, 84));
		tbl_details.setColorFilasBackgound2(new Color(255, 255, 255));
		tbl_details.setColorBordeHead(new Color(255, 255, 255));
		tbl_details.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_details.setColorSelBackgound(new Color(5, 85, 165));
		tbl_details.setSelectionBackground(new Color(0, 112, 192));
		tbl_details.setForeground(new Color(0, 0, 0));
		tbl_details.setFont(new Font("SansSerif", Font.BOLD, 20));
		tbl_details.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tbl_details.setRowMargin(4);
		tbl_details.setRowHeight(40);
		tbl_issuedBookDetails.setViewportView(tbl_details);
		tbl_details.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
			}
		));
		tbl_details.getColumnModel().getColumn(0).setPreferredWidth(52);
		tbl_details.getColumnModel().getColumn(1).setPreferredWidth(162);
		tbl_details.getColumnModel().getColumn(2).setPreferredWidth(172);
		tbl_details.getColumnModel().getColumn(3).setPreferredWidth(97);
		tbl_details.getColumnModel().getColumn(3).setMinWidth(17);
		tbl_details.getColumnModel().getColumn(4).setPreferredWidth(95);
		
		setIssuedBookDetailsToTable();
	}
	
	//Set Issued Book Details To Table
		public void setIssuedBookDetailsToTable() {
			try {
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from issuebookdetails");
				
				while(rs.next()) {
					String studentId = rs.getString("ID");
					String bookName = rs.getString("book_Name");
					String studentName = rs.getString("student_Name");
					String issueDate = rs.getString("issue_Date");
					String dueDate = rs.getString("due_Date");
					String status = rs.getString("status");
						
					Object[] obj = {studentId,bookName,studentName,issueDate,dueDate,status};
					model = (DefaultTableModel) tbl_details.getModel();
					model.addRow(obj);
				}
			}catch(SQLException e) {
			}
		}
		
		// Clear Table
		public void clearTable() {
			DefaultTableModel model1;
                        model1 = (DefaultTableModel) tbl_details.getModel();
			model1.setRowCount(0);
		}
		
		// To Fetch the record using date fields
		public void search() {
			Date ufromDate = date_fromDate.getDatoFecha();
			Date utoDate = date_toDate.getDatoFecha();
			
			long l1 = ufromDate.getTime();
			long l2 = utoDate.getTime();
			
			java.sql.Date fromDate = new java.sql.Date(l1);
			java.sql.Date toDate = new java.sql.Date(l2);
			
			try {
				Connection con = DBConnection.getConnection();
				String sql = "select * from issuebookdetails where issue_Date between '"+fromDate+"' and '"+toDate+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next() == false) {
					JOptionPane.showMessageDialog(this, "No Record Found.");
				}
				else {
					while(rs.next()) {
						String studentId = rs.getString("ID");
						String bookName = rs.getString("book_Name");
						String studentName = rs.getString("student_Name");
						String issueDate = rs.getString("issue_Date");
						String dueDate = rs.getString("due_Date");
						String status = rs.getString("status");
							
						Object[] obj = {studentId,bookName,studentName,issueDate,dueDate,status};
						model = (DefaultTableModel) tbl_details.getModel();
						model.addRow(obj);
					}
				}
				
				
			}catch(HeadlessException | SQLException e) {
			}
		}
		
		//For the BackUp
		public void backUpData()
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
				PdfWriter.getInstance(doc, new FileOutputStream(path+"IssuedBookDetails.pdf"));
				doc.open();
				PdfPTable tbl = new PdfPTable(6);
				tbl.addCell("Id");
				tbl.addCell("BookName");
				tbl.addCell("StudentName");
				tbl.addCell("IssueDate");
				tbl.addCell("DueDate");
				tbl.addCell("Status");
				for(int i=0; i<tbl_details.getRowCount(); i++)
				{
					String id = tbl_details.getValueAt(i, 0).toString();
					String bnm = tbl_details.getValueAt(i, 1).toString();
					String snm = tbl_details.getValueAt(i, 2).toString();
					String issdate = tbl_details.getValueAt(i, 3).toString();
					String duedate = tbl_details.getValueAt(i, 4).toString();
					String status = tbl_details.getValueAt(i, 5).toString();
		
					tbl.addCell(id);
					tbl.addCell(bnm);
					tbl.addCell(snm);
					tbl.addCell(issdate);
					tbl.addCell(duedate);
					tbl.addCell(status);
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
