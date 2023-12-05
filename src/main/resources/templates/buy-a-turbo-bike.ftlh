<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="description" content="Project"/>
    <meta name="keywords" content="HTML, первый курс, Info about"/>
    <meta name="author" content=" Бусуйок Егор "/>
    <link rel="shortcut icon" href="../static/Images/logo.jpg">

    <title>BikeShop</title>

    <script src="../static/JavaScriptLibraries/gsap/gsap.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/gsap/ScrollTrigger.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/gsap/ScrollSmoother.min.js" defer></script>
    <script src="../static/JavaScript/product_scripts.js" defer></script>
    <script src="../static/JavaScriptLibraries/modal/modal.js" defer></script>
    <script src="../static/JavaScript/simplebar.js" defer></script>
    <script src="../static/JavaScript/shoppingcart.js" defer></script>


    <link rel="stylesheet" href="../static/css/shop.css">
    <link rel="stylesheet" href="../static/css/footer_shop.css">
    <link rel="stylesheet" href="../static/css/shoppingCart.css">
    <link rel="stylesheet" href="../static/css/simplebar.css">
    <link rel="stylesheet" href="../static/libs/modal/modal.css">
    <link rel="stylesheet" href="../static/CSS/modalorder.css">

    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="../JavaScript/app.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

</head>

