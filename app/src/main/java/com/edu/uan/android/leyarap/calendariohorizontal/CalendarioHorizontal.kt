package com.edu.uan.android.leyarap.calendariohorizontal

import androidx.paging.PageKeyedDataSource
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class CalendarioHorizontal(
    private val now:() -> Instant
): PageKeyedDataSource<Long, LocalDate>() {

    private val today: LocalDate
    get() {
        return now().atZone(ZoneId.systemDefault()).toLocalDate()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, LocalDate>
    ) {
        callback.onResult(mutableListOf(today),-1,1)
    }

    override fun loadBefore(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, LocalDate>
    ) {
        val previousDay = today.plusDays((params.key))
        callback.onResult(mutableListOf(previousDay),-1)
    }

    override fun loadAfter(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, LocalDate>
    ) {
        val previousDay = today.plusDays((params.key))
        callback.onResult(mutableListOf(previousDay),-1)
    }


}