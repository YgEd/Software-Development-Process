package com.alset.htl;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TechInterface extends JFrame implements ActionListener {
    Container container = getContentPane();

    //buttons
    JButton log = new JButton("LOGS");
    JButton clear = new JButton("Clear Logs");
    JButton info = new JButton("SYSTEM INFO");
    JButton up = new JButton("UPDATE");
    JButton doup = new JButton("CHECK FOR UPDATES");

    //menu
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("View");
    JMenuItem m1a = new JMenuItem("User");
    JMenuItem m1b = new JMenuItem("Technician");

    //console area
    JLabel clable = new JLabel("CONSOLE");
    JTextArea console = new JTextArea();
    JScrollPane sp = new JScrollPane(console);



    TechInterface() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setTitle("Technician Interface");
        setVisible(true);
        setBounds(10, 10, 800, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void addComponentsToContainer() {
        container.add(log);
        container.add(sp);
        container.add(clable);
        container.add(clear);
        container.add(mb);
        container.add(info);
        container.add(up);
        container.add(doup);
        mb.add(m1);
        m1.add(m1a);
        m1.add(m1b);


        //makes textarea uneditable
        console.setEditable(false);
        
    }

    public void setLocationAndSize() {
        log.setBounds(75, 100, 100, 100);
        info.setBounds(225, 100, 150, 100);
        up.setBounds(425, 100, 175, 100);
        doup.setBounds(425, 200, 175, 40);
        sp.setBounds(75, 300, 600, 400);
        clable.setBounds(75, 250, 100, 50);
        mb.setBounds(10, 10, 40, 40);
        clear.setBounds(75, 200, 100, 40);

        

    }

    

    public void addActionEvent() {
        log.addActionListener(this);
        m1a.addActionListener(this);
        clear.addActionListener(this);
        info.addActionListener(this);
        up.addActionListener(this);
        doup.addActionListener(this);
       
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //action when presssing log button
        if (e.getSource() == log){

            //reads log.txt data into console text area
            File in = new File("Log.txt");
            String path = in.getAbsolutePath();
            try (FileReader reader = new FileReader(path)) {
                BufferedReader br = new BufferedReader(reader);

                try {
                    console.read(reader, null);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                
            }
        }

        //action when pressing user menu bar
        if (e.getSource() == m1a){
            //makes technician login open when pressing technician menu option
            setVisible(false);
            VehicleDisplay user = new VehicleDisplay();
       
        }

        //action when pressing clear button
        if (e.getSource() == clear){

            int n = JOptionPane.showConfirmDialog(TechInterface.this, "Are you sure you want to clear the logs?", "System Management", JOptionPane.YES_NO_OPTION);

            if (n == 0){

                Logger.clear();

             //reads log.txt data into console text area
             File in = new File("Log.txt");
            String path = in.getAbsolutePath();
             try (FileReader reader = new FileReader(path)) {
                 BufferedReader br = new BufferedReader(reader);
 
                 try {
                     console.read(reader, null);
                 } catch (IOException e1) {
                     // TODO Auto-generated catch block
                     
                 }
             } catch (IOException e1) {
                 // TODO Auto-generated catch block
                 
             }

            }

            

        }

        if (e.getSource() == info){
            console.setText("ALSET IOT VEHICLE\n");
            console.append("COPYRIGHT (c) 2022, ALSET and/or its affiliates. All rights reserved\n");
            console.append("CURRENT SOFTWARE VERSION " + SensorFusion.currVer + "\n");

        }

        if (e.getSource() == doup){
            if (SystemManagement.retrieveUpdate()){

                //pausing for 2 seconds
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                console.setText("New Update avaliable, version: " + SensorFusion.newVer + "\n");
            }
            else{
            console.setText("No new Updates\n");
            }
        }

        if (e.getSource() == up){
            if (SystemManagement.getUpdate()){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                console.append("Update downloaded successfully, version " + SensorFusion.currVer + " installed!\n");
            }
            else{
                console.append("No new Updates");
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO: replace with business logic
        
        TechInterface yes = new TechInterface();
    }

}