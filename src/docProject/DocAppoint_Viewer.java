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
import java.util.List;

import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class DocAppoint_Viewer extends JFrame
{
	private JTextArea textArea_name;
	private JTextArea textArea_ID;
	private JTextArea textArea_Info;
	private JTextArea textArea_day;
	private JPanel contentPane;

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
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientName.setBounds(161, 64, 119, 24);
		contentPane.add(lblPatientName);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientId.setBounds(334, 64, 86, 24);
		contentPane.add(lblPatientId);
		
		JLabel lblPatientInfo = new JLabel("Patient Info");
		lblPatientInfo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblPatientInfo.setBounds(484, 64, 106, 24);
		contentPane.add(lblPatientInfo);
		
		textArea_name = new JTextArea();
		textArea_name.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_name.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		textArea_name.setEditable(false);
		textArea_name.setBounds(147, 98, 149, 280);
		contentPane.add(textArea_name);
		
		textArea_ID = new JTextArea();
		textArea_ID.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_ID.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		textArea_ID.setEditable(false);
		textArea_ID.setBounds(306, 98, 146, 280);
		contentPane.add(textArea_ID);
		
		textArea_Info = new JTextArea();
		textArea_Info.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_Info.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		textArea_Info.setEditable(false);
		textArea_Info.setBounds(462, 98, 149, 280);
		contentPane.add(textArea_Info);
		
		textArea_day = new JTextArea();
		textArea_day.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_day.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		textArea_day.setEditable(false);
		textArea_day.setBounds(10, 98, 127, 280);
		contentPane.add(textArea_day);
		
		JLabel lblReversedDay = new JLabel("Reversed Day");
		lblReversedDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblReversedDay.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		lblReversedDay.setBounds(10, 64, 127, 24);
		contentPane.add(lblReversedDay);
		
		JLabel lblNotePatientInfo = new JLabel("Note: Patient Info is in the order of height>weight>blood-type");
		lblNotePatientInfo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNotePatientInfo.setBounds(223, 388, 398, 24);
		contentPane.add(lblNotePatientInfo);
	}
	
	public void set_defalut(List<Appointment> list) throws XMLStreamException, IOException
	{
		XML_Reader reader=new XML_Reader();
		List<Patient> patList=reader.all_PATread();
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		for(Appointment a:list)
		{
			for(Patient p:patList)
			{
				if(a.getPAtID().equals(p.getSSN()))
				{
					s1+=a.getDay()+"\n";
					s2+=p.getFname()+"\n";
					s3+=p.getSSN()+"\n";
					s4+=p.getHeight()+"-"+p.getWeight()+"-"+p.getBlood()+"\n";
				}
			} 
		}
		this.textArea_day.setText(s1);
		this.textArea_name.setText(s2);
		this.textArea_ID.setText(s3);
		this.textArea_Info.setText(s4);
	}

}
