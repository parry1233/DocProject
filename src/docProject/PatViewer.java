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
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class PatViewer extends JFrame
{
	private List<Appointment> appList;
	private List<Server> doc_ServerList=new ArrayList<>();
	private Patient thisPatient;
	private JPanel contentPane;
	private JTextArea textArea;
	private JLabel lblssn_default;
	private JLabel lblpw;
	private JLabel lblName;
	
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
					PatViewer frame = new PatViewer();
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
	public PatViewer() throws XMLStreamException, IOException
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PatViewer.class.getResource("/Icon/paper_plane.png")));
		setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		XML_Reader reader = new XML_Reader();
		setTitle("Patient View");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 549);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icon = new JLabel("");
		icon.setBounds(413, 10, 294, 276);
		contentPane.add(icon);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblSsn.setBounds(10, 64, 111, 59);
		contentPane.add(lblSsn);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblPassword.setBounds(10, 114, 111, 59);
		contentPane.add(lblPassword);
		
		lblName = new JLabel("Firstname");
		lblName.setForeground(new Color(0, 0, 128));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 28));
		lblName.setBounds(10, 10, 356, 59);
		contentPane.add(lblName);
		
		lblssn_default = new JLabel("預設SSN");
		lblssn_default.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblssn_default.setBounds(131, 64, 244, 59);
		contentPane.add(lblssn_default);
		
		lblpw = new JLabel("預設PW");
		lblpw.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblpw.setBounds(131, 114, 244, 59);
		contentPane.add(lblpw);
		
		textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBounds(413, 296, 294, 206);
		contentPane.add(textArea);
		
		JButton btnEditPersonalInformation = new JButton("Edit personal information");
		btnEditPersonalInformation.setBackground(Color.LIGHT_GRAY);
		btnEditPersonalInformation.setIcon(new ImageIcon(PatViewer.class.getResource("/Icon/edit.png")));
		btnEditPersonalInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Patient_Edit_Viewer viewer;
				try
				{
					viewer = new Patient_Edit_Viewer();
					viewer.setVisible(true);
					viewer.set_default(thisPatient);
					dispose();
				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnEditPersonalInformation.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 24));
		btnEditPersonalInformation.setBounds(10, 183, 356, 50);
		contentPane.add(btnEditPersonalInformation);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.setBackground(Color.LIGHT_GRAY);
		btnReserve.setIcon(new ImageIcon(PatViewer.class.getResource("/Icon/reserve.png")));
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ClientReversing_Viewer viewer=new ClientReversing_Viewer();
				viewer.setVisible(true);
				viewer.getServerList(doc_ServerList,thisPatient);
			}
		});
		btnReserve.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 24));
		btnReserve.setBounds(10, 243, 356, 50);
		contentPane.add(btnReserve);
		
		JButton btnCheckAppointment = new JButton("Check Appointment");
		btnCheckAppointment.setBackground(Color.LIGHT_GRAY);
		btnCheckAppointment.setIcon(new ImageIcon(PatViewer.class.getResource("/Icon/appointment.png")));
		btnCheckAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(reader.allAPPread()!=null)
				{
					appList=reader.allAPPread();
					List<Appointment> thisList=new ArrayList<Appointment>();
					
					for(Appointment a:appList)
					{
						if(a.getPAtID().equals(thisPatient.getSSN()))
						{
							thisList.add(a);
						}
					}
					
					try
					{
						PatAppoint_Viewer viewer=new PatAppoint_Viewer();
						viewer.set_default(thisList);
						viewer.setVisible(true);
					}
					catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "沒有掛號紀錄", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCheckAppointment.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 24));
		btnCheckAppointment.setBounds(10, 303, 356, 50);
		contentPane.add(btnCheckAppointment);
	}
	
	public void setDefault(Patient p)
	{
		this.thisPatient=p;
		lblssn_default.setText(p.getSSN());
		lblpw.setText(p.getPW());
		lblName.setText(p.getFname()+" "+p.getLname());
		
		String string="";
		string+="Address: "+p.getAddress()+"\n";
		string+="Phone Number: "+p.getNumber()+"\n";
		string+="Birth: "+p.getBirth()+"\n";
		string+="Blood: "+p.getBlood()+"\n";
		string+="Height: "+p.getHeight()+"\n";
		string+="Weight: "+p.getWeight()+"\n";
		string+="Info: "+p.getInfo()+"\n";
		
		textArea.setText(string);
	}
	
	public void getServer(List<Server> list)
	{
		this.doc_ServerList=list;
	}
}
