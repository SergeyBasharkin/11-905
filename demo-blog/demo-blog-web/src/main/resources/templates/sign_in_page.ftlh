<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>SIGN IN</h1>

<form action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="email" type="email" placeholder="EMAIL">
    <input name="password" type="password" placeholder="PASSWORD">

    <label>
        <input type="checkbox" name="remember-me">
        Запомни меня
    </label>
    <input type="submit" value="SIGN IN">
</form>

</body>
</html>