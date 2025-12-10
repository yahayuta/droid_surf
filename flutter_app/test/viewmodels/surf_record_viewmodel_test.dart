// flutter_app/test/viewmodels/surf_record_viewmodel_test.dart
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';
import 'package:mockito/annotations.dart';
import 'package:flutter_app/data/surf_record_repository.dart';
import 'package:flutter_app/models/surf_record.dart';
import 'package:flutter_app/viewmodels/surf_record_viewmodel.dart';

// Generate a MockSurfRecordRepository class
@GenerateMocks([SurfRecordRepository])
import 'surf_record_viewmodel_test.mocks.dart'; // This file will be generated

void main() {
  group('SurfRecordViewModel', () {
    late SurfRecordViewModel viewModel;
    late MockSurfRecordRepository mockRepository;
    
    final surfRecord1 = SurfRecord(
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

    final surfRecord2 = SurfRecord(
      date: '2025-12-11',
      ymd: '20251211',
      startTime: '11:00',
      time: '3.0',
      pointName: 'Maui',
      weather: 'Cloudy',
      wind: 'Strong',
      size: 'Large',
      cloud: 'Overcast',
      boardType: 'Longboard',
      takeOff: '20',
      comment: 'Good surf!',
    );

    setUp(() {
      mockRepository = MockSurfRecordRepository();
      // Stub the initial call to getAllRecords() when the ViewModel is created
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1, surfRecord2]));
      viewModel = SurfRecordViewModel(mockRepository);
    });

    test('initial records are loaded', () async {
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1, surfRecord2]));
      
      // Wait for the initial loading to complete
      await Future.delayed(Duration.zero); 

      expect(viewModel.allRecords, [surfRecord1, surfRecord2]);
      verify(mockRepository.getAllRecords()).called(1);
    });

    test('insert adds a new record and reloads records', () async {
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([]));
      when(mockRepository.insert(surfRecord1)).thenAnswer((_) async => Future.value(1));
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1]));
      
      await Future.delayed(Duration.zero); // Wait for initial load

      await viewModel.insert(surfRecord1);

      expect(viewModel.allRecords, [surfRecord1]);
      verify(mockRepository.insert(surfRecord1)).called(1);
      verify(mockRepository.getAllRecords()).called(2); // Initial load + reload after insert
    });

    test('update modifies an existing record and reloads records', () async {
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1]));
      when(mockRepository.update(any)).thenAnswer((_) async => Future.value(1));
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord2]));

      await Future.delayed(Duration.zero); // Wait for initial load

      await viewModel.update(surfRecord2); // Assuming surfRecord2 has same date as surfRecord1
      
      expect(viewModel.allRecords, [surfRecord2]);
      verify(mockRepository.update(surfRecord2)).called(1);
      verify(mockRepository.getAllRecords()).called(2);
    });

    test('delete removes a record and reloads records', () async {
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1]));
      when(mockRepository.delete('2025-12-10')).thenAnswer((_) async => Future.value(1));
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([]));

      await Future.delayed(Duration.zero); // Wait for initial load

      await viewModel.delete('2025-12-10');

      expect(viewModel.allRecords, []);
      verify(mockRepository.delete('2025-12-10')).called(1);
      verify(mockRepository.getAllRecords()).called(2);
    });

    test('deleteAll removes all records and notifies listeners', () async {
      when(mockRepository.getAllRecords()).thenAnswer((_) async => Future.value([surfRecord1, surfRecord2]));
      when(mockRepository.deleteAll()).thenAnswer((_) async => Future.value(2));
      
      await Future.delayed(Duration.zero); // Wait for initial load

      await viewModel.deleteAll();

      expect(viewModel.allRecords, []);
      verify(mockRepository.deleteAll()).called(1);
      // getAllRecords should be called once during initial setup
      verify(mockRepository.getAllRecords()).called(1); 
    });
  });
}
