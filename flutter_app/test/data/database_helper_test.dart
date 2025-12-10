import 'package:flutter_test/flutter_test.dart';
import 'package:sqflite/sqflite.dart';
import 'package:sqflite_common_ffi/sqflite_ffi.dart';
import 'package:flutter_app/data/database_helper.dart';
import 'package:flutter_app/models/surf_record.dart';

void main() {
  sqfliteFfiInit(); // Initialize FFI for in-memory testing

  group('DatabaseHelper', () {
    late DatabaseHelper dbHelper;
    late Database database;

    setUp(() async {
      // Use an in-memory database for testing
      databaseFactory = databaseFactoryFfi;
      dbHelper = DatabaseHelper();
      // Ensure a fresh database for each test
      database = await openDatabase(inMemoryDatabasePath, version: 1, onCreate: (db, version) async {
        await db.execute(
          '''
          CREATE TABLE surf_records(
            date TEXT PRIMARY KEY,
            ymd TEXT,
            startTime TEXT,
            time TEXT,
            pointName TEXT,
            weather TEXT,
            wind TEXT,
            size TEXT,
            cloud TEXT,
            boardType TEXT,
            takeOff TEXT,
            comment TEXT
          )
          '''
        );
      });
      // Override the database getter to return the in-memory database
      // This is a bit of a hack for testing. In a real app, you might use dependency injection.
      DatabaseHelper.testDatabase = database;
    });

    tearDown(() async {
      await database.close();
    });

    test('insertSurfRecord and getSurfRecordByDate', () async {
      final surfRecord = SurfRecord(
        date: '2025-12-10',
        ymd: '20251210',
        startTime: '10:00',
        time: '2.5',
        pointName: 'Sunset Beach',
        weather: 'Sunny',
        wind: 'Light',
        size: 'Medium',
        cloud: 'Clear',
        boardType: 'Shortboard',
        takeOff: '15',
        comment: 'Great waves today!',
      );

      await dbHelper.insertSurfRecord(surfRecord);
      final fetchedRecord = await dbHelper.getSurfRecordByDate('2025-12-10');

      expect(fetchedRecord, isNotNull);
      expect(fetchedRecord!.date, '2025-12-10');
      expect(fetchedRecord.pointName, 'Sunset Beach');
    });

    test('updateSurfRecord', () async {
      final surfRecord = SurfRecord(
        date: '2025-12-10',
        ymd: '20251210',
        startTime: '10:00',
        time: '2.5',
        pointName: 'Sunset Beach',
        weather: 'Sunny',
        wind: 'Light',
        size: 'Medium',
        cloud: 'Clear',
        boardType: 'Shortboard',
        takeOff: '15',
        comment: 'Great waves today!',
      );
      await dbHelper.insertSurfRecord(surfRecord);

      final updatedRecord = SurfRecord(
        date: '2025-12-10',
        ymd: '20251210',
        startTime: '10:00',
        time: '3.0', // Updated time
        pointName: 'Sunset Beach',
        weather: 'Sunny',
        wind: 'Light',
        size: 'Medium',
        cloud: 'Clear',
        boardType: 'Shortboard',
        takeOff: '15',
        comment: 'Even greater waves today!', // Updated comment
      );
      await dbHelper.updateSurfRecord(updatedRecord);

      final fetchedRecord = await dbHelper.getSurfRecordByDate('2025-12-10');
      expect(fetchedRecord, isNotNull);
      expect(fetchedRecord!.time, '3.0');
      expect(fetchedRecord.comment, 'Even greater waves today!');
    });

    test('deleteSurfRecord', () async {
      final surfRecord = SurfRecord(
        date: '2025-12-10',
        ymd: '20251210',
        startTime: '10:00',
        time: '2.5',
        pointName: 'Sunset Beach',
        weather: 'Sunny',
        wind: 'Light',
        size: 'Medium',
        cloud: 'Clear',
        boardType: 'Shortboard',
        takeOff: '15',
        comment: 'Great waves today!',
      );
      await dbHelper.insertSurfRecord(surfRecord);
      await dbHelper.deleteSurfRecord('2025-12-10');

      final fetchedRecord = await dbHelper.getSurfRecordByDate('2025-12-10');
      expect(fetchedRecord, isNull);
    });

    test('getSurfRecords and deleteAllSurfRecords', () async {
      final surfRecord1 = SurfRecord(date: '2025-12-10', ymd: '20251210');
      final surfRecord2 = SurfRecord(date: '2025-12-11', ymd: '20251211');
      await dbHelper.insertSurfRecord(surfRecord1);
      await dbHelper.insertSurfRecord(surfRecord2);

      var records = await dbHelper.getSurfRecords();
      expect(records.length, 2);

      await dbHelper.deleteAllSurfRecords();
      records = await dbHelper.getSurfRecords();
      expect(records.length, 0);
    });
  });
}
