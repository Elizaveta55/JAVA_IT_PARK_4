<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
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

        <h1><a href="entrance.ftl" id="logo"><img alt="SllepWllBanner" height="100" src="https://lh3.googleusercontent.com/ta_sufQ5xHSvul8USfj2WoWeohcGMFXlKigIgTd9Z5vWPWYGrEewaFFz_cPwCRlLeeCb=w300" width="100">
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
                <form method="post" action="/signUp" style="position: absolute; left: 470px">
                    <h3>Введите адрес электронной почты</h3>
                    <input type="text" name="email" placeholder="E-mail">
                    <h3>Придумайте надежный пароль</h3>
                    <input type="password" name="password" placeholder="Пароль">
                    <h3>Повторите ваш пароль</h3>
                    <input type="password" name="checkPassword" placeholder="Повторите">
                    <h3>Введите, к какому времени вам точно необходимо встать</h3>
                    <input type="time" name="timeWakeUp"><p><p>
                    <input type="submit">
                </form>
            </section>

        </div>

    </div>
</div>
</body>