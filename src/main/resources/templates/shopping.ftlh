<!DOCTYPE html>
<html>

<head>
    <title>BikeShop</title>

    <link rel="stylesheet" href="../static/CSS/login.css">
</head>

<body>
<div class="container_for_sign_in">
    <div class="header_for_sign_in" style="height: 50px">
        <div class="ShoppingCart__text">ShoppingCart</div>
    </div>
    <div style="display: grid; grid-template-columns: 1fr; grid-gap: 3vh;">
        <div style="align-items: center">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Delete</th>
                    <th>Creation Date</th>
                </tr>
                </thead>
                <tbody>
                <#list products as production>
                        <#if production.getUser().id == user.id>
                            <tr <#if production_index % 2 == 0>class="active-row"</#if>>
                                <td>${production.product.title}</td>
                                <td><#list production.product.bikeCategories as category>${category}</#list></td>
                                <td>${production.product.price}</td>
                                <td><#if production.product.discount?has_content>${production.product.discount}<#else>-</#if></td>
                                <td>${production.user.name}</td>
                                <td><#if production.user.address?has_content>${production.user.address}<#else>-</#if></td>
                                <td><#if production.user.phoneNumber?has_content>${production.user.phoneNumber}<#else>-</#if></td>
                                <td>
                                    <form action="/shopping_cart/delete/${production.id}" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                        <input type="submit" value="Delete" class="table_btn">
                                    </form>
                                </td>
                                <td>${production.creationDate()}</td>
                            </tr>
                        </#if>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>