/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hendro777.piserv;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author hendrik
 */
public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var method = exchange.getRequestMethod();

        switch (method) {
            case "GET":
            default:
                handleGetRequest(exchange);
                break;
        }
    }
    
    public void handleGetRequest(HttpExchange exchange) throws IOException {
        var output = exchange.getResponseBody();
        var writer = new OutputStreamWriter(output);
        
        var map = new HashMap<String, String>();
        
        map.put("message", "Hello World!");
        var json = new JSONObject(map);

        exchange.sendResponseHeaders(200, json.toString().length());
        writer.write(json.toString());
        writer.flush();
        writer.close();
    }
    
    

}
