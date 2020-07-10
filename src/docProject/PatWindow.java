package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class PatWindow extends JFrame
{
	private List<Patient> patList;
	private List<Server> doc_ServerList=new ArrayList<>();
	private JPanel contentPane;
	private JTextField textField_SSN;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PatWindow frame = new PatWindow();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws XMLStreamException 
	 */
	public PatWindow() throws XMLStreamException, IOException
	{
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PatWindow.class.getResource("/Icon/paper_plane.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient SSN");
		lblPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientId.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 25));
		lblPatientId.setBounds(10, 49, 166, 36);
		contentPane.add(lblPatientId);
		
		JLabel lblBirthex = new JLabel("Verify Code");
		lblBirthex.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthex.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 25));
		lblBirthex.setBounds(10, 95, 166, 36);
		contentPane.add(lblBirthex);
		
		textField_SSN = new JTextField();
		textField_SSN.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		textField_SSN.setBounds(186, 49, 211, 36);
		contentPane.add(textField_SSN);
		textField_SSN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("新細明體", Font.PLAIN, 13));
		passwordField.setBounds(186, 95, 211, 33);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("default will be your birth date(ex.19990101)");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblNewLabel.setBounds(177, 138, 259, 23);
		contentPane.add(lblNewLabel);
		
		XML_Reader reader=new XML_Reader();
		patList=reader.all_PATread();
		
		btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon(PatWindow.class.getResource("/Icon/login (1).png")));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index=0;
				boolean check=false;
				String[] id_pw=new String[2];
				id_pw[0]=textField_SSN.getText();
				id_pw[1]=new String(passwordField.getPassword());
				for(Patient p:patList)
				{
					if(id_pw[0].equals(p.getSSN()))
					{
						if(id_pw[1].equals(p.getPW()))
						{
							//PatViewer viewer=new viewer;
							//viewer.setvisible(true);
							//viewer.set_default_info(p);
							//setvisible(false);
							index=patList.indexOf(p);
							check=true;
							break;
						}
					}
				}
				
				if(check)
				{
					Patient patient=patList.get(index);
					//JOptionPane.showMessageDialog(null, "成功登入，但開發者尚未設計使用者視窗!", "SUCCESS", JOptionPane.WARNING_MESSAGE);
					
					try
					{
						PatViewer viewer=new PatViewer();
						viewer.setVisible(true);
						viewer.setDefault(patList.get(index));
						viewer.getServer(doc_ServerList);
						setVisible(false);
					} 
					catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				/*try
				{
					XML_Reader reader = new XML_Reader();
					ArrayList<String> temp=reader.Login_Pat_check(id_pw[0], id_pw[1]);
					if(temp!=null)
					{
						JOptionPane.showMessageDialog(null, "成功登入，但開發者尚未設計使用者視窗!", "SUCCESS", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 25));
		btnNewButton.setBounds(252, 194, 145, 43);
		contentPane.add(btnNewButton);
	}
	
	public void getServer(List<Server> list)
	{
		this.doc_ServerList=list;
	}

}
