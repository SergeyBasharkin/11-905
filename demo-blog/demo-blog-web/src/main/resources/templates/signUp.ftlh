<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>signUp</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(function () {
            $('#button').on("click", function (event) {
                event.preventDefault();
                var username = $('#username').val();
                var password = $("#password").val();
                var confPass = $('#confPassword').val()
                if (confPass === password) {
                    var data_json = {
                        'username': username,
                        'password': password,
                    }
                    console.log(JSON.stringify(data_json));
                    $.ajax({
                        type: "POST",
                        url: window.location.href,
                        data: JSON.stringify(data_json),
                        contentType: "application/json; charset = utf-8",
                        success: function (result) {
                        }
                    });
                } else {
                    alert("Password mismatch")
                }
            });
        });
    </script>
</head>

<body class="back-img">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Demo-blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
            aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/signIn">SignIn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signUp">SignUp</a>
            </li>
        </ul>
    </div>
</nav>
<div class="col-12" style="min-height: 3em">

</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="card text-white bg-dark mb-3" style="max-width: 20em;">
            <div class="card-body">
                <form>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" name="username" class="form-control" id="username"
                               placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="confPassword">Confirm password</label>
                        <input type="password" name="confPassword" class="form-control" id="confPassword"
                               placeholder="confirm password">
                    </div>
                    <button type="button" id="button" class="btn btn-secondary">signUp</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>