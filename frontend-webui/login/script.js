const form = document.getElementById("login-form");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  fetch("https://heydaytime.net/api/v1/users/login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password }),
  })
    .then((response) => response.json())
    .then((response) => {
      console.log(response);
      if (response.id != null) {
        console.log(response.id);
        window.location.href = "https://heydaytime.net/home";
        // window.location.href = "http://127.0.0.1:5500/home";
        localStorage.setItem("id", response.id);
        localStorage.setItem("firstName", response.firstName);
        localStorage.setItem("lastName", response.lastName);
      }
    });
});
