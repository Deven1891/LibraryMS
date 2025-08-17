import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojerusan.RSMaterialButtonCircle;
import java.awt.Dimension;

public class ForegetPassword extends  JFrame{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTextField txt_mobile;
	private final JTextField txt_newPassword;
	private final JTextField txt_confirmPassword;
	private final RSMaterialButtonCircle btnResetPassword;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		ForegetPassword frame = new ForegetPassword();
		frame.setVisible(true);
	}

	//Create the frame.
	
	int Id = 0;
	boolean checked = false;
	public ForegetPassword(){
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 43, 84));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forget Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel.setBounds(140, 50, 214, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(140, 92, 214, 5);
		contentPane.add(panel);
		
		JLabel lblmobile = new JLabel("Mobile");
		lblmobile.setHorizontalAlignment(SwingConstants.LEFT);
		lblmobile.setForeground(Color.WHITE);
		lblmobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmobile.setBounds(85, 127, 149, 27);
		contentPane.add(lblmobile);
		
		txt_mobile = new JTextField();
		txt_mobile.setMinimumSize(new Dimension(15, 22));
		txt_mobile.setColumns(10);
		txt_mobile.setBounds(98, 161, 290, 32);
		contentPane.add(txt_mobile);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(85, 203, 149, 27);
		contentPane.add(lblNewPassword);
		
		txt_newPassword = new JTextField();
		txt_newPassword.setMinimumSize(new Dimension(15, 22));
		txt_newPassword.setColumns(10);
		txt_newPassword.setBounds(98, 237, 290, 32);
		contentPane.add(txt_newPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmPassword.setBounds(85, 279, 149, 27);
		contentPane.add(lblConfirmPassword);
		
		txt_confirmPassword = new JTextField();
		txt_confirmPassword.setMinimumSize(new Dimension(15, 22));
		txt_confirmPassword.setColumns(10);
		txt_confirmPassword.setBounds(98, 314, 290, 32);
		contentPane.add(txt_confirmPassword);
		
		btnResetPassword = new RSMaterialButtonCircle();
		btnResetPassword.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	if(!checked) {
					JOptionPane.showMessageDialog(contentPane, "Please! Verify The Mobile Number First.");
				}else {
					if(checkPassword(Id) == false) {
						JOptionPane.showMessageDialog(contentPane, "Please! Check Password, Both Are Not Same.");
					}else {
						JOptionPane.showMessageDialog(contentPane, "Your Password Successfully Updated.");
						txt_confirmPassword.setText("");
						txt_newPassword.setText("");
						txt_mobile.setText("");
					}
				}
			}
		});
		btnResetPassword.setText("Reset Password");
		btnResetPassword.setForeground(new Color(2, 43, 84));
		btnResetPassword.setFont(new Font("Dialog", Font.BOLD, 23));
		btnResetPassword.setAlignmentX(CENTER_ALIGNMENT);
		btnResetPassword.setBackground(Color.WHITE);
		btnResetPassword.setBounds(114, 390, 261, 60);
		contentPane.add(btnResetPassword);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(398, 191, 82, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Verify");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txt_mobile.getText().equals(null))
				{
					lblNewLabel_2_1.setText("Verifying...");
					checked = true;
					Id = isMobileExist();
					if(Id>0) {
						lblNewLabel_2_1.setText("Verified.");
					}
					else {
						lblNewLabel_2_1.setText("NotFind.");
					}
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Please Enter Mobile Number");
				}
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_2.setBounds(398, 166, 48, 18);
		contentPane.add(lblNewLabel_2);		
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setForeground(new Color(2, 43, 84));
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setBackground(Color.WHITE);
		mtrlbtncrclX.setBounds(440, 0, 60, 60);
		contentPane.add(mtrlbtncrclX);
		
		RSMaterialButtonCircle backButton = new RSMaterialButtonCircle();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginpage login = new Loginpage();
				login.setVisible(true);
				dispose();
			}
		});
		backButton.setText("<");
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setForeground(new Color(2, 43, 84));
		backButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(0, 0, 60, 60);
		contentPane.add(backButton);
	}
	
	//	Check mobile number is in or not
	public int isMobileExist() {
		int ismobileExist = 0;
		String mobile = txt_mobile.getText();
		long mobileNo = Long.parseLong(mobile);
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from admin_ms where mobile = '"+mobileNo+"'";
			PreparedStatement ptst = con.prepareStatement(sql);
			ResultSet rs = ptst.executeQuery();
			while(rs.next()) {
				ismobileExist += rs.getInt("ID");
			}
		}catch(Exception e) {
		}
		return ismobileExist;
	}
	
	//	Check Both Password Are Same
	//	Update Data into database
	public boolean checkPassword(int Id) {
		String newPassword = txt_newPassword.getText();
		String confirmPassword = txt_confirmPassword.getText();
		
		if(newPassword.equals(confirmPassword)) {
			try {
				Connection con = DBConnection.getConnection();
				String sql = "update admin_ms set usrPassword = '"+confirmPassword+"' where ID = '"+Id+"'";
				PreparedStatement ptst = con.prepareStatement(sql);
				int rowCount = ptst.executeUpdate();
				if(rowCount>0) {
					return true;
				}
			}catch( Exception e) {
			}	
		}
		return false;
	}	
}