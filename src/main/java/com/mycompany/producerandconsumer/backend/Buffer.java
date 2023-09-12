/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producerandconsumer.backend;
import com.mycompany.producerandconsumer.backend.ImageUtils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Xavi
 */
public class Buffer {
    private char[] buffer;
    private int next;
    private boolean isEmpty;
    private boolean isFull;
    private JProgressBar progressBar;
    
    public Buffer (int size, JProgressBar progressBar) {
        this.buffer = new char[size];
        this.next = 0;
        this.isEmpty = true;
        this.isFull = false;
        this.progressBar = progressBar;
        progressBar.setMaximum(size);
        progressBar.setValue(0);
    }
    
    public synchronized void produce (char c, JLabel producerLabel) {
        while (this.isFull) {
            try {
                wait();
                ImageUtils.SetImageLabel(producerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\waiting.gif");
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ImageUtils.SetImageLabel(producerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\producing.gif");
        buffer[next] = c;
        next++;
        this.isEmpty = false;
        
        if (next == this.buffer.length) {
            this.isFull = true;
        }
        
        progressBar.setValue(next);
        
        notifyAll();
    }
    
    public synchronized char consume (JLabel consumerLabel) {
        while (this.isEmpty) {
            try {
                wait();
                ImageUtils.SetImageLabel(consumerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\waiting.gif");
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ImageUtils.SetImageLabel(consumerLabel, "C:\\Users\\Xavi\\Documents\\NetBeansProjects\\ProducerAndConsumer\\src\\main\\java\\source\\grab-hand.gif");
        next--;
        this.isEmpty = false;
        
        if (next == 0) {
            this.isEmpty = true;
        }
        
        progressBar.setValue(next);
        
        notifyAll();
        
        return this.buffer[this.next];
    }
    
}
