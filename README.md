# Surf Log 🌊🏄‍♂️ - Flutter Migration in Progress

This project is undergoing a migration from a native Android application to Flutter. The goal is to create a cross-platform mobile application while preserving the existing rich features for tracking and analyzing surfing sessions. The original Android code is preserved in `old_android_project/` for reference and incremental migration.

## 🚀 Migration Status

- **Initial Setup**: Flutter project initialized and integrated.
- **UI Migration**: Core UI components from Android have been migrated to Flutter widgets.
- **Data Layer Migration**: Room database equivalent (using `sqflite`), entities, DAOs, and repositories migrated to Dart.
- **Business Logic Migration**: Android ViewModels migrated to Flutter state management (using `ChangeNotifier`).
- **Testing**: Comprehensive unit and widget tests implemented for migrated components.

## 🌊 Features (Migrated to Flutter)

- **Session Logging**: Record detailed surf sessions with date, time, and duration
- **Condition Tracking**: Log weather, wind conditions, wave size, and crowd levels
- **Performance Metrics**: Track take-offs and board types used
- **Multi-language Support**: Available in English and Japanese (functionality to be re-implemented in Flutter)




## 🚀 Getting Started

### Prerequisites

- Flutter SDK (version compatible with project, see `flutter_app/pubspec.yaml`)
- Android Studio or VS Code with Flutter and Dart plugins (recommended)
- A physical device or emulator for Android/iOS development

### Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/droid_surf.git
    cd droid_surf
    ```
2.  **Navigate to the Flutter project**
    ```bash
    cd flutter_app
    ```
3.  **Get Flutter dependencies**
    ```bash
    flutter pub get
    ```
4.  **Run the Flutter application**
    ```bash
    flutter run
    ```
    To run on a specific device, use `flutter run -d <device_id>`.

### Running Tests

To run all Flutter tests:
```bash
cd flutter_app
flutter test
```
To run specific tests:
```bash
cd flutter_app
flutter test test/models/surf_record_test.dart
flutter test test/data/database_helper_test.dart
# etc.
```

## 📊 Usage

The Flutter application provides a user interface for logging and tracking surf sessions.

### Logging a Surf Session

1.  **Open the app**: Launch the Flutter application on your device or emulator.
2.  **Navigate to the Main Screen**: The main screen will display input fields for your surf session details.
3.  **Fill Session Details**:
    - **Date**: Select the surf session date using the date picker.
    - **Start Time**: Select the start time using the time picker.
    - **Hours**: Enter the duration of your surf session.
    - **Surf Point**: Enter the location name where you surfed.
    - **Weather, Wind, Wave Size, Cloud, Board Type**: Select appropriate values from the dropdowns.
    - **Take-offs**: Enter the number of successful take-offs.
    - **Comments**: Add any personal notes or observations about the session.
4.  **Save**: Tap the "Save" button to store your session data.

### Viewing Your Data

Currently, the application supports logging data. Functionality for viewing detailed records, log lists, charts, and export features are part of the ongoing migration and will be implemented in subsequent phases.


## 🏗️ Project Structure

```
droid_surf/
├── old_android_project/  # Original Android application code (for reference during migration)
├── flutter_app/          # New Flutter application code
│   ├── lib/              # Dart source code for the Flutter application
│   │   ├── main.dart
│   │   ├── main_screen.dart
│   │   ├── models/surf_record.dart
│   │   ├── data/database_helper.dart
│   │   └── viewmodels/surf_record_viewmodel.dart
│   ├── android/          # Flutter's Android runner project
│   ├── ios/              # Flutter's iOS runner project
│   ├── pubspec.yaml      # Flutter project dependencies
│   └── test/             # Flutter tests
├── .gitignore
├── import-summary.txt
├── LICENSE
├── README.md
└── settings.gradle (removed as it was for original Android project at root)
```


## 🛠️ Technical Details (Flutter)

- **Flutter Version**: See `flutter_app/pubspec.yaml`
- **Dart Version**: See `flutter_app/pubspec.yaml`
- **Language**: Dart
- **State Management**: `ChangeNotifier` / `Provider`
- **Database**: `sqflite` (SQLite)
- **Architecture**: MVVM-like pattern adapted for Flutter


## 📈 Features in Detail (Flutter)

### Session Tracking (Migrated)
- Record surf session dates and times
- Track session duration in hours
- Log surf point locations
- Monitor weather and wind conditions
- Document wave sizes and cloud conditions
- Track board types and take-off counts

### Data Analysis, Export & Sharing (Pending Migration)
- Session statistics and summaries
- Analyzing surfing patterns
- Exporting surf logs
- Sharing session details
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