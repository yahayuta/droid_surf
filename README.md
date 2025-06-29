# Surf Log 📱🏄‍♂️

A comprehensive Android application for tracking and analyzing your surfing sessions. Log your surf sessions with detailed information about conditions, performance, and experiences.

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

- Android Studio Arctic Fox or later
- Android SDK 14+ (API level 14)
- Gradle 8.0.1+
- Java 8 or higher

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
│   │   │   ├── SurfRecordActivity.java      # Main activity
│   │   │   ├── SurfRecordDetailActivity.java # Detail view
│   │   │   ├── SurfRecordLogListActivity.java # Log list
│   │   │   ├── SurfRecordDBHelper.java      # Database helper
│   │   │   ├── SurfRecordEntity.java        # Data model
│   │   │   └── SurfRecordrUtil.java         # Utility functions
│   │   ├── res/
│   │   │   ├── layout/                      # UI layouts
│   │   │   ├── values/                      # English strings
│   │   │   ├── values-ja/                   # Japanese strings
│   │   │   └── drawable/                    # App icons and images
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── gradle/
├── build.gradle
└── settings.gradle
```

## 🛠️ Technical Details

- **Minimum SDK**: API 14 (Android 4.0)
- **Target SDK**: API 33 (Android 13)
- **Compile SDK**: API 33
- **Build Tools**: 30.0.3
- **Gradle Version**: 8.0.1
- **Language**: Java
- **Database**: SQLite (via Android's built-in database)

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