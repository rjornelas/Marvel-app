package com.rjornelas.marvelapp.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rjornelas.core.domain.data.DbConstants

@Entity(tableName = DbConstants.REMOTE_KEYS_TABLE_NAME)
data class RemoteKey(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo(name = DbConstants.REMOTE_KEYS_COLUMN_INFO_OFFSET)
    val nextOffset: Int?
)
