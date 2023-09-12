/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producerandconsumer.backend;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import com.mycompany.producerandconsumer.backend.ImageUtils;

/**
 *
 * @author Xavi
 */
public class Consumer extends Thread {
    
    private Buffer buffer;
    private int id;
    private JLabel consumerLabel;
    
    public Consumer (Buffer b, int Id, JLabel consumerLabel) {
        this.buffer = b;
        this.id = Id;
        this.consumerLabel = consumerLabel;
    }
    
    public void run () {
        while (true) {
            try {
                char value = this.buffer.consume(consumerLabel);
                System.out.printf("Char consumed: %c by Consumer: %d %n", value, this.id);
                
                sleep((int) (Math.random() * 7500));
                ImageUtils.SetImageLabel(consumerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\customer.png");
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
