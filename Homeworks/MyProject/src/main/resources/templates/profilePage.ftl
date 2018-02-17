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
                <li class="current"><a href="/profile">Личный кабинет</a></li>
                <li><a href="/diary">Дневник</a></li>
                <li><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form style="position: absolute; left: 500px; top: 200px">
                    <h2> Персональная информация</h2>
                </form>
            </section>
            <div>
                <p>
                </p>
                <table style="margin-left:200px;">
                    <tr>
                        <td>
                            <div id="avatar">
                            <#if model.user.imageUrl??>
                                <img height='200' class="img-circle" src="${model.user.imageUrl}">
                            </#if>
                            </div>
                        </td>
                        <td width="1000">
                            <h3> Ваш аватар </h3>
                            <input type="file" name="file" id="fileInput" placeholder="Файл аватара"/>
                            <button onclick="imageUpload(document.getElementById('fileInput')['files'][0])">Загрузить</button>
                        </td>
                    </tr>
                </table>
                <table style="margin-left:200px;">
                <tr>
                    <td><h3> Ваш email </h3></td>
                    <td><h3 > ${model.user.email} </h3></td>
                    <td><h3><a href="/changeEmail" class="button"> Изменить</a><p></h3></td>
                </tr>
                <tr>
                    <td><h3> Ваше имя </h3></td>
                    <td><h3 > ${model.user.name} </h3></td>
                    <td><h3><a href="/changeNameOrSecondName" class="button"> Изменить</a><p></h3></td>
                </tr>
                <tr>
                    <td><h3> Ваша фамилия </h3></td>
                    <td><h3 > ${model.user.secondName} </h3></td>
                    <td><h3><a href="/changeNameOrSecondName" class="button"> Изменить</a><p></h3></td>
                </tr>
                <tr>
                    <td><h3>Ваш ник</h3></td>
                    <td><h3> ${model.user.nickName} </h3></td>
                    <td><h3><a href="/changeNameOrSecondName" class="button"> Изменить</a><p></h3></td>
                </tr>
                <tr>
                    <td><h3>Ваш возраст</h3></td>
                    <td><h3> ${model.user.age} </h3></td>
                    <td><h3><a href="/changeNameOrSecondName" class="button"> Изменить</a><p></h3></td>
                </tr>
                <tr>
                    <td><h3> Время вашего<p> обязательного подъёма </h3></td>
                <td><h3> ${model.user.timeWakeUp} </h3></td>
                <td><h3><a href="/changeNameOrSecondName" class="button"> Изменить</a></h3></td>
                </tr>
                <tr>
                    <td><h3> Пароль </h3></td>
                    <td></td>
                    <td><h3><a href="/changePassword" class="button"> Изменить пароль</a></h3></td>
                </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>