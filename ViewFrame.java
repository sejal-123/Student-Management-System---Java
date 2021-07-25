import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame() {
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
Font f = new Font("TimesNewRoman", Font.BOLD, 15);

taData = new TextArea(10, 35);		taData.setFont(f);
btnBack = new JButton("Back");		btnBack.setFont(f);

ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);


c.add(taData);
c.add(btnBack);

taData.setText(DbHandler.viewStudent());

setTitle("View Student ");
setSize(500, 400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

