<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<form method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="email">Email</label>
    <input type="email" id="email" name="email" placeholder="Your Email" required><br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password" required>
    <input type="submit" value="Submit">
</form>
</body>
</html>