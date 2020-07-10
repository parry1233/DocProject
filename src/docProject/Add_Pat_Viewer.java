package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Add_Pat_Viewer extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_ssn;
	private JTextField textField_fname;
	private JTextField textField_lname;
	private JTextField textField_address;
	private JTextField textField_number;
	private JTextField textField_height;
	private JTextField textField_weight;
	private JTextField textField_blood;
	private JTextField textField_birth;
	private JTextField textField_info;

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
					Add_Pat_Viewer frame = new Add_Pat_Viewer();
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
	public Add_Pat_Viewer()
	{
		setTitle("Add Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPatientFName = new JLabel("Patient First Name:");
		lblPatientFName.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientFName.setBounds(10, 71, 237, 31);
		panel.add(lblPatientFName);
		
		textField_ssn = new JTextField();
		textField_ssn.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_ssn.setBounds(257, 32, 295, 31);
		panel.add(textField_ssn);
		textField_ssn.setColumns(10);
		
		JLabel lblPatientLName = new JLabel("Patient Last Name:");
		lblPatientLName.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientLName.setBounds(10, 114, 237, 31);
		panel.add(lblPatientLName);
		
		JLabel lblPatientSsn = new JLabel("Patient Personal SSN:");
		lblPatientSsn.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientSsn.setBounds(10, 30, 220, 31);
		panel.add(lblPatientSsn);
		
		JLabel lblPatientBirthday = new JLabel("Patient Birthday:");
		lblPatientBirthday.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientBirthday.setBounds(10, 360, 237, 31);
		panel.add(lblPatientBirthday);
		
		JLabel lblPatientBloodtype = new JLabel("Patient Blood Type:");
		lblPatientBloodtype.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientBloodtype.setBounds(10, 319, 237, 31);
		panel.add(lblPatientBloodtype);
		
		JLabel lblPatientNumber = new JLabel("Patient Phone Number:");
		lblPatientNumber.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientNumber.setBounds(10, 196, 237, 31);
		panel.add(lblPatientNumber);
		
		JLabel lblPatientAddress = new JLabel("Patient Address:");
		lblPatientAddress.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientAddress.setBounds(10, 155, 237, 31);
		panel.add(lblPatientAddress);
		
		JLabel lblPatientHeight = new JLabel("Patient Height:");
		lblPatientHeight.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientHeight.setBounds(10, 237, 237, 31);
		panel.add(lblPatientHeight);
		
		JLabel lblPatientWeight = new JLabel("Patient Weight:");
		lblPatientWeight.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientWeight.setBounds(10, 278, 237, 31);
		panel.add(lblPatientWeight);
		
		JLabel lblPatientInformation = new JLabel("Patient Information:");
		lblPatientInformation.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPatientInformation.setBounds(10, 401, 237, 31);
		panel.add(lblPatientInformation);
		
		textField_fname = new JTextField();
		textField_fname.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_fname.setColumns(10);
		textField_fname.setBounds(257, 71, 295, 31);
		panel.add(textField_fname);
		
		textField_lname = new JTextField();
		textField_lname.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_lname.setColumns(10);
		textField_lname.setBounds(257, 114, 295, 31);
		panel.add(textField_lname);
		
		textField_address = new JTextField();
		textField_address.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_address.setColumns(10);
		textField_address.setBounds(257, 155, 295, 31);
		panel.add(textField_address);
		
		textField_number = new JTextField();
		textField_number.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_number.setColumns(10);
		textField_number.setBounds(257, 196, 295, 31);
		panel.add(textField_number);
		
		textField_height = new JTextField();
		textField_height.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_height.setColumns(10);
		textField_height.setBounds(257, 237, 295, 31);
		panel.add(textField_height);
		
		textField_weight = new JTextField();
		textField_weight.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_weight.setColumns(10);
		textField_weight.setBounds(257, 278, 295, 31);
		panel.add(textField_weight);
		
		textField_blood = new JTextField();
		textField_blood.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_blood.setColumns(10);
		textField_blood.setBounds(257, 319, 295, 31);
		panel.add(textField_blood);
		
		textField_birth = new JTextField();
		textField_birth.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_birth.setColumns(10);
		textField_birth.setBounds(257, 360, 295, 31);
		panel.add(textField_birth);
		
		textField_info = new JTextField();
		textField_info.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_info.setColumns(10);
		textField_info.setBounds(257, 401, 295, 31);
		panel.add(textField_info);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Patient patient=new Patient();
				patient=new Patient(textField_ssn.getText(),textField_birth.getText(),textField_fname.getText(),textField_lname.getText(),textField_address.getText(),textField_number.getText(),textField_height.getText(),textField_weight.getText(),textField_blood.getText(),textField_birth.getText(),textField_info.getText());
				
				try
				{
					All_PatViewer viewer = new All_PatViewer();
					viewer.addnew_pat(patient);
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
				dispose();
			}
		});
		btnSaveButton.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnSaveButton.setBounds(10, 442, 542, 39);
		panel.add(btnSaveButton);
	}
}
