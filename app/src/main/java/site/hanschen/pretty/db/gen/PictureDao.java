package site.hanschen.pretty.db.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import site.hanschen.pretty.db.bean.Picture;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PICTURE".
*/
public class PictureDao extends AbstractDao<Picture, Long> {

    public static final String TABLENAME = "PICTURE";

    /**
     * Properties of entity Picture.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property QuestionId = new Property(1, int.class, "questionId", false, "QUESTION_ID");
        public final static Property Url = new Property(2, String.class, "url", false, "URL");
    }

    private Query<Picture> question_PicturesQuery;

    public PictureDao(DaoConfig config) {
        super(config);
    }
    
    public PictureDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PICTURE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"QUESTION_ID\" INTEGER NOT NULL ," + // 1: questionId
                "\"URL\" TEXT NOT NULL );"); // 2: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PICTURE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Picture entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQuestionId());
        stmt.bindString(3, entity.getUrl());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Picture entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQuestionId());
        stmt.bindString(3, entity.getUrl());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Picture readEntity(Cursor cursor, int offset) {
        Picture entity = new Picture( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // questionId
            cursor.getString(offset + 2) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Picture entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setQuestionId(cursor.getInt(offset + 1));
        entity.setUrl(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Picture entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Picture entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Picture entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "pictures" to-many relationship of Question. */
    public List<Picture> _queryQuestion_Pictures(int questionId) {
        synchronized (this) {
            if (question_PicturesQuery == null) {
                QueryBuilder<Picture> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.QuestionId.eq(null));
                question_PicturesQuery = queryBuilder.build();
            }
        }
        Query<Picture> query = question_PicturesQuery.forCurrentThread();
        query.setParameter(0, questionId);
        return query.list();
    }

}
