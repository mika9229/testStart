package test.com.demostart.core.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import test.com.demostart.core.dao.entity.UserEntity

@Dao
interface AuthDao {

    @get:Query("SELECT * FROM user")
    val all: List<UserEntity>

    @Insert
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @get:Query("SELECT * FROM user")
    val allLogin: List<UserEntity>


}