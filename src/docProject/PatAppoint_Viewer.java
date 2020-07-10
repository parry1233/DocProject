package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class PatAppoint_Viewer extends JFrame
{

	private JPanel contentPane;
	private JTextArea Depart_textArea;
	private JTextArea day_textArea;
	private JTextArea DoctortextArea;

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
					PatAppoint_Viewer frame = new PatAppoint_Viewer();
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
	public PatAppoint_Viewer()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(PatAppoint_Viewer.class.getResource("/Icon/paper_plane.png")));
		setTitle("Patient's Apointment Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 431);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppointmentInformation = new JLabel("Patient's Appointment Information");
		lblAppointmentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentInformation.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		lblAppointmentInformation.setBounds(31, 10, 371, 34);
		contentPane.add(lblAppointmentInformation);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		lblDoctor.setBounds(20, 54, 73, 34);
		contentPane.add(lblDoctor);
		
		JLabel lblDoctorsDepartment = new JLabel("Doctor's Department");
		lblDoctorsDepartment.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		lblDoctorsDepartment.setBounds(103, 54, 174, 34);
		contentPane.add(lblDoctorsDepartment);
		
		JLabel lblReversedDay = new JLabel("Reversed day");
		lblReversedDay.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		lblReversedDay.setBounds(298, 54, 127, 34);
		contentPane.add(lblReversedDay);
		
		DoctortextArea = new JTextArea();
		DoctortextArea.setBackground(SystemColor.inactiveCaptionBorder);
		DoctortextArea.setEditable(false);
		DoctortextArea.setBounds(10, 98, 83, 286);
		contentPane.add(DoctortextArea);
		
		Depart_textArea = new JTextArea();
		Depart_textArea.setBackground(SystemColor.inactiveCaptionBorder);
		Depart_textArea.setEditable(false);
		Depart_textArea.setBounds(103, 98, 174, 286);
		contentPane.add(Depart_textArea);
		
		day_textArea = new JTextArea();
		day_textArea.setBackground(SystemColor.inactiveCaptionBorder);
		day_textArea.setEditable(false);
		day_textArea.setBounds(287, 98, 131, 286);
		contentPane.add(day_textArea);
	}
	
	public void set_default(List<Appointment> list) throws XMLStreamException, IOException
	{
		XML_Reader reader=new XML_Reader();
		List<Doctor> docList=reader.all_DOCread();
		String s1="";
		String s2="";
		String s3="";
		for(Appointment a:list)
		{
			for(Doctor d:docList)
			{
				if(a.getDocID().equals(d.getID()))
				{
					s1+=d.getFName()+"\n";
					s2+=d.getDep()+"\n";
				}
			}
			s3+=a.getDay()+"\n";
		}
		this.DoctortextArea.setText(s1);
		this.Depart_textArea.setText(s2);
		this.day_textArea.setText(s3);
	}
}
