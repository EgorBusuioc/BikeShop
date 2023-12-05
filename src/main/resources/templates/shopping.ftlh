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
                    <th>Article Number</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Fork</th>
                    <th>Frame</th>
                    <th>Swat</th>
                    <th>Cassete</th>
                    <th>Brakes</th>
                    <th>Delete</th>
                    <th>Creation Date</th>
                </tr>
                </thead>
                <tbody>
                <#list products as production>
                    <#list products_from_shop as product>
                        <#if production.getUser().id == user.id>
                            <tr <#if product_index % 2 == 0>class="active-row"</#if>>
                                <td>${product.title}</td>
                                <td><#list product.bikeCategories as category>${category}</#list></td>
                                <td>${product.article_number}</td>
                                <td>${product.price}</td>
                                <td><#if product.discount?has_content>${product.discount}<#else>-</#if></td>
                                <td>${product.fork}</td>
                                <td>${product.frame}</td>
                                <td>${product.swat}</td>
                                <td>${product.cassete}</td>
                                <td>${product.brakes}</td>
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

                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>