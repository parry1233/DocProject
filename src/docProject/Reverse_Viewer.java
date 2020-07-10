package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Reverse_Viewer extends JFrame
{
	private boolean end=false;
	private List<Appointment> appList;
	private JPanel contentPane;
	private JRadioButton M1;
	private JRadioButton M2;
	private JRadioButton M3;
	private JRadioButton T1;
	private JRadioButton T2;
	private JRadioButton T3;
	private JRadioButton W1;
	private JRadioButton W2;
	private JRadioButton W3;
	private JRadioButton Th1;
	private JRadioButton Th2;
	private JRadioButton Th3;
	private JRadioButton F1;
	private JRadioButton F2;
	private JRadioButton F3;
	private JRadioButton S1;
	private JRadioButton S2;
	private JRadioButton S3;
	private JRadioButton Su1;
	private JRadioButton Su2;
	private JRadioButton Su3;
	private Doctor doctor;
	private Patient patient;
	private JLabel lblPatientpatientReverseTo;
	
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
					Reverse_Viewer frame = new Reverse_Viewer();
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
	public Reverse_Viewer() throws XMLStreamException, IOException
	{
		setTitle("Reserve");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reverse_Viewer.class.getResource("/Icon/paper_plane.png")));
		XML_Reader reader = new XML_Reader();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 308);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPatientpatientReverseTo = new JLabel("Patient:(patient) reverse to Doctor:(doctor) appointment");
		lblPatientpatientReverseTo.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 17));
		lblPatientpatientReverseTo.setBounds(10, 10, 445, 42);
		contentPane.add(lblPatientpatientReverseTo);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 62, 515, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblMonday.setBounds(70, 10, 52, 23);
		panel.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblTuesday.setBounds(132, 10, 52, 23);
		panel.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblWednesday.setBounds(194, 10, 68, 23);
		panel.add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblThursday.setBounds(267, 10, 63, 23);
		panel.add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblFriday.setBounds(332, 10, 52, 23);
		panel.add(lblFriday);
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaturday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblSaturday.setBounds(391, 10, 63, 23);
		panel.add(lblSaturday);
		
		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSunday.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblSunday.setBounds(463, 10, 52, 23);
		panel.add(lblSunday);
		
		JLabel lblMorning = new JLabel("Morning");
		lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorning.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblMorning.setBounds(10, 56, 63, 23);
		panel.add(lblMorning);
		
		JLabel lblAfternoon = new JLabel("Afternoon");
		lblAfternoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfternoon.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblAfternoon.setBounds(10, 89, 63, 23);
		panel.add(lblAfternoon);
		
		JLabel lblNight = new JLabel("Night");
		lblNight.setHorizontalAlignment(SwingConstants.CENTER);
		lblNight.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		lblNight.setBounds(10, 122, 63, 23);
		panel.add(lblNight);
		
		M1 = new JRadioButton("");
		M1.setBackground(SystemColor.inactiveCaptionBorder);
		M1.setBounds(87, 56, 21, 23);
		panel.add(M1);
		
		M2 = new JRadioButton("");
		M2.setBackground(SystemColor.inactiveCaptionBorder);
		M2.setBounds(87, 89, 21, 23);
		panel.add(M2);
		
		M3 = new JRadioButton("");
		M3.setBackground(SystemColor.inactiveCaptionBorder);
		M3.setBounds(87, 122, 21, 23);
		panel.add(M3);
		
		T1 = new JRadioButton("");
		T1.setBackground(SystemColor.inactiveCaptionBorder);
		T1.setBounds(152, 56, 21, 23);
		panel.add(T1);
		
		T2 = new JRadioButton("");
		T2.setBackground(SystemColor.inactiveCaptionBorder);
		T2.setBounds(152, 89, 21, 23);
		panel.add(T2);
		
		T3 = new JRadioButton("");
		T3.setBackground(SystemColor.inactiveCaptionBorder);
		T3.setBounds(152, 122, 21, 23);
		panel.add(T3);
		
		W1 = new JRadioButton("");
		W1.setBackground(SystemColor.inactiveCaptionBorder);
		W1.setBounds(217, 56, 21, 23);
		panel.add(W1);
		
		W2 = new JRadioButton("");
		W2.setBackground(SystemColor.inactiveCaptionBorder);
		W2.setBounds(217, 89, 21, 23);
		panel.add(W2);
		
		W3 = new JRadioButton("");
		W3.setBackground(SystemColor.inactiveCaptionBorder);
		W3.setBounds(217, 122, 21, 23);
		panel.add(W3);
		
		Th1 = new JRadioButton("");
		Th1.setBackground(SystemColor.inactiveCaptionBorder);
		Th1.setBounds(282, 56, 21, 23);
		panel.add(Th1);
		
		Th2 = new JRadioButton("");
		Th2.setBackground(SystemColor.inactiveCaptionBorder);
		Th2.setBounds(282, 89, 21, 23);
		panel.add(Th2);
		
		Th3 = new JRadioButton("");
		Th3.setBackground(SystemColor.inactiveCaptionBorder);
		Th3.setBounds(282, 122, 21, 23);
		panel.add(Th3);
		
		F1 = new JRadioButton("");
		F1.setBackground(SystemColor.inactiveCaptionBorder);
		F1.setBounds(347, 56, 21, 23);
		panel.add(F1);
		
		F2 = new JRadioButton("");
		F2.setBackground(SystemColor.inactiveCaptionBorder);
		F2.setBounds(347, 89, 21, 23);
		panel.add(F2);
		
		F3 = new JRadioButton("");
		F3.setBackground(SystemColor.inactiveCaptionBorder);
		F3.setBounds(347, 122, 21, 23);
		panel.add(F3);
		
		S1 = new JRadioButton("");
		S1.setBackground(SystemColor.inactiveCaptionBorder);
		S1.setBounds(412, 56, 21, 23);
		panel.add(S1);
		
		S2 = new JRadioButton("");
		S2.setBackground(SystemColor.inactiveCaptionBorder);
		S2.setBounds(412, 89, 21, 23);
		panel.add(S2);
		
		S3 = new JRadioButton("");
		S3.setBackground(SystemColor.inactiveCaptionBorder);
		S3.setBounds(412, 122, 21, 23);
		panel.add(S3);
		
		Su1 = new JRadioButton("");
		Su1.setBackground(SystemColor.inactiveCaptionBorder);
		Su1.setBounds(477, 56, 21, 23);
		panel.add(Su1);
		
		Su2 = new JRadioButton("");
		Su2.setBackground(SystemColor.inactiveCaptionBorder);
		Su2.setBounds(477, 89, 21, 23);
		panel.add(Su2);
		
		Su3 = new JRadioButton("");
		Su3.setBackground(SystemColor.inactiveCaptionBorder);
		Su3.setBounds(477, 122, 21, 23);
		panel.add(Su3);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean check=false;
				boolean error=false;
				String check_day="";
				/*String day1="FFF";
				String day2="FFF";
				String day3="FFF";
				String day4="FFF";
				String day5="FFF";
				String day6="FFF";
				String day7="FFF";*/
				
				if(M1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Mon1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(M2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Mon2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(M3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Mon3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(T1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Tue1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(T2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Tue2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(T3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Tue3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(W1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Wed1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(W2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Wed2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(W3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Wed3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(Th1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Thu1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(Th2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Thu2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(Th3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Thu3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(F1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Fri1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(F2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Fri2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(F3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Fri3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(S1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sat1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(S2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sat2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(S3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sat3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(Su1.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sun1";
					}
					else if (check) 
					{
						error=true;
					}
					
				}
				if(Su2.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sun2";
					}
					else if (check) 
					{
						error=true;
					}
				}
				if(Su3.isSelected())
				{
					if(!check)
					{
						check=true;
						check_day="Sun3";
					}
					else if (check) 
					{
						error=true;
					}
				}
				
				if(error)
				{
					JOptionPane.showMessageDialog(null, "只能選擇一個時段", "Reject Request", JOptionPane.ERROR_MESSAGE);
				}
				else if(check_day.equals(""))
				{
					JOptionPane.showMessageDialog(null, "未選擇時段", "Reject Request", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					Appointment appointment=new Appointment(doctor.getID(),patient.getSSN(),check_day);
					try
					{
						boolean checkAvailable=true;
						if(reader.allAPPread()!=null)
						{
							appList=reader.allAPPread();
							for(Appointment a:appList)
							{
								if(a.getDay().equals(check_day))
								{
									checkAvailable=false;
								}
							}
						}
						else 
						{
							appList=new ArrayList<Appointment>();
						}
						
						//check and write xml
						if(checkAvailable)
						{
							appList.add(appointment);
							reader.write_NewApp(appList);
							end=true;
							JOptionPane.showMessageDialog(null, "預約成功", "Success", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "已有人預約此時段", "Reject Request", JOptionPane.ERROR_MESSAGE);
						}
					
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
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 17));
		btnNewButton.setBounds(438, 228, 87, 31);
		contentPane.add(btnNewButton);
	}
	
	public boolean check_end()
	{
		return this.end;
	}
	
	public void set_default(Doctor d,Patient p)
	{
		this.doctor=d;
		this.patient=p;
		lblPatientpatientReverseTo.setText("Patient:"+patient.getFname()+" reverse to Doctor:"+doctor.getFName()+ "'s appointment");
		String day1=d.getOFTime().get(0);
		String day2=d.getOFTime().get(1);
		String day3=d.getOFTime().get(2);
		String day4=d.getOFTime().get(3);
		String day5=d.getOFTime().get(4);
		String day6=d.getOFTime().get(5);
		String day7=d.getOFTime().get(6);
		
		if(day1.charAt(0)=='F')
		{
			//M1.setSelected(true);
			M1.setEnabled(false);
		}
		if(day1.charAt(1)=='F')
		{
			//M2.setSelected(true);
			M2.setEnabled(false);
		}
		if(day1.charAt(2)=='F')
		{
			//M3.setSelected(true);
			M3.setEnabled(false);
		}
		if(day2.charAt(0)=='F')
		{
			//T1.setSelected(true);
			T1.setEnabled(false);
		}
		if(day2.charAt(1)=='F')
		{
			//T2.setSelected(true);
			T2.setEnabled(false);
		}
		if(day2.charAt(2)=='F')
		{
			//T3.setSelected(true);
			T3.setEnabled(false);
		}
		if(day3.charAt(0)=='F')
		{
			//W1.setSelected(true);
			W1.setEnabled(false);
		}
		if(day3.charAt(1)=='F')
		{
			//W2.setSelected(true);
			W2.setEnabled(false);
		}
		if(day3.charAt(2)=='F')
		{
			//W3.setSelected(true);
			W3.setEnabled(false);
		}
		if(day4.charAt(0)=='F')
		{
			//Th1.setSelected(true);
			Th1.setEnabled(false);
		}
		if(day4.charAt(1)=='F')
		{
			//Th2.setSelected(true);
			Th2.setEnabled(false);
		}
		if(day4.charAt(2)=='F')
		{
			//Th3.setSelected(true);
			Th3.setEnabled(false);
		}
		if(day5.charAt(0)=='F')
		{
			//F1.setSelected(true);
			F1.setEnabled(false);
		}
		if(day5.charAt(1)=='F')
		{
			//F2.setSelected(true);
			F2.setEnabled(false);
		}
		if(day5.charAt(2)=='F')
		{
			//F3.setSelected(true);
			F3.setEnabled(false);
		}
		if(day6.charAt(0)=='F')
		{
			//S1.setSelected(true);
			S1.setEnabled(false);
		}
		if(day6.charAt(1)=='F')
		{
			//S2.setSelected(true);
			S2.setEnabled(false);
		}
		if(day6.charAt(2)=='F')
		{
			//S3.setSelected(true);
			S3.setEnabled(false);
		}
		if(day7.charAt(0)=='F')
		{
			//Su1.setSelected(true);
			Su1.setEnabled(false);
		}
		if(day7.charAt(1)=='F')
		{
			//Su2.setSelected(true);
			Su2.setEnabled(false);
		}
		if(day7.charAt(2)=='F')
		{
			//Su3.setSelected(true);
			Su3.setEnabled(false);
		}
		
	}
}
