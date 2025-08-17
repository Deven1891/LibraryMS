import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.bolivia.swing.JCTextField;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import rojerusan.RSMaterialButtonCircle;
import rojerusan.RSPanelImage;
import rojerusan.RSPasswordTextPlaceHolder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Loginpage extends JFrame{

	/**
	 * 
	 */
	protected static String Name = "";
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JCTextField txtusr;
	private final RSPasswordTextPlaceHolder txtpsw;	
	
	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try {
            		Loginpage frame = new Loginpage();
            		frame.setVisible(true);
            	} catch (Exception e) {
            	}
            }
		});	
	}

	/**
	 * Create the frame.
	 */
	public Loginpage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(335, 100, 930, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(140, 130, 215));
		mainPanel.setBounds(0, 0, 930, 700);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panelsignupleft = new JPanel();
		panelsignupleft.setBounds(0, 0, 500, 700);
		panelsignupleft.setBackground(new Color(255, 255, 255));
		mainPanel.add(panelsignupleft);
		panelsignupleft.setLayout(null);
		
		JLabel lblDeven = new JLabel("Deven");
		lblDeven.setBounds(10, 6, 50, 20);
		lblDeven.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeven.setForeground(new Color(2, 43, 84));
		lblDeven.setFont(new Font("Georgia", Font.BOLD, 12));
		lblDeven.setBackground(Color.WHITE);
		panelsignupleft.add(lblDeven);
		
		JLabel lblKatara = new JLabel("Katara");
		lblKatara.setBounds(57, 5, 50, 23);
		lblKatara.setHorizontalAlignment(SwingConstants.CENTER);
		lblKatara.setForeground(new Color(2, 43, 84));
		lblKatara.setFont(new Font("Gadugi", Font.BOLD, 15));
		lblKatara.setBackground(Color.WHITE);
		panelsignupleft.add(lblKatara);
		
		JLabel lblWelcomeTo = new JLabel("Welcome To");
		lblWelcomeTo.setBounds(165, 45, 160, 33);
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setForeground(new Color(2, 43, 84));
		lblWelcomeTo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcomeTo.setBackground(Color.WHITE);
		panelsignupleft.add(lblWelcomeTo);
		
		JLabel lblToLibraryManagement = new JLabel("MSC Central Library");
		lblToLibraryManagement.setBounds(145, 77, 216, 23);
		lblToLibraryManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblToLibraryManagement.setForeground(new Color(2, 43, 84));
		lblToLibraryManagement.setFont(new Font("Dialog", Font.BOLD, 22));
		lblToLibraryManagement.setBackground(Color.WHITE);
		panelsignupleft.add(lblToLibraryManagement);
		
		RSPanelImage panelImage = new RSPanelImage();
		panelImage.setImagen(new ImageIcon(Loginpage.class.getResource("/ImagesOfLibrary/home-mod01-400x500.jpg")));
		panelImage.setBounds(50, 160, 400, 500);
		panelsignupleft.add(panelImage);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(2, 43, 84));
		panel.setBackground(new Color(2, 43, 84));
		panel.setBounds(131, 110, 245, 5);
		panelsignupleft.add(panel);
		
		JPanel panelsignup = new JPanel();
		panelsignup.setBounds(500, 0, 430, 700);
		panelsignup.setLayout(null);
		panelsignup.setBackground(new Color(2, 43, 84));
		mainPanel.add(panelsignup);
		
		JLabel lblusr = new JLabel("Username");
		lblusr.setHorizontalAlignment(SwingConstants.LEFT);
		lblusr.setForeground(Color.WHITE);
		lblusr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblusr.setBounds(70, 131, 149, 27);
		panelsignup.add(lblusr);
		
		JLabel lblpsw = new JLabel("Password");
		lblpsw.setHorizontalAlignment(SwingConstants.LEFT);
		lblpsw.setForeground(Color.WHITE);
		lblpsw.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpsw.setBounds(70, 207, 149, 27);
		panelsignup.add(lblpsw);
		
		JLabel lbllogin = new JLabel("Login");
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setForeground(Color.WHITE);
		lbllogin.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lbllogin.setBackground(Color.WHITE);
		lbllogin.setBounds(117, 11, 175, 49);
		panelsignup.add(lbllogin);
		
		JLabel lblCreateNewAccount = new JLabel("Login to your Account\r\n");
		lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
		lblCreateNewAccount.setBackground(Color.WHITE);
		lblCreateNewAccount.setBounds(27, 57, 346, 23);
		panelsignup.add(lblCreateNewAccount);
		
		JLabel lblForgetPassword = new JLabel("Forget Password?");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForegetPassword fp = new ForegetPassword();
				fp.setVisible(true);
				dispose();
			}
		});
		lblForgetPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblForgetPassword.setForeground(new Color(255, 255, 255));
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForgetPassword.setBounds(224, 293, 149, 27);
		panelsignup.add(lblForgetPassword);
		
		RSMaterialButtonCircle mtrlbtncrclX = new RSMaterialButtonCircle();
		mtrlbtncrclX.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mtrlbtncrclX.setBounds(358, 11, 60, 60);
		panelsignup.add(mtrlbtncrclX);
		mtrlbtncrclX.setFont(new Font("Dialog", Font.BOLD, 35));
		mtrlbtncrclX.setForeground(new Color(2, 43, 84));
		mtrlbtncrclX.setText("X");
		mtrlbtncrclX.setBackground(new Color(255, 255, 255));
		
		RSMaterialButtonCircle login_btn = new RSMaterialButtonCircle();
		login_btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(ValidateBlank()==true && validateDuplicateLogin()==true) {
                    deshboard home = new deshboard();
                    home.setVisible(true);
                    dispose();
                }
			}
		});
		login_btn.setText("Login");
		login_btn.setForeground(new Color(2, 43, 84));
		login_btn.setFont(new Font("Dialog", Font.BOLD, 30));
		login_btn.setBackground(Color.WHITE);
		login_btn.setBounds(105, 400, 200, 60);
		panelsignup.add(login_btn);
		
		RSMaterialButtonCircle signup_btn = new RSMaterialButtonCircle();
		signup_btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				SignupPage sign = new SignupPage();
				sign.setVisible(true);
				dispose();
			}
		});
		signup_btn.setText("SignUp");
		signup_btn.setForeground(new Color(2, 43, 84));
		signup_btn.setFont(new Font("Dialog", Font.BOLD, 30));
		signup_btn.setBackground(Color.WHITE);
		signup_btn.setBounds(105, 500, 200, 60);
		panelsignup.add(signup_btn);
		
		txtusr = new JCTextField();
		txtusr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Connection con = DBConnection.getConnection();
					Statement stmt = con.createStatement();
					String sql = "Select * from admin_ms where usrName='"+txtusr.getText()+"'";
			           ResultSet res = stmt.executeQuery(sql);
			           if(res.next()) {
			        	   if(!res.getString(1).equals(txtusr.getText()))
			        	   {
			        		   JOptionPane.showConfirmDialog(null, "UserName Not Exict");
			        		   txtusr.setText(null);
			        	   }
			           }
			           else {
			        	   JOptionPane.showConfirmDialog(null, "UserName Not Exict");
			        	   txtusr.setText(null);
			           }
				}catch(Exception e1) {}
			}
		});
		txtusr.setBounds(80, 169, 290, 32);
		panelsignup.add(txtusr);
		
		txtpsw = new RSPasswordTextPlaceHolder();
		txtpsw.setBounds(80, 245, 290, 32);
		panelsignup.add(txtpsw);
		
		
	}
	
	
	public boolean ValidateBlank() {
		String name = txtusr.getText();
		@SuppressWarnings("deprecation")
		String psw = txtpsw.getText();
		
		if(name.equals("") || psw.equals("")){
			JOptionPane.showConfirmDialog(null, "Please Enter Data in blank field");
			return false;
		}
		return true;
	}
	
	//validate
	@SuppressWarnings("deprecation")
	public boolean validateDuplicateLogin()
	{
       try {
    	   Connection con = DBConnection.getConnection();
           Statement pst = con.createStatement();
           String sql = "Select * from admin_ms where usrName='"+txtusr.getText()+"' and usrPassword='"+txtpsw.getText()+"'";
           ResultSet res = pst.executeQuery(sql);
           if(res.next()) {
        	   if(res.getString(2).equals(txtpsw.getText()))
        	   {
        		   Loginpage.Name = txtusr.getText();
                   return true;
        	   }
        	   else {
        		   JOptionPane.showConfirmDialog(null, "Password is wrong");
        	   }
           }
           else {
               JOptionPane.showConfirmDialog(null, "User Not Found");
           }
		}catch(Exception e) {}
		return false;
	}
	
}
