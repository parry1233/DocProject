package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Comfirm_form extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comfirm_form frame = new Comfirm_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Comfirm_form() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sadso\\Desktop\\idea.png"));
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Confirm");
		setBounds(100, 100, 314, 122);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setToolTipText("YES");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btnNewButton.setEnabled(false);
				button.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Start of the process, wait for few seconds...","Start",JOptionPane.INFORMATION_MESSAGE);
				List<Doctor> doclist=new ArrayList<>();
				List<Patient> patlist=new ArrayList<>();
				List<Diagnosis> diaglist=new ArrayList<>();
				List<Appointment> applist=new ArrayList<>();
				try
				{
					XML_Reader reader=new XML_Reader();
					doclist=reader.all_DOCread();
					patlist=reader.all_PATread();
					diaglist=reader.allDIAGread();
					applist=reader.allAPPread();
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
				
				
			    //doctor XML to database 
			    ToMySQL doc = new ToMySQL(); 
			    doc.dropTable(); 
			    doc.createTable(); 
			    for(Doctor d:doclist)
			    {
			    	doc.insertTable(d.getID(), d.getPW(), d.getFName(), d.getLName(), d.getDep(), d.getPhone(), d.getOFTime().get(0), d.getOFTime().get(1), d.getOFTime().get(2), d.getOFTime().get(3), d.getOFTime().get(4), d.getOFTime().get(5), d.getOFTime().get(6));
			    }
			    doc.SelectTable(); 
			    
			    //patient XML to database
			    ToMySQL_Pat pat = new ToMySQL_Pat(); 
			    pat.dropTable(); 
			    pat.createTable(); 
			    for(Patient p:patlist)
			    {
			    	pat.insertTable(p.getSSN(), p.getPW(),p.getFname(),p.getLname(),p.getAddress(),p.getNumber(),p.getHeight(),p.getWeight(),p.getBlood(),p.getBirth(),p.getInfo());
			    }
			    pat.SelectTable();
			    
			    //diagnosis XML to database
			    ToMySQL_Diag diag = new ToMySQL_Diag(); 
			    diag.dropTable(); 
			    diag.createTable(); 
			    for(Diagnosis d:diaglist)
			    {
			    	diag.insertTable(d.getPSSN(), d.getdID(), d.getDiagnosis(), d.getR_By(), d.getR_Detail(), d.getNote());
			    } 
			    diag.SelectTable(); 
			    
			    //Appointment XML to database
			    ToMySQL_Apoint app = new ToMySQL_Apoint(); 
			    app.dropTable(); 
			    app.createTable(); 
			    for(Appointment a:applist)
			    {
			    	app.insertTable(a.getPAtID(),a.getDocID(),a.getDay());
			    } 
			    app.SelectTable();
			    
			    JOptionPane.showMessageDialog(null, "End of the process.","End",JOptionPane.INFORMATION_MESSAGE);
			    dispose();
			}
		});
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setIcon(new ImageIcon(Comfirm_form.class.getResource("/Icon/check_mark (2).png")));
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("微軟正黑體 Light", Font.BOLD, 18));
		btnNewButton.setBounds(106, 47, 34, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("確認要將資料寫入資料庫內部嗎？");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體 Light", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 291, 27);
		contentPane.add(lblNewLabel);
		
		button = new JButton("");
		button.setToolTipText("NO");
		button.setBorder(null);
		button.setIcon(new ImageIcon(Comfirm_form.class.getResource("/Icon/cross (2).png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微軟正黑體 Light", Font.BOLD, 18));
		button.setBackground(SystemColor.text);
		button.setBounds(150, 47, 34, 27);
		contentPane.add(button);
	}
}
