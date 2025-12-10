import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_app/main_screen.dart'; // Import your MainScreen widget

void main() {
  group('MainScreen Widget Tests', () {
    testWidgets('MainScreen displays all expected widgets', (WidgetTester tester) async {
      // Build our app and trigger a frame.
      await tester.pumpWidget(const MaterialApp(home: MainScreen()));
      await tester.pumpAndSettle();

      // Verify that all buttons are displayed.
      expect(find.widgetWithText(ElevatedButton, 'Forward'), findsOneWidget);
      expect(find.widgetWithText(ElevatedButton, 'Reverse'), findsOneWidget);
      expect(find.widgetWithText(ElevatedButton, 'Delete'), findsOneWidget);
      expect(find.widgetWithText(ElevatedButton, 'Save'), findsOneWidget);

      // Verify that all Text widgets (labels) are displayed.
      expect(find.text('Day:'), findsOneWidget);
      expect(find.text('Start Time:'), findsOneWidget);
      expect(find.text('Hours:'), findsOneWidget);
      expect(find.text('Point:'), findsOneWidget);
      expect(find.text('Weather:'), findsOneWidget);
      expect(find.text('Wind:'), findsOneWidget);
      expect(find.text('Size:'), findsOneWidget);
      expect(find.text('Cloud:'), findsOneWidget);
      expect(find.text('Board:'), findsOneWidget);
      expect(find.text('Take Off:'), findsOneWidget);
      expect(find.text('Comment:'), findsOneWidget);

      // Verify that all TextFormField widgets are displayed.
      expect(find.byType(TextFormField), findsNWidgets(4)); // Hours, Point, Take Off, Comment

      // Verify that all DropdownButtonFormField widgets are displayed by their hintText.
      expect(find.text('Select Weather'), findsOneWidget);
      expect(find.text('Select Wind'), findsOneWidget);
      expect(find.text('Select Size'), findsOneWidget);
      expect(find.text('Select Cloud'), findsOneWidget);
      expect(find.text('Select Board'), findsOneWidget);
    });

    // Note: TimePicker dialog testing is similar to DatePicker.
    // Full interaction testing (e.g., selecting a value in a dropdown)
    // would require more complex widget testing setup.
  });
}