package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.GrayFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DocAppoint_Viewer extends JFrame
{
	private DefaultListModel<Appointment> listModel=new DefaultListModel<>();
	private JList<Appointment> jlist;
	private JPanel contentPane;
	private JLabel lblSsn ;
	private JLabel lblName;
	private JLabel lblBirthday;
	private JLabel lblHeight;
	private JLabel lblDay;
	private JLabel lblWeight;
	private JLabel lblBloodtype;
	private Doctor doctor;
	private Patient patient;

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
					DocAppoint_Viewer frame = new DocAppoint_Viewer();
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
	 */
	public DocAppoint_Viewer()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocAppoint_Viewer.class.getResource("/Icon/paper_plane.png")));
		setTitle("Patient's Appointment View ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 453);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patients' Appointment View");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 601, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblPatientInfo = new JLabel("---- Patient Info ----");
		lblPatientInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientInfo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientInfo.setBounds(350, 124, 200, 24);
		contentPane.add(lblPatientInfo);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 49, 275, 357);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		jlist = new JList<>();
		jlist.setBackground(SystemColor.inactiveCaptionBorder);
		jlist.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		jlist.setVisibleRowCount(17);
		scrollPane.setViewportView(jlist);
		
		JLabel lblPatientSsn = new JLabel("Patient SSN:");
		lblPatientSsn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientSsn.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientSsn.setBounds(295, 158, 136, 24);
		contentPane.add(lblPatientSsn);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientName.setBounds(295, 192, 136, 24);
		contentPane.add(lblPatientName);
		
		JLabel lblPatientBirthday = new JLabel("Patient Birth:");
		lblPatientBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientBirthday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientBirthday.setBounds(295, 226, 136, 24);
		contentPane.add(lblPatientBirthday);
		
		JLabel lblPatientHeight = new JLabel("Patient Height:");
		lblPatientHeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientHeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientHeight.setBounds(295, 260, 136, 24);
		contentPane.add(lblPatientHeight);
		
		JLabel lblPatientWeight = new JLabel("Patient Weight:");
		lblPatientWeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientWeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientWeight.setBounds(295, 294, 136, 24);
		contentPane.add(lblPatientWeight);
		
		JLabel lblPatientBlood = new JLabel("Patient Blood:");
		lblPatientBlood.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatientBlood.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientBlood.setBounds(295, 328, 136, 24);
		contentPane.add(lblPatientBlood);
		
		lblSsn = new JLabel("SSN");
		lblSsn.setHorizontalAlignment(SwingConstants.LEFT);
		lblSsn.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblSsn.setBounds(441, 158, 170, 24);
		contentPane.add(lblSsn);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblName.setBounds(441, 192, 170, 24);
		contentPane.add(lblName);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblBirthday.setBounds(441, 226, 170, 24);
		contentPane.add(lblBirthday);
		
		lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblHeight.setBounds(441, 260, 170, 24);
		contentPane.add(lblHeight);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblWeight.setBounds(441, 294, 170, 24);
		contentPane.add(lblWeight);
		
		lblBloodtype = new JLabel("Bloodtype");
		lblBloodtype.setHorizontalAlignment(SwingConstants.LEFT);
		lblBloodtype.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblBloodtype.setBounds(441, 328, 170, 24);
		contentPane.add(lblBloodtype);
		
		JButton btnAddDiagnose = new JButton("Add Diagnose");
		btnAddDiagnose.setIcon(new ImageIcon(DocAppoint_Viewer.class.getResource("/Icon/officetime.png")));
		btnAddDiagnose.setBackground(Color.LIGHT_GRAY);
		btnAddDiagnose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<Diagnosis> list=new ArrayList<>();
				List<Patient> patlist=new ArrayList<>();
				try
				{
					XML_Reader reader=new XML_Reader();
					list=reader.allDIAGread();
					patlist=reader.all_PATread();
				} catch (Exception e2)
				{
					// TODO: handle exception
				}
				
				for(Patient p:patlist)
				{
					if(jlist.getSelectedValue().getPAtID().equals(p.getSSN()))
					{
						patient=p;
					}
				}
				DocAddDiag_Viewer viewer=new DocAddDiag_Viewer();
				viewer.set_default(list, doctor, patient);
				viewer.setVisible(true);
			}
		});
		btnAddDiagnose.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		btnAddDiagnose.setBounds(411, 362, 200, 44);
		contentPane.add(btnAddDiagnose);
		
		JLabel lblAppointment = new JLabel("---- Appointment ----");
		lblAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointment.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblAppointment.setBounds(350, 49, 200, 24);
		contentPane.add(lblAppointment);
		
		JLabel lblAppointmentTime = new JLabel("Time:");
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblAppointmentTime.setBounds(295, 83, 136, 24);
		contentPane.add(lblAppointmentTime);
		
		lblDay = new JLabel("Day");
		lblDay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDay.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblDay.setBounds(441, 83, 170, 24);
		contentPane.add(lblDay);
	}
	
	public void set_defalut(List<Appointment> list,Doctor d) throws XMLStreamException, IOException
	{
		this.doctor=d;
		XML_Reader reader=new XML_Reader();
		List<Patient> patList=reader.all_PATread();
		for(Appointment a:list)
		{
			listModel.addElement(a);
		}
		jlist.setModel(listModel);
		jlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				for(Patient p:patList)
				{
					if(jlist.getSelectedValue().getPAtID().equals(p.getSSN()))
					{
						lblSsn.setText(p.getSSN());
						lblName.setText(p.getFname()+" "+p.getLname());
						lblBirthday.setText(p.getBirth());
						lblHeight.setText(p.getHeight());
						lblWeight.setText(p.getWeight());
						lblBloodtype.setText(p.getBlood());
						lblDay.setText(jlist.getSelectedValue().getDay());
					}
				}
			}
		});
		
	}
}
