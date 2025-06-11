const form = document.getElementById("verify-form");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const verificationCode = document.getElementById("code").value;

  fetch("https://heydaytime.net/api/v1/users/verify", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, verificationCode }),
  }).then((response) => {
    console.log(response);
    if (response.status == 200) {
      window.location.href = "https://heydaytime.net/login";
    }
  });
});
