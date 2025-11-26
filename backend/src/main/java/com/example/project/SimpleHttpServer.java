package com.example.project;

// Java Program to Set up a Basic HTTP Server
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


// Driver Class
public class SimpleHttpServer 
{
    // Main Method
    public static void main(String[] args) 
    {
        try {
            // Create an HttpServer instance
            HttpServer servers = HttpServer.create(new InetSocketAddress(8000), 0);

            // Create a context for a specific path and set the handler
            server.createContext("/", new MyHandler());

            // Start the server
            server.setExecutor(null); // Use the default executor
            server.start();

            System.out.println("Server is running on port 8000");
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    // Define a custom HttpHandler
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException 
        {
            // Handle the request
            Calculator calculator = new Calculator();
            OutputStream os = exchange.getResponseBody();
            String[] params = exchange.getRequestURI().getQuery().split("&");
            
            int x = Integer.parseInt(params[0].split("=")[1]);
            int y = Integer.parseInt(params[1].split("=")[1]);
            String response = "response:" + calculator.add(x,y);

            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }
}
