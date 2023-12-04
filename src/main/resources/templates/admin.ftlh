<!DOCTYPE html>
<html>
<head>
    <title>BikeShop</title>

    <link rel="stylesheet" href="../static/CSS/login.css">
</head>
<body>
<div class="container_for_sign_in">
    <div class="header_for_sign_in" style="height: 50px"></div>
    <div style="display: grid; grid-template-columns: 1fr; grid-gap: 3vh;">
        <div style="align-items: center">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Active</th>
                    <th>Roles</th>
                    <th>Action</th>
                    <th>Creation Date</th>
                </tr>
                </thead>
                <tbody>
                <#list users as user>
                    <tr <#if user_index % 2 == 0>class="active-row"</#if>>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td><#if user.phoneNumber?has_content>${user.phoneNumber}<#else>-</#if></td>
                        <td><#if user.address?has_content>${user.address}<#else>-</#if></td>
                        <td><#if user.country?has_content>${user.country}<#else>-</#if></td>
                        <td><#if user.city?has_content>${user.city}<#else>-</#if></td>
                        <td><#if user.active>true<#else>false</#if></td>
                        <td><#list user.roles as role>${role}</#list></td>
                        <td>
                            <form action="/admin/user/ban/${user.id}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <input type="submit" value="Change Activity" class="table_btn">
                            </form>
                        </td>
                        <td>${user.creationDate()}</td>
                    </tr>
                </#list>
                <#if users?size == 0>
                    <tr>
                        <td colspan="11">
                            <h3>Users haven't been found</h3>
                        </td>
                    </tr>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="login_form">
            <div class="BikeShop__text">BikeShop</div>
            <div class="sign_in">Add New Product</div>
            <form action="/product/create" method="post" enctype="multipart/form-data">
                <input type="text" name="title" placeholder="Model Name" class="input"/><br><br>
                <input type="text" name="article_number" placeholder="Article Number" class="input"/><br><br>
                <input type="text" name="quantity_in_stock" placeholder="Quantity" class="input"/><br><br>
                <input type="number" name="price" placeholder="Price" class="input"/><br><br>
                <input type="number" name="discount" placeholder="Discount" class="input"/><br><br>
                <input type="text" name="frame" placeholder="Frame" class="input"/><br><br>
                <input type="text" name="fork" placeholder="Fork" class="input"/><br><br>
                <input type="text" name="brakes" placeholder="Brakes" class="input"/><br><br>
                <input type="text" name="swat" placeholder="Swat" class="input"/><br><br>
                <input type="text" name="cassete" placeholder="Cassete" class="input"/><br><br>
                <label class="result_text" style="font-size: 2.3vh">
                    <input type="radio" name="bikeCategories" value="MOUNTAIN_BIKE">
                    Mountain Bike
                </label>
                <br>
                <label class="result_text" style="font-size: 2.3vh">
                    <input type="radio" name="bikeCategories" value="ACTIVE_BIKE">
                    Active Bike
                </label>
                <br>
                <label class="result_text" style="font-size: 2.3vh">
                    <input type="radio" name="bikeCategories" value="ROAD_BIKE">
                    Road Bike
                </label>
                <br>
                <label class="result_text" style="font-size: 2.3vh">
                    <input type="radio" name="bikeCategories" value="TURBO_E">
                    Turbo-E Bike
                </label>
                <br>
                <label class="result_text" style="font-size: 2.3vh">
                    <input type="radio" name="bikeCategories" value="S_WORKS">
                    S-Works Bike <br><br>
                </label>
                <div class="result_text" style="font-size: 2.3vh">
                    First Photo: <input type="file" name="file1" style="float: right;"/><br>
                </div>
                <div class="result_text" style="font-size: 2.3vh">
                    Second Photo: <input type="file" name="file2" style="float: right;"/><br>
                </div>
                <div class="result_text" style="font-size: 2.3vh">
                    Third Photo: <input type="file" name="file3" style="float: right;"/><br>
                </div>
                <div class="result_text" style="font-size: 2.3vh">
                    Fourth Photo: <input type="file" name="file4" style="float: right;"/><br>
                </div>
                <div class="result_text" style="font-size: 2.3vh">
                    Fifth Photo: <input type="file" name="file5" style="float: right;"/><br>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Добавить товар" class="sign_in_btn"/>
                <a href="/product" class="registration">All Products</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
