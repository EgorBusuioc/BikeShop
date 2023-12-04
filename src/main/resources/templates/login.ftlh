<!DOCTYPE html>
<html>
<head>
    <title>BikeShop</title>

    <link rel="stylesheet" href="../static/CSS/login.css">
</head>
<body>
<#if user.email??>
    <div class="container_for_sign_in">
        <div class="grid_container">
            <div class="grid_item">
                <div class="BikeShop__text" style="font-size: 9vh">BikeShop</div>
                <div class="sign_in" style="font-size: 1.9vh; padding-top: 5vh;">My Account</div>
                <div class="sign_in" style="font-size: 4vh">${user.name} ${user.surname}</div>
                <div style="padding-top: 90%">
                    <form action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Sign Out" class="sign_in_btn" style="width: 80%; margin-left: auto; margin-right: auto;">
                    </form>
                </div>
                <div>
                    <#if user.isAdmin()>
                        <a href="/admin" class="registration">Admin Panel</a>
                    </#if>
                </div>
            </div>
            <div class="grid_item item2">
                <div class="grid_container2">
                    <div class="info_text">
                        Name
                    </div>
                    <div class="result_text">
                        ${user.name}
                    </div>
                    <div class="info_text">
                        Surname
                    </div>
                    <div class="result_text">
                        ${user.surname}
                    </div>
                    <div class="info_text">
                        Email
                    </div>
                    <div class="result_text">
                        ${user.email}
                    </div>
                    <div class="info_text">
                        Phone Number
                    </div>
                    <div class="result_text">
                        <#if user.phoneNumber?has_content>${user.phoneNumber}<#else></#if>
                    </div>
                    <div class="info_text">
                        City
                    </div>
                    <div class="result_text">
                        <#if user.city?has_content>${user.city}<#else></#if>
                    </div>
                    <div class="info_text">
                        Country
                    </div>
                    <div class="result_text">
                        <#if user.country?has_content>${user.country}<#else></#if>
                    </div>
                    <div class="info_text">
                        Creation Date
                    </div>
                    <div class="result_text">
                        ${user.creationDate()}
                    </div>
                </div>
            </div>
            <div class="grid_item item3">
                <div class="grid_container2">
                    <div class="item_grid_update">Update your Data</div>
                    <form action="/update-user/${user.id}" method="post" class="item_grid_form">
                        <input type="text" name="address" placeholder="Address" class="input item_grid_form" ><br><br>
                        <input type="text" name="city" placeholder="City" class="input" ><br><br>
                        <input type="text" name="country" placeholder="Country" class="input" ><br><br>
                        <input type="text" name="phoneNumber" placeholder="Phone Number" class="input" ><br><br>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Save" class="sign_in_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
<#else>
    <div class="container_for_sign_in">
        <div class="header_for_sign_in"></div>
        <div class="login_form">
            <div class="form_content">
                <div class="BikeShop__text">BikeShop</div>
                <div class="sign_in">Sign in to your Account</div>
                <form action="/login" method="post">
                    <input type="email" name="username" placeholder="Email" class="input"><br><br>
                    <input type="password" name="password" placeholder="Password" class="input password"><br><br>
                    <#if loginError??>
                        <div class="error">${loginError}</div>
                    </#if>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Sign In" class="sign_in_btn"/>
                </form>
                <a href="/registration" class="registration">Registration</a>
            </div>
        </div>
    </div>
</#if>
</body>
</html>
