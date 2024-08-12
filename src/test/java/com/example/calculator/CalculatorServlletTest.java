package com.example.calculator;

import org.junit.Before;
import org.junit.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CalculatorServletTest {

    private CalculatorServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        servlet = new CalculatorServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        responseWriter = new StringWriter();

        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testAddition() throws Exception {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("20");
        when(request.getParameter("operation")).thenReturn("add");

        servlet.doPost(request, response);

        assertEquals("Result: 30", responseWriter.toString().trim());
    }

    @Test
    public void testSubtraction() throws Exception {
        when(request.getParameter("num1")).thenReturn("20");
        when(request.getParameter("num2")).thenReturn("10");
        when(request.getParameter("operation")).thenReturn("subtract");

        servlet.doPost(request, response);

        assertEquals("Result: 10", responseWriter.toString().trim());
    }

    @Test
    public void testMultiplication() throws Exception {
        when(request.getParameter("num1")).thenReturn("10");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("multiply");

        servlet.doPost(request, response);

        assertEquals("Result: 50", responseWriter.toString().trim());
    }

    @Test
    public void testDivision() throws Exception {
        when(request.getParameter("num1")).thenReturn("20");
        when(request.getParameter("num2")).thenReturn("4");
        when(request.getParameter("operation")).thenReturn("divide");

        servlet.doPost(request, response);

        assertEquals("Result: 5", responseWriter.toString().trim());
    }

    @Test
    public void testDivisionByZero() throws Exception {
        when(request.getParameter("num1")).thenReturn("20");
        when(request.getParameter("num2")).thenReturn("0");
        when(request.getParameter("operation")).thenReturn("divide");

        servlet.doPost(request, response);

        assertEquals("Error: Division by zero", responseWriter.toString().trim());
    }
}
