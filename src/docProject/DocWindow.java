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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class DocWindow extends JFrame
{
	private List<Doctor> docList;
	private JPanel contentPane;
	private JTextField doctorID;
	private JPasswordField doctorPW;

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
					DocWindow frame = new DocWindow();
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
	public DocWindow() throws XMLStreamException, IOException
	{
		setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocWindow.class.getResource("/Icon/paper_plane.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Doctor Host");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorId.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 23));
		lblDoctorId.setBounds(38, 38, 132, 38);
		contentPane.add(lblDoctorId);
		
		doctorID = new JTextField();
		doctorID.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		doctorID.setBounds(201, 40, 174, 38);
		contentPane.add(doctorID);
		doctorID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 23));
		lblPassword.setBounds(38, 123, 132, 34);
		contentPane.add(lblPassword);
		
		doctorPW = new JPasswordField();
		doctorPW.setFont(new Font("新細明體", Font.PLAIN, 13));
		doctorPW.setBounds(201, 123, 174, 38);
		contentPane.add(doctorPW);
		
		XML_Reader reader=new XML_Reader();
		docList=reader.all_DOCread();
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon(DocWindow.class.getResource("/Icon/login (1).png")));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String[] id_pw=new String[2];
				id_pw[0]=doctorID.getText();
				id_pw[1]=new String(doctorPW.getPassword());
				ArrayList<String> temp=new ArrayList<>();
				for(Doctor d:docList)
				{
					if(id_pw[0].equals(d.getID()))
					{
						if(id_pw[1].equals(d.getPW()))
						{
							temp.add(d.getID());
							temp.add(d.getPW());
							temp.add(d.getFName());
							temp.add(d.getLName());
							temp.add(d.getDep());
							temp.add(d.getPhone());
							break;
						}
					}
				}
				if(temp.size()==6)
				{
					try
					{
						DocViewer viewer=new DocViewer();
						viewer.set_default_info(temp);
						viewer.setVisible(true);
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
					/*XML_Reader reader = new XML_Reader();
					ArrayList<String> temp=reader.LoginCheck(id_pw[0], id_pw[1]);
					if(temp!=null)
					{
						DocViewer viewer=new DocViewer();
						viewer.set_default_info(temp);
						viewer.setVisible(true);
						setVisible(false);
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
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		btnNewButton.setBounds(243, 204, 142, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setIcon(new ImageIcon(DocWindow.class.getResource("/Icon/register.png")));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Register_DOC_viewer viewer=new Register_DOC_viewer();
				viewer.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		btnNewButton_1.setBounds(68, 204, 142, 38);
		contentPane.add(btnNewButton_1);
		
	}
}
