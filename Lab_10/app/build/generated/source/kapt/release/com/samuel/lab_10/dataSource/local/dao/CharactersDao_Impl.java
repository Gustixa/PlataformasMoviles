package com.samuel.lab_10.dataSource.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.samuel.lab_10.dataSource.local.model.Character;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CharactersDao_Impl implements CharactersDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Character> __insertionAdapterOfCharacter;

  private final EntityDeletionOrUpdateAdapter<Character> __deletionAdapterOfCharacter;

  private final EntityDeletionOrUpdateAdapter<Character> __updateAdapterOfCharacter;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CharactersDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharacter = new EntityInsertionAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Character` (`id`,`name`,`status`,`species`,`gender`,`image`,`origin`,`episodes`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStatus());
        }
        if (value.getSpecies() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSpecies());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        if (value.getOrigin() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOrigin());
        }
        stmt.bindLong(8, value.getEpisodes());
      }
    };
    this.__deletionAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Character` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Character` SET `id` = ?,`name` = ?,`status` = ?,`species` = ?,`gender` = ?,`image` = ?,`origin` = ?,`episodes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStatus());
        }
        if (value.getSpecies() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSpecies());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        if (value.getOrigin() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOrigin());
        }
        stmt.bindLong(8, value.getEpisodes());
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM character";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<Character> characters,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCharacter.insert(characters);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Character character,
      final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfCharacter.handle(character);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Character character, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCharacter.handle(character);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAll(final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getCharacters(final Continuation<? super List<Character>> continuation) {
    final String _sql = "SELECT * FROM character";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Character>>() {
      @Override
      public List<Character> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfSpecies = CursorUtil.getColumnIndexOrThrow(_cursor, "species");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final List<Character> _result = new ArrayList<Character>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Character _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpSpecies;
            if (_cursor.isNull(_cursorIndexOfSpecies)) {
              _tmpSpecies = null;
            } else {
              _tmpSpecies = _cursor.getString(_cursorIndexOfSpecies);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpOrigin;
            if (_cursor.isNull(_cursorIndexOfOrigin)) {
              _tmpOrigin = null;
            } else {
              _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
            }
            final int _tmpEpisodes;
            _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            _item = new Character(_tmpId,_tmpName,_tmpStatus,_tmpSpecies,_tmpGender,_tmpImage,_tmpOrigin,_tmpEpisodes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getCharacter(final int id, final Continuation<? super Character> continuation) {
    final String _sql = "SELECT * FROM character WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Character>() {
      @Override
      public Character call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfSpecies = CursorUtil.getColumnIndexOrThrow(_cursor, "species");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final Character _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpSpecies;
            if (_cursor.isNull(_cursorIndexOfSpecies)) {
              _tmpSpecies = null;
            } else {
              _tmpSpecies = _cursor.getString(_cursorIndexOfSpecies);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpOrigin;
            if (_cursor.isNull(_cursorIndexOfOrigin)) {
              _tmpOrigin = null;
            } else {
              _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
            }
            final int _tmpEpisodes;
            _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            _result = new Character(_tmpId,_tmpName,_tmpStatus,_tmpSpecies,_tmpGender,_tmpImage,_tmpOrigin,_tmpEpisodes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
