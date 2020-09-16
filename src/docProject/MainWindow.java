package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Window.Type;

public class MainWindow extends JFrame
{
	private List<Doctor> docList;
	private JPanel contentPane;
	private List<Server> doc_ServerList=new ArrayList<>();

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
					MainWindow frame = new MainWindow();
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
	public MainWindow() throws XMLStreamException, IOException
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Icon/paper_plane.png")));
		setBackground(SystemColor.menu);
		XML_Reader read=new XML_Reader();
		docList=read.all_DOCread();
		
		for(Doctor d:docList)
		{
			Server server=new Server();
			server.Set(d);
			doc_ServerList.add(server);
		}
		
		for(Server s:doc_ServerList)
		{
			s.start();
		}
		
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 287);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel.add(panel_1);
		
		
		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/Icon/user.png")));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					PatWindow patWindow = new PatWindow();
					patWindow.setVisible(true);
					patWindow.getServer(doc_ServerList);
				}
				catch (XMLStreamException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel.add(panel_2);
		
		JButton btnNewButton = new JButton("Doctor");
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Icon/administrator.png")));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					DocWindow docWindow = new DocWindow();
					docWindow.setVisible(true);
				}
				catch (XMLStreamException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.text);
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel lblWelcomeToCcu = new JLabel("CCU Hospital");
		lblWelcomeToCcu.setBounds(55, 56, 280, 54);
		panel_3.add(lblWelcomeToCcu);
		lblWelcomeToCcu.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 40));
		lblWelcomeToCcu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/Icon/hospital-icon (1).png")));
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 57, 32, 45);
		panel_3.add(lblNewLabel);
		
		JLabel lblDesignBy = new JLabel("2019 Designed by Perry");
		lblDesignBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesignBy.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		lblDesignBy.setBounds(0, 112, 389, 30);
		panel_3.add(lblDesignBy);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("To MySQL");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Comfirm_form form=new Comfirm_form();
				form.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(SystemColor.text);
		btnNewButton_2.setBounds(357, 0, 32, 33);
		panel_3.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon(MainWindow.class.getResource("/Icon/our_proccess.png")));
		
		try
		{
			XML_Reader reader = new XML_Reader();
		} catch (XMLStreamException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
