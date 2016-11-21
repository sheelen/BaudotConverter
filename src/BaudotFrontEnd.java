import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class BaudotFrontEnd extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp=new JPanel();
	JLabel welcomelabel=new JLabel("BAUDOT CONVERTER");

	JPanel jpWest=new JPanel();
	JButton button1=new JButton("ENCODE"); 
	JButton button2=new JButton("DECODE");
	
	JPanel jpCenter=new JPanel();
	JTextArea outputArea=new JTextArea();

	JScrollPane jsp=new JScrollPane(outputArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	JPanel jpSouth=new JPanel();
	JTextArea codeWindow1=new JTextArea("Type Message to be ENCODED here",5,25);
	JScrollPane jsp1=new JScrollPane(codeWindow1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea codeWindow2=new JTextArea("Type Message to be DECODED here",5,25);
	JScrollPane jsp2=new JScrollPane(codeWindow2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	
	public BaudotFrontEnd(){
		super("BAUDOT CONVERTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setResizable(false);
		jp.setLayout(new BorderLayout());
		
		outputArea.setEditable(false);
		outputArea.setFont(new Font("Serif", Font.BOLD, 16));
		outputArea.setLineWrap(true);
		outputArea.setWrapStyleWord(true);
		codeWindow1.setLineWrap(true);
		codeWindow2.setLineWrap(true);
		//NORTH
		jp.add(welcomelabel,BorderLayout.NORTH);
		//CENTER
		jp.add(jsp,BorderLayout.CENTER);
		
		//WEST
		jpWest.setLayout(new GridLayout(2, 1));
		jpWest.add(button1);
		jpWest.add(button2);
		jp.add(jpWest,BorderLayout.WEST);
		
		//SOUTH		
		jpSouth.add(jsp1);
		jpSouth.add(jsp2);
		
		jp.add(jpSouth,BorderLayout.SOUTH);
		
		//jp.add(button1);
		//jp.add(button2);
		//jp.add(codeWindow1);
		
		add(jp);
		setVisible(true);
		
		button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
     //   System.out.println("button1 clicked"); 
        BaudotEncoder be=new BaudotEncoder(codeWindow1.getText());
        outputArea.setText(be.getOut());
        BaudotEncoder.count=true;
        }          
     });

	button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
       	BaudotDecoder bd=new BaudotDecoder(codeWindow2.getText());
        outputArea.setText(bd.getOut());
        BaudotDecoder.flag=true;
        }
     });
	}
	
	
	
	public static void main(String[] args){
		new BaudotFrontEnd();
	}



}