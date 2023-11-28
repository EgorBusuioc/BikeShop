<!DOCTYPE html>
<html>

<head>
    <title>ADMINPAGE</title>
</head>

<body style="background-color: pink;">
<h1>AdminPage</h1>
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
<form action="/product/create" method="post">
    Название Обьявления: <input type="text" name="title"/><br><br>
    Номер Артикля: <input type="text" name="article_number"/><br><br>
    Количество на складе: <input type="text" name="quantity_in_stock"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>

</html>