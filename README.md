# Tugas Semester 2 | Pemrograman Berbasis Objek

[![DeepSource](https://app.deepsource.com/gh/Dxrry/Semester2-PBO-UAS.svg/?label=active+issues&show_trend=true&token=5sEASpwOghIcmZYu_jeRPH-w)](https://app.deepsource.com/gh/Dxrry/Semester2-PBO-UAS/?ref=repository-badge)

## Simple Restaurant Booking (Client)
* Bahasa Pemrograman: Java
* Database : MySQL

## Apa yang Ada di Project Ini?
- Main Menu (Halaman Utama)
- Login (Masuk)
- Register (Daftar)
- Pembayaran Gateway
- Pembayaran
- History Order
- Detail Order
- Loading (Splash Screen)

## Aplikasi yang Saya Gunakan untuk Membuat Project ini
- Figma (Mendesain UI & UX)
- MySQL WorkBench (Manage Database)
- Apache NetBeans IDE 16
## Penginstalan
1. Download & Import SQL: [/database.sql](/database.sql)
2. Clone Repository ini di NetBeans  
Open NetBeans Pilih *Team* > *Git* > *Clone* dari  main menu.  
Untuk *Username* dan *Password* boleh dikosongkan
![SSFirst](/Screenshoots/Screenshot%20from%202023-06-24%2009-02-13.png)

3. Konfigurasi *dbUrl*, *dbUsername* dan *dbPassword*
```java
private Connection createConnection() throws SQLException {
    String dbUrl = "jdbc:mysql://localhost/database_name"; // Ubah
    String dbUsername = "database_username"; // Ubah
    String dbPassword = "database_password"; // Ubah
    return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
}
```
https://github.com/Dxrry/Semester2-PBO-UAS/blob/797adbe5c0ded7bc6862edcc171abec0f2cb6f4e/src/Functions/MySQL/Database.java#L23-L28

4. Build Project (F11)  

![SSSecond](/Screenshoots/Screenshot%20from%202023-06-24%2009-19-21.png)

5. Finally Run Project (F6)  

![SSThird](/Screenshoots/Screenshot%20from%202023-06-24%2009-24-33.png)

## Screenshots
### Main Menu (Halaman Utama)
![Main Menu](/Screenshoots/DASHBOARD.png)
### Login (Masuk)
![Login](/Screenshoots/LOGIN.png)
### Register (Daftar)
![Register](/Screenshoots/REGISTER.png)
### Pembayaran Gateway
![Pembayaran Gateway](/Screenshoots/PAYMENTGATEWAY.png)
### Pembayaran
![Pembayaran](/Screenshoots/PAYMENT.png)
### History Order
![History Order](/Screenshoots/HISTORY.png)
### Detail Order
![Detail Order](/Screenshoots/DETAILORDER.png)
### Loading (Splash Screen)
![Loading](/Screenshoots/LOADING.png)

## Referensi
YouTube Channel: Layanan Fotokopi Online  
[Video Link](https://www.youtube.com/watch?v=hbHmELoUS9Y) | https://www.youtube.com/watch?v=hbHmELoUS9Y

DJ - Raven (UI Swing Components)  
[GitHub Link](https://github.com/DJ-Raven/) | https://github.com/DJ-Raven/

Google Fonts: Poppins  
[Google Fonts Link](https://fonts.google.com/specimen/Poppins) | https://fonts.google.com/specimen/Poppins

Icons8  
[Icons8 Website Link](https://icons8.com/) | https://icons8.com/

DesignAI - GraphicMaker  
[DesignAI Website Link](https://designs.ai/) | https://designs.ai/
