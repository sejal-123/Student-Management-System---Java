import javax.swing.*;
import java.sql.*;

class DbHandler{

public static void addStudent(int rno, String name, int marks1, int marks2, int marks3){

try{
//s2: driver load kiya
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

//s3: database ko connect kiya
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl123");

	//s3a: String banana
	String sql = "insert into student values(?, ?, ?, ?, ?)";

	//s3b: Statement banana
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setInt(1, rno);
	stmt.setString(2, name);
	stmt.setInt(3, marks1);
	stmt.setInt(4, marks2);
	stmt.setInt(5, marks3);

	//s3c: statemnet ko execute krnna hai
	int r = stmt.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(), "Record added");

//s4 : database disconnect kiya
con.close();
}
catch(SQLException e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}

}

public static String viewStudent() {
String data = "";

try{
//s2: driver load kiya
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

//s3: database ko connect kiya
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl123");

	//s3a: String banana
	String sql = "select * from student";

	//s3b: Statement banana
	Statement stmt = con.createStatement();

	//s3c: statemnet ko execute krnna hai
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next())
		data = data + "Rno:" + rs.getInt("rno") + "   Name:" + rs.getString("name") + "   Marks1:" + rs.getInt("marks1") + "   Marks2:" + rs.getInt("marks2") + "   Marks3:" + rs.getInt("marks3") +"\n";

//s4 : database disconnect kiya
con.close();
}
catch(SQLException e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
return data;
}

public static void deleteStudent(int rno) {
String data = "";

try{
//s2: driver load kiya
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

//s3: database ko connect kiya
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl123");

	//s3a: String banana
	String sql = "delete from student where rno = ?";

	//s3b: Statement banana
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setInt(1, rno);

	//s3c: statemnet ko execute krnna hai
	int r = stmt.executeUpdate();
	if(r == 1){
		JOptionPane.showMessageDialog(new JDialog(), "Record deleted");
	}
	else{
		JOptionPane.showMessageDialog(new JDialog(), "Record does not exists");
	}


//s4 : database disconnect kiya
con.close();
}
catch(SQLException e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
}

public static void updateStudent(int rno, String name, int marks1, int marks2, int marks3){

try{
//s2: driver load kiya
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

//s3: database ko connect kiya
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl123");

	//s3a: String banana
	String sql = "update student set name = ?, marks1=?, marks2=?, marks3=? where rno = ?";

	//s3b: Statement banana
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, name);
	stmt.setInt(2, marks1);
	stmt.setInt(3, marks2);
	stmt.setInt(4, marks3);
	stmt.setInt(5, rno);
	
	//s3c: statemnet ko execute krnna hai
	int r = stmt.executeUpdate();
	if(r==1){
		JOptionPane.showMessageDialog(new JDialog(), "Record updated");
	}
	else{
		JOptionPane.showMessageDialog(new JDialog(), "Rno does not exists");
	}

//s4 : database disconnect kiya
con.close();
}
catch(SQLException e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}

}
}