# 🛍️ MultiScreen B2C App with Integrated API (Jetpack Compose)

A modern **B2C (Business-to-Consumer)** e-commerce Android application built with **Jetpack Compose**. The app showcases a complete example of a scalable, modular architecture using modern Android development practices — including **MVI**, **Hilt**, **Retrofit**, **Room**, and **Jetpack Navigation**.

---

## 📱 Features

- 🖼️ **Onboarding Banner** with promotional call-to-action
- 🧭 **Bottom Navigation** with multiple screens:
  - Home
  - Categories
  - Promotions
  - Payments
  - Settings
- 🔍 **Shop by Category**: Grid-based product category layout
- 🛒 **Product Detail Screen**
- 🧑‍💼 **Register/Login Screen** with Room database integration
- 🔐 **Hashed Passwords** and profile storage
- 📅 **Timestamped Registration**
- 📷 **Optional Profile Picture Upload**
- 📦 **Product Listing** from real-world REST API
- 🚀 **Performance-optimized UI** using Compose best practices

---

## 🧱 Architecture

This project follows a **modular and scalable architecture**:

- **Jetpack Compose**: Declarative UI framework
- **MVI Pattern** (Model–View–Intent): For predictable state management
- **Hilt**: Dependency Injection
- **Retrofit**: Network client for consuming RESTful APIs
- **Room**: Local persistence for user registration & profile
- **Jetpack Navigation**: Type-safe, Compose-native screen transitions

---

## 🧰 Tech Stack

| Layer          | Technology             |
|----------------|------------------------|
| UI             | Jetpack Compose        |
| Architecture   | MVI                    |
| DI             | Hilt                   |
| Networking     | Retrofit + Moshi/Gson  |
| Local Storage  | Room Database          |
| Navigation     | Jetpack Compose Nav    |
| Image Loading  | Coil                   |
| Language       | Kotlin (100%)          |
| Min SDK        | 24                     |
| Target SDK     | 34                     |

---


---

## 🧪 Testing

- ✅ Unit-tested ViewModels with mocked dependencies
- 🧪 API mocking using Retrofit Test Dispatcher
- 🧪 Room database tested with in-memory DB

---

## 🔧 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- Kotlin 1.9+
- Gradle 8.0+
- Android SDK 24+


🔒 Security
🔑 Passwords are hashed before being stored with Room.
🔐 Best practices for storing sensitive data are followed.


## 📽️ Demo Video

<video width="320" height="240" controls>
  <source src="https://raw.githubusercontent.com/SiriZim37/MultiScreenB2CAppWithIntegreirteAPI/main/assets/demo_video.webm" type="video/webm">
  Your browser does not support the video tag.
</video>
