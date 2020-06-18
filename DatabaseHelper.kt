package maverick.com.kotlinsqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import maverick.com.kotlinsqlitedatabase.DatabaseContainer.PersonTable.Companion.COL1
import maverick.com.kotlinsqlitedatabase.DatabaseContainer.PersonTable.Companion.TABLE_NAME

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val taskTable = "CREATE TABLE " + TABLE_NAME + " ("+ BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1 +" TEXT)"
        db!!.execSQL(taskTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun insertData(task : String) : Boolean {
        val db : SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL1, task)
        val insert_data = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return !insert_data.equals(-1)
    }

    fun readData() : Cursor {
        val db : SQLiteDatabase = this.writableDatabase
        val read : Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        return  read
    }

    companion object {
        private const val DATABASE_NAME = "myData.db"
        private const val  DATABASE_VERSION = 1
    }

}