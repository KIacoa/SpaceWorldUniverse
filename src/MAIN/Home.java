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

public class Home {
    JFrame frame_home;
    JPanel panel;
    JPanel home_base;
    JLabel story_image;
    JPanel panel_story_center_base;
    JButton story_center_base;
    JLabel story_center_title;
    JLabel story_center_author;
    JTextArea story_center_begin;
    JLabel story_center_bottom_line;
    JLabel story_left_title;
    JLabel story_left_author;
    JLabel story_right_title;
    JLabel story_right_author;
    int num=0;
    int mx=5;
    Home(){
        //创建主页窗体
        frame_home=new JFrame();
        frame_home.setSize(1200,800);//三个预定窗体同等大小
        frame_home.setTitle("欢迎来到新的世界");//原本为主页，我换了个名字
        frame_home.setLocation(0,0);//不用改
        frame_home.setVisible(true);
        frame_home.setDefaultCloseOperation(frame_home.EXIT_ON_CLOSE);

        //背景面板
        panel = new JPanel();
        panel.setBackground(new Color(10,10,12));//背景底色
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setSize(frame_home.getSize());//好好好
        JPanel j=(JPanel)frame_home.getContentPane();
        j.setOpaque(false);

        //放在背景面板上的主要面板
        home_base=new JPanel();
        home_base.setBackground(new Color(10,10,12,180));
        home_base.setSize(frame_home.getSize());
        home_base.setVisible(true);
        home_base.setOpaque(false);
        home_base.setLayout(null);

        //右上角菜单栏，详细见Bulid_menu类
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
        build_menu.build_menu(frame_home,frame_home.getWidth(),frame_home.getHeight(),false,false,true,menu_up_base,hide_up,menu_base,hide,border_line,menu,map,underline_map,hero,underline_hero,home,underline_home);

        //导入主页的主体图片
        ImageIcon icon_story_image=new ImageIcon("src/images/story/story"+num+"-1.jpg");
        //放图片的label标签
        story_image=new JLabel();
        story_image.setVisible(true);
        story_image.setOpaque(true);
        story_image.setIcon(icon_story_image);
        story_image.setSize(icon_story_image.getIconWidth(),icon_story_image.getIconHeight());
        story_image.setLocation(0,menu_base.getHeight()+3);

        //导入主页左翻页按钮图片
        ImageIcon icon_story_switch_left=new ImageIcon("src/images/story_switch_left.png");
        //导入按钮图片鼠标按压时触发事件图片
        ImageIcon icon_story_switch_left_hover=new ImageIcon("src/images/story_switch_left_hover.png");
        //创建对应左翻页按钮
        JButton story_switch_left=new JButton(icon_story_switch_left);
        story_switch_left.setVisible(true);
        story_switch_left.setBorderPainted(false);
        story_switch_left.setContentAreaFilled(false);
        story_switch_left.setFocusPainted(false);
        story_switch_left.setIcon(icon_story_switch_left);
        story_switch_left.setPressedIcon(icon_story_switch_left_hover);
        story_switch_left.setRolloverIcon(icon_story_switch_left_hover);
        story_switch_left.setSize(icon_story_switch_left.getIconWidth(),icon_story_switch_left.getIconHeight());
        story_switch_left.setLocation(20,story_image.getLocation().y+(story_image.getHeight()-story_switch_left.getHeight())/2);
        //开始写按钮点击对应事件
        story_switch_left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=(num+mx-1)%mx;//当前页码更改
                build_story_center_base();//见下方具体方法
            }
        });

        //同上
        ImageIcon icon_story_switch_right=new ImageIcon("src/images/story_switch_right.png");
        ImageIcon icon_story_switch_right_hover=new ImageIcon("src/images/story_switch_right_hover.png");
        JButton story_switch_right=new JButton(icon_story_switch_right);
        story_switch_right.setVisible(true);
        story_switch_right.setBorderPainted(false);
        story_switch_right.setContentAreaFilled(false);
        story_switch_right.setFocusPainted(false);
        story_switch_right.setIcon(icon_story_switch_right);
        story_switch_right.setPressedIcon(icon_story_switch_right_hover);
        story_switch_right.setRolloverIcon(icon_story_switch_right_hover);
        story_switch_right.setSize(icon_story_switch_right.getIconWidth(),icon_story_switch_right.getIconHeight());
        story_switch_right.setLocation(home_base.getWidth()-story_switch_right.getWidth()-20,story_image.getLocation().y+(story_image.getHeight()-story_switch_right.getHeight())/2);
        story_switch_right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=(num+1)%mx;
                build_story_center_base();
            }
        });

        //故事页下方按钮的承载面板
        JPanel panel_story_bottom=new JPanel();
        panel_story_bottom.setLayout(null);
        panel_story_bottom.setVisible(true);
        panel_story_bottom.setOpaque(false);
        panel_story_bottom.setSize(frame_home.getWidth(),300);
        panel_story_bottom.setLocation(0,story_image.getLocation().y+story_image.getHeight()-40);

        //导入图片素材然后创建对应按钮
        ImageIcon icon_story_center_base=new ImageIcon("src/images/story-center-base2.png");
        ImageIcon icon_story_center_base_hover=new ImageIcon("src/images/story-center-base2-hover.png");
        story_center_base=new JButton(icon_story_center_base);
        story_center_base.setVisible(true);
        story_center_base.setBorderPainted(false);
        story_center_base.setContentAreaFilled(false);
        story_center_base.setFocusPainted(false);
        story_center_base.setIcon(icon_story_center_base);
        story_center_base.setRolloverIcon(icon_story_center_base_hover);
        story_center_base.setPressedIcon(icon_story_center_base_hover);
        story_center_base.setSize(icon_story_center_base.getIconWidth(),icon_story_center_base.getIconHeight());
        story_center_base.setLocation(0,0);
        //设置按钮事件
        story_center_base.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            //鼠标移动到按钮上触发事件，移开按钮触发事件
            public void mouseEntered(MouseEvent e) {
                story_center_begin.setBackground(new Color(14,17,20));
            }
            public void mouseExited(MouseEvent e) {
                story_center_begin.setBackground(new Color(22,23,27));
            }
        });

        //创建下方文本对应承载面板
        panel_story_center_base=new JPanel();
        panel_story_center_base.setVisible(true);
        panel_story_center_base.setOpaque(false);
        panel_story_center_base.setLayout(null);
        panel_story_center_base.setSize(story_center_base.getSize());
        panel_story_center_base.setLocation((panel_story_bottom.getWidth()-panel_story_center_base.getWidth())/2,0);

        //左下方切换按钮
        JButton story_left_base=new JButton();
        story_left_base.setVisible(true);
        story_left_base.setBackground(new Color(15,15,15));
        story_left_base.setBorderPainted(false);
        story_left_base.setFocusPainted(false);
        story_left_base.setSize((panel_story_bottom.getWidth()-panel_story_center_base.getWidth())/2,panel_story_center_base.getHeight()-40*2);
        story_left_base.setLocation(0,0);
        story_left_base.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=(num+mx-1)%mx;
                build_story_center_base();
            }
        });
        story_left_base.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                story_left_base.setVisible(false);
            }
            public void mouseReleased(MouseEvent e) {
                story_left_base.setVisible(true);
                num=(num+mx-1)%mx;
                build_story_center_base();
            }
            public void mouseEntered(MouseEvent e) {
                story_left_title.setVisible(false);
                story_left_title.setVisible(true);
            }
            public void mouseExited(MouseEvent e) {
                story_left_title.setVisible(false);
                story_left_title.setVisible(true);
            }
        });

        JPanel panel_story_left_base=new JPanel();
        panel_story_left_base.setVisible(true);
        panel_story_left_base.setOpaque(false);
        panel_story_left_base.setLayout(null);
        panel_story_left_base.setSize(story_left_base.getSize());
        panel_story_left_base.setLocation(0,40);

        //右下方切换按钮
        JButton story_right_base=new JButton();
        story_right_base.setVisible(true);
        story_right_base.setBackground(new Color(15,15,15));
        story_right_base.setBorderPainted(false);
        story_right_base.setFocusPainted(false);
        story_right_base.setSize((panel_story_bottom.getWidth()-panel_story_center_base.getWidth())/2,panel_story_center_base.getHeight()-40*2);
        story_right_base.setLocation(0,0);
        story_right_base.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=(num+1)%mx;
                build_story_center_base();
            }
        });
        story_right_base.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                story_right_base.setVisible(false);
            }
            public void mouseReleased(MouseEvent e) {
                story_right_base.setVisible(true);
                num=(num+1)%mx;
                build_story_center_base();
            }
            public void mouseEntered(MouseEvent e) {
                story_right_title.setVisible(false);
                story_right_title.setVisible(true);
            }
            public void mouseExited(MouseEvent e) {
                story_right_title.setVisible(false);
                story_right_title.setVisible(true);
            }
        });

        JPanel panel_story_right_base=new JPanel();
        panel_story_right_base.setVisible(true);
        panel_story_right_base.setOpaque(false);
        panel_story_right_base.setLayout(null);
        panel_story_right_base.setSize(story_right_base.getSize());
        panel_story_right_base.setLocation(panel_story_center_base.getLocation().x+panel_story_center_base.getWidth(),panel_story_left_base.getLocation().y);

        //下方两条装饰线
        JLabel story_up_line=new JLabel();
        story_up_line.setVisible(true);
        story_up_line.setOpaque(true);
        story_up_line.setBackground(new Color(29,29,29));
        story_up_line.setSize(panel_story_bottom.getWidth(),2);
        story_up_line.setLocation(0,panel_story_left_base.getLocation().y-story_up_line.getHeight());
        JLabel story_down_line=new JLabel();
        story_down_line.setVisible(true);
        story_down_line.setOpaque(true);
        story_down_line.setBackground(new Color(29,29,29));
        story_down_line.setSize(panel_story_bottom.getWidth(),2);
        story_down_line.setLocation(0,panel_story_left_base.getLocation().y+story_left_base.getHeight());

        //中央文本中作者
        story_center_author=new JLabel("作者:",JLabel.CENTER);
        story_center_author.setVisible(true);
        story_center_author.setSize(panel_story_center_base.getWidth()-100,18);
        story_center_author.setFont(new Font("黑体",Font.BOLD,18));
        story_center_author.setForeground(new Color(196,185,152));
        story_center_author.setLocation((panel_story_center_base.getWidth()-story_center_author.getWidth())/2,60);

        //中央文本中标题
        story_center_title=new JLabel("test",JLabel.CENTER);
        story_center_title.setVisible(true);
        story_center_title.setSize(panel_story_center_base.getWidth()-100,36);
        story_center_title.setFont(new Font("黑体",Font.BOLD,36));
        story_center_title.setForeground(new Color(147,115,65));
        story_center_title.setLocation((panel_story_center_base.getWidth()-story_center_title.getWidth())/2,story_center_author.getLocation().y+story_center_author.getHeight()+5);

        //中央文本主体
        story_center_begin=new JTextArea();
        story_center_begin.setForeground(new Color(196,185,152));
        story_center_begin.setBackground(new Color(22,23,27));
        story_center_begin.setFont(new Font("黑体",Font.PLAIN,15));
        story_center_begin.setLineWrap(true);
        story_center_begin.setSize(panel_story_center_base.getWidth()-100,74);
        story_center_begin.setLocation((panel_story_center_base.getWidth()-story_center_begin.getWidth())/2,story_center_title.getLocation().y+story_center_title.getHeight()+5);

        //中央文本中装饰下滑线
        story_center_bottom_line=new JLabel();
        story_center_bottom_line.setVisible(true);
        story_center_bottom_line.setOpaque(true);
        story_center_bottom_line.setBackground(new Color(147,115,65));
        story_center_bottom_line.setSize(80,3);
        story_center_bottom_line.setLocation((panel_story_center_base.getWidth()-story_center_bottom_line.getWidth())/2,story_center_begin.getLocation().y+story_center_begin.getHeight()+5);

        //左下方按钮文本作者
        story_left_author=new JLabel("作者:",JLabel.CENTER);
        story_left_author.setVisible(true);
        story_left_author.setSize(panel_story_left_base.getWidth()-50,18);
        story_left_author.setFont(new Font("黑体",Font.PLAIN,18));
        story_left_author.setForeground(new Color(42,40,35));
        story_left_author.setLocation((panel_story_left_base.getWidth()-story_left_author.getWidth())/2,50);

        //左下方按钮文本标题
        story_left_title=new JLabel("test",JLabel.CENTER);
        story_left_title.setVisible(true);
        story_left_title.setSize(panel_story_left_base.getWidth()-50,36);
        story_left_title.setFont(new Font("黑体",Font.PLAIN,36));
        story_left_title.setForeground(new Color(35,30,22));
        story_left_title.setLocation((panel_story_left_base.getWidth()-story_left_title.getWidth())/2,story_left_author.getLocation().y+story_left_author.getHeight()+5);

        //右下方按钮文本作者
        story_right_author=new JLabel("作者:",JLabel.CENTER);
        story_right_author.setVisible(true);
        story_right_author.setSize(panel_story_right_base.getWidth()-50,18);
        story_right_author.setFont(new Font("黑体",Font.PLAIN,18));
        story_right_author.setForeground(new Color(42,40,35));
        story_right_author.setLocation((panel_story_right_base.getWidth()-story_right_author.getWidth())/2,50);

        //右下方按钮文本标题
        story_right_title=new JLabel("test",JLabel.CENTER);
        story_right_title.setVisible(true);
        story_right_title.setSize(panel_story_right_base.getWidth()-50,36);
        story_right_title.setFont(new Font("黑体",Font.PLAIN,36));
        story_right_title.setForeground(new Color(35,30,22));
        story_right_title.setLocation((panel_story_right_base.getWidth()-story_right_title.getWidth())/2,story_right_author.getLocation().y+story_right_author.getHeight()+5);

        //绘制主页初始界面
        build_story_center_base();

        //下方按钮有关组件放入下方按钮承载面板
        panel_story_bottom.add(panel_story_center_base);
        panel_story_bottom.add(panel_story_left_base);
        panel_story_bottom.add(panel_story_right_base);
        panel_story_bottom.add(story_up_line);
        panel_story_bottom.add(story_down_line);

        //左下方按钮面板加入对应组件
        panel_story_left_base.add(story_left_author);
        panel_story_left_base.add(story_left_title);
        panel_story_left_base.add(story_left_base);
        //右下方按钮面板加入对应组件
        panel_story_right_base.add(story_right_author);
        panel_story_right_base.add(story_right_title);
        panel_story_right_base.add(story_right_base);

        //菜单栏组件处理
        menu.add(underline_map);
        menu.add(underline_hero);
        menu.add(underline_home);
        menu.add(map);
        menu.add(hero);
        menu.add(home);
        menu_base.add(hide);
        menu_base.add(menu);
        menu_up_base.add(hide_up);

        //总体汇总到面板home_base
        //中央按钮面板
        home_base.add(panel_story_bottom);
        //左右按钮面板
        home_base.add(story_switch_left);
        home_base.add(story_switch_right);
        //主体面板图片
        home_base.add(story_image);

        //把所有整合的组件导入窗体内容面板
        frame_home.getLayeredPane().add(panel,new Integer(Integer.MIN_VALUE));
        frame_home.getLayeredPane().add(home_base,-1);
        frame_home.getLayeredPane().add(menu_base,1);
        frame_home.getLayeredPane().add(border_line,1);
        frame_home.getLayeredPane().add(menu_up_base,1);
        //frame_home.getLayeredPane().add(story_image,-1);
    }
    void build_story_center_base(){
        //导入图片
        ImageIcon icon_story_image=new ImageIcon("src/images/story/story"+num+"-1.jpg");
        story_image.setIcon(icon_story_image);
        story_image.setVisible(false);
        char[] info = new char[10000];

        //导入文本
        File file=new File("src/data/story/story"+num+".txt");
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

        //分割文本
        String hero_info=new String(info);
        String title=hero_info.substring(hero_info.indexOf("title")+6,hero_info.indexOf("\n",hero_info.indexOf("title")));
        String author=hero_info.substring(hero_info.indexOf("author")+7,hero_info.indexOf("\n",hero_info.indexOf("author")));
        String begin=hero_info.substring(hero_info.indexOf("begin")+6,hero_info.indexOf("\n",hero_info.indexOf("begin")));

        //文本方入中央按钮中的文本
        story_center_author.setText("作者: "+author);
        story_center_title.setText(title);
        story_center_begin.setText(begin);

        //清空中下方面板组件
        panel_story_center_base.setVisible(false);
        panel_story_center_base.removeAll();

        //导入中下方按钮的装饰框体
        ImageIcon icon_story_center_base=new ImageIcon("src/images/story-center-base2.png");
        ImageIcon icon_story_center_base_hover=new ImageIcon("src/images/story-center-base2-hover.png");

        //设置中下方面板参数
        story_center_base=new JButton(icon_story_center_base);
        story_center_base.setVisible(true);
        story_center_base.setBorderPainted(false);
        story_center_base.setContentAreaFilled(false);
        story_center_base.setFocusPainted(false);
        story_center_base.setIcon(icon_story_center_base);
        story_center_base.setRolloverIcon(icon_story_center_base_hover);
        story_center_base.setPressedIcon(icon_story_center_base_hover);
        story_center_base.setSize(icon_story_center_base.getIconWidth(),icon_story_center_base.getIconHeight());
        story_center_base.setLocation(0,0);
        story_center_base.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            //设置鼠标掠过时的反馈
            public void mouseEntered(MouseEvent e) {story_center_begin.setBackground(new Color(14,17,20));}
            public void mouseExited(MouseEvent e) {
                story_center_begin.setBackground(new Color(22,23,27));
            }
        });
        story_center_base.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Story_detail story_detail=new Story_detail(num);
            }
        });


        info = new char[10000];
        file=new File("src/data/story/story"+(num+1)%mx+".txt");
        reader = null;
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
        hero_info=new String(info);
        String title_right=hero_info.substring(hero_info.indexOf("title")+6,hero_info.indexOf("\n",hero_info.indexOf("title")));
        String author_right=hero_info.substring(hero_info.indexOf("author")+7,hero_info.indexOf("\n",hero_info.indexOf("author")));
        //这一句可以删
        String begin_right=hero_info.substring(hero_info.indexOf("begin")+6,hero_info.indexOf("\n",hero_info.indexOf("begin")));
        story_right_author.setText("作者: "+author_right);
        story_right_title.setText(title_right);

        info = new char[10000];
        file=new File("src/data/story/story"+(num+mx-1)%mx+".txt");
        reader = null;
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
        hero_info=new String(info);
        String title_left=hero_info.substring(hero_info.indexOf("title")+6,hero_info.indexOf("\n",hero_info.indexOf("title")));
        String author_left=hero_info.substring(hero_info.indexOf("author")+7,hero_info.indexOf("\n",hero_info.indexOf("author")));
        //这一句也可以删
        String begin_left=hero_info.substring(hero_info.indexOf("begin")+6,hero_info.indexOf("\n",hero_info.indexOf("begin")));
        story_left_author.setText("作者: "+author_left);
        story_left_title.setText(title_left);

        //重组中央按钮面板
        story_image.setVisible(true);
        panel_story_center_base.add(story_center_author);
        panel_story_center_base.add(story_center_title);
        panel_story_center_base.add(story_center_begin);
        panel_story_center_base.add(story_center_bottom_line);
        panel_story_center_base.add(story_center_base);
        panel_story_center_base.setVisible(true);
    }
}
