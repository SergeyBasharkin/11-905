<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>SIGN UP</h1>

<form action="/signUp" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="email" type="email" placeholder="EMAIL">
    <input name="password" type="password" placeholder="PASSWORD">
    <input type="submit" value="SIGN UP">
</form>

</body>
</html>