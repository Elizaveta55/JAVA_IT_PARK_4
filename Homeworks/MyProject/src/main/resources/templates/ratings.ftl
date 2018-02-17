<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<head>
    <title>SLeepWell</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/main.css" />
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->
    <script src="/js/main.js"></script>
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
                <li><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li class="current"><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form style="position: absolute; left: 50px; top: 100px; right: 50px">
                    <h2> Рейтинг</h2>
                    <p>
                    <h3> Мы задались вопросом, а сколько же надо часов среднему человеку, чтобы хорошо выспаться?</h3>
                    <p>
                    <h3> Поэтому мы создали рейтинг качества сна, чтобы посмотреть, сколько же часов необходимо для наших пользователей.</h3>
                </form>
            </section>
            <form style="position: absolute; left: 450px; top: 850px">
                <table>
                    <tr>
                        <th width="70"> </th>
                        <th width="200"><h3>Ник</h3></th>
                        <th width="200"><h3>Количество часов сна</h3></th>
                        <th width="200"><h3>Качество сна</h3></th>
                    </tr>
                    <#list model.users as user>
                        <tr>
                            <td height="50">
                                <div id="avatar">
                                <#if user.imageUrl??>
                                    <img height='50' width="50" class="img-circle" src="${user.imageUrl}">
                                </#if>
                            </div>
                            </td>
                            <td height="50">${user.nickName}</td>
                            <td height="50">${user.delta}</td>
                            <td height="50">${user.testGoodSleep}</td>
                        </tr>
                    </#list>
                </table>
            </form>
        </div>
    </div>
</div>
</body>