import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRno, lblName, lblMrk1, lblMrk2, lblMrk3;
JTextField txtRno, txtName, txtMrk1, txtMrk2, txtMrk3;
JButton btnSave, btnBack;

UpdateFrame(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
Font f = new Font("TimesNewRoman", Font.BOLD, 20);

lblRno = new JLabel("Enter rno : ");			lblRno.setFont(f);
txtRno = new JTextField(18);				txtRno.setFont(f);
lblName = new JLabel("Enter new name : ");		lblName.setFont(f);
txtName = new JTextField(18);				txtName.setFont(f);
lblMrk1 = new JLabel("Enter new marks of sub1 : ");	lblMrk1.setFont(f);
txtMrk1 = new JTextField(18);				txtMrk1.setFont(f);
lblMrk2 = new JLabel("Enter new marks of sub2 : ");	lblMrk2.setFont(f);
txtMrk2 = new JTextField(18);				txtMrk2.setFont(f);
lblMrk3 = new JLabel("Enter new marks of sub3 : ");	lblMrk3.setFont(f);
txtMrk3 = new JTextField(18);				txtMrk3.setFont(f);
btnSave = new  JButton("Save");				btnSave.setFont(f);
btnBack = new JButton("Back");				btnBack.setFont(f);

c.add(lblRno);		c.add(txtRno);
c.add(lblName);		c.add(txtName);
c.add(lblMrk1);		c.add(txtMrk1);
c.add(lblMrk2);		c.add(txtMrk2);
c.add(lblMrk3);		c.add(txtMrk3);
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
	String s2 = txtName.getText();
	if(!s2.matches("^[a-zA-Z]*$")){
		txtName.setText("");
		txtName.requestFocus();
		throw new Exception("Enter alphabets only");
	}
	if(s2.equals("")){
		txtName.requestFocus();
		throw new Exception("U need to enter name.");
	}
	if(s2.length() < 2){
		txtName.setText("");
		txtName.requestFocus();
		throw new Exception("Name should be atleast 2 letters.");
	}
	String s3 = txtMrk1.getText();
	if(s3.equals("")){
		txtMrk1.requestFocus();
		throw new Exception("enter sub1 marks");
	}
	if(!s3.matches("[0-9]+")){
		txtMrk1.setText("");
		txtMrk1.requestFocus();
		throw new Exception("Enter only +ve integers in sub1");
	}
	int m1 = Integer.parseInt(s3);
	if(m1 < 0 || m1 > 100){
		txtMrk1.setText("");
		txtMrk1.requestFocus();
		throw new Exception("Marks should be between 0 and 100");
	}
	String s4 = txtMrk2.getText();
	if(s4.equals("")){
		txtMrk2.requestFocus();
		throw new Exception("enter sub2 marks");
	}
	if(!s4.matches("[0-9]+")){
		txtMrk2.setText("");
		txtMrk2.requestFocus();
		throw new Exception("Enter only +ve integers in sub2");
	}
	int m2 = Integer.parseInt(s4);
	if(m2 < 0 || m2 > 100){
		txtMrk2.setText("");
		txtMrk2.requestFocus();
		throw new Exception("Marks should be between 0 and 100");
	}
	String s5 = txtMrk3.getText();
	if(s5.equals("")){
		txtMrk3.requestFocus();
		throw new Exception("enter sub3 marks");
	}
	if(!s5.matches("[0-9]+")){
		txtMrk3.setText("");
		txtMrk3.requestFocus();
		throw new Exception("Enter only +ve integers in sub3");
	}
	int m3 = Integer.parseInt(s5);
	if(m3 < 0 || m3 > 100){
		txtMrk3.setText("");
		txtMrk3.requestFocus();
		throw new Exception("Marks should be between 0 and 100");
	}

	DbHandler.updateStudent(Integer.parseInt(txtRno.getText()), txtName.getText(), Integer.parseInt(txtMrk1.getText()), Integer.parseInt(txtMrk2.getText()), Integer.parseInt(txtMrk3.getText()));
	txtRno.setText("");	txtName.setText("");	txtMrk1.setText("");	txtMrk2.setText("");	txtMrk3.setText("");
}
/*catch(NumberFormatException e) {
	JOptionPane.showMessageDialog(c, "U nees to enter +ve integers", "Error", JOptionPane.ERROR_MESSAGE);
}*/
catch(Exception e){
	JOptionPane.showMessageDialog(c,e, "Error", JOptionPane.ERROR_MESSAGE);
}
};
btnSave.addActionListener(a2);


setTitle("Update Student ");
setSize(500,550);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
