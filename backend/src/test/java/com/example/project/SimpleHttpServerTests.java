package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.sun.net.httpserver.HttpExchange;
import static org.mockito.Mockito.*;

class MyHandlerTests{


  void handleObject() {

  HttpExchange mock = mock(HttpExchange.class);

  SimpleHttpServer.MyHandler handler = new SimpleHttpServer.MyHandler();


  // when(mock.get(0)).thenReturn("one");
  // when(mock.get(1)).thenReturn("two");
  //
  // someCodeThatInteractsWithMock();

  } 
}
