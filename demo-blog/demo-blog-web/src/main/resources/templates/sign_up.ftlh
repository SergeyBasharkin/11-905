<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>Login V8</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/util.css">
    <link rel="stylesheet" href="/css/main.css">
    <style>
        .error {
            color: red;
            font-size: 18px;
        }
    </style>
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="/signUp" method="post" class="login100-form  p-l-55 p-r-55 p-t-178">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <span class="login100-form-title">
						Регистрация
                </span>

                <#if namesErrorMessage??>
                    <p class="error">${namesErrorMessage}</p>
                </#if>

                <div class="wrap-input100 validate-input m-b-16" data-validate="Введите почту">
<#--                    <input class="input100" type="email" name="email" placeholder="Почта">-->
                    <@spring.formInput "userForm.email" "name='email' class='input100 input' type='email' placeholder='Почта'"/>
                    <@spring.showErrors "<br>" "error"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-16" data-validate="Введите пароль">
<#--                    <input class="input100" type="password" name="pass" placeholder="Пароль">-->
                    <@spring.formPasswordInput "userForm.password" "name='pass' class='input100' type='password' placeholder='Пароль'"/>
                    <@spring.showErrors "<br>" "error"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-16" data-validate="Введите пароль еще раз">
<#--                    <input class="input100" type="password" name="confirm_pass" placeholder="Повторить пароль">-->
                    <@spring.formPasswordInput "userForm.confirmPassword" "name='confirm_pass' class='input100' type='password' placeholder='Повторить пароль'"/>
                    <@spring.showErrors "<br>" "error"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="text-right p-t-13 p-b-23">
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Регистрация
                    </button>
                </div>

                <div class="flex-col-c p-t-60 p-b-40">
						<span class="txt1 p-b-9">
							Уже есть аккаунт?
						</span>

                    <a href="/login" class="txt3">
                        Войти
                    </a>
                    <p class="back_link" style="margin-top: 10px"><a href="/">Вернуться на главную</a></p>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>