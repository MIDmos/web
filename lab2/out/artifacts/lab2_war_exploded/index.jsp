<%@ page pageEncoding="UTF-8" %>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Лабораторная работа №2</title>

  <link rel="stylesheet" href="main.css">
  <link rel="stylesheet" href="colors.css">

  <script src="validator.js" type="text/javascript"></script>

  <jsp:useBean id="results" class="server.ResultsHolder" scope="session">
    <jsp:setProperty name="results" property="*"></jsp:setProperty>
  </jsp:useBean>
</head>

<body>
<header>
  <h2>Мосягин Иван Денисович - P3212</h2>
  <h3>Вариант: 212305</h3>
</header>

<div class="block">

  <h3>Введите X, Y, R и узнайте, попала ли точка в синюю зону. </h3>

  <%=session.getAttribute("HELLO")!=null?session.getAttribute("HELLO"):"WHAT?"%>

  <form action="control" method="get">

    <p>Выберите одно значение X для проверки</p>
    <input type="button" onclick="choseX(-2)" value=-2>
    <input type="button" onclick="choseX(-1.5)" value=-1.5>
    <input type="button" onclick="choseX(-1)" value=-1>
    <input type="button" onclick="choseX(-0.5)" value=-0.5>
    <input type="button" onclick="choseX(0)" value=0>
    <input type="button" onclick="choseX(0.5)" value=0.5>
    <input type="button" onclick="choseX(1)" value=1>
    <input type="button" onclick="choseX(1.5)" value=1.5>
    <input type="button" onclick="choseX(2)" value=2>

    <p>
      <label >Ваш выбор X <input onload="choseX(0)" type="text" readonly  id="lastX" name="x" value="?"></label>
    </p>

    <label>Введите значение Y
      <input id="Y_input" name="y" oninput="validateY()" maxlength="6" placeholder="[-3 ... 3]" autocomplete="off">
    </label>

    <p>Выберите все значения R</p>

    <div class="check-box-block">
      <label for="r1">1</label>
      <label for="r1.5">1.5</label>
      <label for="r2">2</label>
      <label for="r2.5">2.5</label>
      <label for="r3">3</label>

      <p>
        <input id="r1" type="checkbox" onclick="putR(1)" name="r" value=1>
        <input id="r1.5" type="checkbox" onclick="putR(1.5)" name="r" value=1.5>
        <input id="r2" type="checkbox" onclick="putR(2)" name="r" value=2>
        <input id="r2.5" type="checkbox" onclick="putR(2.5)" name="r" value=2.5>
        <input id="r3" type="checkbox" onclick="putR(3)" name="r" value=3>
      </p>
    </div>



    <p><button name="submit_btn" disabled type="submit" id="submit">Проверить</button></p>

  </form>
    <img src="zone.png" alt="Рабочая зона">

</div>
    <%=results.toString()%>
</body>
</html>