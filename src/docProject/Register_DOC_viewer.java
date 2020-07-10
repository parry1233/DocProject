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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Register_DOC_viewer extends JFrame
{
	private List<Doctor> docList;
	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_pw;
	private JTextField textField_fname;
	private JTextField textField_lname;
	private JTextField textField_number;

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
					Register_DOC_viewer frame = new Register_DOC_viewer();
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
	public Register_DOC_viewer()
	{
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Personal ID:");
		lblId.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblId.setBounds(10, 10, 150, 31);
		panel.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPassword.setBounds(10, 51, 150, 31);
		panel.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblFirstName.setBounds(10, 92, 150, 31);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblLastName.setBounds(10, 133, 150, 31);
		panel.add(lblLastName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblDepartment.setBounds(10, 174, 150, 31);
		panel.add(lblDepartment);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblPhoneNumber.setBounds(10, 215, 150, 31);
		panel.add(lblPhoneNumber);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_id.setBounds(170, 14, 202, 31);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		textField_pw = new JTextField();
		textField_pw.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_pw.setColumns(10);
		textField_pw.setBounds(170, 51, 202, 31);
		panel.add(textField_pw);
		
		textField_fname = new JTextField();
		textField_fname.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_fname.setColumns(10);
		textField_fname.setBounds(170, 92, 202, 31);
		panel.add(textField_fname);
		
		textField_lname = new JTextField();
		textField_lname.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_lname.setColumns(10);
		textField_lname.setBounds(170, 133, 202, 31);
		panel.add(textField_lname);
		
		textField_number = new JTextField();
		textField_number.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_number.setColumns(10);
		textField_number.setBounds(170, 215, 202, 31);
		panel.add(textField_number);
		
		JComboBox dep_comboBox = new JComboBox();
		dep_comboBox.setFont(new Font("新細明體", Font.PLAIN, 25));
		dep_comboBox.setModel(new DefaultComboBoxModel(new String[] {"administrator", "dentist", "pediatrics", "surgical"}));
		dep_comboBox.setBounds(170, 174, 202, 31);
		panel.add(dep_comboBox);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				List<Doctor> doclist;
				try
				{
					doclist=read();
					ArrayList<String> daily=new ArrayList<>();
					daily.add("TTT");
					Doctor doctor=new Doctor(textField_id.getText(), textField_pw.getText(), textField_fname.getText(), textField_lname.getText(), String.valueOf(dep_comboBox.getSelectedItem()), textField_number.getText(), daily.get(0), daily.get(0), daily.get(0), daily.get(0), daily.get(0), daily.get(0), daily.get(0));
					doclist.add(doctor);
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try
				{
					XML_Reader reader=new XML_Reader();
					reader.write_NewDoc(docList);
				}
				catch (Exception e) 
				{
					// TODO: handle exception
					e.printStackTrace();
				}
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnNewButton.setBounds(382, 211, 225, 39);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\chpar\\OneDrive\\Pictures\\下載.png"));
		lblNewLabel.setBounds(382, 10, 225, 190);
		panel.add(lblNewLabel);
		
	}
	
	public List<Doctor> read() throws XMLStreamException, IOException
	{
		XML_Reader reader=new XML_Reader();
		docList=reader.all_DOCread();
		return docList;
	}
}
