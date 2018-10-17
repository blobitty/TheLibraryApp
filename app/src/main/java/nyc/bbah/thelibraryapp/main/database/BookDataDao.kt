package nyc.bbah.thelibraryapp.main.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface BookDataDao {
    @Query("SELECT * from bookData")
    fun getAll(): List<BookData>

    @Insert(onConflict = REPLACE)
    fun insertAll(bookData: BookData)


    @Query("SELECT * FROM bookData WHERE title LIKE title LIMIT 1")
    fun findByName(title: String): Int

    @Query("SELECT * FROM bookData WHERE id LIKE id LIMIT 1")
    fun findByID(id: Int): BookData

    @Update
    fun updateBook(id: Int, lastCheckoutBy: String, lastCheckedOut: String )

    @Update(onConflict = REPLACE)
    fun updateCheckoutTime()

    @Query("DELETE from bookData")
    fun deleteAll()
}