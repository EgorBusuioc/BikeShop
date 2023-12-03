<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="description" content="Project" />
    <meta name="keywords" content="HTML, первый курс, Info about" />
    <meta name="author" content=" Бусуйок Егор " />
    <link rel="shortcut icon" href="images/logo.jpg">

    <title>BikeShop</title>

    <script src="../static/JavaScriptLibraries/libs/gsap/gsap.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/libs/gsap/ScrollTrigger.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/libs/gsap/ScrollSmoother.min.js" defer></script>
    <script src="../static/JavaScript/product_scripts.js" defer></script>
    <script src="../static/JavaScriptLibraries/libs/modal/modal.js" defer></script>
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
                                            style="width: 83vw; height: 100vh;" src="../Images/work/Bikes.jpg">
                                    </span></div>

                            <div class="tooltip"><a href="../HTML/ShopAMoutainBike.html" class="ancestor">mountain</a><span>
                                        <div class="main__text__menu">Mountain <br>bikes
                                            <div class="text__menu">We’re drawn to the trail for all sorts of reasons,
                                                whether it’s to chase that rush of speed, to push our limits, or to
                                                simply
                                                escape the daily grind. No matter your motivation, you’ll find a bike
                                                here that puts a grin on your face, from ultra-light XC
                                                machines and do-it-all trail bikes to gravity-racing speed sleds.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/MTB-hero.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="../HTML/ShopARoadBike.html" class="ancestor">road</a><span>
                                        <div class="main__text__menu" style="top: 40vh">ROAD BIKES
                                            <div class="text__menu">
                                                Whether it’s the alpine passes of the Tour or the rolling gravel roads
                                                outside of town,
                                                the Saturday club ride with friends or the crosswinds of Kona, our road
                                                bikes set the standard by which all others are measured.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/Road.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="../HTML/ShopAActiveBike.html" class="ancestor">active</a><span>
                                        <div class="main__text__menu" style="top: 40vh">Active
                                            <div class="text__menu">
                                                From light hill-climbers to pedal-assist bikes that’ll flatten hills for
                                                you, our Fitness Bikes
                                                are designed to help you get on, get out, and achieve your goals fast.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/Active.jpg">
                                    </span>
                            </div>

                            <div class="tooltip"><a href="../HTML/ShopATurboBike.html" class="ancestor">turbo-e</a><span>
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
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/electro.jpg">
                                    </span></a>
                            </div>

                            <div class="tooltip"><a href="../HTML/Equipment.html" class="parent">equipment</a><span>
                                        <div class="main__text__menu" style="top: 44vh; color: black;">equipment
                                            <div class="text__menu">
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/equipment1.jpg">
                                    </span></a>
                            </div>


                            <div class="tooltip"><a href="../HTML/Component.html" class="parent">components</a><span>
                                        <div class="main__text__menu" style="top: 40vh;">Bike <br>Components
                                            <div class="text__menu">
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/comp11.jpg">
                                    </span></a>
                            </div>

                            <div class="tooltip"><a href="../HTML/ShopASWorksBike.html" class="parent">s-works</a><span>
                                        <div class="main__text__menu" style="top: 40vh;">S-Works <br>Bikes
                                            <div class="text__menu">
                                                Innovate or Die. <br>Three words behind every design<br> decision we
                                                make.
                                            </div>
                                        </div>
                                        <img style="width: 83vw; height: 100vh;" src="../Images/work/s-works.jpg">
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
                        <a href="../index.html" style="color: black; text-decoration: none;">BikeShop</a>
                    </div>

                    <div class="header__cart cart" tabindex="0">
                        <div class="cart__text">
                            <img class="img2" src="../Images/shoppingcart.png">
                            <span class="cart__quantity"></span>
                        </div>
                        <div class="cart-content">
                            <ul class="cart-content__list" data-simplebar>
                                <li class="cart-content__item">
                                </li>

                            </ul>
                            <div class="cart-content__bottom">
                                <div class="cart-content__fullprice">
                                    <span class="total__price">Total price:</span>
                                    <span class="fullprice">1000</span>
                                </div>
                                <button class="cart-content__btn" data-graph-path="modal" data-graph-animation="fadeInUp">View My Cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main>
            <div class="container">
                <div class="hero__selection">
                    <div class="hero__text">Shaped by the <br>Fastest Riders <br>on Earth
                        <div class="hero__text__little">When races are won and lost by fractions of a second,
                            riders get particular about their bikes. Which explains why we spent years field-testing
                            prototypes,
                            nerd’ing out on the R&D, and testing various wheel and geometry setups in World Cup
                            events. It might seem excessive,
                            but when your R&D team has some of the best riders on earth, you listen. They know fast.
                        </div>
                    </div>
                    <img src="../Images/work/heroselectionbikes.jpg">
                </div>
            </div>

            <div class="sort__selection">
                <div class="container__of__sort">
                    <div class="sort__content grid-container-sort">
                        <ul class="product-grid-sort">
                            <li class="product-grid__item__sort">
                                <button class="product__btn__sort" style="width: 50%; position: relative; left: 50%;" data-id="low-to-hight">LOW TO HIGHT</button>
                            </li>
                            <li>
                                <button class="product__btn__sort" data-id="discounts">WITH DISCOUNT</button>
                            </li>
                            <li>
                                <button class="product__btn__sort" style="width: 50%; position: relative;" data-id="hight-to-low">HIGHT TO LOW</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="products__selection">
                <div class="container__of__products">
                    <div class="products-content grid-container">
                        <ul class="product-grid">
                            <li class="product-grid__item dis" data-price="4500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">IC088-2/RT003-1, 2021 EPIC 11m 29</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SRAM BSE RL 29 SB 100 BLK/DFB 44 C1</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM DB LVLTL LO GLB FRT DIR</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT EMT Cage-Mount Tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1275, 12-speed, 10-52t</div>
                                        <div class="classification" style="padding-top: 8%;">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB1.1.webp" alt="MTB1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB1.2.webp" alt="MTB1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB1.4.webp" alt="MTB1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB1.3.webp" alt="MTB1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Epic Comp</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 879876</span>
                                        <span class="product__available">In Stock: 13 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">4 500 $</span>
                                        <span class="product-price__old">5 600 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="7200">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m carbon chassis and rear-end</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox Zeb Select Plus1</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Code RS, 4-piston caliper, hydraulic disc</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Roval Traverse 29 Alloy</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1275, 12-speed, 10-52t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.1.webp" alt="MTB2">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.2.webp" alt="MTB2">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.3.webp" alt="MTB2">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.4.webp" alt="MTB2">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.5.webp" alt="MTB2">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB2.6.webp" alt="MTB2">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Enduro Expert</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 457982</span>
                                        <span class="product__available">In Stock: 5 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">7 200 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="11200">
                                <article class="product "
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m full carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Fox 38 Factory, Grip 2 damper, 29"</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Code Silver Stealth</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT CC steerer tube integrated tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM X0 Eagle Transmission Cassette</div>
                                        <div class="classification" style="padding-top: 8%;">Mountain Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.1.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.2.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.3.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.4.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.5.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.6.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.7.webp" alt="MTB3">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB3.8.webp" alt="MTB3">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Levo Pro Carbon</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 874521</span>
                                        <span class="product__available">In Stock: 1 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">11 200 $</span>
                                        <span class="product-price__old">13 500 $</span>
                                    </div>
                                    <button class="product__btn">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="14000">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Levo SL SW Frame</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Fox 36 Factory, 29", 44mm offset</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Code Stealth Ultimate</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT CC steerer tube</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XX Eagle Transmission Cassette</div>
                                        <div class="classification">Mountain Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.1.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.2.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.3.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.4.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.5.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.6.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.7.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB4.8.webp" alt="MTB4">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">S-Works Turbo Levo SL Carbon</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 8547126</span>
                                        <span class="product__available">In Stock: 6 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">14 000 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="12000">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">S-Works FACT 12m Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox SID SL ULTIMATE BRAIN</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level Ultimate, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT Box, Bottle cage EMT Tool cradle</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1299, 12-Speed, 10-52t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.1.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.2.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.3.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.4.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.5.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.6.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.7.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB5.8.webp" alt="MTB4">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">S-Works Epic</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 569741</span>
                                        <span class="product__available">In Stock: 9 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">12 000 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="4500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m carbon chassis and rear-end</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FOX FLOAT 36 Rhythm</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Code RS, 4-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Increased-volume SWAT™</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1275, 12-speed, 10-52t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB6.1.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB6.2.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB6.3.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB6.4.webp" alt="MTB4">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB6.5.webp" alt="MTB4">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Stumjumper EVO Comp</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 569741</span>
                                        <span class="product__available">In Stock: 9 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">4 500 $</span>
                                        <span class="product-price__old">7 200 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="1200">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized A1 premium butted alloy</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox Judy, Solo Air</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT Box, Bottle cage EMT Tool cradle</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM PG-1210 Eagle, 11-50t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.1.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.2.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.3.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.4.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.5.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.6.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.7.webp" alt="MTB7">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB7.8.webp" alt="MTB7">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Rockhopper Expert 27.5</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 100000</span>
                                        <span class="product__available">In Stock: 42 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">1 200 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="9000">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m Full Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox SID SL ULTIMATE BRAIN</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level Silver Stealth</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT Box, Bottle cage</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XO Eagle 10-52t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.1.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.2.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.3.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.4.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.5.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.6.webp" alt="MTB8">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB8.7.webp" alt="MTB8">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Epic Pro LTD</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 964581</span>
                                        <span class="product__available">In Stock: 4 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">9 000 $</span>
                                        <span class="product-price__old">11 200 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="3150">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Alloy chassis and rear-end</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FOX FLOAT 34 Rhythm</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM G2 R, 4-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT Box, Bottle cage EMT Tool cradle</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM NX Eagle, 12-speed, 11-50t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB9.1.webp" alt="MTB9">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB9.2.webp" alt="MTB9">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB9.3.webp" alt="MTB9">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB9.4.webp" alt="MTB9">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB9.5.webp" alt="MTB9">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Stumpjumper Comp Alloy</a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 854712</span>
                                        <span class="product__available">In Stock: 13 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">3 150 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="540">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized A1 premium butted alloy</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour XCM 29</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano Hydraulic Disc</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Roval Control SL</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SunRace, 9-Speed, 11-36t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB11.1.webp" alt="MTB11">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB11.2.webp" alt="MTB11">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Rockhopper Sport 29
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 147852</span>
                                        <span class="product__available">In Stock: 95 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">540 $</span>
                                        <span class="product-price__old">775 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="4500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m carbon chassis and rear-end</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox Zeb Select</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Code RS, 4-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Roval Control SL</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1275, 12-speed, 10-52t</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.1.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.2.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.3.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.4.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.5.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.6.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.7.webp" alt="MTB12">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB12.8.webp" alt="MTB12">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Enduro Comp
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 563214</span>
                                        <span class="product__available">In Stock: 2 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">4 500 $</span>
                                        <span class="product-price__old">5 800 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="10400">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">S-Works FACT 12m Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Rockshox SID ULTIMATE</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM G2 Ultimate</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Roval Control SL</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XG-1299 10-52T Rainbow</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.1.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.2.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.3.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.4.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.5.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.6.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB10.7.webp" alt="MTB10">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">S-Works Epic EVO RS
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 852147</span>
                                        <span class="product__available">In Stock: 1 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">10 400 $</span>
                                        <span class="product-price__old">14 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="7700">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">FACT 11m Full Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FOX FLOAT 34 Factory</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano XTR M9120</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Roval Control SL</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XG-1299 10-52T Rainbow</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.1.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.2.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.3.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.4.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.5.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.6.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB13.8.webp" alt="MTB10">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Epic EVO Pro
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 854745</span>
                                        <span class="product__available">In Stock: 7 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">7 700 $</span>
                                        <span class="product-price__old">10 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="9900">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">S-Works FACT 12m Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">RockShox SID SL ULTIMATE BRAIN</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano XTR M9120</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT EMT Cage-Mount Tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM Level Ultimate</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.1.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.2.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.3.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.4.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.5.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.6.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.7.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB14.8.webp" alt="MTB10">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">S-Works Epic
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 321789</span>
                                        <span class="product__available">In Stock: 6 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">9 900 $</span>
                                        <span class="product-price__old">14 000 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="10400">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">S-Works FACT 12m Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FOX FLOAT 34 Factory</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM G2 Ultimate</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT EMT Cage-Mount Tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Sram XG-1299, 12-Speed</div>
                                        <div class="classification">Mountain Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.1.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.2.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.3.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.4.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.5.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.6.webp" alt="MTB10">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/MTB15.7.webp" alt="MTB10">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">S-Works Epic EVO
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 621453</span>
                                        <span class="product__available">In Stock: 6 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">10 400 $</span>
                                        <span class="product-price__old">14 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="4900">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized Diverge FACT 9r carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Future Shock 2.0</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano GRX ST-R810</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT EMT Cage-Mount Tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Shimano Ultegra</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD1.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD1.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD1.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge Comp Carbon
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 854123</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">10 400 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="7500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized Diverge FACT 9r carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Future Shock 2.0</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano GRX ST-R810</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">SWAT EMT Cage-Mount Tool</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Shimano Ultegra</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.4.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.5.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.6.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD2.7.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge STR Expert
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 854123</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">7 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="9500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Diverge FACT 11r</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Future Shock 2.0 w</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Force</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XG-1275 Eagle</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.4.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.5.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.6.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD3.7.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge STR Pro
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 854123</span>
                                        <span class="product__available">In Stock: 7 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">9 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="6600">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized Diverge FACT</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Future Shock 2.0 w</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Force</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM XG-1275 Eagle</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.4.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.5.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.6.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD4.7.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge Expert Carbon
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 95147</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">6 600 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="2100">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized Diverge E5 Premium Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FACT carbon</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano GRX RX400</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Shimano CS-HG50-10</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.4.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.5.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD5.6.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge Expert Carbon
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 95147</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">2 100 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="9200">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Tarmac SL7 FACT 10r Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">FACT carbon</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Shimano GRX RX400</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Shimano CS-HG50-10</div>
                                        <div class="classification">Road Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.1.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.2.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.3.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.4.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.5.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ROAD6.6.webp" alt="ROAD1">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Diverge Expert Carbon
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 95147</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">9 200 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="4000">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">E5 Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour MobieA32</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Gates Carbon Drive CDX 22t</div>
                                        <div class="classification">Active Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE1.8.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Como 4.0 IGH
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 874152</span>
                                        <span class="product__available">In Stock: 63 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">4 000 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="3500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">E5 Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour MobieA32</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Gates Carbon Drive CDX 22t</div>
                                        <div class="classification">Active Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE2.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Vado 3.0 IGH
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 582645</span>
                                        <span class="product__available">In Stock: 11 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">3 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="4500">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">E5 Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour MobieA32</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Gates Carbon Drive CDX 22t</div>
                                        <div class="classification">Active Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE3.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Vado SL 5.0 Step-Through
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 951357</span>
                                        <span class="product__available">In Stock: 17 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">4 500 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="3100">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">E5 Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour MobieA32</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Gates Carbon Drive CDX 22t</div>
                                        <div class="classification">Active Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE4.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Vado SL 4.0 Step-Through
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 521478</span>
                                        <span class="product__available">In Stock: 7 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">3 100 $</span>
                                        <span class="product-price__old">3 900 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item dis" data-price="2900">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">E5 Aluminum</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">SR Suntour MobieA32</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">SRAM Level, 2-piston caliper</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">Gates Carbon Drive CDX 22t</div>
                                        <div class="classification">Active Turbo-E Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE5.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Turbo Vado SL 4.0 Step-Through
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 145268</span>
                                        <span class="product__available">In Stock: 9 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">2 900 $</span>
                                        <span class="product-price__old">3 700 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                            <li class="product-grid__item" data-price="2100">
                                <article class="product"
                                         style="color: black; background-color: #f1f1f1; margin: auto;">
                                    <div class="final__description">
                                        <div class="bold__text">FRAME:</div>
                                        <div class="light__text">Specialized FACT 9r Carbon</div>
                                        <div class="bold__text">FORK:</div>
                                        <div class="light__text">Specialized FACT 9r</div>
                                        <div class="bold__text">BRAKES:</div>
                                        <div class="light__text">Tektro HD-R510, hydraulic discr</div>
                                        <div class="bold__text">SWAT:</div>
                                        <div class="light__text">Integrated SWAT door</div>
                                        <div class="bold__text">CASSETTE:</div>
                                        <div class="light__text">SRAM PG-1210 Eagle</div>
                                        <div class="classification">Active Bikes</div>
                                    </div>
                                    <a href="#" class="product__image">
                                        <div class="product__switch image-switch">
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.1.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.2.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.3.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.4.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.5.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.6.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                            <div class="image-switch__item">
                                                <div class="image-switch__img"><img
                                                            src="../Images/Products/ACTIVE6.7.webp" alt="ACTIVE">
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="product__image-pagination image-pagination" aria-hidden="true">
                                        </ul>
                                    </a>

                                    <h3 class="product__title">
                                        <a href="#" style="text-decoration: none; color: black;">Sirrus X 5.0
                                        </a>
                                    </h3>
                                    <div class="product__info">
                                        <span class="product__term">Article number: 142365</span>
                                        <span class="product__available">In Stock: 21 pcs.</span>
                                    </div>
                                    <div class="product__price product-price">
                                        <span class="product-price__current">2 100 $</span>
                                    </div>
                                    <button class="product__btn ">ADD TO CART</button>
                                    <div class="description"
                                         style="text-align: center; cursor: pointer; height: 10%;">
                                        DESCRIPTION
                                    </div>
                                </article>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </main>
        <div class="modal">
            <div class="modal__container order-modal" role="dialog" aria-modal="true" data-graph-target="modal">
                <div class="modal-content order-modal__content">
                    <div class="order-modal__top">
                        <h2 class="order-modal__title">Order registration</h2>
                        <span class="order-modal__number">order № 1452</span>
                    </div>
                    <form action="#" class="order-modal__form order">
                        <label class="order__label">
                            <span class="order__text">Your name</span>
                            <input type="text" name="Имя" class="order__input">
                        </label>
                        <label class="order__label">
                            <span class="order__text">Phone number</span>
                            <input type="tel" name="Телефон" class="order__input" placeholder="+(373) 0__-___-___">
                        </label>
                        <label class="order__label">
                            <span class="order__text">Your mail</span>
                            <input type="email" name="Email" class="order__input" placeholder="YourMail@gmail.com">
                        </label>
                        <button class="order__btn btn" style="margin-top: 12px;">Buy</button>
                    </form>
                </div>
            </div>
        </div>
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
                                <div><a class="links__decoration" href="mailto:busuioc.egor@yandex.ru">busuioc.egor@yandex.ru</a></div>
                                <div><a class="links__decoration" href="mailto:busuiocegor@outlook.com">busuiocegor@outlook.com</a></div>
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