<h1>
  <img src="https://github.com/user-attachments/assets/a92d701e-68c2-4246-80ba-a9ab02ea5de4" alt="Logo" width="30" style="vertical-align: middle;"/>
  Javazon
</h1>

Javazon is a full-stack e-commerce web application I built in late December 2022 as my final computer science project for junior high school. The idea was to create a mini Amazon clone — hence the name "Javazon." While the UI might not scream "Amazon," I implemented many core features you’d expect from a real-world e-commerce platform.

This project was a huge learning journey for me — and my first time creating a **fully functional application** with both frontend and backend from scratch.

---

## 🔧 Tech Stack

### Backend:
- **Java (Spring Boot)** – REST API
- **MongoDB** – Used to store user and application data
- **Docker** – Used to containerize MongoDB
- **Deployed on Linode VPS**

### Frontend:
- Plain **HTML**, **CSS**, **JavaScript**
- Served via **Nginx** (most likely — I don’t remember exactly)
- The frontend can be found in the frontend-webui directory

---

## ✨ Features

### ✅ Authentication
- Email-based OTP (One-Time Password) login system
- On successful verification, users are logged into their accounts

<p align="center">
  <img src="https://github.com/user-attachments/assets/bd983da8-7c42-490b-95af-fbf600ba1d44" alt="Centered Image" />
</p>

![image](https://github.com/user-attachments/assets/2c43d001-46a6-44f3-8182-4aa885dfc2d6)


### 🛍️ Products & Search
- Displayed a large set of items post-login
- A **search bar** to filter items by:
  - Product name
  - Category
  - Other filters (e.g. High to Low)

 ![image](https://github.com/user-attachments/assets/6eedd0ba-88eb-4170-ad85-5f53615fc99a)

### 🛒 Cart & Checkout
- Add or remove items from the cart
- Click **Checkout** to simulate an order
- Checkout did **not** include real payment processing (demo only)
- After checkout:
  - An **invoice** would be generated
  - Included a **random, believable ETA** for delivery
  - This would be sent to the user's email

![image](https://github.com/user-attachments/assets/3292b74c-3b6d-41bd-bf90-b5eac26795ae)

---

## 🎓 What I Learned

- Learned **Spring Boot** in under two weeks (never again 😅)
- Gained hands-on experience with:
  - RESTful API design
  - MongoDB data modeling
  - Docker basics
  - Hosting and deploying backend services
- Frontend & backend integration
- Real-world security concerns (read below...)

---

## 💥 Fun(?) Incident – I Got Hacked (sort of)

Somewhere along the way, I *accidentally* left my MongoDB port (27017) open to the internet — possibly without proper security settings.

A cyberwarfare group (yes, seriously) found the vulnerability and:
- Started **deleting my database** repeatedly
- Left a message in my MongoDB files about **violating data privacy laws** (I had stored *all* user info in plain text for demo purposes — not that it matters that much!)

![image](https://github.com/user-attachments/assets/4753e70c-3835-4e8f-a9ef-2a0f1c3c6cb2)

---

## 🎬 Bonus: I Made a Cringey YouTube Video Blogging My Journey

Yes, there’s a video out there.  
No, I’m not linking it here because it’s *way too cringe*. 😅

---

## 📁 Status

**Archived.**  
This was a school project.

---

> Checkout the OG Javazon!!! It was the first real programming project I was ever a part of! You can find it in the javazon-v1.0-2020 directory.
