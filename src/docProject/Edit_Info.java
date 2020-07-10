package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Edit_Info extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_pw;
	private JTextField textField_phone;
	private JComboBox comboBox;
	private JTextField textField_lname;

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
					Edit_Info frame = new Edit_Info();
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
	public Edit_Info()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel.setLayout(fl_panel);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("First Name     ");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_3.add(lblNewLabel);
		
		textField_name = new JTextField();
		panel_3.add(textField_name);
		textField_name.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_name.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblLastName = new JLabel("Last Name      ");
		lblLastName.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_4.add(lblLastName);
		
		textField_lname = new JTextField();
		textField_lname.setFont(new Font("新細明體", Font.PLAIN, 25));
		textField_lname.setColumns(10);
		panel_4.add(textField_lname);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Password        ");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_1);
		
		textField_pw = new JTextField();
		textField_pw.setFont(new Font("新細明體", Font.PLAIN, 25));
		panel_2.add(textField_pw);
		textField_pw.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Department     ");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"administrator", "dentist", "pediatrics", "surgical"}));
		comboBox.setFont(new Font("新細明體", Font.PLAIN, 25));
		panel_5.add(comboBox);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_6.add(lblNewLabel_4);
		
		textField_phone = new JTextField();
		textField_phone.setFont(new Font("新細明體", Font.PLAIN, 25));
		panel_6.add(textField_phone);
		textField_phone.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					XML_Reader reader = new XML_Reader();
					reader.Edit(getTitle(),textField_pw.getText(),textField_name.getText(),textField_lname.getText(),String.valueOf(comboBox.getSelectedItem()),textField_phone.getText());
					ArrayList<String> temp=reader.LoginCheck(getTitle(), textField_pw.getText());
					if(temp!=null)
					{
						DocViewer viewer=new DocViewer();
						viewer.set_default_info(temp);
						viewer.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		panel_1.add(btnNewButton);
	}
	
	public void set_default_text(String id,String password,String name,String lname,String department,String number)
	{
		setTitle(id);
		textField_name.setText(name);
		textField_lname.setText(lname);
		textField_pw.setText(password);
		textField_phone.setText(number);
		comboBox.setSelectedItem(department);
	}
	
	

}
