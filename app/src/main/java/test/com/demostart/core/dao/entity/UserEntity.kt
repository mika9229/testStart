package test.com.demostart.core.dao.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
(tableName = "user")
data class UserEntity(@PrimaryKey(autoGenerate = false) var name: String)