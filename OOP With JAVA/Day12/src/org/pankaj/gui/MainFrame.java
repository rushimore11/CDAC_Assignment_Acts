package org.pankaj.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainFrame extends Frame {
    // Thread pool management using Executors
    public ExecutorService singleService = Executors.newCachedThreadPool();
    
    public ThreadGroup guiThreads = new ThreadGroup("GUIThreads");
    public Object dummy = new Object();
    public Object dummy2 = new Object();

    public MainFrame() {
        setTitle("Multithreading Graphics Example");
        setSize(600, 600);
        setLayout(new FlowLayout());

        
        Button btnStop = new Button("Stop");
        btnStop.setActionCommand("Stop");
        btnStop.addActionListener(new ButtonHandler(this));
        add(btnStop);
        
        
        Button btnStart = new Button("start");
        btnStart.setActionCommand("Start");
        btnStart.addActionListener(new ButtonHandler(this));
        add(btnStart);


        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                singleService.shutdown(); 
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

