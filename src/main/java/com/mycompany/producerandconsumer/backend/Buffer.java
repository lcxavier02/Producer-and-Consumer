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
public class Buffer {
    private char[] buffer;
    private int next;
    private boolean isEmpty;
    private boolean isFull;
    
    public Buffer (int size) {
        this.buffer = new char[size];
        this.next = 0;
        this.isEmpty = true;
        this.isFull = false;
    }
    
    public synchronized void produce (char c) {
        while (this.isFull) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        buffer[next] = c;
        next++;
        this.isEmpty = false;
        
        if (next == this.buffer.length) {
            this.isFull = true;
        }
        
        notifyAll();
        
    }
    
    public synchronized char consume () {
        while (this.isEmpty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        next--;
        this.isEmpty = false;
        
        if (next == 0) {
            this.isEmpty = true;
        }
        
        notifyAll();
        
        return this.buffer[this.next];
    }
    
}
