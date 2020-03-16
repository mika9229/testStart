package test.com.demostart.core.di.storage


interface AuthStorage {

    fun saveUserName(userName: String?)

    fun getUserName(): List<String>

}