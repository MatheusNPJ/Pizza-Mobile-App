import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.trabalho_moblie.data.local.entities.UserEntity
import com.example.trabalho_moblie.data.model.User
import kotlinx.coroutines.flow.Flow


//O DAO é objeto que tem salvo quais as ações o entity tem disponíveis para uso
@Dao
abstract interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)


    @Query("SELECT * FROM users WHERE name = :name AND senha = :senha LIMIT 1")
    suspend fun getUser(name: String, senha: String): UserEntity?



}