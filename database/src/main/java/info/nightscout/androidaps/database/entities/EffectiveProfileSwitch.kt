package info.nightscout.androidaps.database.entities

import androidx.room.*
import info.nightscout.androidaps.database.Block
import info.nightscout.androidaps.database.TABLE_EFFECTIVE_PROFILE_SWITCHES
import info.nightscout.androidaps.database.embedments.InterfaceIDs
import info.nightscout.androidaps.database.interfaces.DBEntry
import info.nightscout.androidaps.database.interfaces.DBEntryWithTimeAndDuration

@Entity(tableName = TABLE_EFFECTIVE_PROFILE_SWITCHES,
        foreignKeys = [ForeignKey(
                entity = EffectiveProfileSwitch::class,
                parentColumns = ["id"],
                childColumns = ["referenceID"])],
        indices = [Index("referenceID"), Index("timestamp")])
data class EffectiveProfileSwitch(
        @PrimaryKey(autoGenerate = true)
        override var id: Long = 0,
        override var version: Int = 0,
        override var lastModified: Long = -1,
        override var valid: Boolean = true,
        override var referenceID: Long? = null,
        @Embedded
        override var interfaceIDs2: InterfaceIDs? = null,
        override var timestamp: Long,
        override var utcOffset: Long,
        override var duration: Long,
        var basalBlocks: List<Block>
) : DBEntry<EffectiveProfileSwitch>, DBEntryWithTimeAndDuration