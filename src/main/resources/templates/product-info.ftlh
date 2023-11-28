<!DOCTYPE html>
<html>

<head>
    <title>ADMINPAGE</title>
</head>

<body style="background-color: pink;">
<h1>AdminPage</h1>
<h4>Товары</h4>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Номер Артикля: </b>${product.article_number}</br>
<b>Количество на складе: </b>${product.quantity_in_stock}
<b>Цена: </b>${product.price}
<b>Описание: </b>${product.description}
<hr>
<h3>Создать новый товар</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="удалить товар"/>
</form>
</body>

</html>