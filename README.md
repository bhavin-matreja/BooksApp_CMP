# Books App

## Overview

This is a Compose Multiplatform application for browsing and managing books. It allows users to
search for books through an API, view book details, and add books to their favorites, which are
stored locally using Room.

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

| Listing                                                      | Detail                                                      | Favorites                                                        |
|--------------------------------------------------------------|-------------------------------------------------------------|------------------------------------------------------------------|
| <img src="screenshots/android-book-listing.png" width="200"> | <img src="screenshots/android-book-detail.png" width="200"> | <img src="screenshots/android-favorite-listing.png" width="200"> |

### 🍏 iOS

| Listing                                                  | Detail                                                  | Favorites                                                    |
|----------------------------------------------------------|---------------------------------------------------------|--------------------------------------------------------------|
| <img src="screenshots/iOS-book-listing.png" width="200"> | <img src="screenshots/iOS-book-detail.png" width="200"> | <img src="screenshots/iOS-favorite-listing.png" width="200"> |

### 💻 Desktop

| Listing                                                      | Detail                                                      | Favorites                                                        |
|--------------------------------------------------------------|-------------------------------------------------------------|------------------------------------------------------------------|
| <img src="screenshots/desktop-book-listing.png" width="300"> | <img src="screenshots/desktop-book-detail.png" width="300"> | <img src="screenshots/desktop-favorite-listing.png" width="300"> |
