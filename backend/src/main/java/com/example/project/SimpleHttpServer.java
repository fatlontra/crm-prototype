package com.example.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
// Java Program to Set up a Basic HTTP Server
import com.sun.net.httpserver.HttpServer;

// Driver Class
public class SimpleHttpServer {
    // Main Method
    public static void main(String[] args) {
        try {
            // Create an HttpServer instance
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            // Create a context for a specific path and set the handler
            server.createContext("/", new MyHandler());
            server.createContext("/login", new LoginHandler());
            server.createContext("/api/users", new PathFinder());

            // Start the server
            server.setExecutor(null); // Use the default executor
            server.start();

            System.out.println("Server is running on port 8000");
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    static class PathFinder implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Handle the request
            OutputStream os = exchange.getResponseBody();
            String response = "Hello World";

            if (exchange.getRequestMethod().equals("POST")) {
                InputStream is = exchange.getRequestBody();
                String data = new String(is.readAllBytes());
                System.out.println();
                response = "Hello from POST";
            }

            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    // Define a custom HttpHandler
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Handle the request
            Calculator calculator = new Calculator();
            OutputStream os = exchange.getResponseBody();
            String[] params = exchange.getRequestURI().getQuery().split("&");

            int x = Integer.parseInt(params[0].split("=")[1]);
            int y = Integer.parseInt(params[1].split("=")[1]);
            String response = "response:" + calculator.add(x, y);

            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

}
