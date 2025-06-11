"use strict";

let u_id;

const cartBtn = document.getElementsByClassName("cart")[0];
const addSearchBtn = document.getElementsByClassName("search-bar-btn")[0];

const idCheck = () => {
  const id = localStorage.getItem("id");

  if (id == null) {
    window.location.href = "https://heydaytime.net/login";
    // window.location.href = "http://127.0.0.1:5500/login";
  } else {
    u_id = id;
    // localStorage.clear();
    return id;
  }
};

const setAcccountDetails = () => {
  const firstName = localStorage.getItem("firstName");
  const lastName = localStorage.getItem("lastName");

  const wlcmMsg = document.createElement("p");

  wlcmMsg.appendChild(
    document.createTextNode(`Welcome ${firstName} ${lastName}!`)
  );

  document.getElementsByClassName("user")[0].appendChild(wlcmMsg);
};

const createProduct = (
  name,
  price,
  maker,
  rating,
  reviews,
  description,
  itemCategory,
  id
) => {
  const product = document.createElement("div");
  product.classList.add("product");

  const productInfo = document.createElement("div");
  productInfo.classList.add("product-info");

  const productName = document.createElement("span");
  productName.classList.add("product-name");
  productName.appendChild(document.createTextNode(name));

  const productPrice = document.createElement("span");
  productPrice.classList.add("product-price");
  productPrice.appendChild(document.createTextNode(`$${price}`));

  const productManufacturer = document.createElement("span");
  productManufacturer.classList.add("product-manufacturer");
  productManufacturer.appendChild(document.createTextNode(`by ${maker}`));

  productInfo.appendChild(productName);
  productInfo.append(productPrice);
  productInfo.append(productManufacturer);

  const productRatings = document.createElement("div");
  productRatings.classList.add("product-rating");

  let stars = "";
  for (let i = 0; i < Math.floor(rating); i++) {
    stars += "⭐";
  }

  productRatings.appendChild(document.createTextNode(` ${stars} ${rating}`));

  const productReviews = document.createElement("div");
  productReviews.classList.add("product-reviews");
  productReviews.appendChild(
    document.createTextNode(`(${reviews}) ${itemCategory}`)
  );

  const productDescription = document.createElement("div");
  productDescription.classList.add("product-description");
  productDescription.appendChild(document.createTextNode(description));

  const addToCart = document.createElement("div");
  addToCart.classList.add("add-to-cart");

  // const addToCartBtn = document.createElement("button");
  // addToCartBtn.classList.add("add-to-cart-btn");
  // addToCartBtn.appendChild(document.createTextNode("ADD"));

  addToCart.innerHTML = `<button value="${id}" id="${id}" type="button">ADD</button>`;

  product.appendChild(productInfo);
  product.appendChild(productRatings);
  product.appendChild(productReviews);
  product.appendChild(productDescription);
  product.append(addToCart);

  document.getElementsByClassName("product-list")[0].appendChild(product);

  addBtnListner(id);
};

const btn = document.getElementsByClassName("search-btn")[0];

btn.addEventListener("click", () => {
  const category = document.getElementsByClassName("ctg")[0].value;
  const filter = document.getElementsByClassName("fltr")[0].value;

  let filterBy, ord;

  [filterBy, ord] = filter.split("&");

  fetchItems(category, filterBy, ord);
});

const fetchItems = (category, filterBy, ord) => {
  document.getElementsByClassName("product-list")[0].innerHTML = "";

  fetch(
    `https://heydaytime.net/api/v1/items?ctg=${category}&by_w=${filterBy}&ord=${ord}`
  )
    .then((response) => response.json())
    .then((data) => {
      data.forEach((element) => {
        const {
          id,
          productName,
          price,
          manufacturer,
          rating,
          numberOfReviews,
          description,
          itemCategory,
        } = element;

        createProduct(
          productName,
          price,
          manufacturer,
          rating,
          numberOfReviews,
          description,
          itemCategory,
          id
        );
      });
    });
};

const setCart = () => {
  fetch(`https://heydaytime.net/api/v1/users/get-cart?u_id=${u_id}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      let n = Array.from(data).length;
      updateCart(n);
      return n;
    });
};

const updateCart = (n) => {
  cartBtn.innerHTML = `🛒Cart x${n}`;
};

const addBtnListner = (id) => {
  document.getElementById(id).addEventListener("click", () => {
    addToCart(id, "i_id");
  });
};

const addToCart = (i_attr, byWhat) => {
  fetch(
    `https://heydaytime.net/api/v1/users/add-item?u_id=${u_id}&i_attr=${i_attr}&by_w=${byWhat}`
  )
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      updateCart(data.length);
    });
};

addSearchBtn.addEventListener("click", (event) => {
  event.preventDefault();
  const searchBar = document.getElementsByClassName("search-bar")[0];

  addToCart(searchBar.value, "i_pr_n");
});

cartBtn.addEventListener("click", (event) => {
  event.preventDefault();
  if (setCart !== 0) {
    window.location.href = "https://heydaytime.net/checkout";
    // window.location.href = "http://127.0.0.1:5500/checkout";
  }
});

idCheck();
setAcccountDetails();
fetchItems("ALL", "fb_rat", "htl");
setCart();
