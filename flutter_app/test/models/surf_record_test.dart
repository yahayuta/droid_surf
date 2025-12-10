import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_app/models/surf_record.dart';

void main() {
  group('SurfRecord', () {
    test('SurfRecord can be created and converted to/from Map', () {
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

      final map = surfRecord.toMap();

      expect(map['date'], '2025-12-10');
      expect(map['ymd'], '20251210');
      expect(map['startTime'], '10:00');
      expect(map['time'], '2.5');
      expect(map['pointName'], 'Sunset Beach');
      expect(map['weather'], 'Sunny');
      expect(map['wind'], 'Light');
      expect(map['size'], 'Medium');
      expect(map['cloud'], 'Clear');
      expect(map['boardType'], 'Shortboard');
      expect(map['takeOff'], '15');
      expect(map['comment'], 'Great waves today!');

      final fromMapRecord = SurfRecord.fromMap(map);

      expect(fromMapRecord.date, surfRecord.date);
      expect(fromMapRecord.ymd, surfRecord.ymd);
      expect(fromMapRecord.startTime, surfRecord.startTime);
      expect(fromMapRecord.time, surfRecord.time);
      expect(fromMapRecord.pointName, surfRecord.pointName);
      expect(fromMapRecord.weather, surfRecord.weather);
      expect(fromMapRecord.wind, surfRecord.wind);
      expect(fromMapRecord.size, surfRecord.size);
      expect(fromMapRecord.cloud, surfRecord.cloud);
      expect(fromMapRecord.boardType, surfRecord.boardType);
      expect(fromMapRecord.takeOff, surfRecord.takeOff);
      expect(fromMapRecord.comment, surfRecord.comment);
    });

    test('SurfRecord with null values can be created and converted to/from Map', () {
      final surfRecord = SurfRecord(
        date: '2025-12-11',
        ymd: null,
        startTime: null,
        time: null,
        pointName: null,
        weather: null,
        wind: null,
        size: null,
        cloud: null,
        boardType: null,
        takeOff: null,
        comment: null,
      );

      final map = surfRecord.toMap();

      expect(map['date'], '2025-12-11');
      expect(map['ymd'], isNull);
      expect(map['startTime'], isNull);
      expect(map['time'], isNull);

      final fromMapRecord = SurfRecord.fromMap(map);

      expect(fromMapRecord.date, surfRecord.date);
      expect(fromMapRecord.ymd, isNull);
      expect(fromMapRecord.startTime, isNull);
    });
  });
}
