package MAIN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.WritableByteChannel;

public class Story_detail {
    JFrame frame_story_detail;
    JPanel panel;
    JPanel story_image_base;
    JPanel story_detail_base;
    JLabel story_image;
    JLabel story_title;
    Story_detail(int index){
        char[] info = new char[10000];
        for(int i=0;i<10000;i++){
            info[i]=(char)(-1);
        }
        File file=new File("src/data/story/story"+index+".txt");
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
        String story_info=new String(info);
        String title=story_info.substring(story_info.indexOf("title")+6,story_info.indexOf("\n",story_info.indexOf("title")));
        String author=story_info.substring(story_info.indexOf("author")+7,story_info.indexOf("\n",story_info.indexOf("author")));
        String main=story_info.substring(story_info.indexOf("main")+5,story_info.indexOf((char)(-1)));
        frame_story_detail=new JFrame();
        frame_story_detail.setSize(1200,800);
        frame_story_detail.setTitle(title);
        frame_story_detail.setLocation(0,0);
        frame_story_detail.setVisible(true);
        panel = new JPanel();
        panel.setBackground(new Color(10,10,12));
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setSize(frame_story_detail.getSize());
        JPanel j=(JPanel)frame_story_detail.getContentPane();
        j.setOpaque(false);
        story_detail_base=new JPanel();
        story_detail_base.setSize(frame_story_detail.getSize());
        story_detail_base.setVisible(false);
        story_detail_base.setOpaque(false);
        story_detail_base.setLayout(null);
        story_image_base=new JPanel();
        story_image_base.setSize(frame_story_detail.getSize());
        story_image_base.setVisible(true);
        story_image_base.setOpaque(false);
        story_image_base.setLayout(null);
        //icon_story=new ImageIcon(new ImageIcon("src/images/story/detail/story"+index+".jpg").getImage().getScaledInstance(story_button[i].getWidth() ,story_button[i].getHeight(), Image.SCALE_SMOOTH));
        ImageIcon icon_story_image=new ImageIcon("src/images/story/detail/story"+index+"-1.jpg");
        story_image=new JLabel(icon_story_image);
        story_image.setSize(icon_story_image.getIconWidth(),icon_story_image.getIconHeight());
        story_image.setLocation(0,0);
        JLabel story_image_title=new JLabel(title,JLabel.CENTER);
        story_image_title.setFont(new Font("黑体",Font.BOLD,60));
        story_image_title.setForeground(new Color(240,230,210));
        story_image_title.setSize(1200,60);
        story_image_title.setLocation((story_image_base.getWidth()-story_image_title.getWidth())/2,550);
        JLabel story_image_author=new JLabel("作者: "+author,JLabel.CENTER);
        story_image_author.setFont(new Font("黑体",Font.BOLD,25));
        story_image_author.setForeground(new Color(200,170,110));
        story_image_author.setSize(1200,25);
        story_image_author.setLocation((story_image_base.getWidth()-story_image_author.getWidth())/2,story_image_title.getLocation().y+story_image_title.getHeight()+10);
        //ImageIcon icon_hide_up_story=new ImageIcon(new ImageIcon("src/images/hide_up_detail_image1.png").getImage().getScaledInstance(400 ,58, Image.SCALE_SMOOTH));
        ImageIcon icon_hide_up_story=new ImageIcon("src/images/hide_up_detail_image1.png");
        ImageIcon icon_hide_up_story_hover=new ImageIcon("src/images/hide_up_detail_image1-hover.png");
        ImageIcon icon_hide_story=new ImageIcon("src/images/hide_detail_image1.png");
        ImageIcon icon_hide_story_hover=new ImageIcon("src/images/hide_detail_image1-hover.png");
        JButton hide_button=new JButton(icon_hide_up_story);
        hide_button.setSize(icon_hide_up_story.getIconWidth(),icon_hide_up_story.getIconHeight());
        hide_button.setLocation((story_detail_base.getWidth()-icon_hide_story.getIconWidth())/2,story_detail_base.getHeight()-icon_hide_story.getIconHeight()-40);
        hide_button.setIcon(icon_hide_story);
        hide_button.setRolloverIcon(icon_hide_story_hover);
        hide_button.setPressedIcon(icon_hide_story_hover);
        hide_button.setBorderPainted(false);
        hide_button.setContentAreaFilled(false);
        hide_button.setFocusPainted(false);

        JButton hide_up_button=new JButton(icon_hide_up_story);
        hide_up_button.setSize(icon_hide_up_story.getIconWidth(),icon_hide_up_story.getIconHeight());
        hide_up_button.setLocation((story_detail_base.getWidth()-icon_hide_up_story.getIconWidth())/2,2);
        hide_up_button.setIcon(icon_hide_up_story);
        hide_up_button.setRolloverIcon(icon_hide_up_story_hover);
        hide_up_button.setPressedIcon(icon_hide_up_story_hover);
        hide_up_button.setBorderPainted(false);
        hide_up_button.setContentAreaFilled(false);
        hide_up_button.setFocusPainted(false);
        hide_up_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                story_image_base.setVisible(true);
                story_detail_base.setVisible(false);
            }
        });

        JLabel detail_story_title=new JLabel(title,JLabel.CENTER);
        detail_story_title.setForeground(new Color(240,230,210));
        Font font_detail_story_title=new Font("黑体",Font.BOLD,30);
        detail_story_title.setFont(font_detail_story_title);
        detail_story_title.setSize(400,100);
        detail_story_title.setLocation((story_detail_base.getWidth()-detail_story_title.getWidth())/2,100);
        JLabel detail_story_author=new JLabel("作者: "+author,JLabel.CENTER);
        detail_story_author.setForeground(new Color(200,170,110));
        Font font_detail_story_author=new Font("黑体",Font.BOLD,15);
        detail_story_author.setFont(font_detail_story_author);
        detail_story_author.setSize(400,100);
        detail_story_author.setLocation((story_detail_base.getWidth()-detail_story_title.getWidth())/2,130);
        JPanel scrollpane_base=new JPanel();
        scrollpane_base.setBackground(new Color(10,10,12));
        scrollpane_base.setSize(1200,500);
        scrollpane_base.setVisible(true);
        scrollpane_base.setLayout(new GridLayout(1,3));
        JLabel left=new JLabel("");
        JLabel right=new JLabel("");
        left.setBackground(new Color(10,10,12));
        right.setBackground(new Color(10,10,12));
        JTextArea detail_story_story=new JTextArea();
        Font font_detail_story_story=new Font("黑体",Font.PLAIN,20);
        detail_story_story.setForeground(new Color(240,230,210));
        detail_story_story.setBackground(new Color(10,10,12));
        detail_story_story.setFont(font_detail_story_story);
        detail_story_story.setLineWrap(true);
        detail_story_story.setSize(story_detail_base.getWidth()/3,800);
        //detail_story_story.setLocation((story_detail_base.getWidth()-detail_story_story.getWidth())/2,300);
        //detail_story_story.setLocation((story_detail_base.getWidth()-detail_story_story.getWidth())/2,0);
        detail_story_story.setText(main);
        JScrollPane detail_scrollpane=new JScrollPane(
                scrollpane_base,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        detail_scrollpane.setOpaque(false);
        detail_scrollpane.setBorder(null);
        detail_scrollpane.setLocation(0,250);
        detail_scrollpane.setSize(story_detail_base.getWidth()+20,500);
        //detail_scrollpane.setBackground(new Color(10,10,12));
        scrollpane_base.add(left);
        scrollpane_base.add(detail_story_story);
        scrollpane_base.add(right);
        /*JScrollBar detail_scrollpane_Bar = detail_scrollpane.getVerticalScrollBar();
        detail_scrollpane_Bar.setValue(50);*/
        hide_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                story_image_base.setVisible(false);
                story_detail_base.setVisible(true);
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

        story_image_base.add(hide_button);
        story_image_base.add(story_image_title);
        story_image_base.add(story_image_author);
        story_image_base.add(story_image);
        story_detail_base.add(hide_up_button);
        story_detail_base.add(set_top);
        story_detail_base.add(detail_story_title);
        story_detail_base.add(detail_story_author);
        story_detail_base.add(detail_scrollpane);


        frame_story_detail.getLayeredPane().add(panel,new Integer(Integer.MIN_VALUE));
        frame_story_detail.getLayeredPane().add(story_detail_base,-1);
        frame_story_detail.getLayeredPane().add(story_image_base,0);
    }
}
