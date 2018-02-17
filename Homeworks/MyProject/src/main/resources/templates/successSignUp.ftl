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
                <li><a href="/dairy">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form style="position: absolute; left: 400px; top: 100px">
                    <h2> Добро пожаловать!</h2>
                    <p>
                        <h3> Пожалуйста, подтвердите адрес электронной почты. <p> Вам на почту было отправлено письмо с ссылкой-подтверждением.</h3>
                    <p>
                    <a href="/personalData" class="button">Продолжить регистрацию</a>
                </form>
            </section>
        </div>
    </div>
</div>
</body>