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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class DocViewer extends JFrame
{
	private Doctor thisDoctor;
	private List<Appointment> appList;
	private JLabel IDinput;
	private JLabel FNAMEinput;
	private JLabel PWinput;
	private JLabel DPinput;
	private JLabel NUMinput;
	private JButton btnEditInformation;
	private JButton btnReservedPatients;
	private JButton btnOFTime;
	private JLabel LNameInput;
	
	private String name_edit;
	private String phone_edit;
	private String pw_edit;
	private JPanel panel;
	private JButton btnViewAllPatients;
	private JLabel lblNewLabel;
	public Server server;
	private JButton btnViewAppointment;

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
					DocViewer frame = new DocViewer();
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
	public DocViewer() throws XMLStreamException, IOException
	{
		setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocViewer.class.getResource("/Icon/paper_plane.png")));	
		XML_Reader reader = new XML_Reader();
		setTitle("DoctorView");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 555);
		panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblD = new JLabel("ID:");
		lblD.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblD.setBounds(10, 10, 173, 59);
		panel.add(lblD);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblName.setBounds(10, 64, 173, 59);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblPassword.setBounds(10, 172, 173, 59);
		panel.add(lblPassword);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblDepartment.setBounds(10, 226, 173, 59);
		panel.add(lblDepartment);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblPhoneNumber.setBounds(10, 280, 188, 59);
		panel.add(lblPhoneNumber);
		
		IDinput = new JLabel("預設ID");
		IDinput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		IDinput.setBounds(220, 10, 244, 59);
		panel.add(IDinput);
		
		FNAMEinput = new JLabel("預設名稱");
		FNAMEinput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		FNAMEinput.setBounds(220, 64, 244, 59);
		panel.add(FNAMEinput);
		
		PWinput = new JLabel("預設密碼");
		PWinput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		PWinput.setBounds(220, 172, 244, 59);
		panel.add(PWinput);
		
		DPinput = new JLabel("預設部門");
		DPinput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		DPinput.setBounds(220, 226, 244, 59);
		panel.add(DPinput);
		
		NUMinput = new JLabel("預設號碼");
		NUMinput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		NUMinput.setBounds(220, 280, 244, 59);
		panel.add(NUMinput);
		
		btnEditInformation = new JButton("Edit Information");
		btnEditInformation.setBackground(Color.LIGHT_GRAY);
		btnEditInformation.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/edit.png")));
		btnEditInformation.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		btnEditInformation.setBounds(37, 353, 223, 39);
		panel.add(btnEditInformation);
		
		btnOFTime = new JButton("Edit Office Time");
		btnOFTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOFTime.setBackground(Color.LIGHT_GRAY);
		btnOFTime.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/officetime.png")));
		btnOFTime.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnOFTime.setBounds(387, 322, 262, 39);
		panel.add(btnOFTime);
		
		btnReservedPatients = new JButton("History Patients");
		btnReservedPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservedPatients.setBackground(Color.LIGHT_GRAY);
		btnReservedPatients.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/patients.png")));
		btnReservedPatients.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnReservedPatients.setBounds(387, 371, 262, 39);
		panel.add(btnReservedPatients);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		lblLastName.setBounds(10, 118, 173, 59);
		panel.add(lblLastName);
		
		LNameInput = new JLabel("預設名稱");
		LNameInput.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		LNameInput.setBounds(220, 118, 244, 59);
		panel.add(LNameInput);
		
		btnViewAllPatients = new JButton("View All Patients");
		btnViewAllPatients.setBackground(Color.LIGHT_GRAY);
		btnViewAllPatients.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/view.png")));
		btnViewAllPatients.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnViewAllPatients.setBounds(387, 420, 262, 39);
		panel.add(btnViewAllPatients);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/tumblr_pf83uw6Z5m1xzv69ro9_400.png")));
		lblNewLabel.setBounds(386, 10, 280, 290);
		panel.add(lblNewLabel);
		
		btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.setBackground(Color.LIGHT_GRAY);
		btnViewAppointment.setIcon(new ImageIcon(DocViewer.class.getResource("/Icon/appointment.png")));
		btnViewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<Doctor> doclist=new ArrayList<Doctor>();
				doclist=reader.all_DOCread();
				for(Doctor d: doclist)
				{
					if(d.getID().equals(IDinput.getText()))
					{
						thisDoctor=d;
					}
				}
				
				if(reader.allAPPread()!=null)
				{
					appList=reader.allAPPread();
					List<Appointment> thisList=new ArrayList<Appointment>();
					
					for(Appointment a:appList)
					{
						if(a.getDocID().equals(thisDoctor.getID()))
						{
							thisList.add(a);
						}
					}
					
					try
					{
						if(thisList.size()!=0)
						{
							DocAppoint_Viewer viewer=new DocAppoint_Viewer();
							viewer.set_defalut(thisList,thisDoctor);
							viewer.setVisible(true);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "沒有掛號紀錄", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
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
		btnViewAppointment.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnViewAppointment.setBounds(387, 469, 262, 39);
		panel.add(btnViewAppointment);
	}


	public void set_default_info(ArrayList<String> info)
	{
		IDinput.setText(info.get(0));
		PWinput.setText(info.get(1));
		FNAMEinput.setText(info.get(2));
		LNameInput.setText(info.get(3));
		DPinput.setText(info.get(4));
		NUMinput.setText(info.get(5));
		
		btnEditInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Edit_Info editor=new Edit_Info();
				editor.setVisible(true);
				editor.set_default_text(info.get(0),info.get(1),info.get(2),info.get(3),info.get(4),info.get(5));
				dispose();
			}
		});
		
		btnOFTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				OfficeTWindow officeTWindow=new OfficeTWindow();
				officeTWindow.setVisible(true);
				officeTWindow.set_idpw(info.get(0),info.get(1));
				officeTWindow.set_default_radio();
				dispose();
			}
		});
		
		btnReservedPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					XML_Reader reader=new XML_Reader();
					ArrayList<ArrayList<String>> temp=reader.matches_check(info.get(0));
					if(temp.get(0).size()!=0)
					{
						HistoryDiagViewer viewer=new HistoryDiagViewer();
						viewer.setVisible(true);
						viewer.set_default_info(info.get(0));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "無任何歷史病患資料!", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnViewAllPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				All_PatViewer viewer;
				try
				{
					viewer = new All_PatViewer();
					viewer.setVisible(true);
				}
				catch (XMLStreamException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
