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

        <h1><a href="entrance.ftl" id="logo"><img alt="SllepWllBanner" height="100" src="https://lh3.googleusercontent.com/ta_sufQ5xHSvul8USfj2WoWeohcGMFXlKigIgTd9Z5vWPWYGrEewaFFz_cPwCRlLeeCb=w300" width="100">
            Sleep<em>Well</em></a></h1>

        <nav id="nav">
            <ul>
                <li><a href="/entrance">Главная</a></li>
                <li><a href="/profile">Личный кабинет</a></li>
                <li><a href="/diary">Дневник</a></li>
                <li class="current"><a href="/recommendation">Рекомендации</a></li>
                <li><a href="/ratings">Рейтинг</a></li>
            </ul>
        </nav>

        <div>

            <section id="banner">
                <form style="position: absolute; left: 400px; top: 100px">
                    <h2> Рекоммендации для вас</h2>
                    <p>
                        <h3> На основе ваших персональных данных и данных вашего дневника сервис<p> составляет персональные рекомендации по улучшению качества сна.</h3>
                    <p>
                </form>
            </section>
            <div>
            <form style="position: absolute; left: 250px; top: 850px; right: 250px">

                <p>
                <p>
                <table width="800">
                    <tr>
                        <th width="400"><h3>Для полноценного сна рекомендовано засыпать в</h3></th>
                        <th width="400"><h3>и просыпать в данное время</h3></th>
                    </tr>
                    <tr>
                       <#list model.times as time>
                         <td width="400"><h3><p style="text-indent: 200px">${time}</h3></td>
                       </#list>
                    </tr>
                </table>


                <h3> Общие рекомендации для качественного и здорового сна </h3>
                <ul>
                    <li> Старайтесь ложиться спать в одно и тоже время. </li>
                    <li> Старайтесь пить кофе только по утрам. Кофеин снижает уровень аденозина, из-за чего человек не может быстро успокоиться и уснуть.</li>
                    <li> Для хорошего сна нужно создать комфортные условия: купите удобный матрас, повесьте плотные шторы на окна, устраните источники шума, мешающие заснуть. </li>
                    <li> Любое освещение также могут создавать проблемы со сном. Если устранить источники света невозможно, то, чтобы они не мешали вам отдыхать, используйте маску для сна. </li>
                    <li> Перед сном организм должен расслабиться, поэтому перед тем, как отправиться в царство Морфея, примите горячий душ или ванну. Они помогут снять стресс и вызовут сонливость.</li>
                    <li> Свежий воздух благоприятно влияет на качества сну, поэтому постарайтесь всегда проветривать комнату перед сном</li>
                </ul>
            </form>
            </div>
        </div>
    </div>
</div>
</body>