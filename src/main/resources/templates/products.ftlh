<!DOCTYPE html>
<html>

<head>
    <title>ADMINPAGE</title>
</head>

<body style="background-color: pink;">
<h1>AdminPage</h1>
<h4>Товары</h4>
<#list products as product>
    <div>
        <p><b>${product.model_name}</b> ${product.price} | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название Обьявления: <input type="text" name="model_name"/><br><br>
    Номер Артикля: <input type="text" name="article_number"/><br><br>
    Количество на складе: <input type="text" name="quantity_in_stock"/><br><br>
    Цена: <input type="text" name="price"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>

</html>