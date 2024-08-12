package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorServletTest {

    private CalculatorServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new CalculatorServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testAddition() throws ServletException, IOException {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("add");

        servlet.doGet(request, response);

        verify(response).getWriter().println("<h1>Result: 15.0</h1>");
    }

    @Test
    public void testSubtraction() throws ServletException, IOException {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("subtract");

        servlet.doGet(request, response);

        verify(response).getWriter().println("<h1>Result: 5.0</h1>");
    }

    @Test
    public void testMultiplication() throws ServletException, IOException {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("multiply");

        servlet.doGet(request, response);

        verify(response).getWriter().println("<h1>Result: 50.0</h1>");
    }

    @Test
    public void testDivision() throws ServletException, IOException {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("divide");

        servlet.doGet(request, response);

        verify(response).getWriter().println("<h1>Result: 2.0</h1>");
    }

    @Test
    public void testDivisionByZero() throws ServletException, IOException {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("0");
        when(request.getParameter("operation")).thenReturn("divide");

        servlet.doGet(request, response);

        verify(response).getWriter().println("<h3>Division by zero is not allowed!</h3>");
    }
}

