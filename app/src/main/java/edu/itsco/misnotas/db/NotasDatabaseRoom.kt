package edu.itsco.misnotas.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(Nota::class),version = 1, exportSchema = false)
public abstract class NotasDatabaseRoom: RoomDatabase() {

    abstract fun notaDao(): NotaDao

    companion object{

        @Volatile
        private var INSTANCE: NotasDatabaseRoom? = null

        fun getDatabase(context: Context): NotasDatabaseRoom{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
             val instance = Room.databaseBuilder(
                 context.applicationContext,
                 NotasDatabaseRoom::class.java,
                 "notas_database"
             ).build()
                INSTANCE=instance
                return instance
        }

        }
    }
}