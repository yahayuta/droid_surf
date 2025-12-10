// flutter_app/lib/data/surf_record_repository.dart
import 'package:flutter_app/data/database_helper.dart';
import 'package:flutter_app/models/surf_record.dart';

class SurfRecordRepository {
  final DatabaseHelper _databaseHelper;

  SurfRecordRepository(this._databaseHelper);

  Future<int> insert(SurfRecord record) async {
    return await _databaseHelper.insertSurfRecord(record);
  }

  Future<List<SurfRecord>> getAllRecords() async {
    return await _databaseHelper.getSurfRecords();
  }

  Future<SurfRecord?> getRecordByDate(String date) async {
    return await _databaseHelper.getSurfRecordByDate(date);
  }

  Future<int> update(SurfRecord record) async {
    return await _databaseHelper.updateSurfRecord(record);
  }

  Future<int> delete(String date) async {
    return await _databaseHelper.deleteSurfRecord(date);
  }

  Future<int> deleteAll() async {
    return await _databaseHelper.deleteAllSurfRecords();
  }
}
