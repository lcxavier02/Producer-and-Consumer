/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producerandconsumer.backend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavi
 */
public class Producer extends Thread {
    
    private Buffer buffer;
    private final String string = "abcdefghijklmnñopqrstuvwxyz";
    
    public Producer (Buffer b) {
        this.buffer = b;
    }
    
    public void run () {
        while (true) {
            try {
                char c = string.charAt((int) (Math.random() * string.length()));
                buffer.produce(c);
                System.out.println("Char produced: " + c);
                
                sleep((int) (Math.random() * 4500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
