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
                        <label for="email">Email</label>
                        <input type="email" name="email" class="form-control ${(emailError??)?string('is-invalid','')}"
                               id="email"
                               value="<#if user??>${user.email}</#if>" placeholder="Email">
                        <#if emailError??>
                            <div class="invalid-feedback">
                                ${emailError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" name="username"
                               class="form-control ${(usernameError??)?string('is-invalid','')}"
                               id="username"
                               value="<#if user??>${user.username}</#if>" placeholder="Username">
                        <#if usernameError??>
                            <div class="invalid-feedback">
                                ${usernameError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password"
                               class="form-control ${(passwordError??)?string('is-invalid','')}"
                               id="password"
                               value="<#if user??>${user.password}</#if>" placeholder="Password">
                        <#if passwordError??>
                            <div class="invalid-feedback">
                                ${passwordError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <label for="password">Password confirmation</label>
                        <input type="password" name="confirmPassword"
                               class="form-control ${(confirmPasswordError??)?string('is-invalid','')}"
                               id="confirmPassword"
                               value="<#if user??>${user.confirmPassword}</#if>" placeholder="Password confirmation">
                        <#if confirmPasswordError??>
                            <div class="invalid-feedback">
                                ${confirmPasswordError}
                            </div>
                        </#if>
                        <label for="password" style="color: red">
                            <#if passwordMatchError??>
                                ${passwordMatchError}
                            </#if>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-outline-success">signUp</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>