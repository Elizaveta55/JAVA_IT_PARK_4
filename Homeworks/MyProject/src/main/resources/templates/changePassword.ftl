<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>SLeepWell</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="/css/main.css" />
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->
</head>
<body>

<div id="page-wrapper">

    <div id="header">

        <h1><a href="entrance.html" id="logo"><img alt="SllepWllBanner" height="100" src="https://lh3.googleusercontent.com/ta_sufQ5xHSvul8USfj2WoWeohcGMFXlKigIgTd9Z5vWPWYGrEewaFFz_cPwCRlLeeCb=w300" width="100">
            Sleep<em>Well</em></a></h1>

        <nav id="nav">
            <ul>
                <li><a href="/entrance">Главная</a></li>
                <li class="current"><a href="/profile">Личный кабинет</a></li>
                <li><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                 <#if model.error??>
                  <h1>Ошибка. Проверьте правильность написания пароля.</h1>
                 </#if>
                <form method="post" action="/changePassword" style="position: absolute; top: 100px; left: 350px">
                    <h3>Введите старый пароль</h3>
                    <input type="password" size="100" name="oldPassword" placeholder="Пароль"><p>
                    <h3>Введите новый пароль</h3>
                    <input type="password" size="100" name="newPassword" placeholder="Пароль"><p>
                    <input type="submit">
                </form>
            </section>

        </div>

    </div>
</div>
</body>
</html>