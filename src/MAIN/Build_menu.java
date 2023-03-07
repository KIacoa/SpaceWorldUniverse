package MAIN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Build_menu {
    void build_menu(JFrame frame,int frame_width,int frame_height,boolean is_map_select,boolean is_hero_select,boolean is_home_select,
                    JPanel menu_up_base,JButton hide_up,JPanel menu_base,JButton hide,JLabel border_line,JPanel menu,JButton map,JLabel underline_map,JButton hero,JLabel underline_hero,JButton home,JLabel underline_home){

        menu_up_base.setSize(80,50);
        menu_up_base.setOpaque(false);
        menu_up_base.setLayout(null);
        menu_up_base.setLocation(frame_width-menu_up_base.getWidth(),0);
        menu_up_base.setVisible(false);

        //导入隐藏后按钮图标
        ImageIcon icon_hide_up=new ImageIcon("src/images/back9.png");
        ImageIcon icon_hover_hide_up=new ImageIcon("src/images/back9-hover.png");
        hide_up.setSize(icon_hide_up.getIconWidth(),icon_hide_up.getIconHeight());
        hide_up.setIcon(icon_hide_up);
        hide_up.setRolloverIcon(icon_hover_hide_up);
        hide_up.setPressedIcon(icon_hover_hide_up);
        hide_up.setBorderPainted(false);
        hide_up.setContentAreaFilled(false);
        hide_up.setFocusPainted(false);

        hide_up.setLocation(0,0);

        menu_base.setSize(340,50);
        menu_base.setOpaque(false);
        menu_base.setLayout(null);
        menu_base.setLocation(frame_width-menu_base.getWidth(),0);
        ImageIcon icon_hide=new ImageIcon("src/images/back8.png");
        ImageIcon icon_hover_hide=new ImageIcon("src/images/back8-hover.png");
        hide.setSize(icon_hide.getIconWidth(),icon_hide.getIconHeight());
        hide.setIcon(icon_hide);
        hide.setRolloverIcon(icon_hover_hide);
        hide.setPressedIcon(icon_hover_hide);
        hide.setBorderPainted(false);
        hide.setContentAreaFilled(false);
        hide.setFocusPainted(false);
        hide.setLocation(0,0);
        border_line.setBackground(new Color(38,38,38));
        border_line.setSize(menu_base.getWidth()-35,2);
        border_line.setLocation(menu_base.getLocation().x+35,menu_base.getHeight());
        border_line.setVisible(true);
        border_line.setOpaque(true);
        //菜单栏事件
        hide_up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu_up_base.setVisible(false);
                menu_base.setVisible(true);
                border_line.setSize(menu_base.getWidth()-35,2);
                border_line.setLocation(menu_base.getLocation().x+35, menu_base.getHeight());
            }
        });
        hide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu_base.setVisible(false);
                menu_up_base.setVisible(true);
                border_line.setSize(menu_up_base.getWidth()-45,2);
                border_line.setLocation(menu_up_base.getLocation().x+45, menu_up_base.getHeight());
            }
        });
        menu.setSize(280,50);
        menu.setBackground(new Color(18,18,18,255));
        menu.setLocation(icon_hide.getIconWidth(),0);
        menu.setLayout(null);

        map.setText("地图");
        Font font = new Font("黑体", Font.BOLD, 23);//210 170 113
        map.setBackground(new Color(18,18,18));
        map.setForeground(new Color(255,255,255));
        map.setFont(font);
        map.setBorderPainted(false);
        map.setContentAreaFilled(false);
        map.setSize(menu.getWidth()/3,menu.getHeight()-5);
        map.setLocation(0,0);
        map.setVerticalAlignment(JButton.BOTTOM);
        map.setFocusPainted(false);
        underline_map.setBackground(new Color(199,154,60));
        underline_map.setSize(font.getSize()*2+10,2);
        underline_map.setVisible(true);
        underline_map.setOpaque(true);
        underline_map.setLocation(map.getLocation().x+(map.getWidth()-underline_map.getWidth())/2,map.getHeight());
        if(!is_map_select){
            map.setForeground(new Color(201,170,113));
            underline_map.setVisible(false);
            map.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Map map=new Map();
                    frame.dispose();
                }
            });
            map.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    underline_map.setVisible(true);
                    map.setForeground(new Color(255,255,255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    underline_map.setVisible(false);
                    map.setForeground(new Color(201,170,113));
                }
            });
        }


        hero.setText("英雄");
        hero.setBackground(new Color(18,18,18));
        hero.setForeground(new Color(255,255,255));
        hero.setFont(font);
        hero.setBorderPainted(false);
        hero.setContentAreaFilled(false);
        hero.setSize(menu.getWidth()/3,menu.getHeight()-5);
        hero.setLocation(menu.getWidth()/3,0);
        hero.setVerticalAlignment(JButton.BOTTOM);
        hero.setFocusPainted(false);
        underline_hero.setBackground(new Color(199,154,60));
        underline_hero.setSize(font.getSize()*2+10,2);
        underline_hero.setVisible(true);
        underline_hero.setOpaque(true);
        underline_hero.setLocation(hero.getLocation().x+(hero.getWidth()-underline_hero.getWidth())/2,hero.getHeight());
        if(!is_hero_select){
            hero.setForeground(new Color(201,170,113));
            underline_hero.setVisible(false);
            hero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hero hero=new Hero();
                    frame.dispose();
                }
            });
            hero.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    underline_hero.setVisible(true);
                    hero.setForeground(new Color(255,255,255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    underline_hero.setVisible(false);
                    hero.setForeground(new Color(201,170,113));
                }
            });
        }

        home.setText("主页");
        home.setBackground(new Color(18,18,18));
        home.setForeground(new Color(255,255,255));
        home.setFont(font);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setSize(menu.getWidth()/3,menu.getHeight()-5);
        home.setLocation(2*menu.getWidth()/3,0);
        home.setVerticalAlignment(JButton.BOTTOM);
        home.setFocusPainted(false);
        underline_home.setBackground(new Color(199,154,60));
        underline_home.setSize(font.getSize()*2+10,2);
        underline_home.setVisible(true);
        underline_home.setOpaque(true);
        underline_home.setLocation(home.getLocation().x+(home.getWidth()-underline_home.getWidth())/2,home.getHeight());
        if(!is_home_select){
            home.setForeground(new Color(201,170,113));
            underline_home.setVisible(false);
            home.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Home home=new Home();
                    frame.dispose();
                }
            });
            home.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    underline_home.setVisible(true);
                    home.setForeground(new Color(255,255,255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    underline_home.setVisible(false);
                    home.setForeground(new Color(201,170,113));
                }
            });
        }

    }
}
