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
                <li class="current"><a href="/entrance">Главная</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <li><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <h2> Добро пожаловть в SleepWell калькулятор сна.</h2>
                <form style="position: absolute; left: 100px; right: 100px">
                    <p><h3> Сон - неотъемлемая часть нашей жизни, необходимая для эффективного функционирования всех систем организма. Но тщательно ли вы высыпаетесь? Знаете ли свою норму сна? С помощью нашего сервиса вы сможете ответить на эти вопросы и начать высыпаться, эффективно используюя время.</h3> </p>
                    <a href="/signUp" class="button">Начать</a>
                    <a href="/signIn" class="button">Войти</a>
                </form>
                <p>
                    <header>
                        <h2>SleepWell <em>составляет рейтинги сна пользователей </em></h2>
                        <a href="/ratings" class="button">Узнать больше</a>
                    </header>
            </section>
        </div>
    </div>
</div>
</body>