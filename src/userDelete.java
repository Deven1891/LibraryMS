import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import rojerusan.RSMaterialButtonCircle;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import rojeru_san.complementos.RSTableMetro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import app.bolivia.swing.JCTextField;
import javax.swing.ImageIcon;

public class userDelete extends JFrame {

	private JPanel contentPane;
	private RSTableMetro tbl_UserDetails;
	private JCTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userDelete frame = new userDelete();
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
	
	DefaultTableModel model;
	public userDelete() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 125, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1300, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(new Color(2, 43, 84));
		backButton.setBounds(0, 0, 60, 60);
		panel.add(backButton);
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setForeground(Color.WHITE);
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setBackground(new Color(2, 43, 84));
		mtrlbtncrclX.setBounds(1240, 0, 60, 60);
		panel.add(mtrlbtncrclX);
		
		JScrollPane tbl_userdetails = new JScrollPane();
		tbl_userdetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbl_userdetails.setBounds(50, 240, 1200, 400);
		panel.add(tbl_userdetails);
		
		tbl_UserDetails = new RSTableMetro();
		tbl_UserDetails.setRowMargin(0);
		tbl_UserDetails.setRowHeight(40);
		tbl_UserDetails.setColorSelBackgound(new Color(3, 70, 137));
		tbl_UserDetails.setColorFilasBackgound2(Color.WHITE);
		tbl_UserDetails.setColorBordeHead(Color.WHITE);
		tbl_UserDetails.setColorBordeFilas(new Color(226, 226, 226));
		tbl_UserDetails.setColorBackgoundHead(new Color(2, 43, 84));
		tbl_UserDetails.setAltoHead(40);
		tbl_UserDetails.setBounds(0, 0, 1198, 1);
		tbl_UserDetails.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"AdminID", "AdminName", "Password", "Mobile", "Email"
				}
			));
		tbl_userdetails.setViewportView(tbl_UserDetails);
		
		JLabel lblNewLabel = new JLabel("Enter AdminName which you want to delete!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(52, 187, 328, 29);
		panel.add(lblNewLabel);
		
		username = new JCTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(50, 131, 200, 32);
		panel.add(username);
		
		RSMaterialButtonCircle deluser = new RSMaterialButtonCircle();
		deluser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
				displayAdminData();
			}
		});
		deluser.setFont(new Font("Dialog", Font.BOLD, 17));
		deluser.setText("Delete");
		deluser.setBounds(279, 118, 101, 51);
		panel.add(deluser);
		
		JLabel lblAdminsList = new JLabel("Admins List");
		lblAdminsList.setIcon(new ImageIcon(userDelete.class.getResource("/Images/adminIcons/icons8_People_50px.png")));
		lblAdminsList.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdminsList.setForeground(new Color(2, 43, 84));
		lblAdminsList.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblAdminsList.setBackground(Color.WHITE);
		lblAdminsList.setAlignmentX(0.5f);
		lblAdminsList.setBounds(598, 67, 300, 70);
		panel.add(lblAdminsList);
		
		JPanel underline_third = new JPanel();
		underline_third.setBackground(new Color(2, 43, 84));
		underline_third.setBounds(573, 147, 340, 4);
		panel.add(underline_third);
		

		displayAdminData();
	}
	
	//display superuser data into table
	public void displayAdminData() {
		clearTable();
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin_ms where superUser='not'");
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String userName = rs.getString("usrName");
				String userPassword = rs.getString("usrPassword");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
					
				Object[] obj = {id,userName,userPassword,mobile,email};
				model = (DefaultTableModel) tbl_UserDetails.getModel();
				model.addRow(obj);	
			}
		}catch(SQLException e) {}
	}
	
	public void deleteUser() {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ptst = con.prepareStatement("delete from admin_ms where usrName = '"+username.getText()+"'");
			ptst.executeUpdate();
			username.setText("");
		}catch(SQLException e) {e.printStackTrace();}
	}
	
//	Clear Table
	public void clearTable() {
		DefaultTableModel model1 = (DefaultTableModel) tbl_UserDetails.getModel();
		model1.setRowCount(0);
	}
}
