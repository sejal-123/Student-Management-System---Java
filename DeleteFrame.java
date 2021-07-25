import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave, btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 24));
Font f = new Font("TimesNewRoman", Font.BOLD, 20);

lblRno = new JLabel("Enter rno : ");			lblRno.setFont(f);
txtRno = new JTextField(18);				txtRno.setFont(f);
btnSave = new  JButton("Save");				btnSave.setFont(f);
btnBack = new JButton("Back");				btnBack.setFont(f);

c.add(lblRno);		c.add(txtRno);
c.add(btnSave);		c.add(btnBack);

ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
try{
	String s1 = txtRno.getText();
	if(s1.equals("")){
		txtRno.setText("");
		txtRno.requestFocus();
		throw new Exception("Invalid rno");
	}
	if(!s1.matches("[0-9]+")){
		txtRno.setText("");
		txtRno.requestFocus();
		throw new Exception("Enter +ve integers only");
	}
	int rno = Integer.parseInt(s1);
	if(rno < 0){
		txtRno.setText("");
		txtRno.requestFocus();
		throw new Exception("U need to enter only +ve integer in roll no");
	}
	DbHandler.deleteStudent(rno);
	txtRno.setText("");
}
catch(Exception e){
	JOptionPane.showMessageDialog(c,e, "Error", JOptionPane.ERROR_MESSAGE);
	txtRno.setText("");
}
};
btnSave.addActionListener(a2);

setTitle("Delete Student ");
setSize(500,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
