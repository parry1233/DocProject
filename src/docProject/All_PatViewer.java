package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.stream.XMLStreamException;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class All_PatViewer extends JFrame
{
	private List<Patient> patList;
	private DefaultListModel<String> listModel;
	private JList<String> list;
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
					All_PatViewer frame = new All_PatViewer();
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
	public All_PatViewer() throws XMLStreamException, IOException
	{
		setTitle("AllPatients Viewer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 126, 23);
		panel.add(lblNewLabel);
		
		JLabel lblPatientFname = new JLabel("Patient Fname:");
		lblPatientFname.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientFname.setBounds(10, 43, 126, 23);
		panel.add(lblPatientFname);
		
		JLabel lblPatientLname = new JLabel("Patient Lname:");
		lblPatientLname.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientLname.setBounds(10, 76, 126, 23);
		panel.add(lblPatientLname);
		
		JLabel lblPatientAddress = new JLabel("Patient Address:");
		lblPatientAddress.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientAddress.setBounds(10, 109, 126, 23);
		panel.add(lblPatientAddress);
		
		JLabel lblPatientHeight = new JLabel("Patient Height:");
		lblPatientHeight.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientHeight.setBounds(10, 175, 126, 23);
		panel.add(lblPatientHeight);
		
		JLabel lblPatientNumber = new JLabel("Patient Number:");
		lblPatientNumber.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientNumber.setBounds(10, 142, 126, 23);
		panel.add(lblPatientNumber);
		
		JLabel lblPatientWeight = new JLabel("Patient Weight:");
		lblPatientWeight.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientWeight.setBounds(10, 206, 126, 23);
		panel.add(lblPatientWeight);
		
		JLabel lblPatientBlood = new JLabel("Patient Blood:");
		lblPatientBlood.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientBlood.setBounds(10, 239, 126, 23);
		panel.add(lblPatientBlood);
		
		JLabel lblPatientBirth = new JLabel("Patient Birth:");
		lblPatientBirth.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientBirth.setBounds(10, 272, 126, 23);
		panel.add(lblPatientBirth);
		
		JLabel lblPatientInfo = new JLabel("Patient Info:");
		lblPatientInfo.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblPatientInfo.setBounds(10, 305, 126, 23);
		panel.add(lblPatientInfo);
		
		JLabel lblDefaultSsn = new JLabel("default SSN");
		lblDefaultSsn.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultSsn.setBounds(146, 10, 210, 23);
		panel.add(lblDefaultSsn);
		
		JLabel lblDefaultFname = new JLabel("default Fname");
		lblDefaultFname.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultFname.setBounds(146, 43, 210, 23);
		panel.add(lblDefaultFname);
		
		JLabel lblDefaultLname = new JLabel("default Lname");
		lblDefaultLname.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultLname.setBounds(146, 76, 210, 23);
		panel.add(lblDefaultLname);
		
		JLabel lblDefaultAddress = new JLabel("default Address");
		lblDefaultAddress.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultAddress.setBounds(146, 109, 210, 23);
		panel.add(lblDefaultAddress);
		
		JLabel lblDefaultNumber = new JLabel("default Number");
		lblDefaultNumber.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultNumber.setBounds(146, 142, 210, 23);
		panel.add(lblDefaultNumber);
		
		JLabel lblDefaultHeight = new JLabel("default Height");
		lblDefaultHeight.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultHeight.setBounds(146, 175, 210, 23);
		panel.add(lblDefaultHeight);
		
		JLabel lblDefaultWeight = new JLabel("default Weight");
		lblDefaultWeight.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultWeight.setBounds(146, 206, 210, 23);
		panel.add(lblDefaultWeight);
		
		JLabel lblDefaultBlood = new JLabel("default Blood");
		lblDefaultBlood.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultBlood.setBounds(146, 239, 210, 23);
		panel.add(lblDefaultBlood);
		
		JLabel lblDefaultBirth = new JLabel("default Birth");
		lblDefaultBirth.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultBirth.setBounds(146, 272, 210, 23);
		panel.add(lblDefaultBirth);
		
		JLabel lblDefaultInfo = new JLabel("default Info");
		lblDefaultInfo.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblDefaultInfo.setBounds(146, 305, 210, 23);
		panel.add(lblDefaultInfo);
		
		JButton btnAddNewPatient = new JButton("Add New Patient");
		btnAddNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Add_Pat_Viewer viewer=new Add_Pat_Viewer();
				viewer.setVisible(true);
				dispose();
			}
		});
		btnAddNewPatient.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		btnAddNewPatient.setBounds(10, 408, 346, 42);
		panel.add(btnAddNewPatient);
		
		JButton btnRemovePatient = new JButton("Remove Patient");
		btnRemovePatient.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		btnRemovePatient.setBounds(10, 356, 346, 42);
		panel.add(btnRemovePatient);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		XML_Reader reader=new XML_Reader();
		patList = reader.all_PATread();
		listModel = new DefaultListModel<>();
        for(Patient p: patList){
            listModel.addElement(p.getFname());
        }
        list = new JList<>(listModel);
        list.setFont(new Font("新細明體", Font.PLAIN, 20));
		list.setVisibleRowCount(15);
		scrollPane.setViewportView(list);
		
		JLabel lblViewAllPatient = new JLabel("View All Patient");
		lblViewAllPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewAllPatient.setFont(new Font("新細明體", Font.PLAIN, 18));
		contentPane.add(lblViewAllPatient, BorderLayout.NORTH);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if(arg0.getValueIsAdjusting())
				{
		            Patient p = patList.get(list.getSelectedIndex());
		            lblDefaultSsn.setText(p.getSSN());
		            lblDefaultFname.setText(p.getFname());
		            lblDefaultLname.setText(p.getLname());
		            lblDefaultAddress.setText(p.getAddress());
		            lblDefaultNumber.setText(p.getNumber());
		            lblDefaultHeight.setText(p.getHeight());
		            lblDefaultWeight.setText(p.getWeight());
		            lblDefaultBlood.setText(p.getBlood());
		            lblDefaultBirth.setText(p.getBirth());
		            lblDefaultInfo.setText(p.getInfo());
		        }
			}
		});
		
		btnRemovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=list.getSelectedIndex();
				patList.remove(i);
				listModel.remove(i);
				
				try
				{
					reader.write_NewPat(patList);
					dispose();
					All_PatViewer viewer=new All_PatViewer();
					viewer.setVisible(true);
				}
				catch (Exception e2)
				{
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
	}
	
	public void addnew_pat(Patient p)
	{
		patList.add(p);
		listModel.addElement(p.getFname());
		try 
		{
			XML_Reader reader=new XML_Reader();
			reader.write_NewPat(patList);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
