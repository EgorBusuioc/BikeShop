const products = document.querySelectorAll('.product');

if (products) {
    products.forEach(el => {
        let currentProduct = el;
        const imageSwitchItems = currentProduct.querySelectorAll('.image-switch__item');
        const imagePagination = currentProduct.querySelector('.image-pagination');
        if (imageSwitchItems.length > 1) {
            imageSwitchItems.forEach((el, index) => {
                el.setAttribute('data-index', index);
                imagePagination.innerHTML += `<li class="image-pagination__item ${index == 0 ? 'image-pagination__item--active' : ''}" data-index="${index}"></li>`;
                el.addEventListener('mouseenter', (e) => {
                    currentProduct.querySelectorAll('.image-pagination__item').forEach(el => { el.classList.remove('image-pagination__item--active') });
                    currentProduct.querySelector(`.image-pagination__item[data-index="${e.currentTarget.dataset.index}"]`).classList.add('image-pagination__item--active');
                });

                el.addEventListener('mouseleave', (e) => {
                    currentProduct.querySelectorAll('.image-pagination__item').forEach(el => { el.classList.remove('image-pagination__item--active') });
                    currentProduct.querySelector(`.image-pagination__item[data-index="0"]`).classList.add('image-pagination__item--active');
                });
            });
        }
    });
}

// Получаем все элементы товаров
var productArticles = document.querySelectorAll('.product');

// Перебираем каждый элемент товара
productArticles.forEach(function(productArticle) {
    // Получаем уникальный идентификатор товара из его атрибута id
    var productId = productArticle.getAttribute('id');

    // Получаем ссылку на элемент описания для текущего товара
    var productDescription = productArticle.querySelector('.description');

    // Получаем ссылки на остальные элементы текущего товара
    var productButton = productArticle.querySelector('.product__btn');
    var productImage = productArticle.querySelector('.product__image');
    var productTitle = productArticle.querySelector('.product__title');
    var productInfo = productArticle.querySelector('.product__info');
    var productPrice = productArticle.querySelector('.product__price');
    var productFinalDescription = productArticle.querySelector('.final__description');

    // Проверяем существование элемента перед применением стилей
    if (productDescription && productButton && productImage && productTitle && productInfo && productPrice && productFinalDescription) {
        var originalBackgroundColor = productArticle.style.backgroundColor;

        // Добавляем обработчики событий для текущего товара
        productDescription.addEventListener('mouseover', function () {
            productArticle.style.backgroundColor = '#b9fcf7';
            productButton.style.opacity = 0;
            productImage.style.opacity = 0.15;
            productTitle.style.opacity = 0;
            productInfo.style.opacity = 0;
            productPrice.style.opacity = 0;
            productFinalDescription.style.display = 'inline';
        });

        productDescription.addEventListener('mouseout', function () {
            productArticle.style.backgroundColor = originalBackgroundColor;
            productTitle.style.opacity = 1;
            productImage.style.opacity = 1;
            productButton.style.opacity = 1;
            productInfo.style.opacity = 1;
            productPrice.style.opacity = 1;
            productFinalDescription.style.display = 'none';
        });
    }
});



const list = document.querySelector('.product-grid-sort');
const items = document.querySelectorAll('.product-grid__item');
let isFiltered = false;
let sort = document.querySelector('.product-grid');

function filter() {
  list.addEventListener('click', event => {
    const targetId = event.target.dataset.id;
    console.log(targetId);

    // Проверка, является ли нажатая кнопка уже активной
    const isActive = event.target.classList.contains('active');

    // Удаление класса "active" со всех кнопок
    const buttons = document.querySelectorAll('.product-grid-sort button');
    buttons.forEach(button => {
      button.classList.remove('active');
    });

    if (!isActive) {
      // Добавление класса "active" к нажатой кнопке
      event.target.classList.add('active');
    }

    function mySort(){
        for (let i = 0; i <= sort.children.length; i++){
            for (let j = i; j <= sort.children.length; j++){
                 if (+sort.children[i].getAttribute('data-price') > +sort.children[j].getAttribute('data-price')){
                    replacedNode = sort.replaceChild(sort.children[j], sort.children[i]);
                    insertAfter(replacedNode, sort.children[i]);
                 }
            }
        }
    }

    function mySortDesc(){
        for (let i = 0; i <= sort.children.length; i++){
            for (let j = i; j <= sort.children.length; j++){
                 if (+sort.children[i].getAttribute('data-price') < +sort.children[j].getAttribute('data-price')){
                    replacedNode = sort.replaceChild(sort.children[j], sort.children[i]);
                    insertAfter(replacedNode, sort.children[i]);
                 }
            }
        }
    }

    function insertAfter(elem, refElem){
        return refElem.parentNode.insertBefore(elem, refElem.NextSibling);
    }


    switch (targetId) {
      case 'discounts':
        isFiltered = !isFiltered;
        items.forEach(item => {
          if (isFiltered) {
            if (item.classList.contains('dis')) {
              item.style.display = 'block';
            } else {
              item.style.display = 'none';
            }
          } else {
            item.style.display = 'block';
          }
        });
        break;
      case 'low-to-hight':
        mySort();
        break;
        case 'hight-to-low':
        mySortDesc();
              break;
      default:
        items.forEach(item => {
          item.style.display = 'block';
        });
        isFiltered = false;
    }
  });
}

filter();

