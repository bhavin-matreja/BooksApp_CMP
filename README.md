# Books App 

## Overview
This is a Compose Multiplatform application for browsing and managing books. It allows users to search for books through an API, view book details, and add books to their favorites, which are stored locally using Room.


## 🚀 Features
- 🔍 **Search for books** using an API
- ⭐ **Add books to favorites**
- 📜 **View list of saved books** (stored locally)
- 💾 **Offline access** to favorites
- 🖥️ **Runs on Android, iOS, and Desktop**

## 🛠 Tech Stack
- **UI:** [Jetpack Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
- **Networking:** Ktor Client
- **Local Storage:** Room Database
- **Dependency Injection:** Koin
- **Navigation:** Jetpack Compose Navigation
- **State Management:** Flow & Coroutines

## 🖥️ Screenshots

### 📱 Android
| Listing | Detail                                         | Favorites                                              |
|---------|------------------------------------------------|--------------------------------------------------------|
| ![Listing]<img src="screenshots/android-book-listing.png" width="200"> | ![Detail]<img src="screenshots/android-book-detail.png" width="200"> | ![Favorites]<img src="screenshots/android-favorite-listing.png" width="200"> |

### 🍏 iOS
| Listing | Detail | Favorites |
|---------|--------|----------|
| ![Listing](screenshots/ios_listing.png) | ![Detail](screenshots/ios_detail.png) | ![Favorites](screenshots/ios_favorites.png) |

### 💻 Desktop
| Listing | Detail | Favorites |
|---------|--------|----------|
| ![Listing](screenshots/desktop_listing.png) | ![Detail](screenshots/desktop_detail.png) | ![Favorites](screenshots/desktop_favorites.png) |