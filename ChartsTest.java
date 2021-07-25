import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import java.sql.*;

class ChartsTest extends JFrame{
JButton btnBack;

ChartsTest() {
Font f = new Font("TimesNewRoman", Font.BOLD, 20);

btnBack = new JButton("Back");	btnBack.setFont(f);

//step1 : create Datasets
DefaultCategoryDataset ds = new DefaultCategoryDataset();
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl123");

	String sql = "select * from (select name, marks1, marks2, marks3 from student order by (marks1+marks2+marks3) desc) where rownum<= 3";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next()) {
		String name = rs.getString(1);
		int marks1 = rs.getInt(2);
		int marks2 = rs.getInt(3);
		int marks3 = rs.getInt(4);
	
	ds.addValue(marks1, name, "S1");
	ds.addValue(marks2, name, "S2");
	ds.addValue(marks3, name, "S3");

	}

	rs.close();
}catch(SQLException e) {
	System.out.println("db issue : " + e);
}


//step2 : design chart
JFreeChart chart = ChartFactory.createBarChart(" ", "Subjects", "Marks", ds, PlotOrientation.VERTICAL, true, false, false);

//step3 : chart display
ChartPanel p = new ChartPanel(chart);
setContentPane(p);

p.add(btnBack);



ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("Top 3 Performers");
setSize(700, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
