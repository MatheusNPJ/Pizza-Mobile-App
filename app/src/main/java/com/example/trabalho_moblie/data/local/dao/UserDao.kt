import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.example.trabalho_moblie.data.local.entities.UserEntity


//O DAO é objeto que tem salvo quais as ações o entity tem disponíveis para uso
@Dao
interface UserDao {

    // ✅ Inserir um usuário
    @Insert
    suspend fun insertUser(user: UserEntity)

    // ✅ Atualizar um usuário
    @Update
    suspend fun updateUser(user: UserEntity)

    // ✅ Deletar um usuário
    @Delete
    suspend fun deleteUser(user: UserEntity)

    // ✅ Buscar todos os usuários
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    // ✅ Buscar um usuário pelo id
    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): UserEntity?
}