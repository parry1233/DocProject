package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Pat_Info_Edit extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_address;
	private JTextField textField_number;
	private JTextField textField_height;
	private JTextField textField_weight;
	private JTextField textField_note;

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
					Pat_Info_Edit frame = new Pat_Info_Edit();
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
	public Pat_Info_Edit()
	{
		setTitle("Patient Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pat_Info_Edit.class.getResource("/Icon/paper_plane.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 342);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.text);
		panel.add(panel_4);
		
		JLabel lblAddress = new JLabel("Address         ");
		lblAddress.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_4.add(lblAddress);
		
		textField_address = new JTextField();
		textField_address.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_address.setColumns(20);
		panel_4.add(textField_address);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.text);
		panel.add(panel_5);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_5.add(lblPhoneNumber);
		
		textField_number = new JTextField();
		textField_number.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_number.setColumns(10);
		panel_5.add(textField_number);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.text);
		panel.add(panel_6);
		
		JLabel lblHeight = new JLabel("Height           ");
		lblHeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_6.add(lblHeight);
		
		textField_height = new JTextField();
		textField_height.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_height.setColumns(10);
		panel_6.add(textField_height);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.text);
		panel.add(panel_7);
		
		JLabel lblWeight = new JLabel("Weight          ");
		lblWeight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_7.add(lblWeight);
		
		textField_weight = new JTextField();
		textField_weight.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_weight.setColumns(10);
		panel_7.add(textField_weight);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel.add(panel_2);
		
		JLabel lblNote = new JLabel("Note              ");
		lblNote.setBackground(SystemColor.text);
		lblNote.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_2.add(lblNote);
		
		textField_note = new JTextField();
		textField_note.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_note.setColumns(20);
		panel_2.add(textField_note);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					XML_Reader reader = new XML_Reader();
					reader.Doc_edit_Pat(getTitle(),textField_address.getText(), textField_number.getText(), textField_height.getText(), textField_weight.getText(), textField_note.getText());
				}
				catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		panel_1.add(btnNewButton);
	}
	
	public void set_default_info(String patient_SSN)
	{
		setTitle(patient_SSN);
		ArrayList<String> temp=new ArrayList<>();
		try
		{
			XML_Reader reader = new XML_Reader();
			temp=reader.DocViewPat_info(patient_SSN);
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_address.setText(temp.get(1));
		textField_number.setText(temp.get(2));
		textField_height.setText(temp.get(3));
		textField_weight.setText(temp.get(4));
		textField_note.setText(temp.get(5));
	}

}
