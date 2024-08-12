package com.example.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalculatorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Use POST method to submit calculations.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operation = request.getParameter("operation");

        double result = 0;
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

            switch (operation) {
                case "add":
                    result = number1 + number2;
                    break;
                case "subtract":
                    result = number1 - number2;
                    break;
                case "multiply":
                    result = number1 * number2;
                    break;
                case "divide":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        response.getWriter().println("Error: Division by zero.");
                        return;
                    }
                    break;
                default:
                    response.getWriter().println("Error: Invalid operation.");
                    return;
            }
            response.getWriter().println("The result is: " + result);
        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Invalid input. Please enter valid numbers.");
        }
    }
}
