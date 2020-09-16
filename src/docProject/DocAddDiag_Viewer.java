package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DocAddDiag_Viewer extends JFrame
{
	private List<Diagnosis> diag_list=new ArrayList<>();
	private Doctor doctor;
	private Patient patient;
	private JPanel contentPane;
	private JTextField textField_diag;
	private JTextField textField_detail;
	private JTextField textField_by;
	private JLabel lblId;
	private JLabel lblSsn;
	private JTextArea textArea_note;
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
					DocAddDiag_Viewer frame = new DocAddDiag_Viewer();
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
	public DocAddDiag_Viewer()
	{
		setTitle("Add Diagnosis");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocAddDiag_Viewer.class.getResource("/Icon/paper_plane.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 445);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblDoctorId.setBounds(10, 10, 147, 27);
		contentPane.add(lblDoctorId);
		
		JLabel lblPatientSsn = new JLabel("Patient SSN:");
		lblPatientSsn.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblPatientSsn.setBounds(10, 47, 147, 27);
		contentPane.add(lblPatientSsn);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis:");
		lblDiagnosis.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblDiagnosis.setBounds(10, 84, 147, 27);
		contentPane.add(lblDiagnosis);
		
		JLabel lblResultby = new JLabel("Cure Method by:");
		lblResultby.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblResultby.setBounds(10, 121, 147, 27);
		contentPane.add(lblResultby);
		
		JLabel lblMethodDetail = new JLabel("Method Detail:");
		lblMethodDetail.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblMethodDetail.setBounds(10, 158, 147, 27);
		contentPane.add(lblMethodDetail);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblNote.setBounds(10, 195, 147, 27);
		contentPane.add(lblNote);
		
		textArea_note = new JTextArea();
		textArea_note.setBackground(SystemColor.inactiveCaption);
		textArea_note.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		textArea_note.setBounds(10, 226, 368, 122);
		contentPane.add(textArea_note);
		
		textField_diag = new JTextField();
		textField_diag.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		textField_diag.setBounds(167, 84, 211, 27);
		contentPane.add(textField_diag);
		textField_diag.setColumns(10);
		
		textField_detail = new JTextField();
		textField_detail.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		textField_detail.setColumns(10);
		textField_detail.setBounds(167, 158, 211, 27);
		contentPane.add(textField_detail);
		
		textField_by = new JTextField();
		textField_by.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		textField_by.setColumns(10);
		textField_by.setBounds(167, 121, 211, 27);
		contentPane.add(textField_by);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblId.setBounds(167, 10, 211, 27);
		contentPane.add(lblId);
		
		lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		lblSsn.setBounds(167, 47, 211, 27);
		contentPane.add(lblSsn);
		
		JButton btnNewButton = new JButton("Add Note");
		btnNewButton.setIcon(new ImageIcon(DocAddDiag_Viewer.class.getResource("/Icon/tag.png")));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Diagnosis diagnosis=new Diagnosis(patient.getSSN(),doctor.getID(),textField_diag.getText(),textField_by.getText(),textField_detail.getText(),textArea_note.getText());
				diag_list.add(diagnosis);
				try
				{
					XML_Reader reader=new XML_Reader();
					reader.write_NewDiagnosis(diag_list);
					dispose();
				}
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 362, 368, 36);
		contentPane.add(btnNewButton);
	}
	
	public void set_default(List<Diagnosis> list,Doctor d,Patient p)
	{
		this.diag_list=list;
		this.doctor=d;
		this.patient=p;
		this.lblId.setText(doctor.getID());
		this.lblSsn.setText(patient.getSSN());
	}
}
