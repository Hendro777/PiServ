/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.hendro777.piserv;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendrik
 */
public class PiServ {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {

            var threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            var server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/api/", new RequestHandler());
            server.setExecutor(threadPoolExecutor);

            server.start();

            Logger.getLogger(PiServ.class.getName()).log(Level.INFO, "Server started on port 8080");

        } catch (IOException ex) {
            Logger.getLogger(PiServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
