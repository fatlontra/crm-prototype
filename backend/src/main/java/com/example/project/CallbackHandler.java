package com.example.project;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CallbackHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String code = query.split("=")[1];

        // Exchange code for tokens
        String tokens = exchangeCodeForTokens(code);

        System.out.println("Code" + tokens);
        byte[] bytes = tokens.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.getResponseBody().close();
    }

    public static String exchangeCodeForTokens(String code) throws IOException {
        URL url = new URL("https://oauth2.googleapis.com/token");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String clientId = "556235218872-jbhcs02e3mm0s3miniqanvsea7tirogo.apps.googleusercontent.com";
        String redirectUri = "http://localhost:8000/oauth/callback";

        String body = "code=" + code +
                "&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&grant_type=authorization_code";

        conn.getOutputStream().write(body.getBytes());

        InputStream is = conn.getInputStream();
        return new String(is.readAllBytes());
    }
}
