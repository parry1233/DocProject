package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class ClientReversing_Viewer extends JFrame
{
	private JButton btnSelect;
	private Patient thisPatient;
	private Doctor thisdoctor;
	private String selected;
	private String now_info;
	private List<Server> doc_serList=new ArrayList<Server>();
	private JPanel contentPane;
	//public Client client;
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private int selected_port;
	private Server server;
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
					ClientReversing_Viewer frame = new ClientReversing_Viewer();
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
	public ClientReversing_Viewer()
	{
		
		setTitle("Choose doctor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientReversing_Viewer.class.getResource("/Icon/paper_plane.png")));		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 222);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(159, 12, 213, 35);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent)
			{
				int state=itemEvent.getStateChange();
				selected=String.valueOf(itemEvent.getItem());
				
				for(Server s:doc_serList)
				{
					if(selected.equals(s.returnDoc().getFName()))
					{
						thisdoctor=s.returnDoc();
						server=s;
						selected_port=s.returnPort();
						now_info =s.returnDoc().getFName()+s.returnDoc().getLName()+"--Department:"+s.returnDoc().getDep()+"\nPort:"+selected_port;
						textArea.setText(now_info);
					}
				}
			}
		});
		contentPane.add(comboBox);
		
		JLabel lblChooseDoctor = new JLabel("Choose Doctor");
		lblChooseDoctor.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		lblChooseDoctor.setBounds(10, 10, 139, 35);
		contentPane.add(lblChooseDoctor);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(10, 57, 362, 71);
		contentPane.add(textArea);
		
		btnSelect = new JButton("Select");
		btnSelect.setBackground(Color.LIGHT_GRAY);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource() == btnSelect)
				{
					JOptionPane.showMessageDialog(null, "請稍候", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				Client client=new Client("127.0.0.1",selected_port);
				client.setDocPat(thisdoctor,thisPatient);
				//System.out.println(client.getState());
				client.start();
				//System.out.println(client.getState());
				/*if(client.getCheck())
				{
					try
					{
						Reverse_Viewer viewer=new Reverse_Viewer();
						viewer.set_default(thisdoctor,thisPatient);
						viewer.setVisible(true);
					}
					catch (Exception e2)
					{
						e2.printStackTrace();
					}
					
				}
				else if(!client.getCheck())
				{
					JOptionPane.showMessageDialog(null, "已有用戶在使用，請稍後重試", "Sorry", JOptionPane.ERROR_MESSAGE);
				}
				/*Reverse_Viewer viewer=new Reverse_Viewer();
				viewer.set_default(thisdoctor,thisPatient);
				viewer.setVisible(true);*/
			}
		});
		btnSelect.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		btnSelect.setBounds(117, 138, 124, 38);
		contentPane.add(btnSelect);
	}
	
	public void getServerList(List<Server> list,Patient p)
	{
		thisPatient=p;
		ArrayList<String> string=new ArrayList<String>();
		this.doc_serList=list;
		int index=0;
		for(Server s:list)
		{
			string.add(s.returnDoc().getFName());
			comboBox.addItem(string.get(index));
			index++;
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		
	}
	
	public void checkAvailable()
	{
		/*Reverse_Viewer viewer=new Reverse_Viewer();
		viewer.setVisible(true);
		viewer.set_default(thisdoctor,thisPatient);
		JOptionPane.showMessageDialog(null, "已有用戶在使用，請稍後重試", "Sorry", JOptionPane.ERROR_MESSAGE);*/
	}
	
}
