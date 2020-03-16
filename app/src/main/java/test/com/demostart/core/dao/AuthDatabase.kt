package test.com.demostart.core.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import test.com.demostart.core.dao.entity.UserEntity


@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AuthDatabase : RoomDatabase() {
    abstract fun getUserDao(): AuthDao
}