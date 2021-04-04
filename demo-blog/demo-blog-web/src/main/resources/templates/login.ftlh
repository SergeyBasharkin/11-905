<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login V8</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/util.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="/login" method="post" class="login100-form  p-l-55 p-r-55 p-t-178">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <span class="login100-form-title">
						Войти
					</span>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Введите почту">
                    <input class="input100" type="email" name="email" placeholder="Почта">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Введите пароль">
                    <input class="input100" type="password" name="pass" placeholder="Пароль">
                    <span class="focus-input100"></span>
                </div>

                <div class="text-right p-t-13 p-b-23">
                    <label for="remember-me">Запомнить меня</label>
                    <input type="checkbox" id="remember-me" name="remember-me">
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Войти
                    </button>
                </div>

                <div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							Еще не зарегистрировались?
						</span>

                    <a href="/signUp" class="txt3">
                        Регистрация
                    </a>
                    <p class="back_link" style="margin-top: 10px"><a href="/">Вернуться на главную</a></p>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>