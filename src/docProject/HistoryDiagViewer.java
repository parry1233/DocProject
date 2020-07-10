package docProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HistoryDiagViewer extends JFrame
{
	private DefaultListModel<String> listModel=new DefaultListModel<>();
	private JPanel contentPane;
	private JList<String> list ;
	private JLabel lblpatientsSsn;
	private JLabel lbldiagnosis;
	private JLabel lblhowToCure;
	private JLabel lblmedicine;
	private JLabel lblnote;
	
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
					HistoryDiagViewer frame = new HistoryDiagViewer();
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
	public HistoryDiagViewer()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("History Patient Dianosis");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		list = new JList<String>();
		list.setVisibleRowCount(18);
		list.setFont(new Font("新細明體", Font.PLAIN, 20));
		scrollPane.setViewportView(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient's SSN");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 117, 32);
		panel_1.add(lblNewLabel_1);
		
		lblpatientsSsn = new JLabel("(Patient's SSN)");
		lblpatientsSsn.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblpatientsSsn.setBounds(155, 10, 225, 32);
		panel_1.add(lblpatientsSsn);
		
		JLabel label = new JLabel("診斷結果");
		label.setFont(new Font("新細明體", Font.PLAIN, 20));
		label.setBounds(10, 52, 117, 32);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("治療方式");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_1.setBounds(10, 94, 117, 32);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("治療用物");
		label_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_2.setBounds(10, 136, 117, 32);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("附註");
		label_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_3.setBounds(10, 178, 117, 32);
		panel_1.add(label_3);
		
		lbldiagnosis = new JLabel("(Diagnosis)");
		lbldiagnosis.setFont(new Font("新細明體", Font.PLAIN, 20));
		lbldiagnosis.setBounds(155, 52, 225, 32);
		panel_1.add(lbldiagnosis);
		
		lblhowToCure = new JLabel("(How to cure)");
		lblhowToCure.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblhowToCure.setBounds(155, 94, 225, 32);
		panel_1.add(lblhowToCure);
		
		lblmedicine = new JLabel("(Medicine)");
		lblmedicine.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblmedicine.setBounds(155, 136, 225, 32);
		panel_1.add(lblmedicine);
		
		lblnote = new JLabel("(Note)");
		lblnote.setVerticalAlignment(SwingConstants.TOP);
		lblnote.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblnote.setBounds(155, 178, 225, 116);
		panel_1.add(lblnote);
		
		JButton btnNewButton = new JButton("Edit Patient's Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Pat_Info_Edit viewer=new Pat_Info_Edit();
				viewer.setVisible(true);
				viewer.set_default_info(lblpatientsSsn.getText());
			}
		});
		btnNewButton.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		btnNewButton.setBounds(10, 406, 370, 56);
		panel_1.add(btnNewButton);
	}
	
	public void set_default_info(String docID)
	{
		setTitle(docID);
		try
		{
			XML_Reader reader = new XML_Reader();
			ArrayList<ArrayList<String>> temp=reader.matches_check(docID);
			for(int i=0;i<temp.get(0).size();i++)
			{
				listModel.addElement(temp.get(0).get(i));
			}
			
			list.setModel(listModel);
			
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) 
				{
					lblpatientsSsn.setText(temp.get(0).get(list.getSelectedIndex()));
					lbldiagnosis.setText(temp.get(1).get(list.getSelectedIndex()));
					lblhowToCure.setText(temp.get(2).get(list.getSelectedIndex()));
					lblmedicine.setText(temp.get(3).get(list.getSelectedIndex()));
					lblnote.setText(temp.get(4).get(list.getSelectedIndex()));
				}
			});
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
