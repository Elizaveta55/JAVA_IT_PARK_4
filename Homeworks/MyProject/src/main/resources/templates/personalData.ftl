<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
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
                <form style="position: absolute; left: 500px; top: 100px">
                    <h2> Добро пожаловать!</h2>
                    <p>
                    <h3> Заполните, пожалуйста, информацию о себе</h3>
                    <p>
                </form>
            </section>
            <form method="post" action="/personalData" style="position: absolute; left: 350px">
                <h3>Введите ваше имя</h3>
                <input type="text" name="name" placeholder="Имя"><p>
                <h3>Введите вашу фамилию</h3>
                <input type="text" name="secondName" placeholder="Фамилия" ><p>
                <h3>Введите ваш ник</h3>
                <input type="text" name="nickName" size="100" placeholder="Ник"><p>
                <h3>Ваш возраст</h3>
                <input type="number" name="age" min="0" max="100" value="20"><p><p>
                <input type="submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>