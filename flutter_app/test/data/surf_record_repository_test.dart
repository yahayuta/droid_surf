// flutter_app/test/data/surf_record_repository_test.dart
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';
import 'package:mockito/annotations.dart'; // Import annotations
import 'package:flutter_app/data/database_helper.dart';
import 'package:flutter_app/data/surf_record_repository.dart';
import 'package:flutter_app/models/surf_record.dart';

// Generate a MockDatabaseHelper class
@GenerateMocks([DatabaseHelper])
import 'surf_record_repository_test.mocks.dart'; // This file will be generated

void main() {
  group('SurfRecordRepository', () {
    late SurfRecordRepository repository;
    late MockDatabaseHelper mockDatabaseHelper;

    setUp(() {
      mockDatabaseHelper = MockDatabaseHelper();
      repository = SurfRecordRepository(mockDatabaseHelper);
    });

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

    test('insert calls databaseHelper.insertSurfRecord', () async {
      when(mockDatabaseHelper.insertSurfRecord(surfRecord)).thenAnswer((_) async => Future.value(1));
      await repository.insert(surfRecord);
      verify(mockDatabaseHelper.insertSurfRecord(surfRecord)).called(1);
    });

    test('getAllRecords calls databaseHelper.getSurfRecords', () async {
      when(mockDatabaseHelper.getSurfRecords()).thenAnswer((_) async => Future.value([surfRecord]));
      final records = await repository.getAllRecords();
      expect(records, [surfRecord]);
      verify(mockDatabaseHelper.getSurfRecords()).called(1);
    });

    test('getRecordByDate calls databaseHelper.getSurfRecordByDate', () async {
      when(mockDatabaseHelper.getSurfRecordByDate('2025-12-10')).thenAnswer((_) async => Future.value(surfRecord));
      final record = await repository.getRecordByDate('2025-12-10');
      expect(record, surfRecord);
      verify(mockDatabaseHelper.getSurfRecordByDate('2025-12-10')).called(1);
    });

    test('update calls databaseHelper.updateSurfRecord', () async {
      when(mockDatabaseHelper.updateSurfRecord(surfRecord)).thenAnswer((_) async => Future.value(1));
      await repository.update(surfRecord);
      verify(mockDatabaseHelper.updateSurfRecord(surfRecord)).called(1);
    });

    test('delete calls databaseHelper.deleteSurfRecord', () async {
      when(mockDatabaseHelper.deleteSurfRecord('2025-12-10')).thenAnswer((_) async => Future.value(1));
      await repository.delete('2025-12-10');
      verify(mockDatabaseHelper.deleteSurfRecord('2025-12-10')).called(1);
    });

    test('deleteAll calls databaseHelper.deleteAllSurfRecords', () async {
      when(mockDatabaseHelper.deleteAllSurfRecords()).thenAnswer((_) async => Future.value(1));
      await repository.deleteAll();
      verify(mockDatabaseHelper.deleteAllSurfRecords()).called(1);
    });
  });
}
