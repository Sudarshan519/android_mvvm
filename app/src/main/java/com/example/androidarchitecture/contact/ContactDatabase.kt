package com.example.androidarchitecture.contact

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {
    abstract fun contactDAO():ContactDAO

    companion object{
        val migration_1_2=object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
             database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCE:ContactDatabase?=null
        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,ContactDatabase::class.java,"contactDB").addMigrations(
                        migration_1_2
                    ).build()
                }


            }
            return INSTANCE!!
        }
    }

}