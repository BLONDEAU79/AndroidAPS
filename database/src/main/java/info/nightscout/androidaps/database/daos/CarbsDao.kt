package info.nightscout.androidaps.database.daos

import androidx.room.Dao
import androidx.room.Query
import info.nightscout.androidaps.database.TABLE_CARBS
import info.nightscout.androidaps.database.entities.Carbs
import io.reactivex.Single

@Suppress("FunctionName")
@Dao
internal interface CarbsDao : BaseDao<Carbs> {

    @Query("SELECT * FROM $TABLE_CARBS WHERE id = :id")
    override fun findById(id: Long): Carbs?

    @Query("DELETE FROM $TABLE_CARBS")
    override fun deleteAllEntries()

    @Query("SELECT * FROM $TABLE_CARBS WHERE timestamp >= :start AND timestamp <= :end AND referenceId IS NULL AND isValid = 1 ORDER BY timestamp ASC")
    fun getCarbsInTimeRange(start: Long, end: Long): List<Carbs>

    @Query("SELECT * FROM $TABLE_CARBS WHERE dateCreated >= :start AND dateCreated < :end ORDER BY dateCreated ASC")
    override fun getAllEntriesCreatedBetween(start: Long, end: Long): Single<List<Carbs>>
}