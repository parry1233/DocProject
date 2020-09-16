package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Patient_Edit_Viewer extends JFrame
{
	private Patient thisPatient;
	private List<Patient> patList;
	private JPanel contentPane;
	private JLabel lblPassword;
	private JTextField textFieldPW;
	private JTextField textFieldFname;
	private JTextField textFieldLname;
	private JTextField textFieldAddress;
	private JTextField textFieldNumber;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textFieldBirth;
	private JTextField textFieldInfo;
	private JComboBox comboBoxBlood;

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
					Patient_Edit_Viewer frame = new Patient_Edit_Viewer();
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
	public Patient_Edit_Viewer() throws XMLStreamException, IOException
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Patient_Edit_Viewer.class.getResource("/Icon/paper_plane.png")));
		setTitle("Edit Information");
		XML_Reader reader=new XML_Reader();
		patList=reader.all_PATread();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblPassword.setBounds(10, 13, 126, 35);
		contentPane.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblFirstName.setBounds(10, 63, 126, 35);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblLastName.setBounds(10, 116, 126, 35);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblAddress.setBounds(10, 169, 126, 35);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumer = new JLabel("Phone:");
		lblPhoneNumer.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblPhoneNumer.setBounds(10, 222, 126, 35);
		contentPane.add(lblPhoneNumer);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblHeight.setBounds(10, 275, 126, 35);
		contentPane.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblWeight.setBounds(265, 275, 93, 35);
		contentPane.add(lblWeight);
		
		JLabel lblBlood = new JLabel("Blood:");
		lblBlood.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblBlood.setBounds(10, 328, 126, 35);
		contentPane.add(lblBlood);
		
		JLabel lblBirth = new JLabel("Birth:");
		lblBirth.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblBirth.setBounds(219, 328, 63, 35);
		contentPane.add(lblBirth);
		
		JLabel lblInfo = new JLabel("Information:");
		lblInfo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 23));
		lblInfo.setBounds(10, 381, 137, 35);
		contentPane.add(lblInfo);
		
		textFieldPW = new JTextField();
		textFieldPW.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldPW.setBounds(146, 13, 320, 35);
		contentPane.add(textFieldPW);
		textFieldPW.setColumns(10);
		
		textFieldFname = new JTextField();
		textFieldFname.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldFname.setColumns(10);
		textFieldFname.setBounds(146, 63, 320, 35);
		contentPane.add(textFieldFname);
		
		textFieldLname = new JTextField();
		textFieldLname.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldLname.setColumns(10);
		textFieldLname.setBounds(146, 116, 320, 35);
		contentPane.add(textFieldLname);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(146, 169, 320, 35);
		contentPane.add(textFieldAddress);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldNumber.setColumns(10);
		textFieldNumber.setBounds(146, 222, 320, 35);
		contentPane.add(textFieldNumber);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(146, 277, 109, 35);
		contentPane.add(textFieldHeight);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(357, 278, 109, 35);
		contentPane.add(textFieldWeight);
		
		textFieldBirth = new JTextField();
		textFieldBirth.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldBirth.setColumns(10);
		textFieldBirth.setBounds(292, 328, 174, 35);
		contentPane.add(textFieldBirth);
		
		comboBoxBlood = new JComboBox();
		comboBoxBlood.setForeground(new Color(255, 0, 0));
		comboBoxBlood.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 25));
		comboBoxBlood.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "AB", "O"}));
		comboBoxBlood.setBounds(146, 328, 63, 35);
		contentPane.add(comboBoxBlood);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		textFieldInfo.setColumns(10);
		textFieldInfo.setBounds(146, 381, 320, 35);
		contentPane.add(textFieldInfo);
		
		JButton btnNewButton = new JButton("Save Edit");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				thisPatient.setPW(textFieldPW.getText());
				thisPatient.setFname(textFieldFname.getText());
				thisPatient.setLname(textFieldLname.getText());
				thisPatient.setAddress(textFieldAddress.getText());
				thisPatient.setHeight(textFieldHeight.getText());
				thisPatient.setWeight(textFieldWeight.getText());
				thisPatient.setNumber(textFieldNumber.getText());
				thisPatient.setBirth(textFieldBirth.getText());
				thisPatient.setBlood(String.valueOf(comboBoxBlood.getSelectedItem()));
				thisPatient.setInfo(textFieldInfo.getText());
				
				int index=-1;
				for(Patient p:patList)
				{
					if(p.getSSN().equals(thisPatient.getSSN()))
					{
						index=patList.indexOf(p);
					}
				}
				patList.set(index, thisPatient);
				try
				{
					reader.write_NewPat(patList);
				} 
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
				
				try
				{
					PatViewer viewer=new PatViewer();
					viewer.setVisible(true);
					viewer.setDefault(patList.get(index));
					dispose();
				} 
				catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 26));
		btnNewButton.setBounds(10, 430, 479, 48);
		contentPane.add(btnNewButton);
	}
	
	public void set_default(Patient patient)
	{
		this.thisPatient=patient;
		setTitle(patient.getSSN());
		textFieldPW.setText(patient.getPW());
		textFieldFname.setText(patient.getFname());
		textFieldLname.setText(patient.getLname());
		textFieldAddress.setText(patient.getAddress());
		textFieldHeight.setText(patient.getHeight());
		textFieldWeight.setText(patient.getWeight());
		textFieldNumber.setText(patient.getNumber());
		textFieldBirth.setText(patient.getBirth());
		comboBoxBlood.setSelectedItem(patient.getBlood());
		textFieldInfo.setText(patient.getInfo());
	}
}
