import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import rojerusan.RSPanelImage;
import javax.swing.ImageIcon;
import rojerusan.RSMaterialButtonCircle;
import app.bolivia.swing.JCTextField;
import java.awt.HeadlessException;
import rojerusan.RSPasswordTextPlaceHolder;

public class SignupPage extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JCTextField txtusr, txtmobile, txtemail;
	private final RSPasswordTextPlaceHolder txtpsw;
	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					SignupPage frame = new SignupPage();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignupPage() {
		setUndecorated(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(335, 100, 930, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(140, 130, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//mainPanel.setBounds(width/2,0,800,800);
		
		JPanel panelsignup = new JPanel();
		panelsignup.setLayout(null);
		panelsignup.setBackground(new Color(2, 43, 84));
		panelsignup.setBounds(500, 0, 430, 700);
		contentPane.add(panelsignup);
		
		JLabel lblusr = new JLabel("Username");
		lblusr.setHorizontalAlignment(SwingConstants.LEFT);
		lblusr.setForeground(Color.WHITE);
		lblusr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblusr.setBounds(34, 131, 149, 27);
		panelsignup.add(lblusr);
		
		JLabel lblpsw = new JLabel("Password");
		lblpsw.setHorizontalAlignment(SwingConstants.LEFT);
		lblpsw.setForeground(Color.WHITE);
		lblpsw.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpsw.setBounds(34, 207, 149, 27);
		panelsignup.add(lblpsw);
		
		JLabel lblSignup = new JLabel("SignUp");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblSignup.setBackground(Color.WHITE);
		lblSignup.setBounds(117, 11, 175, 49);
		panelsignup.add(lblSignup);
		
		JLabel lblmobile = new JLabel("Mobile");
		lblmobile.setHorizontalAlignment(SwingConstants.LEFT);
		lblmobile.setForeground(Color.WHITE);
		lblmobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmobile.setBounds(34, 296, 149, 27);
		panelsignup.add(lblmobile);
		
		JLabel lblemail = new JLabel("Email ID");
		lblemail.setHorizontalAlignment(SwingConstants.LEFT);
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblemail.setBounds(34, 372, 149, 27);
		panelsignup.add(lblemail);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
		lblCreateNewAccount.setBackground(Color.WHITE);
		lblCreateNewAccount.setBounds(27, 57, 346, 23);
		panelsignup.add(lblCreateNewAccount);
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setForeground(new Color(2, 43, 84));
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setBackground(Color.WHITE);
		mtrlbtncrclX.setBounds(358, 11, 60, 60);
		panelsignup.add(mtrlbtncrclX);
		
		txtusr = new JCTextField();
		txtusr.setBounds(44, 169, 290, 32);
		panelsignup.add(txtusr);
		
		txtpsw = new RSPasswordTextPlaceHolder();
		txtpsw.setBounds(44, 245, 290, 32);
		panelsignup.add(txtpsw);
		
		txtmobile = new JCTextField();
		txtmobile.setBounds(44, 329, 290, 32);
		panelsignup.add(txtmobile);
		
		txtemail = new JCTextField();
		txtemail.setBounds(44, 412, 290, 32);
		panelsignup.add(txtemail);
		
		RSMaterialButtonCircle btnSignUp = new RSMaterialButtonCircle();
		btnSignUp.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(Validate()==true)
				{
					insertSignupDetail();
					Loginpage login = new Loginpage();
					login.setVisible(true);
					dispose();
				}
			}
		});
		btnSignUp.setText("SignUp");
		btnSignUp.setForeground(new Color(2, 43, 84));
		btnSignUp.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(110, 500, 200, 60);
		panelsignup.add(btnSignUp);
		
		RSMaterialButtonCircle btnlogin1 = new RSMaterialButtonCircle();
		btnlogin1.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				Loginpage l = new Loginpage();
				l.setVisible(true);
				dispose();
			}
		});
		btnlogin1.setText("Login");
		btnlogin1.setForeground(new Color(2, 43, 84));
		btnlogin1.setFont(new Font("Dialog", Font.BOLD, 30));
		btnlogin1.setBackground(Color.WHITE);
		btnlogin1.setBounds(110, 570, 200, 60);
		panelsignup.add(btnlogin1);
		
		JPanel panelsignupleft = new JPanel();
		panelsignupleft.setBounds(0, 0, 500, 700);
		contentPane.add(panelsignupleft);
		panelsignupleft.setLayout(null);
		panelsignupleft.setBackground(Color.WHITE);
		
		JLabel lblDeven = new JLabel("Deven");
		lblDeven.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeven.setForeground(new Color(2, 43, 84));
		lblDeven.setFont(new Font("Georgia", Font.BOLD, 12));
		lblDeven.setBackground(Color.WHITE);
		lblDeven.setBounds(10, 6, 50, 20);
		panelsignupleft.add(lblDeven);
		
		JLabel lblKatara = new JLabel("Katara");
		lblKatara.setHorizontalAlignment(SwingConstants.CENTER);
		lblKatara.setForeground(new Color(2, 43, 84));
		lblKatara.setFont(new Font("Gadugi", Font.BOLD, 15));
		lblKatara.setBackground(Color.WHITE);
		lblKatara.setBounds(57, 5, 50, 23);
		panelsignupleft.add(lblKatara);
		
		JLabel lblWelcomeTo_1 = new JLabel("Welcome To");
		lblWelcomeTo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo_1.setForeground(new Color(2, 43, 84));
		lblWelcomeTo_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcomeTo_1.setBackground(Color.WHITE);
		lblWelcomeTo_1.setBounds(165, 45, 160, 33);
		panelsignupleft.add(lblWelcomeTo_1);
		
		JLabel lblToLibraryManagement_1 = new JLabel("MSC Central Library");
		lblToLibraryManagement_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblToLibraryManagement_1.setForeground(new Color(2, 43, 84));
		lblToLibraryManagement_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblToLibraryManagement_1.setBackground(Color.WHITE);
		lblToLibraryManagement_1.setBounds(145, 77, 216, 23);
		panelsignupleft.add(lblToLibraryManagement_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(2, 43, 84));
		panel_1.setBounds(131, 110, 245, 5);
		panelsignupleft.add(panel_1);
		
		RSPanelImage panelImage = new RSPanelImage();
		panelImage.setImagen(new ImageIcon(SignupPage.class.getResource("/ImagesOfLibrary/photo-1535905557558-afc4877a26fc.jpg")));
		panelImage.setBounds(50, 160, 400, 500);
		panelsignupleft.add(panelImage);
			
		
	}
	
	//Insert Data To Database
	public void insertSignupDetail()
	{
		Connection con;
		PreparedStatement stmt;
		try {
			con = DBConnection.getConnection();
			@SuppressWarnings("deprecation")
			String sql = "INSERT INTO `admin_ms` (`usrName`, `usrPassword`, `mobile`, `email`) "
							+ "VALUES ('"+txtusr.getText()+"','"+txtpsw.getText()+"','"+txtmobile.getText()+"','"+txtemail.getText()+"')";
			stmt = con.prepareStatement(sql);
				int rs = stmt.executeUpdate();
				System.out.println(rs);
				if(rs > 0){	
					JOptionPane.showConfirmDialog(this, "Account Saved Successfully");
					txtusr.setText("");
					txtpsw.setText(null);
					txtmobile.setText("");
					txtemail.setText("");
				}
				else{
					JOptionPane.showConfirmDialog(this, "Accoount Not Saved Please! Try Again");
					txtusr.setText("");
					txtpsw.setText(null);
					txtmobile.setText("");
					txtemail.setText("");
				}
				con.close();
		}catch(HeadlessException | SQLException e1) {e1.getMessage();  }
	}
	
	//Validate Data
	public boolean Validate() {
		String name = txtusr.getText();
		@SuppressWarnings("deprecation")
		String psw = txtpsw.getText();
		String mobile = txtmobile.getText();
		String email = txtemail.getText();
		
		if(name.equals("") || psw.equals("") || mobile.equals("") || (email.equals("") || !email.matches("^.+@.+\\..+$")))
		{
			JOptionPane.showConfirmDialog(this, "Please Enter Data to All Field");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
