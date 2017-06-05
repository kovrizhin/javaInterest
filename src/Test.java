package com.javacodegeeks.snippets.desktop;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class CreateJScrollPaneExample {

    private static final long serialVersionUID = 1L;

    private static void createAndShowGUI() {

        // Create and set up the window.
        final JFrame frame = new JFrame("Scroll Pane Example");

        // Display the window.
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set flow layout for the frame
        frame.getContentPane().setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea(5, 5);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);

    }

    public static void main(String[] args) {
//
//        Integer i1 = 127;
//        Integer i2 = 127;
//        System.out.println(i1==i2);
//
//        String a= "aaa";
//        String b= "aaa";
//        System.out.println(a==b);
//        String c= new String("aaa");
//        String d= new String("aaa");
//        System.out.println(c==d);

//        Integer i=5;

////        i+= ++i + ++i;
//        System.out.println( ++i + ++i);
//        i=5;
////        i+= i++ + ++i;
//        System.out.println(i++ + ++i);
//        i=5;
////        i+= ++i + i++;
//        System.out.println(++i + i++);
//        i=5;
////        i+= i++ + i++;
//        System.out.println(i++ + i++);

        try {
            String str[]= new String[0];
            String sda = str[1];



        } catch (Exception e){
            System.out.println(e);
        } catch (Throwable throwable ){
            System.out.println(throwable);

        }

//        CheckBoxTr
    }

}