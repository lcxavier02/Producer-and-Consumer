/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.producerandconsumer.backend;

import com.mycompany.producerandconsumer.frontend.MainFrame;

/**
 *
 * @author Xavi
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        MainFrame main = new MainFrame();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        
        int numberProducers = 5;
        int numberConsumers = 3;
        int idCounter = 1;
        
        Buffer b = new Buffer(15);
        
        for (int i = 0; i < numberProducers; i++ ) {
            Producer p = new Producer(b, idCounter++);
            p.start();
        }
        
        for (int i = 0; i < numberConsumers; i++) {
            Consumer c = new Consumer(b, idCounter++);
            c.start();
        }
        
    }
}
