package com.edu.uan.android.leyarap.calendariohorizontal

import androidx.paging.DataSource
import java.time.Instant
import java.time.LocalDate
import javax.inject.Inject


class CalendarioHorizontalFabrica @Inject constructor(
    private val now: ()-> Instant
): DataSource.Factory<Long,LocalDate>(){
    override fun create(): DataSource<Long, LocalDate> {
        return CalendarioHorizontal(now)

    }
}