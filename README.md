🍕 Pizza Mobile App
An Android application developed in Kotlin with Jetpack Compose for pizza restaurant menu visualization and login system.
📱 Features

Home Screen: Attractive interface with gradient background and intuitive navigation
Digital Menu: Complete menu visualization with organized categories
Login System: Simple authentication for restricted area
User Area: Personalized session after login
Responsive Interface: Design adapted for different screen sizes

🎨 Design Characteristics

Color Palette: Gray, brown and orange tones for visual identity
Gradients: Gradient background on home screen
Typography: Well-defined fonts with varied weights
Components: Buttons with custom borders and shadows

🏗️ Architecture
Navigation Structure
Index (Home Screen)
├── Cardapio (Menu)
└── Login
    └── Sessao/{name} (Restricted Area)
Main Components
📂 MainActivity.kt

Main navigation configuration
App routes definition
NavController management

📂 Screens (Views)

Index.kt: Welcome screen with presentation
Login.kt: Authentication form
Cardapio.kt: Complete menu display
Sessao.kt: Restricted area after login

📂 Theme

Color.kt: Color palette definition
Theme.kt: Material 3 theme configuration
Type.kt: Typography styling

📋 Organized Menu
Available Categories

Traditional - Classic pizzas (4 Cheeses, Pepperoni, Mozzarella)
Special - Differentiated flavors (Portuguese, Chicken with Catupiry)
Sweet - Sweet options (Chocolate)
Beverages - Water and other drinks

Price Structure

Pizzas: Small, Medium and Large sizes with different prices
Beverages: Single price

🔐 Access System
Test Credentials:

Username: admin
Password: 123

🚀 How to Run
Prerequisites

Android Studio (recent version)
Minimum Android SDK 24
Kotlin configured

Execution Steps

Clone or download the project
Open in Android Studio
Wait for Gradle synchronization
Run on Android device/emulator

bash# Build the project
./gradlew build

# Install on device
./gradlew installDebug
🛠️ Technologies Used
Main Dependencies

Jetpack Compose: Modern declarative UI
Navigation Compose: Navigation between screens
Material 3: Design components
Kotlin: Main language

Compose Libraries
kotlinimplementation "androidx.compose.ui:ui"
implementation "androidx.compose.material3:material3"
implementation "androidx.navigation:navigation-compose"
implementation "androidx.activity:activity-compose"
📁 File Structure
app/src/main/java/com/example/trabalho_moblie/
├── MainActivity.kt
├── ui/theme/
│   ├── Color.kt
│   ├── Theme.kt
│   ├── Type.kt
│   └── views/
│       ├── Index.kt
│       ├── Login.kt
│       ├── Cardapio.kt
│       └── Sessao.kt
└── res/
    └── drawable/
        └── logo.png
🎯 Future Features
Possible Improvements

 Functional shopping cart
 Payment system integration
 Order history
 Push notifications
 Product reviews
 Delivery system with tracking
 New user registration
 Pizza customization

Technical Improvements

 Implement ViewModel for state management
 Add local database (Room)
 REST API integration
 Unit and UI testing
 Internationalization (i18n)

🐛 Known Issues

Encoding: Some special characters may not display correctly
Fixed Data: Menu and credentials are hardcoded in the code
Validation: Basic login system without encryption

👨‍💻 Developer
Project developed as academic work to demonstrate knowledge in:

Native Android development
Jetpack Compose
Mobile application architecture
Interface design

📱 Screenshots
Home Screen

Gradient background with restaurant logo
Welcome message with highlighted text
Navigation buttons to Menu and Login

Menu Screen

Organized categories (Traditional, Special, Sweet, Beverages)
Price table with different sizes
Clean and readable layout

Login Screen

Simple authentication form
Logo display
Error handling with Toast messages

User Session

Personalized welcome message
Restricted area access
Material 3 card design

🎨 UI/UX Design Decisions
Color Scheme

Primary: Orange (#FF5722) - Warm and appetizing
Background: Gray gradients - Modern and elegant
Text: High contrast for readability

Typography

Headers: Bold weights for emphasis
Body text: Regular weight for readability
Buttons: Bold text for call-to-action

Layout Patterns

Scrollable content: Prevents content overflow
Consistent spacing: 20dp padding throughout
Responsive design: Adapts to different screen sizes

📄 License
This project is intended for educational purposes and technical skills demonstration.
🚀 Getting Started for Developers
Setting up the Development Environment

Install Android Studio Arctic Fox or later
Configure Android SDK (API 24+)
Enable Kotlin plugin
Set up Android Virtual Device (AVD) for testing

Project Structure Understanding
├── MainActivity: Navigation setup
├── Index: Landing page with branding
├── Login: Authentication handling
├── Cardapio: Menu data and display logic
├── Sessao: User session management
└── Theme: UI styling and colors
Adding New Features

Create new Composable in views package
Add navigation route in MainActivity
Update theme colors if needed
Test on different screen sizes


Version: 1.0.0
Last Update: 2024
Compatibility: Android 7.0+ (API 24+)
Language: Kotlin
Framework: Jetpack Compose
