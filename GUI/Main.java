import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[]args){
        JFrame f=new JFrame("信息输入");
        f.setLayout(null);
        f.setLocation(300,300);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        f.setBackground(Color.WHITE);
        JPanel panel=new JPanel();
        panel.setBounds(10,0,500,90);
        //name label
        JLabel name=new JLabel("姓名: ");
        JTextField namejtf=new JTextField("",10);
        panel.add(name);
        panel.add(namejtf);
        //显示选择的信息模组
        JPanel displayPanel=new JPanel();
        displayPanel.setBounds(0,160,500,100);
        JTextArea disp=new JTextArea(10,20);
        displayPanel.add(disp);
        //sex block
        JPanel sexPanel=new JPanel();
        sexPanel.setBounds(0,100,500,50);
        JLabel sex=new JLabel("性别");
        ButtonGroup buttonGroup=new ButtonGroup();
        JRadioButton jRadioButton1=new JRadioButton("男");
        JRadioButton jRadioButton2=new JRadioButton("女");
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        JLabel btnGroup=new JLabel();
        sexPanel.add(sex);
        sexPanel.add(jRadioButton1);
        sexPanel.add(jRadioButton2);
        JButton button=new JButton("确认");
        sexPanel.add(button);
        //注册按钮的监听事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=namejtf.getText();
                String sex="";
                sex=jRadioButton1.isSelected()?"男":sex;
                sex=jRadioButton2.isSelected()?"女":sex;
                disp.setText("name="+name+"\nsex="+sex);
            }
        });
        f.add(panel);
        f.add(sexPanel);
        f.add(displayPanel);
        f.setVisible(true);
    }
}
