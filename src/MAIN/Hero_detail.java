package MAIN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.WritableByteChannel;

public class Hero_detail {
    JFrame frame_hero_detail;
    JPanel panel;
    JPanel hero_image_base;
    JPanel hero_detail_base;
    JLabel hero_image;
    JLabel hero_name;
    Hero_detail(int index){
        char[] info = new char[10000];
        for(int i=0;i<10000;i++){
            info[i]=(char)(-1);
        }
        File file=new File("src/data/hero/hero"+index+".txt");
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
        String region=hero_info.substring(hero_info.indexOf("region")+7,hero_info.indexOf("\n",hero_info.indexOf("region")));
        //String main=hero_info.substring(hero_info.indexOf("main")+5,hero_info.indexOf("\n",hero_info.indexOf("main")));
        String main=hero_info.substring(hero_info.indexOf("main")+5,hero_info.indexOf((char)(-1)));
        frame_hero_detail=new JFrame();
        frame_hero_detail.setSize(1200,800);
        frame_hero_detail.setTitle(name);
        frame_hero_detail.setLocation(0,0);
        frame_hero_detail.setVisible(true);
        panel = new JPanel();
        panel.setBackground(new Color(10,10,12));
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setSize(frame_hero_detail.getSize());
        JPanel j=(JPanel)frame_hero_detail.getContentPane();
        j.setOpaque(false);
        hero_detail_base=new JPanel();
        hero_detail_base.setSize(frame_hero_detail.getSize());
        hero_detail_base.setVisible(false);
        hero_detail_base.setOpaque(false);
        hero_detail_base.setLayout(null);
        hero_image_base=new JPanel();
        hero_image_base.setSize(frame_hero_detail.getSize());
        hero_image_base.setVisible(true);
        hero_image_base.setOpaque(false);
        hero_image_base.setLayout(null);
        //icon_hero=new ImageIcon(new ImageIcon("src/images/hero/detail/hero"+index+".jpg").getImage().getScaledInstance(hero_button[i].getWidth() ,hero_button[i].getHeight(), Image.SCALE_SMOOTH));
        ImageIcon icon_hero_image=new ImageIcon("src/images/hero/detail2/hero"+index+"-1.jpg");
        hero_image=new JLabel(icon_hero_image);
        hero_image.setSize(icon_hero_image.getIconWidth(),icon_hero_image.getIconHeight());
        hero_image.setLocation(0,0);
        JLabel hero_image_name=new JLabel(name,JLabel.CENTER);
        hero_image_name.setFont(new Font("黑体",Font.BOLD,60));
        hero_image_name.setForeground(new Color(240,230,210));
        hero_image_name.setSize(400,100);
        hero_image_name.setLocation((hero_image_base.getWidth()-hero_image_name.getWidth())/2,550);
        //ImageIcon icon_hide_up_hero=new ImageIcon(new ImageIcon("src/images/hide_up_detail_image1.png").getImage().getScaledInstance(400 ,58, Image.SCALE_SMOOTH));
        ImageIcon icon_hide_up_hero=new ImageIcon("src/images/hide_up_detail_image1.png");
        ImageIcon icon_hide_up_hero_hover=new ImageIcon("src/images/hide_up_detail_image1-hover.png");
        ImageIcon icon_hide_hero=new ImageIcon("src/images/hide_detail_image1.png");
        ImageIcon icon_hide_hero_hover=new ImageIcon("src/images/hide_detail_image1-hover.png");
        JButton hide_button=new JButton(icon_hide_up_hero);
        hide_button.setSize(icon_hide_up_hero.getIconWidth(),icon_hide_up_hero.getIconHeight());
        hide_button.setLocation((hero_detail_base.getWidth()-icon_hide_hero.getIconWidth())/2,hero_detail_base.getHeight()-icon_hide_hero.getIconHeight()-40);
        hide_button.setIcon(icon_hide_hero);
        hide_button.setRolloverIcon(icon_hide_hero_hover);
        hide_button.setPressedIcon(icon_hide_hero_hover);
        hide_button.setBorderPainted(false);
        hide_button.setContentAreaFilled(false);
        hide_button.setFocusPainted(false);

        JButton hide_up_button=new JButton(icon_hide_up_hero);
        hide_up_button.setSize(icon_hide_up_hero.getIconWidth(),icon_hide_up_hero.getIconHeight());
        hide_up_button.setLocation((hero_detail_base.getWidth()-icon_hide_up_hero.getIconWidth())/2,2);
        hide_up_button.setIcon(icon_hide_up_hero);
        hide_up_button.setRolloverIcon(icon_hide_up_hero_hover);
        hide_up_button.setPressedIcon(icon_hide_up_hero_hover);
        hide_up_button.setBorderPainted(false);
        hide_up_button.setContentAreaFilled(false);
        hide_up_button.setFocusPainted(false);
        hide_up_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero_image_base.setVisible(true);
                hero_detail_base.setVisible(false);
            }
        });

        JLabel detail_hero_name=new JLabel(name,JLabel.CENTER);
        detail_hero_name.setForeground(new Color(240,230,210));
        Font font_detail_hero_name=new Font("黑体",Font.BOLD,30);
        detail_hero_name.setFont(font_detail_hero_name);
        detail_hero_name.setSize(200,100);
        detail_hero_name.setLocation((hero_detail_base.getWidth()-detail_hero_name.getWidth())/2,100);
        JLabel detail_hero_region=new JLabel(region,JLabel.CENTER);
        detail_hero_region.setForeground(new Color(200,170,110));
        Font font_detail_hero_region=new Font("黑体",Font.BOLD,15);
        detail_hero_region.setFont(font_detail_hero_region);
        detail_hero_region.setSize(200,100);
        detail_hero_region.setLocation((hero_detail_base.getWidth()-detail_hero_name.getWidth())/2,130);
        JPanel scrollpane_base=new JPanel();
        scrollpane_base.setBackground(new Color(10,10,12));
        scrollpane_base.setSize(1200,500);
        scrollpane_base.setVisible(true);
        scrollpane_base.setLayout(new GridLayout(1,3));
        JLabel left=new JLabel("");
        JLabel right=new JLabel("");
        left.setBackground(new Color(10,10,12));
        right.setBackground(new Color(10,10,12));
        JTextArea detail_hero_story=new JTextArea();
        Font font_detail_hero_story=new Font("黑体",Font.PLAIN,20);
        detail_hero_story.setForeground(new Color(240,230,210));
        detail_hero_story.setBackground(new Color(10,10,12));
        detail_hero_story.setFont(font_detail_hero_story);
        detail_hero_story.setLineWrap(true);
        detail_hero_story.setSize(hero_detail_base.getWidth()/3,800);
        //detail_hero_story.setLocation((hero_detail_base.getWidth()-detail_hero_story.getWidth())/2,300);
        //detail_hero_story.setLocation((hero_detail_base.getWidth()-detail_hero_story.getWidth())/2,0);
        detail_hero_story.setText(main);
        JScrollPane detail_scrollpane=new JScrollPane(
                scrollpane_base,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        detail_scrollpane.setOpaque(false);
        detail_scrollpane.setBorder(null);
        detail_scrollpane.setLocation(0,250);
        detail_scrollpane.setSize(hero_detail_base.getWidth()+20,500);
        //detail_scrollpane.setBackground(new Color(10,10,12));
        scrollpane_base.add(left);
        scrollpane_base.add(detail_hero_story);
        scrollpane_base.add(right);
        /*JScrollBar detail_scrollpane_Bar = detail_scrollpane.getVerticalScrollBar();
        detail_scrollpane_Bar.setValue(50);*/
        hide_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero_image_base.setVisible(false);
                hero_detail_base.setVisible(true);
                detail_scrollpane.getViewport().setViewPosition(new Point(0,0));
            }
        });
        ImageIcon icon_set_top=new ImageIcon("src/images/set_top1.png");
        ImageIcon icon_set_top_hover=new ImageIcon("src/images/set_top_hover1.png");
        JButton set_top=new JButton(icon_set_top);
        set_top.setSize(icon_set_top.getIconWidth(),icon_set_top.getIconHeight());
        set_top.setLocation(850,680);
        set_top.setIcon(icon_set_top);
        set_top.setRolloverIcon(icon_set_top_hover);
        set_top.setPressedIcon(icon_set_top_hover);
        set_top.setBorderPainted(false);
        set_top.setContentAreaFilled(false);
        set_top.setFocusPainted(false);
        set_top.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detail_scrollpane.getViewport().setViewPosition(new Point(0,0));
            }
        });

        hero_image_base.add(hide_button);
        hero_image_base.add(hero_image_name);
        hero_image_base.add(hero_image);
        hero_detail_base.add(hide_up_button);
        hero_detail_base.add(set_top);
        hero_detail_base.add(detail_hero_name);
        hero_detail_base.add(detail_hero_region);
        hero_detail_base.add(detail_scrollpane);


        frame_hero_detail.getLayeredPane().add(panel,new Integer(Integer.MIN_VALUE));
        frame_hero_detail.getLayeredPane().add(hero_detail_base,-1);
        frame_hero_detail.getLayeredPane().add(hero_image_base,0);

    }
}
