package com.example.project;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class LoginHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String clientId = "556235218872-jbhcs02e3mm0s3miniqanvsea7tirogo.apps.googleusercontent.com";
        String redirectUri = "http://localhost:8000/oauth/callback";

        String url = "https://accounts.google.com/o/oauth2/v2/auth" +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&response_type=code" +
                "&scope=openid%20email%20profile" +
                "&access_type=offline" +
                "&prompt=consent";

        exchange.getResponseHeaders().add("Location", url);
        exchange.sendResponseHeaders(302, -1);
    }
}
