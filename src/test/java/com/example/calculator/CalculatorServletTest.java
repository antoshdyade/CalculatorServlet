package com.example.calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class CalculatorServletTest {

    private CalculatorServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;

    @Before
    public void setUp() throws Exception {
        servlet = new CalculatorServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        stringWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
    }

    @Test
    public void testAddition() throws Exception {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("20");
        when(request.getParameter("operation")).thenReturn("add");

        servlet.doPost(request, response);

        assertEquals("The result is: 30.0", stringWriter.toString().trim());
    }

    @Test
    public void testDivisionByZero() throws Exception {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("0");
        when(request.getParameter("operation")).thenReturn("divide");

        servlet.doPost(request, response);

        assertEquals("Error: Division by zero.", stringWriter.toString().trim());
    }

    @Test
    public void testInvalidOperation() throws Exception {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("mod");

        servlet.doPost(request, response);

        assertEquals("Error: Invalid operation.", stringWriter.toString().trim());
    }
}
