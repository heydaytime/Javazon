"use strict";

let u_id;

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

const setCheckoutCart = () => {
  fetch(`https://heydaytime.net/api/v1/users/get-cart?u_id=${u_id}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      data.forEach((item) => {
        const { productName, price, quantity, id } = item;
        addItemToTable(productName, price, quantity, id);
      });
    });
};

const resetTable = () => {
  const table = (document.getElementsByClassName(
    "cart-list"
  )[0].innerHTML = `        <tr>
          <th>PRODUCT NAME</th>
          <th>PRICE</th>
          <th>QUANTITY</th>
        </tr>`);
};

const addItemToTable = (productName, productPrice, productQuantity, id) => {
  const item = document.createElement("tr");
  item.classList.add("items");

  const name = document.createElement("th");
  name.classList.add("item-name");
  name.appendChild(document.createTextNode(productName));

  name.innerHTML += `<button class="remove-btn" value="${id}" id="${id}">🚫</button>`;

  const price = document.createElement("th");
  price.classList.add("item-price");
  price.appendChild(document.createTextNode(`$${productPrice}`));

  const quantity = document.createElement("th");
  quantity.classList.add("item-quantity");
  quantity.appendChild(document.createTextNode(`x${productQuantity}`));

  item.appendChild(name);
  item.appendChild(price);
  item.appendChild(quantity);

  document.getElementsByClassName("cart-list")[0].appendChild(item);

  addRemoveBtnListener(id);
};

const addRemoveBtnListener = (id) => {
  const btn = document.getElementById(id);

  btn.addEventListener("click", (event) => {
    event.preventDefault();
    removeItem(id);
  });
};

const removeItem = (id) => {
  console.log(id);
  fetch(
    `https://heydaytime.net/api/v1/users/clear-cart?u_id=${u_id}&i_ud=${id}`
  )
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      resetTable();

      data.forEach((item) => {
        const { productName, price, quantity, id } = item;
        addItemToTable(productName, price, quantity, id);
      });
    });
};

document
  .getElementsByClassName("back-btn")[0]
  .addEventListener("click", (event) => {
    event.preventDefault();
    window.location.href = "https://heydaytime.net/home";
    // window.location.href = "http://127.0.0.1:5500/home/";
  });

document
  .getElementsByClassName("checkout-btn")[0]
  .addEventListener("click", (event) => {
    event.preventDefault();

    fetch(`https://heydaytime.net/api/v1/users/checkout?u_id=${u_id}`).then(
      () => {
        window.location.href = "https://heydaytime.net/home";
        // window.location.href = "http://127.0.0.1:5500/home/";
      }
    );
  });

idCheck();
setCheckoutCart();
