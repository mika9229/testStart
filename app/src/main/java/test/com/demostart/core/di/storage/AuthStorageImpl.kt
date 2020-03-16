package test.com.demostart.core.di.storage

import android.content.Context
import androidx.room.Room
import test.com.demostart.core.dao.AuthDatabase
import test.com.demostart.core.dao.entity.UserEntity

class AuthStorageImpl(val context: Context) : AuthStorage {
    val db = Room.databaseBuilder(context, AuthDatabase::class.java, "database")
        .build()

    override fun saveUserName(userName: String?) {
        userName?.let {
            db.getUserDao().insert(UserEntity(it))
        }

    }

    override fun getUserName(): List<String> {

        return db.getUserDao().all.map { return@map it.name }
    }


}