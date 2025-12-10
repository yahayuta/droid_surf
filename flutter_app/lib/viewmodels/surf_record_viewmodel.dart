// flutter_app/lib/viewmodels/surf_record_viewmodel.dart
import 'package:flutter/foundation.dart';
import 'package:flutter_app/data/surf_record_repository.dart';
import 'package:flutter_app/models/surf_record.dart';

class SurfRecordViewModel extends ChangeNotifier {
  final SurfRecordRepository _repository;
  List<SurfRecord> _allRecords = [];

  SurfRecordViewModel(this._repository) {
    _loadAllRecords();
  }

  List<SurfRecord> get allRecords => _allRecords;

  Future<void> _loadAllRecords() async {
    _allRecords = await _repository.getAllRecords();
    notifyListeners();
  }

  Future<void> insert(SurfRecord record) async {
    await _repository.insert(record);
    await _loadAllRecords(); // Reload records after insert
  }

  Future<void> update(SurfRecord record) async {
    await _repository.update(record);
    await _loadAllRecords(); // Reload records after update
  }

  Future<void> delete(String date) async {
    await _repository.delete(date);
    await _loadAllRecords(); // Reload records after delete
  }

  Future<void> deleteAll() async {
    await _repository.deleteAll();
    _allRecords = []; // Clear local list
    notifyListeners(); // Notify listeners that the list is empty
  }
}
