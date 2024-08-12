<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator Application</title>
</head>
<body>
    <h1>Welcome to the Calculator Application</h1>
    <form action="calculate" method="post">
        <label for="num1">Number 1:</label>
        <input type="text" id="num1" name="num1" required>
        <br>
        <label for="num2">Number 2:</label>
        <input type="text" id="num2" name="num2" required>
        <br>
        <label for="operation">Operation:</label>
        <select id="operation" name="operation" required>
            <option value="add">Add</option>
            <option value="subtract">Subtract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select>
        <br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
