<%@ page pageEncoding="UTF-8" %>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", -1);
%>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Лабораторная работа №2</title>

  <link rel="stylesheet" href="main.css">
  <link rel="stylesheet" href="colors.css">

  <script src="validator.js" type="text/javascript"></script>
  <script src="zoneDrawer.js" type="text/javascript"></script>
  <script src="mouseListener.js" type="text/javascript"></script>


  <jsp:useBean id="results" class="server.ResultsHolder" scope="application">
  </jsp:useBean>

  <%
    if(request.getParameter("refresh")!=null)results.refresh();
  %>

  <script>
    function clearForm() {
      document.forms["form1"].reset();
    }
  </script>
  <script>
    function drawPoints() {
      <%=results.drawPoints()%>
    }
  </script>


</head>

<body onload="clearForm();addListener('zoneCanvas'); drawZone('zoneCanvas','R')"
onclick="clearMessage()">
<header>
  <h2>Мосягин Иван Денисович - P3212</h2>
  <h3>Вариант: 212304</h3>
</header>

<div class="block">

  <h3>Введите X, Y, R и узнайте, попала ли точка в синюю зону. </h3>

  <form name="form1" action="control" method="get">

    <p>Выберите одно значение X для проверки</p>


      <label><input type="radio" name="x" onclick="choseX(-5)" value=-5>-5</label>
      <label><input type="radio" name="x" onclick="choseX(-4)" value=-4>-4</label>
      <label><input type="radio" name="x" onclick="choseX(-3)" value=-3>-3</label>
      <label><input type="radio" name="x" onclick="choseX(-2)" value=-2>-2</label>
      <label><input type="radio" name="x" onclick="choseX(-1)" value=-1>-1</label>
      <label><input type="radio" name="x" onclick="choseX(0)" value=0>0</label>
      <label><input type="radio" name="x" onclick="choseX(1)" value=1>1</label>
      <label><input type="radio" name="x" onclick="choseX(2)" value=2>2</label>
      <label><input type="radio" name="x" onclick="choseX(3)" value=3>3</label>
    <p><label>Введите значение Y
      <input id="Y_input" name="y" oninput="validateY()" maxlength="6" placeholder="[-3 ... 3]" autocomplete="off">
    </label></p>

    <p>Выберите все значения R</p>

    <div class="check-box-block">
      <label for="r1">1</label>
      <label for="r1.5">1.5</label>
      <label for="r2">2</label>
      <label for="r2.5">2.5</label>
      <label for="r3">3</label>

      <p>
        <input id="r1" type="radio" onclick="chooseR(1)" name="r" value=1>
        <input id="r1.5" type="radio" onclick="chooseR(1.5)" name="r" value=1.5>
        <input id="r2" type="radio" onclick="chooseR(2)" name="r" value=2>
        <input id="r2.5" type="radio" onclick="chooseR(2.5)" name="r" value=2.5>
        <input id="r3" type="radio" onclick="chooseR(3)" name="r" value=3>
      </p>
    </div>


    <p><button name="submit_btn" disabled type="submit" id="submit">Проверить</button></p>

  </form>

  <canvas height="300px" width="300px" id="zoneCanvas"></canvas>

  <p><a href=index.jsp?refresh= >Очистить историю</a></p>

</div>
  <span id="error-message"></span>

  <%=results.toString()%>
</body>
</html>