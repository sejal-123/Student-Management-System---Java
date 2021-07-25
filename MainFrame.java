import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{
Container c;
JButton btnAdd, btnView, btnUpd, btnDel, btnChr;

MainFrame(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
Font f = new Font("TimesNewRoman", Font.BOLD, 30);


btnAdd = new  JButton("Add");		btnAdd.setFont(f);
btnView = new JButton("View");		btnView.setFont(f);
btnUpd = new JButton("Update");		btnUpd.setFont(f);
btnDel = new JButton("Delete");		btnDel.setFont(f);
btnChr = new JButton("Charts");		btnChr.setFont(f);

c.add(btnAdd);		c.add(btnView);
c.add(btnUpd);		c.add(btnDel);
c.add(btnChr);

ActionListener a1 = (ae) -> {
AddFrame a = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {
ViewFrame v = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
UpdateFrame u = new UpdateFrame();
dispose();
};
btnUpd.addActionListener(a3);

ActionListener a4 = (ae) -> {
DeleteFrame d = new DeleteFrame();
dispose();
};
btnDel.addActionListener(a4);

ActionListener a5 = (ae) -> {
ChartsTest t = new ChartsTest();
dispose();
};
btnChr.addActionListener(a5);


setTitle("S.M.S. ");
setSize(550,550);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

