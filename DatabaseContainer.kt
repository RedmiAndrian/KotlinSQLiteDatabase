package maverick.com.kotlinsqlitedatabase

import android.provider.BaseColumns

object DatabaseContainer {
    class PersonTable : BaseColumns {
        companion object {
            val TABLE_NAME = "Person_table"
            val COL1 = "TASK"
        }
    }
}