<body style="background-color: #fafafa;">
<div class="wrapper">
    <div class="content">
        <header>
            <div class="header__container">
                <div class="headers__of__header">
                    <div class="burger_menu">
                        <a href="#" class="burger_active"></a>
                        <nav class="menu-list">
                            <div class="tooltip"><a href="#" class="parent">bikes</a><span>
                                        <div class="main__text__menu" style="top:40vh;">Bikes</div><img
                                            style="width: 83vw; height: 100vh;" src="../static/Images/work/Bikes.jpg">
                                    </span></div>

                            <div class="tooltip"><a href="/mountain-bike"
                                                    class="ancestor">mountain</a><span>
                                        <div class="main__text__menu">Mountain <br>bikes
                                            <div class="text__menu">We’re drawn to the trail for all sorts of reasons,
                                                whether it’s to chase that rush of speed, to push our limits, or to
                                                simply
                                                escape the daily grind. No matter your motivation, you’ll find a bike
                                                here that puts a grin on your face, from ultra-light XC
                                                machines and do-it-all trail bikes to gravity-racing speed sleds.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;"
                                             src="../static/Images/work/MTB-hero.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="/road-bike" class="ancestor">road</a><span>
                                        <div class="main__text__menu" style="top: 40vh">ROAD BIKES
                                            <div class="text__menu">
                                                Whether it’s the alpine passes of the Tour or the rolling gravel roads
                                                outside of town,
                                                the Saturday club ride with friends or the crosswinds of Kona, our road
                                                bikes set the standard by which all others are measured.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../static/Images/work/Road.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="/active-bike"
                                                    class="ancestor">active</a><span>
                                        <div class="main__text__menu" style="top: 40vh">Active
                                            <div class="text__menu">
                                                From light hill-climbers to pedal-assist bikes that’ll flatten hills for
                                                you, our Fitness Bikes
                                                are designed to help you get on, get out, and achieve your goals fast.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../static/Images/work/Active.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="/turbo-bike"
                                                    class="ancestor">turbo-e</a><span>
                                        <div class="main__text__menu" style="color:rgb(0, 0, 0); left: 50vw;">It's You,
                                            <br>Only Faster
                                            <div class="text__menu" style="color:rgb(35, 35, 35);">
                                                Since 1974, we’ve had one goal: Innovate and inspire to improve riders’
                                                lives. So, when we developed our first electric bike in 2009,
                                                we knew it had to ride and feel like a great bike first—something we’d
                                                really love to ride ourselves. We wanted you to feel like you were on a
                                                “regular” bike, but that somehow,
                                                you’d grown superhero legs. Our core mission still hasn’t changed. It’s
                                                now, and forever will be, our promise for every Turbo: It’s You, Only
                                                Faste
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;"
                                             src="../static/Images/work/electro.jpg">
                                    </span></a>
                            </div>

                            <div class="tooltip"><a href="/sworks-bike" class="parent">s-works</a><span>
                                        <div class="main__text__menu" style="top: 40vh;">S-Works <br>Bikes
                                            <div class="text__menu">
                                                Innovate or Die. <br>Three words behind every design<br> decision we
                                                make.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;"
                                             src="../static/Images/work/s-works.jpg">
                                    </span></a>
                            </div>

                            <div class="logo_menu">BikeShop</div>
                        </nav>
                    </div>
                    <div style="cursor: pointer; padding-top: 50px;" class="burger" onclick="myFunction(this)">
                        <div class="bar1"></div>
                        <div class="bar2"></div>
                        <div class="bar3"></div>
                    </div>
                    <div class="menu__button">
                        <a href="#" class="menu__button__active"></a>
                        MENU
                    </div>

                    <div class="bikeshop__header__text" data-lag=".4" style="color: black;">
                        <a href="/" style="color: black; text-decoration: none;">BikeShop</a>
                    </div>
                    <div class="header__cart cart" tabindex="0">
                        <div class="cart__text">
                            <a href="/shopping_cart">
                                <img class="img2" src="../static/Images/shoppingcart.png">
                            </a>
                            <span class="cart__quantity"></span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main>
            <div class="container">
                <div class="hero__selection">
                    <div class="hero__text" style="padding-top: 120px; left: 1vw;">Turbo-E<br> Bikes
                    </div>
                    <iframe src="https://www.youtube.com/embed/MjLlZbQEdQI?modestbranding=1&amp;controls=0&amp;disablekb=1&amp;showinfo=0&amp;rel=0&amp;autoplay=1&amp;loop=1&amp;mute=1&amp;playlist=MjLlZbQEdQI" frameborder="0" data-gtm-yt-inspected-53="true" allowfullscreen style="width: 100%; height: 116vh; pointer-events: none;"></iframe>

                </div>
            </div>

            <div class="products__selection">
                <div class="container__of__products">
                    <div class="products-content grid-container">
                        <ul class="product-grid">
                            <#list products as product>
                                <#list product.bikeCategories as category>
                                    <#if category == "TURBO_E">
                                        <li class="product-grid__item dis">
                                            <article class="product"
                                                     style="color: black; background-color: #f1f1f1; margin: auto;">
                                                <div class="final__description">
                                                    <div class="bold__text">FRAME:</div>
                                                    <div class="light__text">${product.frame}</div>
                                                    <div class="bold__text">FORK:</div>
                                                    <div class="light__text">${product.fork}</div>
                                                    <div class="bold__text">BRAKES:</div>
                                                    <div class="light__text">${product.brakes}</div>
                                                    <div class="bold__text">SWAT:</div>
                                                    <div class="light__text">${product.swat}</div>
                                                    <div class="bold__text">CASSETTE:</div>
                                                    <div class="light__text">${product.cassete}</div>
                                                    <div class="classification" style="padding-top: 8%;">
                                                        <#list product.bikeCategories as category>
                                                            <#if category == "MOUNTAIN_BIKE">Mountain Bikes</#if>
                                                            <#if category == "ACTIVE_BIKE">Active Bikes</#if>
                                                            <#if category == "ROAD_BIKE">Road Bikes</#if>
                                                            <#if category == "TURBO_E">Turbo-E Bikes</#if>
                                                            <#if category == "S_WORKS">S-Works Bikes</#if>
                                                        </#list>
                                                    </div>
                                                </div>
                                                <a href="#" class="product__image">
                                                    <div class="product__switch image-switch">
                                                        <#list images as img>
                                                            <#if product.getId() == img.product.getId()>
                                                                <div class="image-switch__item">
                                                                    <div class="image-switch__img">
                                                                        <img src="/images/${img.id}">
                                                                    </div>
                                                                </div>
                                                            </#if>
                                                        </#list>
                                                    </div>
                                                    <ul class="product__image-pagination image-pagination"
                                                        aria-hidden="true">
                                                    </ul>
                                                </a>

                                                <h3 class="product__title">
                                                    <a href="#"
                                                       style="text-decoration: none; color: black;">${product.title}</a>
                                                </h3>
                                                <div class="product__info">
                                                    <span class="product__term">Article number: ${product.article_number}</span>
                                                    <span class="product__available">In Stock: ${product.quantity_in_stock} pcs.</span>
                                                </div>
                                                <div class="product__price product-price">
                                                    <#if product.discount == ""><span
                                                            class="product-price__current">${product.price} $</span>
                                                    <#else>
                                                        <span class="product-price__current">${product.discount} $</span>
                                                        <span class="product-price__old">${product.price} $</span>
                                                    </#if>
                                                </div>
                                                <form action="/add_to_cart/add/${product.getId()}" method="post">
                                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                                    <input type="submit" value="ADD TO CART" class="product__btn"/>
                                                </form>
                                                <div class="description"
                                                     style="text-align: center; cursor: pointer; height: 10%;">
                                                    DESCRIPTION
                                                </div>
                                            </article>
                                        </li>
                                    </#if>
                                </#list>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div class="footer" data-speed=1.005 style="margin-top: 20vh;">
                <div class="footer_container">
                    <div class="colors">
                        <div class="footer__content">
                            <div style="height: 15vh; position: relative; top: 5vh;">
                                <div style="display: flex; justify-content: space-between;">
                                    <div class="footer__lines"></div>
                                    <div class="footer__lines" style="width: 50%;"></div>
                                </div>
                                <div style="display: flex;">
                                    <div class="footer__text">
                                        YEAR FOUNDED
                                    </div>
                                    <div class="footer__text" style="width: 6.5vw; position: relative; left: 25vw;">
                                        COMPANY
                                    </div>
                                </div>
                                <div class="footer_2023">
                                    2023
                                </div>
                                <div class="footer_bikeshop" data-lag=".4">
                                    BikeShop
                                </div>
                            </div>
                            <div class="footer_busuiocegor">
                                Busuioc Egor
                            </div>
                        </div>
                    </div>
                    <div style="display: inline-block; height:5%;"></div>
                    <div style="display: flex; flex-direction: row; height: 21%">
                        <div class="get__in__touch">
                            <div style="margin: auto;">
                                Get in touch
                            </div>
                            <div style="margin: auto; display: flex; flex-direction: column;">
                                <div><a class="links__decoration" href="mailto:busuioc.egor@yandex.ru">busuioc.egor@yandex.ru</a>
                                </div>
                                <div><a class="links__decoration" href="mailto:busuiocegor@outlook.com">busuiocegor@outlook.com</a>
                                </div>
                            </div>
                        </div>
                        <div class="follow__me">
                            <div style="margin: auto;">Follow Me</div>
                            <div style="display: block; height: 100%;"></div>
                            <div style="margin:auto;" class="social-links">
                                <a href="https://www.facebook.com/profile.php?id=100008517721439"><i
                                            class="fab fa-facebook-f"></i></a>
                                <a href="https://vk.com/idp1os"><i class="fab fa-vk"></i></a>
                                <a href="https://www.instagram.com/personal_id_eguar/"><i
                                            class="fab fa-instagram"></i></a>
                                <a href="https://github.com/EgorBusuioc"><i class="fab fa-github"></i></a>
                            </div>
                        </div>
                        <div class="go__back">
                            <a href="#" class="go__back__button" style="border:3px solid #b9fcf7;">Go Back</a>
                        </div>
                    </div>
                    <div style="display: block; height: 100%;">
                        <div data-lag=".4" class="white__bike"><img src="../Images/Bike black.png" width="140px">
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
</body>

</html>