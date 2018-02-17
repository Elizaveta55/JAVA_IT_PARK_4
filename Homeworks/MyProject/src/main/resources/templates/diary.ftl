<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
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
                <li><a href="/profile">Личный кабинет</a></li>
                <li class="current"><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form style="position: absolute; left: 500px; top: 100px">
                    <h2> А вот и новый день!</h2>
                    <p>
                    <h3> Расскажи, как тебе спалось. Просто пройди тест.</h3>
                       <#if model.noError??>
                            <h1>Данные не добавлены.</h1>
                       </#if>
                    <p>
                </form>
            </section>
            <form method="post" action="/diary" style="position: absolute; left: 400px">
                <h3>Введите время отхода ко сну</h3><p>
                <input type="time" name="timeGoToSleep"><p>
                <h3>Введите время пробуждения</h3><p>
                <input type="time" name="timeWakeUpCurrent"><p>
                <h3>На сколько по десятибалльной системе оцениваете свое состояние,<p> чувствуете ли, что вы выспались?</h3>
                <input type="number" name="testGoodSleep" min="0" max="10" value="0"><p>
                <h3>Просыпались ли вы ночью, и если ДА, то сколько раз?</h3><p>
                <input type="number" name="testMoonWalker" value="0" min="0" max="10"><p>
                <h3>Помните ли вы свои сны<p> 0 - да, помню<p> 1 - нет, не помню</h3><p>
                <input type="number" name="testDreams" max="1" min="0"><p><p>
                <input type="submit">
            </form>

        </div>

    </div>
</div>
</body>