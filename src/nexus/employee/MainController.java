package nexus.employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPage implements ActionListener{

    JFrame jf;
    JLabel lblimage,lbltitle;
    JButton badd,bremove,bview,bupdate;
    MainPage()
    {
        jf=new JFrame("メイン　ページ");

        //Background Image
        lblimage= new JLabel();
        lblimage.setBounds(0,0,900,600);
        lblimage.setLayout(null);
        ImageIcon i = new ImageIcon("Quan Ly Nhan Vien/Employee Management/src/Employee/images/main.png");
        lblimage.setIcon(i);
        jf.add(lblimage);

        //Adding Buttons
        //1.Add button
        badd=new JButton("追加");
        badd.setBounds(400,80,120,40);
        badd.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        badd.setForeground(Color.BLACK);
        badd.setBackground(Color.LIGHT_GRAY);
        lblimage.add(badd);

        //2.Remove Button
        bremove=new JButton("削除");
        bremove.setBounds(400,140,120,40);
        bremove.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bremove.setForeground(Color.BLACK);
        bremove.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bremove);

        //3.View Button
        bview=new JButton("検索");
        bview.setBounds(530,80,120,40);
        bview.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bview.setForeground(Color.BLACK);
        bview.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bview);

        //4.Update button
        bupdate=new JButton("更新");
        bupdate.setBounds(530,140,120,40);
        bupdate.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bupdate.setForeground(Color.BLACK);
        bupdate.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bupdate);

        //Add Action Listeners to buttons
        bview.addActionListener(this);
        bremove.addActionListener(this);
        badd.addActionListener(this);
        bupdate.addActionListener(this);

        //Frame details
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(30,30);
        jf.setSize(900,600);
        jf.setVisible(true);



    }
    public void actionPerformed(ActionEvent ae)
    {
    }
    public void setVisible(boolean b)
    {
        if(b==true)
            jf.setVisible(true);
        else
            jf.setVisible(false);
    }
    public static void main(String args[])
    {
        MainPage mp=new MainPage();
    }
}
