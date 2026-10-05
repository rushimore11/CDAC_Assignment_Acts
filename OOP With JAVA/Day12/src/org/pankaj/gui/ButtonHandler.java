package org.pankaj.gui;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonHandler implements ActionListener {  
    private MainFrame frame;
    public ButtonHandler(MainFrame frame) {
        super();
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Stop")) {
            
            // Task 1: Moving Oval Animation (Moves UP)
            Runnable ovalTarget = () -> {
                int xPos = 300;
                int yPos = 500;
                Graphics grp = frame.getGraphics();
                
                grp.setColor(Color.black);
                grp.drawOval(xPos, yPos, 60, 20);

                try {
                    for (int tmp = 0; tmp < 100; tmp++) {
                        grp.setColor(Color.black);
                        grp.drawOval(xPos, yPos, 60, 20);

                        Thread.sleep(25);

                        grp.setColor(Color.white); // Erases previous frame
                        grp.drawOval(xPos, yPos, 60, 20);

                        yPos -= 1; // Move up
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            };

            // Task 2: Moving Rectangle Animation (Moves DOWN)
            Runnable rectTarget = () -> {
                int xPos = 100;
                int yPos = 60;
                Graphics grp = frame.getGraphics();

                try {
                    for (int tmp = 0; tmp < 100; tmp++) {
                        grp.setColor(Color.black);
                        grp.drawRect(xPos, yPos, 60, 20);

                        Thread.sleep(25);

                        grp.setColor(Color.white);
                        grp.drawRect(xPos, yPos, 60, 20);

                        yPos += 1; // Move down
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            };
       
            frame.singleService.execute(ovalTarget);
            frame.singleService.execute(rectTarget);
        }
    }
}
