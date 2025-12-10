package droid.surf;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SurfRecordDao_Impl implements SurfRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SurfRecordEntity> __insertionAdapterOfSurfRecordEntity;

  private final EntityDeletionOrUpdateAdapter<SurfRecordEntity> __updateAdapterOfSurfRecordEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SurfRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSurfRecordEntity = new EntityInsertionAdapter<SurfRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `surf_records` (`date`,`ymd`,`startTime`,`time`,`pointName`,`weather`,`wind`,`size`,`cloud`,`boardType`,`takeOff`,`comment`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SurfRecordEntity entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
        if (entity.getYmd() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getYmd());
        }
        if (entity.getStartTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStartTime());
        }
        if (entity.getTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTime());
        }
        if (entity.getPointName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPointName());
        }
        if (entity.getWeather() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getWeather());
        }
        if (entity.getWind() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getWind());
        }
        if (entity.getSize() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSize());
        }
        if (entity.getCloud() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getCloud());
        }
        if (entity.getBoardType() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getBoardType());
        }
        if (entity.getTakeOff() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getTakeOff());
        }
        if (entity.getComment() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getComment());
        }
      }
    };
    this.__updateAdapterOfSurfRecordEntity = new EntityDeletionOrUpdateAdapter<SurfRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `surf_records` SET `date` = ?,`ymd` = ?,`startTime` = ?,`time` = ?,`pointName` = ?,`weather` = ?,`wind` = ?,`size` = ?,`cloud` = ?,`boardType` = ?,`takeOff` = ?,`comment` = ? WHERE `date` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SurfRecordEntity entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
        if (entity.getYmd() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getYmd());
        }
        if (entity.getStartTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStartTime());
        }
        if (entity.getTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTime());
        }
        if (entity.getPointName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPointName());
        }
        if (entity.getWeather() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getWeather());
        }
        if (entity.getWind() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getWind());
        }
        if (entity.getSize() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSize());
        }
        if (entity.getCloud() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getCloud());
        }
        if (entity.getBoardType() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getBoardType());
        }
        if (entity.getTakeOff() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getTakeOff());
        }
        if (entity.getComment() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getComment());
        }
        if (entity.getDate() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getDate());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM surf_records WHERE date = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM surf_records";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SurfRecordEntity record) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSurfRecordEntity.insert(record);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SurfRecordEntity record) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSurfRecordEntity.handle(record);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final String date) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Flow<List<SurfRecordEntity>> getAll() {
    final String _sql = "SELECT * FROM surf_records ORDER BY ymd DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"surf_records"}, new Callable<List<SurfRecordEntity>>() {
      @Override
      @NonNull
      public List<SurfRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfYmd = CursorUtil.getColumnIndexOrThrow(_cursor, "ymd");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfPointName = CursorUtil.getColumnIndexOrThrow(_cursor, "pointName");
          final int _cursorIndexOfWeather = CursorUtil.getColumnIndexOrThrow(_cursor, "weather");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfCloud = CursorUtil.getColumnIndexOrThrow(_cursor, "cloud");
          final int _cursorIndexOfBoardType = CursorUtil.getColumnIndexOrThrow(_cursor, "boardType");
          final int _cursorIndexOfTakeOff = CursorUtil.getColumnIndexOrThrow(_cursor, "takeOff");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<SurfRecordEntity> _result = new ArrayList<SurfRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SurfRecordEntity _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpYmd;
            if (_cursor.isNull(_cursorIndexOfYmd)) {
              _tmpYmd = null;
            } else {
              _tmpYmd = _cursor.getString(_cursorIndexOfYmd);
            }
            final String _tmpStartTime;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmpStartTime = null;
            } else {
              _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpPointName;
            if (_cursor.isNull(_cursorIndexOfPointName)) {
              _tmpPointName = null;
            } else {
              _tmpPointName = _cursor.getString(_cursorIndexOfPointName);
            }
            final String _tmpWeather;
            if (_cursor.isNull(_cursorIndexOfWeather)) {
              _tmpWeather = null;
            } else {
              _tmpWeather = _cursor.getString(_cursorIndexOfWeather);
            }
            final String _tmpWind;
            if (_cursor.isNull(_cursorIndexOfWind)) {
              _tmpWind = null;
            } else {
              _tmpWind = _cursor.getString(_cursorIndexOfWind);
            }
            final String _tmpSize;
            if (_cursor.isNull(_cursorIndexOfSize)) {
              _tmpSize = null;
            } else {
              _tmpSize = _cursor.getString(_cursorIndexOfSize);
            }
            final String _tmpCloud;
            if (_cursor.isNull(_cursorIndexOfCloud)) {
              _tmpCloud = null;
            } else {
              _tmpCloud = _cursor.getString(_cursorIndexOfCloud);
            }
            final String _tmpBoardType;
            if (_cursor.isNull(_cursorIndexOfBoardType)) {
              _tmpBoardType = null;
            } else {
              _tmpBoardType = _cursor.getString(_cursorIndexOfBoardType);
            }
            final String _tmpTakeOff;
            if (_cursor.isNull(_cursorIndexOfTakeOff)) {
              _tmpTakeOff = null;
            } else {
              _tmpTakeOff = _cursor.getString(_cursorIndexOfTakeOff);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _item = new SurfRecordEntity(_tmpDate,_tmpYmd,_tmpStartTime,_tmpTime,_tmpPointName,_tmpWeather,_tmpWind,_tmpSize,_tmpCloud,_tmpBoardType,_tmpTakeOff,_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
