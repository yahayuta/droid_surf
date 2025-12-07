# Surf Log 📱🏄‍♂️

A comprehensive Android application for tracking and analyzing your surfing sessions. Log your surf sessions with detailed information about conditions, performance, and experiences. The project has undergone a significant modernization effort, updating its architecture and dependencies to align with modern Android development best practices.

## 🌊 Features

- **Session Logging**: Record detailed surf sessions with date, time, and duration
- **Condition Tracking**: Log weather, wind conditions, wave size, and crowd levels
- **Performance Metrics**: Track take-offs and board types used
- **Data Analysis**: View charts and statistics of your surfing history
- **Export Functionality**: Share your surf logs with other applications
- **Multi-language Support**: Available in English and Japanese

## 📱 Screenshots

*Screenshots will be added here*

## 🚀 Getting Started

### Prerequisites

- Android Studio Giraffe or later
- Android SDK 34 (Android 14)
- Gradle 8.2 or higher
- Java 17 or higher (recommended for Gradle 8.x)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/droid_surf.git
   cd droid_surf
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon) in Android Studio
   - The app will be installed and launched on your device

### Building from Command Line

```bash
# Navigate to project directory
cd droid_surf

# Build the project
./gradlew build

# Install on connected device
./gradlew installDebug
```

## 📊 Usage

### Logging a Surf Session

1. **Add New Record**: Tap the "ADD RECORD" menu option
2. **Fill Session Details**:
   - **Date**: Select the surf session date
   - **Start Time**: Record when you started surfing
   - **Duration**: Log how many hours you surfed
   - **Surf Point**: Enter the location name
   - **Weather**: Choose from Fine, Cloud, Rain, or Snow
   - **Wind**: Select wind conditions (Off-shore, On-shore, etc.)
   - **Wave Size**: Pick from 0ft to Giant Wave
   - **Crowd**: Rate crowd level from No One to Heavy
   - **Board Type**: Select your board (Short, Long, SUP, etc.)
   - **Take-offs**: Count your successful waves
   - **Comments**: Add personal notes about the session

3. **Save**: Tap "SAVE" to store your session

### Viewing Your Data

- **Detail View**: See comprehensive session information
- **Log List**: Browse all your surf sessions
- **Charts**: Analyze your surfing patterns and statistics
- **Export**: Share your logs with other applications

## 🏗️ Project Structure

```
droid_surf/
├── app/
│   ├── src/main/
│   │   ├── java/droid/surf/
│   │   │   ├── SurfRecordActivity.kt      # Main activity (Kotlin, MVVM, ViewBinding)
│   │   │   ├── SurfRecordDetailActivity.kt # Detail view (Kotlin, MVVM, ViewBinding)
│   │   │   ├── SurfRecordLogListActivity.kt # Log list (Kotlin, MVVM, ViewBinding)
│   │   │   ├── SurfRecordEntity.kt        # Room Entity
│   │   │   ├── SurfRecordDao.kt           # Room Data Access Object
│   │   │   ├── SurfLogDatabase.kt         # Room Database
│   │   │   ├── SurfRecordRepository.kt    # Data Repository
│   │   │   ├── SurfRecordViewModel.kt     # ViewModel for UI data
│   │   │   └── SurfApplication.kt         # Custom Application class
│   │   ├── res/
│   │   │   ├── layout/                      # UI layouts
│   │   │   ├── values/                      # English strings, themes, colors
│   │   │   ├── values-ja/                   # Japanese strings
│   │   │   └── drawable/                    # App icons and images
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── gradle/
├── build.gradle
└── settings.gradle
```

## ✨ Modernization Highlights

This project has undergone a significant modernization effort, including:

- **AndroidX Migration**: Upgraded all deprecated support libraries to AndroidX for improved compatibility and access to modern features.
- **Kotlin Conversion**: All core Java activities and utility classes have been converted to Kotlin, leveraging its conciseness and safety features.
- **ViewBinding Implementation**: Replaced `findViewById` calls with ViewBinding for type-safe and null-safe access to UI elements, reducing boilerplate and runtime errors.
- **Room Persistence Library**: Migrated from raw SQLite database operations to Room, providing an abstraction layer over SQLite for more robust database interactions, compile-time SQL validation, and easier migration handling.
- **MVVM Architecture**: Refactored the application to follow the Model-View-ViewModel architectural pattern, separating concerns and improving testability, maintainability, and scalability.
- **LiveData & Coroutines**: Utilized LiveData for observable data holders and Kotlin Coroutines for asynchronous operations, ensuring a responsive UI and efficient background processing.
- **Target SDK Update**: Updated `compileSdkVersion` and `targetSdkVersion` to 34 (Android 14) to ensure compatibility with the latest Android features and security enhancements.

## 🛠️ Technical Details

- **Minimum SDK**: API 14 (Android 4.0)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34
- **Gradle Version**: 8.9
- **Android Gradle Plugin (AGP)**: 8.2.0
- **Language**: Kotlin
- **Database**: Room Persistence Library

## 📈 Features in Detail

### Session Tracking
- Record surf session dates and times
- Track session duration in hours
- Log surf point locations
- Monitor weather and wind conditions
- Document wave sizes and crowd levels
- Track board types and take-off counts

### Data Analysis
- View session statistics and summaries
- Analyze surfing patterns over time
- Compare performance across different conditions
- Track progress and improvement

### Export & Sharing
- Export surf logs to other applications
- Share session details via social media
- Backup and restore functionality

## 🤝 Contributing

We welcome contributions! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### Development Setup

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**yahayuta**

## 🙏 Acknowledgments

- Thanks to all surfers who provided feedback and suggestions
- Inspired by the surfing community's need for better session tracking
- Built with love for the ocean and surfing culture

## 📞 Support

If you encounter any issues or have questions:

1. Check the existing [Issues](../../issues) page
2. Create a new issue with detailed information
3. Include device information and steps to reproduce

---

**Happy Surfing! 🏄‍♀️🌊**