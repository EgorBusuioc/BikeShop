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

var descriptionElements = document.querySelectorAll('.description');
var productFinalDescriptions = document.querySelectorAll('.final__description');
var productElements = document.querySelectorAll('.product');
var productImages = document.querySelectorAll('.product__image');
var productTitles = document.querySelectorAll('.product__title');
var productButtons = document.querySelectorAll('.product__btn');
var productInfos = document.querySelectorAll('.product__info');
var productPrices = document.querySelectorAll('.product__price');

// Добавляем обработчики событий каждому элементу
descriptionElements.forEach(function (element, index) {
    var originalBackgroundColor = productElements[index].style.backgroundColor;

    function handleMouseOver() {
        productElements[index].style.backgroundColor = '#b9fcf7';
        productButtons[index].style.opacity = 0;
        productImages[index].style.opacity = 0.15;
        productTitles[index].style.opacity = 0;
        productInfos[index].style.opacity = 0;
        productPrices[index].style.opacity = 0;
        productFinalDescriptions[index].style.display = 'inline';
    }

    function handleMouseOut() {
        productElements[index].style.backgroundColor = originalBackgroundColor;
        productTitles[index].style.opacity = 1;
        productImages[index].style.opacity = 1;
        productButtons[index].style.opacity = 1;
        productInfos[index].style.opacity = 1;
        productPrices[index].style.opacity = 1;
        productFinalDescriptions[index].style.display = 'none';
    }

    element.addEventListener('mouseover', handleMouseOver);
    element.addEventListener('mouseout', handleMouseOut);
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

