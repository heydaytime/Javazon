const form = document.getElementById("signup-form");

form.addEventListener("submit", (event) => {
  event.preventDefault();
  console.log("Form Submitted");

  const firstName = document.getElementById("first-name").value;
  const lastName = document.getElementById("last-name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const dob = document.getElementById("dob").value;
  const gender = document.getElementById("gender").value;

  fetch("https://heydaytime.net/api/v1/users/signup", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ firstName, lastName, dob, email, password, gender }),
  }).then((response) => {
    console.log(response);
    if (response.status == 200) {
      window.location.href = "https://heydaytime.net/verify";
      // window.location.href = "http://127.0.0.1:5500/verify/";
    }
  });
});
