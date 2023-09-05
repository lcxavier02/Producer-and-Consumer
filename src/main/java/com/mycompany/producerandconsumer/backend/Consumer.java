/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producerandconsumer.backend;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavi
 */
public class Consumer extends Thread {
    
    private Buffer buffer;
    
    public Consumer (Buffer b) {
        this.buffer = b;
    }
    
    public void run () {
        while (true) {
            try {
                char value = this.buffer.consume();
                System.out.println("Char consumed: " + value);
                
                sleep((int) (Math.random() * 7500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
