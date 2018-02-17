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
                <li class="current"><a href="/profile">Личный кабинет</a></li>
                <li><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form method="post" action="/changeNameOrSecondName" style="position: absolute; top: 10px; left: 350px">
                    <h3>Введите новое имя</h3>
                    <input type="text" size="100" name="name" <#if model.user.name??>
                           value="${model.user.name}"
                    <#else>
                           placeholder="Не заполнено"
                    </#if>>
                    <p>
                    <h3>Введите новую фамилию</h3>
                    <input type="text" size="100" name="secondName" <#if model.user.secondName??>
                           value="${model.user.secondName}"
                    <#else>
                           placeholder="Не заполнено"
                    </#if>>
                    <p>
                    <h3>Введите новый ник</h3>
                    <input type="text" size="100" name="nickName" <#if model.user.nickName??>
                           value="${model.user.nickName}"
                    <#else>
                           placeholder="Не заполнено"
                    </#if>>
                    <p>
                    <h3>Введите новое время отхода ко сну</h3>
                    <input type="time" size="100" name="timeWakeUp" <#if model.user.timeWakeUp??>
                           value="${model.user.timeWakeUp}"
                    <#else>
                           placeholder="Не заполнено"
                    </#if>>
                    <p>
                    <p>
                    <input type="submit">
                </form>
            </section>

        </div>

    </div>
</div>
</body>
