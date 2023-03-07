package MAIN;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Hero {
    JFrame frame_hero;
    JPanel panel;
    JPanel hero_base;
    JPanel[] hero_panel =new JPanel[10];
    JButton[] hero_button =new JButton[10];
    JPanel[] hero_name_panel =new JPanel[10];
    JLabel[] hero_name =new JLabel[10];
    JLabel[] hero_name_border =new JLabel[10];
    int[] hero_name_index =new int[1000];
    int hero_cnt=0;
    int page=0;
    int mx=26;
    int page_total=(hero_cnt-1)/10+1;
    Hero(){
        //创建窗体
        frame_hero=new JFrame();
        frame_hero.setSize(1200,800);
        frame_hero.setTitle("英雄");
        frame_hero.setLocation(0,0);
        frame_hero.setVisible(true);
        frame_hero.setDefaultCloseOperation(frame_hero.EXIT_ON_CLOSE);

        //背景面板
        panel = new JPanel();
        panel.setBackground(new Color(10,10,12));
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setSize(frame_hero.getSize());
        JPanel j=(JPanel)frame_hero.getContentPane();
        j.setOpaque(false);

        //中央英雄图标的界面面板
        hero_base=new JPanel();
        hero_base.setSize(frame_hero.getSize());
        hero_base.setVisible(true);
        hero_base.setOpaque(false);
        hero_base.setLayout(null);

        //上方代表英雄的图标
        ImageIcon icon_hero_logo=new ImageIcon(new ImageIcon("src/images/hero_logo.png").getImage().getScaledInstance(100/4 ,176/4, Image.SCALE_SMOOTH));
        JLabel hero_logo=new JLabel(icon_hero_logo);
        hero_logo.setSize(icon_hero_logo.getIconWidth(),icon_hero_logo.getIconHeight());
        hero_logo.setLocation((frame_hero.getWidth()-icon_hero_logo.getIconWidth())/2,30);

        //图标对应文本
        JLabel hero_label=new JLabel("英 雄",JLabel.CENTER);
        Font font_hero=new Font("黑体",Font.BOLD,35);
        hero_label.setFont(font_hero);
        hero_label.setForeground(new Color(196,185,152));
        hero_label.setSize(120,50);
        hero_label.setLocation((frame_hero.getWidth()-hero_label.getWidth())/2,85);

        //文字左右装饰
        ImageIcon icon_hero_line_left=new ImageIcon(new ImageIcon("src/images/hero_line_left2.png").getImage().getScaledInstance(450 ,15, Image.SCALE_SMOOTH));
        ImageIcon icon_hero_line_right=new ImageIcon(new ImageIcon("src/images/hero_line_right2.png").getImage().getScaledInstance(450 ,15, Image.SCALE_SMOOTH));
        JLabel hero_line_left=new JLabel(icon_hero_line_left);
        hero_line_left.setSize(icon_hero_line_left.getIconWidth(),icon_hero_line_left.getIconHeight());
        hero_line_left.setLocation(hero_label.getLocation().x-icon_hero_line_left.getIconWidth()-30,hero_label.getLocation().y+(hero_label.getHeight()-hero_line_left.getHeight())/2);
        JLabel hero_line_right=new JLabel(icon_hero_line_right);
        hero_line_right.setSize(icon_hero_line_right.getIconWidth(),icon_hero_line_right.getIconHeight());
        hero_line_right.setLocation(hero_label.getLocation().x+hero_label.getWidth()+30,hero_label.getLocation().y+(hero_label.getHeight()-hero_line_right.getHeight())/2);

        for(int i=0;i<10;i++){
            hero_panel[i]=new JPanel();
            hero_panel[i].setBackground(new Color(255,255,255));
            hero_panel[i].setOpaque(false);
            hero_panel[i].setSize(200,300);
            hero_panel[i].setLocation((i%5)*220+60,(i/5)*315+140);
            hero_panel[i].setLayout(null);


            hero_name_panel[i]=new JPanel();
            hero_name_panel[i].setBackground(new Color(10,10,12,180));
            hero_name_panel[i].setSize(hero_panel[i].getWidth(),40);
            hero_name_panel[i].setLocation(hero_panel[i].getLocation().x+(hero_panel[i].getWidth()-hero_name_panel[i].getWidth())/2,hero_panel[i].getLocation().y+(hero_panel[i].getHeight()-hero_name_panel[i].getHeight()));
            hero_name_panel[i].setLayout(null);
            hero_name[i]=new JLabel("",JLabel.CENTER);
            Font font_hero_name=new Font("黑体",Font.PLAIN,20);
            hero_name[i].setFont(font_hero_name);
            hero_name[i].setForeground(new Color(147,99,37));
            hero_name[i].setSize(hero_name_panel[i].getWidth(),hero_name_panel[i].getHeight()-1);
            hero_name[i].setLocation(0,hero_name_panel[i].getHeight()-hero_name[i].getHeight());
            hero_name_border[i]=new JLabel();
            hero_name_border[i].setVisible(true);
            hero_name_border[i].setOpaque(true);
            hero_name_border[i].setBackground(new Color(146,115,69));
            hero_name_border[i].setSize(hero_name_panel[i].getWidth(),1);
            hero_name_border[i].setLocation(0,0);

            hero_name_panel[i].add(hero_name[i]);
            hero_name_panel[i].add(hero_name_border[i]);

            frame_hero.getLayeredPane().add(hero_name_panel[i],2);
            hero_base.add(hero_panel[i]);
        }
        for(int i=0;i<mx;i++){
            hero_name_index[hero_cnt]=i;
            hero_cnt++;
        }
        page_total=(hero_cnt-1)/10+1;
        build_hero();

        //导入左右翻页图标
        ImageIcon icon_page_switch_up=new ImageIcon(new ImageIcon("src/images/page_switch_up2.png").getImage().getScaledInstance((int)(64*0.8) ,(int)(128*0.8) , Image.SCALE_SMOOTH));
        ImageIcon icon_page_switch_down=new ImageIcon(new ImageIcon("src/images/page_switch_down2.png").getImage().getScaledInstance((int)(64*0.8)  ,(int)(128*0.8), Image.SCALE_SMOOTH));
        ImageIcon icon_page_switch_up_hover=new ImageIcon(new ImageIcon("src/images/page_switch_up2-hover.png").getImage().getScaledInstance((int)(64*0.8)  ,(int)(128*0.8), Image.SCALE_SMOOTH));
        ImageIcon icon_page_switch_down_hover=new ImageIcon(new ImageIcon("src/images/page_switch_down2-hover.png").getImage().getScaledInstance((int)(64*0.8)  ,(int)(128*0.8), Image.SCALE_SMOOTH));

        JButton page_switch_up=new JButton(icon_page_switch_up);
        JButton page_switch_down=new JButton(icon_page_switch_down);
        page_switch_up.setSize(icon_page_switch_up.getIconWidth(),icon_page_switch_up.getIconHeight());
        page_switch_up.setIcon(icon_page_switch_up);
        page_switch_up.setRolloverIcon(icon_page_switch_up_hover);
        page_switch_up.setPressedIcon(icon_page_switch_up_hover);
        page_switch_up.setBorderPainted(false);
        page_switch_up.setContentAreaFilled(false);
        page_switch_up.setFocusPainted(false);
        page_switch_up.setLocation(hero_panel[9].getLocation().x+hero_panel[9].getWidth()+3,hero_panel[9].getLocation().y-8-page_switch_up.getHeight()/2);
        page_switch_down.setSize(icon_page_switch_down.getIconWidth(),icon_page_switch_down.getIconHeight());
        page_switch_down.setIcon(icon_page_switch_down);
        page_switch_down.setRolloverIcon(icon_page_switch_down_hover);
        page_switch_down.setPressedIcon(icon_page_switch_down_hover);
        page_switch_down.setBorderPainted(false);
        page_switch_down.setContentAreaFilled(false);
        page_switch_down.setFocusPainted(false);
        page_switch_down.setLocation(5,hero_panel[5].getLocation().y-8-page_switch_down.getHeight()/2);
        page_switch_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page++;
                if(page==page_total){
                    page=0;
                }
                build_hero();//点击重置面板
            }
        });
        page_switch_up.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_RIGHT){
                    page++;
                    if(page==page_total){
                        page=0;
                    }
                    build_hero();
                }
            }
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        });
        page_switch_down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page--;
                if(page==-1){
                    page=page_total-1;
                }
                build_hero();
            }
        });
        //把组件放入中间面板中
        hero_base.add(page_switch_up);
        hero_base.add(page_switch_down);
        hero_base.add(hero_logo);
        hero_base.add(hero_label);
        hero_base.add(hero_line_left);
        hero_base.add(hero_line_right);

        //菜单栏
        Build_menu build_menu=new Build_menu();
        JPanel menu_up_base=new JPanel();
        JButton hide_up=new JButton();
        JPanel menu_base=new JPanel();
        JButton hide=new JButton();
        JLabel border_line=new JLabel();
        JPanel menu=new JPanel();
        JButton map=new JButton();
        JLabel underline_map=new JLabel();
        JButton hero=new JButton();
        JLabel underline_hero=new JLabel();
        JButton home=new JButton();
        JLabel underline_home=new JLabel();
        build_menu.build_menu(frame_hero,frame_hero.getWidth(),frame_hero.getHeight(),false,true,false,menu_up_base,hide_up,menu_base,hide,border_line,menu,map,underline_map,hero,underline_hero,home,underline_home);

        //搜索框
        JTextField search_hero=new JTextField("",JTextField.CENTER);
        search_hero.setBackground(new Color(18,18,18));//196185152
        search_hero.setForeground(new Color(196,185,152));
        search_hero.setFont(new Font("黑体",Font.BOLD,20));
        search_hero.setBorder(BorderFactory.createLineBorder(new Color(75,60,41),1));//146,115,69
        search_hero.setCaretColor(new Color(147,115,65));
        search_hero.setSize(400,40);
        search_hero.setLocation(hero_line_left.getLocation().x,hero_line_left.getLocation().y-search_hero.getHeight()-20);

        //搜缩框提示文本
        JLabel search_hero_no=new JLabel("找到一个英雄");
        search_hero_no.setFont(new Font("黑体",Font.BOLD,20));
        search_hero_no.setForeground(new Color(47,40,30));
        search_hero_no.setVisible(true);
        search_hero_no.setSize(200,40);
        search_hero_no.setLocation(search_hero.getLocation().x,search_hero.getLocation().y);

        //焦点事件
        search_hero.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                search_hero.setBorder(BorderFactory.createLineBorder(new Color(146,115,69),1));//146,115,69
            }
            public void focusLost(FocusEvent e) {
                search_hero.setBorder(BorderFactory.createLineBorder(new Color(75,60,41),1));//146,115,69
            }
        });
        Document doc=search_hero.getDocument();
        //输入时事件
        doc.addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                Document doc_this = e.getDocument();
                String s="";
                try {
                    s=doc_this.getText(0, doc_this.getLength());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                hero_cnt=0;
                for(int i=0;i<mx;i++){
                    char[] info = new char[10000];
                    File file=new File("src/data/hero/hero"+i+".txt");
                    FileReader reader = null;
                    try {
                        reader = new FileReader(file);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        reader.read(info);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String hero_info=new String(info);
                    String name=hero_info.substring(hero_info.indexOf("name")+5,hero_info.indexOf("\n",hero_info.indexOf("name")));
                    boolean f=true;
                    for(int j=0;j<s.length();j++){
                        if(name.indexOf(s.charAt(j))==-1){
                            f=false;
                            break;
                        }
                    }
                    if(f){
                        hero_name_index[hero_cnt]=i;
                        hero_cnt++;
                    }
                }
                page_total=(hero_cnt-1)/10+1;
                page=0;
                build_hero();
                search_hero.setCaretColor(new Color(196,185,152));
                search_hero_no.setVisible(false);
            }

            //删除时事件
            public void removeUpdate(DocumentEvent e) {
                Document doc_this = e.getDocument();
                String s="";
                if(doc_this.getLength()==0){
                    hero_cnt=0;
                    for(int i=0;i<mx;i++){
                        hero_name_index[hero_cnt]=i;
                        hero_cnt++;
                    }
                    page_total=(hero_cnt-1)/10+1;
                    page=0;
                    build_hero();
                    search_hero.setCaretColor(new Color(147,115,65));
                    search_hero_no.setVisible(true);
                    //page_switch_up.setVisible(true);
                    //page_switch_down.setVisible(true);
                }
                else{
                    try {
                        s=doc_this.getText(0, doc_this.getLength());
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                    hero_cnt=0;
                    for(int i=0;i<mx;i++){
                        char[] info = new char[10000];
                        File file=new File("src/data/hero/hero"+i+".txt");
                        FileReader reader = null;
                        try {
                            reader = new FileReader(file);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }

                        try {
                            reader.read(info);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        String hero_info=new String(info);
                        String name=hero_info.substring(hero_info.indexOf("name")+5,hero_info.indexOf("\n",hero_info.indexOf("name")));
                        boolean f=true;
                        for(int j=0;j<s.length();j++){
                            if(name.indexOf(s.charAt(j))==-1){
                                f=false;
                                break;
                            }
                        }
                        if(f){
                            hero_name_index[hero_cnt]=i;
                            hero_cnt++;
                        }
                    }
                    page_total=(hero_cnt-1)/10+1;
                    page=0;
                    build_hero();
                    search_hero.setCaretColor(new Color(196,185,152));
                    search_hero_no.setVisible(false);
                }
            }
            public void changedUpdate(DocumentEvent e) {}
        });

        //菜单栏组件整合
        menu.add(underline_map);
        menu.add(underline_hero);
        menu.add(underline_home);
        menu.add(map);
        menu.add(hero);
        menu.add(home);
        menu_base.add(hide);
        menu_base.add(menu);
        menu_up_base.add(hide_up);

        //中央面板组件整合
        hero_base.add(search_hero);

        //所有整合完面板或组件方入窗体内容面板
        frame_hero.getLayeredPane().add(panel,new Integer(Integer.MIN_VALUE));
        frame_hero.getLayeredPane().add(search_hero_no,3);
        frame_hero.getLayeredPane().add(menu_base,1);
        frame_hero.getLayeredPane().add(border_line,1);
        frame_hero.getLayeredPane().add(menu_up_base,1);
        frame_hero.getLayeredPane().add(hero_base,-1);
    }
    ImageIcon icon_hero;
    void build_hero(){
        //换页时改变页面
        //更新每页十个英雄
        for(int i=0;i<10;i++){
            hero_panel[i].setVisible(false);
            hero_name_panel[i].setVisible(false);
            hero_panel[i].removeAll();
            int index=i+page*10;
            icon_hero=new ImageIcon("src/images/hero/hero"+hero_name_index[index]+"-1.jpg");
            hero_button[i]=new JButton();
            hero_button[i].setVisible(false);
            hero_button[i].setSize(hero_panel[i].getSize());
            hero_button[i].setBorderPainted(true);
            hero_button[i].setFocusPainted(true);
            hero_button[i].setBorder(null);
            if(index>=hero_cnt){
                hero_button[i].setVisible(false);
                hero_name_panel[i].setVisible(false);
            }
            else{
                hero_button[i].setVisible(true);
                hero_name_panel[i].setVisible(true);
            }
            hero_button[i].setIcon(icon_hero);
            hero_button[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Hero_detail hero_detail=new Hero_detail(hero_name_index[index]);
                }
            });
            int temp=i;
            hero_button[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {
                    hero_button[temp].setBorder(BorderFactory.createLineBorder(new Color(146,115,69),1));
                    hero_name_panel[temp].setSize(hero_panel[temp].getWidth()-2,40-1);
                    hero_name_panel[temp].setLocation(hero_panel[temp].getLocation().x+(hero_panel[temp].getWidth()-hero_name_panel[temp].getWidth())/2,hero_panel[temp].getLocation().y+(hero_panel[temp].getHeight()-hero_name_panel[temp].getHeight())-1);
                }
                public void mouseExited(MouseEvent e) {
                    hero_button[temp].setBorder(null);
                    hero_name_panel[temp].setSize(hero_panel[temp].getWidth(),40);
                    hero_name_panel[temp].setLocation(hero_panel[temp].getLocation().x+(hero_panel[temp].getWidth()-hero_name_panel[temp].getWidth())/2,hero_panel[temp].getLocation().y+(hero_panel[temp].getHeight()-hero_name_panel[temp].getHeight()));
                }
            });

            //导入更新后英雄对应的名字文本
            char[] info = new char[10000];
            File file=new File("src/data/hero/hero"+hero_name_index[index]+".txt");
            FileReader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            try {
                reader.read(info);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String hero_info=new String(info);
            String name=hero_info.substring(hero_info.indexOf("name")+5,hero_info.indexOf("\n",hero_info.indexOf("name")));
            hero_name[i].setText(name);
            hero_panel[i].add(hero_button[i]);
            hero_panel[i].setVisible(true);
        }
    }

}
