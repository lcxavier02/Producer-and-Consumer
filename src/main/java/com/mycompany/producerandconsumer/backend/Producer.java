/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producerandconsumer.backend;

import com.mycompany.producerandconsumer.backend.ImageUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Xavi
 */
public class Producer extends Thread {
    
    private Buffer buffer;
    private int id;
    private final String string = "abcdefghijklmnñopqrstuvwxyz";
    private JLabel producerLabel;
    
    public Producer (Buffer b, int Id, JLabel producerLabel) {
        this.buffer = b;
        this.id = Id;
        this.producerLabel = producerLabel;
    }
    
    public void run () {
        while (true) {
            try {
                char c = string.charAt((int) (Math.random() * string.length()));
                buffer.produce(c, producerLabel);
                System.out.printf("Char produced: %c by Producer: %d %n", c, this.id);
                
                sleep((int) (Math.random() * 4000));
                ImageUtils.SetImageLabel(producerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\chef.png");
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
