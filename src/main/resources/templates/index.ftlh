<#assign staticPath = "../static">

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="description" content="Project" />
    <meta name="keywords" content="HTML, первый курс, Info about" />
    <meta name="author" content=" Бусуйок Егор " />
    <link rel="shortcut icon" href="../static/Images/logo.jpg">

    <title>BikeShop</title>

    <script src="../static/JavaScriptLibraries/gsap/gsap.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/gsap/ScrollTrigger.min.js" defer></script>
    <script src="../static/JavaScriptLibraries/gsap/ScrollSmoother.min.js" defer></script>

    <link rel="stylesheet" href="${staticPath}/CSS/main.css">
    <link rel="stylesheet" href="${staticPath}/CSS/footer.css">
    <link rel="stylesheet" href="../static/CSS/main.css">
    <link rel="stylesheet" href="../static/CSS/footer.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="../static/JavaScript/app.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

</head>
<body>
<div class="wrapper">
    <div class="content">
        <header>
            <div class="header__container" >
                <div class="headers__of__header">
                    <div class="circle">
                        <a href="#" class="circle_actice"></a>
                    </div>
                    <div class="burger_menu">
                        <a href="#" class="burger_active"></a>
                        <nav class="menu-list">
                            <div class="tooltip"><a href="HTML/ShopADefaultBike.html" class="parent">bikes</a><span><div class = "main__text__menu" style="top:40vh;">Bikes</div><img style="width: 83vw; height: 100vh;"src="Images/work/Bikes.jpg"></span></div>

                            <div class="tooltip"><a href="HTML/ShopAMoutainBike.html" class="ancestor">mountain</a><span>
                            <div class = "main__text__menu">Mountain <br>bikes
                                <div class="text__menu">We’re drawn to the trail for all sorts of reasons, whether it’s to chase that rush of speed, to push our limits, or to simply
                                escape the daily grind. No matter your motivation, you’ll find a bike here that puts a grin on your face, from ultra-light XC
                                machines and do-it-all trail bikes to gravity-racing speed sleds.
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;"src="Images/work/MTB-hero.jpg"></span>
                            </div>

                            <div class="tooltip"><a href="HTML/ShopARoadBike.html" class="ancestor">road</a><span>
                            <div class = "main__text__menu" style="top: 40vh">ROAD BIKES
                                <div class="text__menu">
                                    Whether it’s the alpine passes of the Tour or the rolling gravel roads outside of town,
                                    the Saturday club ride with friends or the crosswinds of Kona, our road bikes set the standard by which all others are measured.
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/Road.jpg"></span>
                            </div>

                            <div class="tooltip"><a href="HTML/ShopAActiveBike.html" class="ancestor">active</a><span>
                            <div class = "main__text__menu" style="top: 40vh">Active
                                <div class="text__menu">
                                    From light hill-climbers to pedal-assist bikes that’ll flatten hills for you, our Fitness Bikes
                                    are designed to help you get on, get out, and achieve your goals fast.
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/Active.jpg"></span>
                            </div>

                            <div class="tooltip"><a href="HTML/ShopATurboBike.html" class="ancestor">turbo-e</a><span>
                            <div class = "main__text__menu" style="color:rgb(0, 0, 0); left: 50vw;">It's You, <br>Only Faster
                                <div class="text__menu" style="color:rgb(35, 35, 35);">
                                    Since 1974, we’ve had one goal: Innovate and inspire to improve riders’ lives. So, when we developed our first electric bike in 2009,
                                    we knew it had to ride and feel like a great bike first—something we’d really love to ride ourselves. We wanted you to feel like you were on a “regular” bike, but that somehow,
                                    you’d grown superhero legs. Our core mission still hasn’t changed. It’s now, and forever will be, our promise for every Turbo: It’s You, Only Faste
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/electro.jpg"></span></a>
                            </div>

                            <div class="tooltip"><a href="HTML/Equipment.html" class="parent">equipment</a><span>
                            <div class = "main__text__menu" style="top: 44vh; color: black;">equipment
                                <div class="text__menu">
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/equipment1.jpg"></span></a>
                            </div>

                            <div class="tooltip"><a href="HTML/Component.html" class="parent">components</a><span>
                            <div class = "main__text__menu" style="top: 40vh;">Bike <br>Components
                                <div class="text__menu">
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/comp11.jpg"></span></a>
                            </div>

                            <div class="tooltip"><a href="HTML/ShopASWorksBike.html" class="parent">s-works</a><span>
                            <div class = "main__text__menu" style="top: 40vh;">S-Works <br>Bikes
                                <div class="text__menu">
                                    Innovate or Die. <br>Three words behind every design<br> decision we make.
                                </div>
                            </div>
                            <img style="width: 83vw; height: 100vh;" src="Images/work/s-works.jpg"></span></a>
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

                    <div class="item2">
                        <img src="./Images/Bike.png" width="320">
                    </div>
                    <!--
                                <div class="item item3">
                                    <a href="#share">
                                        <img class="img1" src="./Images/share.png">
                                    </a>
                                </div>
                    -->
                    <div class="item item4">
                        <a href="HTML/share.html">
                            <img class="img2" src="./Images/share.png">
                        </a>
                    </div>
                </div>

                <div class="header__texts">
                    <div data-lag=".4" class="BikeShop__text">
                        BikeShop
                    </div>
                    <div class="hello__text">
                        Our team has done a great job of putting everything in one convenient place.
                        Here you will find: a store, a historical reference, and a photo archive.
                        <br>It is out of the question that you won't like it
                    </div>
                </div>

                <div class="very__beatiful__button">
                    <a href="HTML/ShopADefaultBike.html" class="shop__now">shop now</a>
                </div>
                <div>
                    <div data-lag=".4" class="mouse__container">
                        <div class="field">
                            <div class="mouse"></div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="portfolio">
            <div class="container">
                <main class="gallery">

                    <div data-speed=".9" class="gallery__left">

                        <img class="gallery__item" src="Images/work/stmp1.jpg" alt="Alt">
                        <img class="gallery__item" src="Images/work/stmp2.jpg" alt="Alt">

                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">COMPONENTS</h2>
                            <p class="text-block__p">We have the best components, each of them is made by professionals, tested at landfills, and only then go to the consumer.</p>
                        </div>
                        <img class="gallery__item" src="Images/work/comp2.jpg" alt="Alt">
                        <img class="gallery__item" src="Images/work/Equipment.jpg" alt="Alt">
                        <img class="gallery__item" src="Images/work/S-WORKS1.jpg" alt="Alt">
                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">INNOVATE OR DIE</h2>
                            <p class="text-block__p">What does it mean? Does it mean to stay in the office for a long time and work on CAD rendering until the cleaning column throws one out? Does it mean to stay completely burned out on the rear wheel of the Bora-hansgrohe riders to ask them for product feedback? Maybe it means standing at the racetrack with spare parts in the pouring rain. No matter what it is, S-WORKS was born out of this passion. This motivation drives us and pushes the limits of performance further upwards.</p>
                        </div>
                    </div>
                    <div data-speed="1.1" class="gallery__right">
                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">1974</h2>
                            <p class="text-block__p">We are riders—that fact has guided our every decision since 1974. When quality tires weren't around, we strove to make the best. When people wanted to ride cruisers in the dirt, we made the first production mountain bike. When roadies wanted to go faster, we doubled-down on carbon and built our own wind tunnel. And when we saw kids struggling to focus in school, we began supporting Outride to help promote better health through cycling.</p>
                        </div>
                        <img class="gallery__item" src="Images/work/stmp3.jpg" alt="Alt">
                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">STUMPJUMPER</h2>
                            <p class="text-block__p">A dream. A vision.</p>
                        </div>
                        <img class="gallery__item" src="Images/work/components.jpg" alt="Alt">
                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">EQUIPMENT</h2>
                            <p class="text-block__p">Best. Convenient. Effective.</p>
                        </div>
                        <img class="gallery__item" src="Images/work/equipment123.jpg" alt="Alt">
                        <div class="text-block gallery__item">
                            <h2 class="text-block__h">S-WORKS</h2>
                            <p class="text-block__p">S-WORKS-Frames, helmets, shoes and clothing. Challenges make solutions possible, solutions require innovations, innovations need courage and foresight. There are easier ways than that of the pioneer. The pursuit of innovation drives us and we are only satisfied with the perfect solution.</p>
                        </div>
                        <img class="gallery__item" src="Images/work/HELMET.jpg" alt="Alt">
                    </div>
                </main>
            </div>

            <footer>
                <div class="footer" data-speed = 1.005>
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
                                    <a href="https://www.facebook.com/profile.php?id=100008517721439"><i class="fab fa-facebook-f"></i></a>
                                    <a href="https://vk.com/idp1os"><i class="fab fa-vk"></i></a>
                                    <a href="https://www.instagram.com/personal_id_eguar/"><i class="fab fa-instagram"></i></a>
                                    <a href="https://github.com/EgorBusuioc"><i class="fab fa-github"></i></a>
                                </div>
                            </div>
                            <div class="go__back">
                                <a href="#" class="go__back__button" style="border:3px solid #b9fcf7;">Go Back</a>
                            </div>
                        </div>
                        <div style="display: block; height: 100%;">
                            <div data-lag=".4" class="white__bike"><img src="Images/Bike white.png" width="140px"></div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>
</body>
</html>