// flutter_app/lib/models/surf_record.dart
class SurfRecord {
  final String date;
  final String? ymd;
  final String? startTime;
  final String? time;
  final String? pointName;
  final String? weather;
  final String? wind;
  final String? size;
  final String? cloud;
  final String? boardType;
  final String? takeOff;
  final String? comment;

  SurfRecord({
    required this.date,
    this.ymd,
    this.startTime,
    this.time,
    this.pointName,
    this.weather,
    this.wind,
    this.size,
    this.cloud,
    this.boardType,
    this.takeOff,
    this.comment,
  });

  // Factory constructor to create a SurfRecord from a map (e.g., from a database query)
  factory SurfRecord.fromMap(Map<String, dynamic> map) {
    return SurfRecord(
      date: map['date'],
      ymd: map['ymd'],
      startTime: map['startTime'],
      time: map['time'],
      pointName: map['pointName'],
      weather: map['weather'],
      wind: map['wind'],
      size: map['size'],
      cloud: map['cloud'],
      boardType: map['boardType'],
      takeOff: map['takeOff'],
      comment: map['comment'],
    );
  }

  // Convert a SurfRecord into a Map. The keys must correspond to the names of the
  // columns in the database.
  Map<String, dynamic> toMap() {
    return {
      'date': date,
      'ymd': ymd,
      'startTime': startTime,
      'time': time,
      'pointName': pointName,
      'weather': weather,
      'wind': wind,
      'size': size,
      'cloud': cloud,
      'boardType': boardType,
      'takeOff': takeOff,
      'comment': comment,
    };
  }
}
