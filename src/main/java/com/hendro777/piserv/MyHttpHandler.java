/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hendro777.piserv;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

/**
 *
 * @author hendrik
 */
public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var output = exchange.getResponseBody();
        
        String response = "Hello World!";
                
        exchange.sendResponseHeaders(200, response.length());
        output.write(response.getBytes());
        output.flush();
        output.close();
    }
    
}
