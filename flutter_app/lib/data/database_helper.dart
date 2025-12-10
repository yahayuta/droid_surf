import 'package:flutter/foundation.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'package:flutter_app/models/surf_record.dart';

class DatabaseHelper {
  static final DatabaseHelper _instance = DatabaseHelper._internal();
  static Database? _database;

  // Setter for testing purposes
  @visibleForTesting
  static set testDatabase(Database db) {
    _database = db;
  }

  factory DatabaseHelper() {
    return _instance;
  }

  DatabaseHelper._internal();

  Future<Database> get database async {
    if (_database != null) {
      return _database!;
    }
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    String path = join(await getDatabasesPath(), 'surf_log.db');
    return await openDatabase(
      path,
      version: 1,
      onCreate: _onCreate,
    );
  }

  Future<void> _onCreate(Database db, int version) async {
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
  }

  Future<int> insertSurfRecord(SurfRecord record) async {
    Database db = await database;
    return await db.insert('surf_records', record.toMap(), conflictAlgorithm: ConflictAlgorithm.replace);
  }

  Future<List<SurfRecord>> getSurfRecords() async {
    Database db = await database;
    final List<Map<String, dynamic>> maps = await db.query('surf_records');
    return List.generate(maps.length, (i) {
      return SurfRecord.fromMap(maps[i]);
    });
  }

  Future<SurfRecord?> getSurfRecordByDate(String date) async {
    Database db = await database;
    final List<Map<String, dynamic>> maps = await db.query(
      'surf_records',
      where: 'date = ?',
      whereArgs: [date],
    );
    if (maps.isNotEmpty) {
      return SurfRecord.fromMap(maps.first);
    }
    return null;
  }

  Future<int> updateSurfRecord(SurfRecord record) async {
    Database db = await database;
    return await db.update(
      'surf_records',
      record.toMap(),
      where: 'date = ?',
      whereArgs: [record.date],
    );
  }

  Future<int> deleteSurfRecord(String date) async {
    Database db = await database;
    return await db.delete(
      'surf_records',
      where: 'date = ?',
      whereArgs: [date],
    );
  }

  Future<int> deleteAllSurfRecords() async {
    Database db = await database;
    return await db.delete('surf_records');
  }
}
