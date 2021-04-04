<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>signUp</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
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
                <form method="POST" action="/signUp">
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
                    <button type="submit" class="btn btn-outline-success">signUp</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>