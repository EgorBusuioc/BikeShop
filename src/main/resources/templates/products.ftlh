<!DOCTYPE html>
<html>

<head>
    <title>ADMINPAGE</title>
</head>

<body style="background-color: pink;">
<h1>AdminPage | <a href="/login">Войти</a></h1>
<hr>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти">
</form>
<h4>Товары</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров Нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<h3>Что вы хотите добавить?</h3>
<script>
    function showSelectedForm() {
        // Получаем все радиокнопки с именем "textOption"
        var radioButtons = document.getElementsByName("textOption");

        // Находим выбранную радиокнопку
        var selectedRadioButton;

        for (var i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].checked) {
                selectedRadioButton = radioButtons[i];
                break;
            }
        }

        // Получаем значение выбранной радиокнопки
        var selectedValue = selectedRadioButton.value;

        // Скрываем все формы
        document.getElementById("bikeForm").style.display = "none";
        document.getElementById("dressForm").style.display = "none";
        document.getElementById("equipmentForm").style.display = "none";

        // Отображаем форму в зависимости от выбранной радиокнопки
        switch (selectedValue) {
            case "bike":
                document.getElementById("bikeForm").style.display = "block";
                break;
            case "dress":
                document.getElementById("dressForm").style.display = "block";
                break;
            case "equipment":
                document.getElementById("equipmentForm").style.display = "block";
                break;
            default:
                break;
        }
    }
</script>

<form action="/product/type" method="post" id="myForm">
    <input type="radio" name="textOption" value="bike"> Велосипед
    <input type="radio" name="textOption" value="dress"> Экипировка
    <input type="radio" name="textOption" value="equipment"> Одежда
</form>

<button onclick="showSelectedForm()">Показать форму</button>

<!-- Форма для велосипеда -->
<form action="/product/create" method="post" enctype="multipart/form-data" id="bikeForm" style="display: none;">
    Название объявления: <input type="text" name="title"/><br><br>
    Номер артикля: <input type="text" name="article_number"/><br><br>
    Количество на складе: <input type="number" name="quantity_in_stock"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>

<!-- Форма для экипировки -->
<form action="/product/create" method="post" id="dressForm" style="display: none;">
    Название одежды: <input type="text" name="title"/><br><br>
    Номер Артикля: <input type="text" name="article_number"/><br><br>
    Количество на складе: <input type="text" name="quantity_in_stock"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>

<!-- Форма для одежды -->
<form action="/product/create" method="post" id="equipmentForm" style="display: none;">
    Название запчасти: <input type="text" name="title"/><br><br>
    Номер Артикля: <input type="text" name="article_number"/><br><br>
    Количество на складе: <input type="text" name="quantity_in_stock"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>

</body>
</html>