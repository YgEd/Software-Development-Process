package com.alset.htl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.util.Random; 
import java.awt.*;
import javax.swing.event.*;

public class VehicleDisplay extends JFrame {
    private boolean start = false;
    private boolean ccontrol = false;
    private boolean turnL = false;
    private boolean turnR = false;
    private int amount_dirs = 0;
    private boolean headlight = false;
    private String destination;
    private boolean smartweath = false;
    //class constructor
    public VehicleDisplay(){



        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setTitle("ALSET PROTOTYPE V.1");
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        // setVisible(true);
        // c.fill = GridBagConstraints.HORIZONTAL;


        //menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("View");
        mb.add(m1);
        JMenuItem m1a = new JMenuItem("User");
        JMenuItem m1b = new JMenuItem("Technician");
        m1.add(m1a);
        m1.add(m1b);

        c.fill = GridBagConstraints.NONE;
        //c.weightx = 0.5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(0, 0, 10, 0);
        add(mb, c);

        //makes technician login open when pressing technician menu option

        m1b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginFrame frame = new LoginFrame();
            } 
        });




        //buttons

        JButton start = new JButton("Button Start");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 20);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        add(start, c);

        JButton cruise = new JButton("Cruise Control");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 15);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        add(cruise, c);


        //Cruise Control input box
        JTextField in = new JTextField(10);
        c.fill = GridBagConstraints.VERTICAL;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(-10, 0, 15, 15);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        add(in, c);

        JButton curr = new JButton("Speed");
        curr.setPreferredSize(new Dimension(100,40));
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 0);
        curr.setBorder(BorderFactory.createRaisedBevelBorder());
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(curr, c);

        JButton brake = new JButton("Brake");
        brake.setPreferredSize(new Dimension(100, 40));
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 10, 0);
        brake.setBorder(BorderFactory.createRaisedBevelBorder());
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        add(brake, c);


        JButton speed = new JButton("SET SPEED");
        brake.setPreferredSize(new Dimension(100, 40));
        c.insets = new Insets(0, 0, 0, 0);
        c.fill = GridBagConstraints.NONE;
        speed.setBorder(BorderFactory.createRaisedBevelBorder());
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;
        speed.setBackground(Color.black);
        speed.setForeground(Color.white);
        add(speed, c);        

        JSlider gears = new JSlider(0, 150);
        c.insets = new Insets(0, 0, 20, 10);
        gears.setPaintTrack(true);
        gears.setPaintLabels(true);
        gears.setOrientation(SwingConstants.HORIZONTAL);
        gears.setMajorTickSpacing(50);
        gears.setMinorTickSpacing(5);
        gears.setBorder(BorderFactory.createLoweredBevelBorder());
        c.gridx = 1;
        c.gridy = 0;
        add(gears, c);

       
        //slider action
        gears.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(ChangeEvent ce){
                speed.setText("SET SPEED = " + gears.getValue());
            }
            
        });

        speed.setText("SET SPEED = " + gears.getValue());

        

        JButton forward = new JButton("Forward");
        brake.setPreferredSize(new Dimension(40, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 20);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 1;
        add(forward, c);

        JButton rev = new JButton("Reverse");
        brake.setPreferredSize(new Dimension(40, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 20);
        c.ipady = 0;
        c.gridx = 4;
        c.gridy = 1;
        add(rev, c);

        JButton neutral = new JButton("Neutral");
        brake.setPreferredSize(new Dimension(100, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 20);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 2;
        add(neutral, c);


        JButton park = new JButton("Park");
        brake.setPreferredSize(new Dimension(100, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 20);
        c.ipady = 0;
        c.gridx = 4;
        c.gridy = 2;
        add(park, c);

        JButton left = new JButton("Turn Left");
        left.setPreferredSize(new Dimension(100, 40));
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 30);
        left.setBorder(BorderFactory.createRaisedBevelBorder());
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;
        add(left, c);

        JButton right = new JButton("Turn Right");
        right.setPreferredSize(new Dimension(100, 40));
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0, 0, 0, 30);
        right.setBorder(BorderFactory.createRaisedBevelBorder());
        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 2;
        add(right, c);
         

        //display
        JLabel textlable = new JLabel("      DISPLAY      ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 4;
        c.ipady = 0;
        textlable.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(textlable, c);

        JTextArea disp = new JTextArea("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 5;
        c.ipady = 40;
        //c.gridwidth = 3;
        disp.setOpaque(true);
        disp.setForeground(Color.green);
        disp.setBackground(Color.black);
        disp.setEditable(false);
        add(disp, c);


        //GPS
        JButton gps = new JButton("Enter Destination");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(-10, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 5;
        c.gridy = 1;
        add(gps, c);


        //GPS input box
        JTextField in_gps = new JTextField(10);
        c.fill = GridBagConstraints.NONE;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(-10, 0, 15, 0);
        c.ipady = 0;
        c.gridx = 5;
        c.gridy = 2;
        add(in_gps, c);

        JButton lights = new JButton("Head Lights: OFF");
        c.fill = GridBagConstraints.NONE;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 0;
        add(lights, c);

        JButton weather = new JButton("Smart Weather: OFF");
        c.fill = GridBagConstraints.NONE;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 5;
        c.gridy = 0;
        add(weather, c);


        //Button actions

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == false){

                    File file = new File("start.wav");
                    String path = file.getAbsolutePath();
                    //plays ignition sound
                    

                    Logger.inLog("Event: Vehicle started succesfully", "VCS");
                    //starts up vehicle display
                    disp.setText("================================================================================================\n");
                    disp.append("  Current Gear: " + SensorFusion.getGear() + "\n");

                    if(SystemManagement.retrieveUpdate()){
                        int n = JOptionPane.showConfirmDialog(VehicleDisplay.this, "Update avaliable, install now?", "System Management", JOptionPane.YES_NO_OPTION);
                        Logger.inLog("Event: querying the user for when to update", "PLN");
                        Logger.inLog("Event: displaying graphical question of when to update", "DSP");
                        System.out.println(n);
                        if (n==0){
                            Logger.inLog("Event: user initiated update", "PLN");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            SystemManagement.getUpdate();
                            JOptionPane.showMessageDialog(VehicleDisplay.this, "Updated Successfully to version " + SensorFusion.currVer);
                        }
                        else{
                            Logger.inLog("Event: user denied update", "PLN");
                        }
                        
                    }
                    
                    VehicleDisplay.this.start = true;
                    return;
                }

                else if (VehicleDisplay.this.start == true && SensorFusion.getGear() == "Park"){
                    disp.setText("");
                    Logger.inLog("Event: Vehicle turned off succesfully", "VCS");
                    VehicleDisplay.this.start = false;
                    weather.setText("Smart Weather: OFF");
                    lights.setText("Head Lights: OFF");
                    ccontrol = false;
                    headlight = false;
                    return;
                }
            } 
        });


        cruise.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == true){
                if (!(in.getText().equals(""))){
                    if (VehicleControl.startCruiseControl(Integer.parseInt(in.getText()))){
                        if (smartweath == true){
                            disp.append("  Smart Weather deactivated\n");
                            weather.setText("Smart Weather: OFF");
                            smartweath = false;
                        }
                        disp.setText("================================================================================================\n");
                        disp.append("  Cruise Control activated  \n");
                        disp.append("  Speed set to: " + in.getText() + "\n"  );
                        VehicleDisplay.this.ccontrol = true;
                        return;
                    }
                }
                
            }
            } 
        });

        left.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == true && SensorFusion.getSpeed() > 0){
                if (VehicleControl.turnleft()){

                    // if gps is activated
                    if (amount_dirs > 1 && turnL == true){
                       
                            amount_dirs--;
                            Random rand = new Random();
                            int num = rand.nextInt(2);
                            if (num == 0){
                                turnL = true;
                                disp.append("  GPS: turn left\n");
                            }
                            else{
                                turnL = false;
                                turnR = true;
                                disp.append("  GPS: turn right\n");
                            }
                        
                    }
                    if (amount_dirs == 1 && turnL == true){
                        amount_dirs--;
                        disp.append(  "  GPS: Arrived at destination '" + destination + "'\n");
                        Logger.inLog("Event: Vehicle arrived at destination '" + destination + "'", "PLN");
                    }
                return;
                }

                
                Random rand = new Random();
                int num = rand.nextInt(2);
                if (num == 0){
                    disp.append("  Can't left right object too close!\n");
                    Logger.inLog("Event: HUD Visual alert", "DSP");
                }
                else {
                    disp.append("  Warning, drifting out of lane!\n");
                    Logger.inLog("Event: HUD Visual alert", "DSP");
                }
                return;
            }
            else{
                Logger.inLog("Error: cannot turn left while not moving", "VCS");
            }
             
            }
        });

        right.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == true && SensorFusion.getSpeed() > 0){
                if (VehicleControl.turnright()){

                    //if gps is activated
                    if (amount_dirs > 1 && turnR == true){
                       
                        amount_dirs--;
                        Random rand = new Random();
                        int num = rand.nextInt(2);
                        if (num == 0){
                            turnR = false;
                            turnL = true;
                            disp.append("  GPS: turn left\n");
                        }
                        else{
                            turnR = true;
                            disp.append("  GPS: turn right\n");
                        }
                    
                }
                if (amount_dirs == 1 && turnR == true){
                    amount_dirs--;
                    disp.append(  "  GPS: Arrived at destination '" + destination + "'\n");
                    Logger.inLog("Event: Vehicle arrived at destination '" + destination + "'", "PLN");
                }
               
                return;
                }
                
                Random rand = new Random();
                int num = rand.nextInt(2);
                if (num == 0){
                    disp.append("  Can't turn right object too close!\n");
                    Logger.inLog("Event: HUD Visual alert", "DSP");
                }
                else {
                    disp.append("  Warning, drifting out of lane!\n");
                    Logger.inLog("Event: HUD Visual alert", "DSP");
                }
                return;
            }
            Logger.inLog("Error: cannot turn right while not moving", "VCS");
             
            }
        });

        brake.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                    if (ccontrol){
                        VehicleControl.stopCruiseControl();
                        disp.append("  CruiseControl deactivated\n");
                        ccontrol = false;
                    }
                    VehicleControl.brake();
                }
            }
        });
        
        curr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                disp.append("  Current Speed: " + SensorFusion.getSpeed() + "\n");
                }
            }
        });

        speed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                    if (VehicleDisplay.this.ccontrol == false){
                        if (VehicleDisplay.this.smartweath == true){
                            weather.setText("Smart Weather: OFF");
                            smartweath = false;
                        }
                        
                            VehicleControl.setSpeed(gears.getValue());
                            return;
                    }
                    else if (VehicleDisplay.this.ccontrol == true){
                        VehicleControl.stopCruiseControl();
                        disp.append("  CruiseControl deactivated\n");
                        VehicleControl.setSpeed(gears.getValue());
                        VehicleDisplay.this.ccontrol = false;
                        return;
                    }
                    
                    
                }
            }
        });

        forward.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                VehicleControl.setGear("Forward");
                disp.append("  Current Gear: " + SensorFusion.getGear() + "\n");
                }
            }
        });

        rev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                VehicleControl.setGear("Reverse");
                disp.append("  Current Gear: " + SensorFusion.getGear() + "\n");
                }
            }
        });

        neutral.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                VehicleControl.setGear("Neutral");
                disp.append("  Current Gear: " + SensorFusion.getGear() + "\n");
                }
            }
        });

        park.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                if (SensorFusion.getSpeed() == 0){
                VehicleControl.setGear("Park");
                disp.append("  Current Gear: " + SensorFusion.getGear() + "\n");
                return;
                }
                disp.append("  Can't Park while moving!\n");
                Logger.inLog("Error: Cannot Current Gear to 'Park' when current speed is not 0", "VCS");
             }
            }
        });

        gps.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == true){
                String dest = in_gps.getText();
                if (!dest.equals("")){
                    destination = dest;
                    disp.append("  Showing Direction to: '" + dest + "'\n");
                    String turn = String.valueOf(PlanningModule.getDirs(dest));
                    int length = turn.length();
                    amount_dirs = length;
                    Random rand = new Random();
                    int num = rand.nextInt(2);
                    if (num == 0){
                       turnL = true;
                       disp.append("  GPS: turn left\n");
                    }
                    else{
                        turnR = true;
                        disp.append("  GPS: turn right\n");
                    }
                                    
                }
            }
            }
        });

        lights.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //include logic if curise control is on
                if (VehicleDisplay.this.start == true){
                    if (!headlight){
                        lights.setText("Head Lights: ON");

                        //if adaptiveLights() returns true its night and 
                        //sets lights to Night Mode
                        //else its day time and sets lights to default
                        if (VehicleControl.adaptiveLights()){
                            disp.append("  Headlights activated to default brightness\n");
                        }
                        disp.append("  Headlights activated to Night brightness\n");
                        headlight = true;
                    }
                    else{
                        lights.setText("Head Lights: OFF");
                        disp.append("  Headlights deactivated\n");
                        headlight = false;
                    }
                }
            }
        });


        weather.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleDisplay.this.start == true){
                    if (!smartweath){
                        if (VehicleControl.smartWeather()){
                            disp.append("  Rainy Weather detected\n");
                            weather.setText("Smart Weather: ON");
                            smartweath = true;
                            return;
                        }
                            disp.append("  Rainy Weather not detected\n");
                    }
                    else {
                        weather.setText("Smart Weather: OFF");
                        smartweath = false;
                    }
                }

             }
            
        });
        

    


        //options
        
        

        //displaying
        
        setSize(1000, 1000);
        setVisible(true);
    }

    



}


