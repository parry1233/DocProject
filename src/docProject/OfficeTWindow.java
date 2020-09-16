package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class OfficeTWindow extends JFrame
{
	
	private String[] idpw= new String[2];
	
	private JPanel contentPane;
	private String[] temp;
	private String[] ending=new String[7];
	private JRadioButton Mon1;
	private JRadioButton Mon2;
	private JRadioButton Mon3;
	private JRadioButton Tue1;
	private JRadioButton Tue2;
	private JRadioButton Tue3;
	private JRadioButton Wed1;
	private JRadioButton Wed2;
	private JRadioButton Wed3;
	private JRadioButton Thu1;
	private JRadioButton Thu2;
	private JRadioButton Thu3;
	private JRadioButton Fri1;
	private JRadioButton Fri2;
	private JRadioButton Fri3;
	private JRadioButton Sat1;
	private JRadioButton Sat2;
	private JRadioButton Sat3;
	private JRadioButton Sun1;
	private JRadioButton Sun2;
	private JRadioButton Sun3;

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
					OfficeTWindow frame = new OfficeTWindow();
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
	public OfficeTWindow()
	{
		setTitle("Edit Office Time");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OfficeTWindow.class.getResource("/Icon/paper_plane.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				set_end_radio();
				
				try
				{
					XML_Reader reader = new XML_Reader();
					reader.Edit_time(ending,idpw[0]);
					ArrayList<String> temp=reader.LoginCheck(idpw[0],idpw[1]);
					if(temp!=null)
					{
						DocViewer viewer=new DocViewer();
						viewer.set_default_info(temp);
						viewer.setVisible(true);
						dispose();
					}
				}
					
				catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 25));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Mon1 = new JRadioButton("");
		Mon1.setBackground(SystemColor.inactiveCaptionBorder);
		Mon1.setBounds(138, 153, 21, 23);
		panel.add(Mon1);
		
		Mon2 = new JRadioButton("");
		Mon2.setBackground(SystemColor.inactiveCaptionBorder);
		Mon2.setBounds(138, 207, 21, 23);
		panel.add(Mon2);
		
		Mon3 = new JRadioButton("");
		Mon3.setBackground(SystemColor.inactiveCaptionBorder);
		Mon3.setBounds(138, 258, 21, 23);
		panel.add(Mon3);
		
		Tue1 = new JRadioButton("");
		Tue1.setBackground(SystemColor.inactiveCaptionBorder);
		Tue1.setBounds(220, 153, 21, 23);
		panel.add(Tue1);
		
		Tue2 = new JRadioButton("");
		Tue2.setBackground(SystemColor.inactiveCaptionBorder);
		Tue2.setBounds(220, 207, 21, 23);
		panel.add(Tue2);
		
		Tue3 = new JRadioButton("");
		Tue3.setBackground(SystemColor.inactiveCaptionBorder);
		Tue3.setBounds(220, 258, 21, 23);
		panel.add(Tue3);
		
		Wed1 = new JRadioButton("");
		Wed1.setBackground(SystemColor.inactiveCaptionBorder);
		Wed1.setBounds(312, 153, 21, 23);
		panel.add(Wed1);
		
		Wed2 = new JRadioButton("");
		Wed2.setBackground(SystemColor.inactiveCaptionBorder);
		Wed2.setBounds(312, 207, 21, 23);
		panel.add(Wed2);
		
		Wed3 = new JRadioButton("");
		Wed3.setBackground(SystemColor.inactiveCaptionBorder);
		Wed3.setBounds(312, 258, 21, 23);
		panel.add(Wed3);
		
		Thu1 = new JRadioButton("");
		Thu1.setBackground(SystemColor.inactiveCaptionBorder);
		Thu1.setBounds(400, 153, 21, 23);
		panel.add(Thu1);
		
		Thu2 = new JRadioButton("");
		Thu2.setBackground(SystemColor.inactiveCaptionBorder);
		Thu2.setBounds(400, 207, 21, 23);
		panel.add(Thu2);
		
		Thu3 = new JRadioButton("");
		Thu3.setBackground(SystemColor.inactiveCaptionBorder);
		Thu3.setBounds(400, 258, 21, 23);
		panel.add(Thu3);
		
		Fri1 = new JRadioButton("");
		Fri1.setBackground(SystemColor.inactiveCaptionBorder);
		Fri1.setBounds(482, 153, 21, 23);
		panel.add(Fri1);
		
		Fri2 = new JRadioButton("");
		Fri2.setBackground(SystemColor.inactiveCaptionBorder);
		Fri2.setBounds(482, 207, 21, 23);
		panel.add(Fri2);
		
		Fri3 = new JRadioButton("");
		Fri3.setBackground(SystemColor.inactiveCaptionBorder);
		Fri3.setBounds(482, 258, 21, 23);
		panel.add(Fri3);
		
		Sat1 = new JRadioButton("");
		Sat1.setBackground(SystemColor.inactiveCaptionBorder);
		Sat1.setBounds(568, 153, 21, 23);
		panel.add(Sat1);
		
		Sat2 = new JRadioButton("");
		Sat2.setBackground(SystemColor.inactiveCaptionBorder);
		Sat2.setBounds(568, 207, 21, 23);
		panel.add(Sat2);
		
		Sat3 = new JRadioButton("");
		Sat3.setBackground(SystemColor.inactiveCaptionBorder);
		Sat3.setBounds(568, 258, 21, 23);
		panel.add(Sat3);
		
		Sun1 = new JRadioButton("");
		Sun1.setBackground(SystemColor.inactiveCaptionBorder);
		Sun1.setBounds(653, 153, 21, 23);
		panel.add(Sun1);
		
		Sun2 = new JRadioButton("");
		Sun2.setBackground(SystemColor.inactiveCaptionBorder);
		Sun2.setBounds(653, 207, 21, 23);
		panel.add(Sun2);
		
		Sun3 = new JRadioButton("");
		Sun3.setBackground(SystemColor.inactiveCaptionBorder);
		Sun3.setBounds(653, 258, 21, 23);
		panel.add(Sun3);
		
		JLabel Monday = new JLabel("Monday");
		Monday.setHorizontalAlignment(SwingConstants.CENTER);
		Monday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Monday.setBounds(104, 80, 82, 47);
		panel.add(Monday);
		
		JLabel Tuesday = new JLabel("Tuesday");
		Tuesday.setHorizontalAlignment(SwingConstants.CENTER);
		Tuesday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Tuesday.setBounds(184, 80, 82, 47);
		panel.add(Tuesday);
		
		JLabel Wednesday = new JLabel("Wednesday");
		Wednesday.setHorizontalAlignment(SwingConstants.CENTER);
		Wednesday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Wednesday.setBounds(261, 80, 108, 47);
		panel.add(Wednesday);
		
		JLabel Thursday = new JLabel("Thursday");
		Thursday.setHorizontalAlignment(SwingConstants.CENTER);
		Thursday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Thursday.setBounds(371, 80, 82, 47);
		panel.add(Thursday);
		
		JLabel Friday = new JLabel("Friday");
		Friday.setHorizontalAlignment(SwingConstants.CENTER);
		Friday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Friday.setBounds(455, 80, 82, 47);
		panel.add(Friday);
		
		JLabel Saturday = new JLabel("Saturday");
		Saturday.setHorizontalAlignment(SwingConstants.CENTER);
		Saturday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Saturday.setBounds(536, 80, 82, 47);
		panel.add(Saturday);
		
		JLabel Sunday = new JLabel("Sunday");
		Sunday.setHorizontalAlignment(SwingConstants.CENTER);
		Sunday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 19));
		Sunday.setBounds(622, 80, 82, 47);
		panel.add(Sunday);
		
		JLabel lblMorning = new JLabel("Morning");
		lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorning.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 22));
		lblMorning.setBounds(10, 137, 108, 39);
		panel.add(lblMorning);
		
		JLabel lblAfternoon = new JLabel("Afternoon");
		lblAfternoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfternoon.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 22));
		lblAfternoon.setBounds(10, 191, 108, 39);
		panel.add(lblAfternoon);
		
		JLabel lblNight = new JLabel("Night");
		lblNight.setHorizontalAlignment(SwingConstants.CENTER);
		lblNight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 22));
		lblNight.setBounds(10, 240, 108, 39);
		panel.add(lblNight);
		
		JLabel lblNewLabel = new JLabel("Office Time");
		lblNewLabel.setIcon(new ImageIcon(OfficeTWindow.class.getResource("/Icon/calendar.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 38));
		lblNewLabel.setBounds(10, 23, 677, 47);
		panel.add(lblNewLabel);
	}
	
	public void set_default_radio()
	{
		if(temp[0].charAt(0)=='T')
		{
			Mon1.setSelected(true);
		}
		if(temp[0].charAt(1)=='T')
		{
			Mon2.setSelected(true);
		}
		if(temp[0].charAt(2)=='T')
		{
			Mon3.setSelected(true);
		}
		
		if(temp[1].charAt(0)=='T')
		{
			Tue1.setSelected(true);
		}
		if(temp[1].charAt(1)=='T')
		{
			Tue2.setSelected(true);
		}
		if(temp[1].charAt(2)=='T')
		{
			Tue3.setSelected(true);
		}
		
		if(temp[2].charAt(0)=='T')
		{
			Wed1.setSelected(true);
		}
		if(temp[2].charAt(1)=='T')
		{
			Wed2.setSelected(true);
		}
		if(temp[2].charAt(2)=='T')
		{
			Wed3.setSelected(true);
		}
		
		if(temp[3].charAt(0)=='T')
		{
			Thu1.setSelected(true);
		}
		if(temp[3].charAt(1)=='T')
		{
			Thu2.setSelected(true);
		}
		if(temp[3].charAt(2)=='T')
		{
			Thu3.setSelected(true);
		}
		
		if(temp[4].charAt(0)=='T')
		{
			Fri1.setSelected(true);
		}
		if(temp[4].charAt(1)=='T')
		{
			Fri2.setSelected(true);
		}
		if(temp[4].charAt(2)=='T')
		{
			Fri3.setSelected(true);
		}
		
		if(temp[5].charAt(0)=='T')
		{
			Sat1.setSelected(true);
		}
		if(temp[5].charAt(1)=='T')
		{
			Sat2.setSelected(true);
		}
		if(temp[5].charAt(2)=='T')
		{
			Sat3.setSelected(true);
		}
		
		if(temp[6].charAt(0)=='T')
		{
			Sun1.setSelected(true);
		}
		if(temp[6].charAt(1)=='T')
		{
			Sun2.setSelected(true);
		}
		if(temp[6].charAt(2)=='T')
		{
			Sun3.setSelected(true);
		}
		
	}
	
	public void set_end_radio()
	{
		if(Mon1.isSelected())
		{
			ending[0]="T";
		}
		else if(!Mon1.isSelected())
		{
			ending[0]="F";
		}
		if(Mon2.isSelected())
		{
			ending[0]+='T';
		}
		else if(!Mon2.isSelected())
		{
			ending[0]+="F";
		}
		if(Mon3.isSelected())
		{
			ending[0]+='T';
		}
		else if(!Mon3.isSelected())
		{
			ending[0]+="F";
		}
		
		//
		if(Tue1.isSelected())
		{
			ending[1]="T";
		}
		else if(!Tue1.isSelected())
		{
			ending[1]="F";
		}
		if(Tue2.isSelected())
		{
			ending[1]+='T';
		}
		else if(!Tue2.isSelected())
		{
			ending[1]+="F";
		}
		if(Tue3.isSelected())
		{
			ending[1]+='T';
		}
		else if(!Tue3.isSelected())
		{
			ending[1]+="F";
		}
		
		//
		if(Wed1.isSelected())
		{
			ending[2]="T";
		}
		else if(!Wed1.isSelected())
		{
			ending[2]="F";
		}
		if(Wed2.isSelected())
		{
			ending[2]+='T';
		}
		else if(!Wed2.isSelected())
		{
			ending[2]+='F';
		}
		if(Wed3.isSelected())
		{
			ending[2]+='T';
		}
		else if(!Wed3.isSelected())
		{
			ending[2]+='F';
		}
		
		//
		if(Thu1.isSelected())
		{
			ending[3]="T";
		}
		else if(!Thu1.isSelected())
		{
			ending[3]="F";
		}
		if(Thu2.isSelected())
		{
			ending[3]+='T';
		}
		else if(!Thu2.isSelected())
		{
			ending[3]+='F';
		}
		if(Thu3.isSelected())
		{
			ending[3]+='T';
		}
		else if(!Thu3.isSelected())
		{
			ending[3]+='F';
		}
		
		//
		if(Fri1.isSelected())
		{
			ending[4]="T";
		}
		else if(!Fri1.isSelected())
		{
			ending[4]="F";
		}
		if(Fri2.isSelected())
		{
			ending[4]+='T';
		}
		else if(!Fri2.isSelected())
		{
			ending[4]+='F';
		}
		if(Fri3.isSelected())
		{
			ending[4]+='T';
		}
		else if(!Fri3.isSelected())
		{
			ending[4]+='F';
		}
		
		//
		if(Sat1.isSelected())
		{
			ending[5]="T";
		}
		else if(!Sat1.isSelected())
		{
			ending[5]="F";
		}
		if(Sat2.isSelected())
		{
			ending[5]+='T';
		}
		else if(!Sat2.isSelected())
		{
			ending[5]+='F';
		}
		if(Sat3.isSelected())
		{
			ending[5]+='T';
		}
		else if(!Sat3.isSelected())
		{
			ending[5]+='F';
		}
		
		//
		if(Sun1.isSelected())
		{
			ending[6]="T";
		}
		else if(!Sun1.isSelected())
		{
			ending[6]="F";
		}
		if(Sun2.isSelected())
		{
			ending[6]+='T';
		}
		else if(!Sun2.isSelected())
		{
			ending[6]+='F';
		}
		if(Sun3.isSelected())
		{
			ending[6]+='T';
		}
		else if(!Sun3.isSelected())
		{
			ending[6]+='F';
		}
	}
	
	public void set_idpw(String id,String pw)
	{
		idpw[0]=id;
		idpw[1]=pw;
		setTitle(idpw[0]);
		try
		{
			XML_Reader reader = new XML_Reader();
			temp=reader.getTime(id);
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
