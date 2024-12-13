package com.example.tanimaster.ui.components.Calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth

/**
 * @deprecated
 */

//@Composable
//fun StaticCalendar(
//    selectedDate: LocalDate?, // Menerima selectedDate sebagai parameter
//    onDateSelected: (LocalDate?) -> Unit
//) {
//    val currentMonth = remember { mutableStateOf(YearMonth.now()) }
//
//    Column(Modifier.fillMaxWidth()) {
//        // ... (MonthHeader dan DaysOfWeekHeader tetap sama)
//        CalendarGrid(currentMonth.value, selectedDate, onDateSelected) // Kirim selectedDate ke CalendarGrid
//    }
//}

//@Composable
//fun CalendarGrid(
//    currentMonth: YearMonth,
//    selectedDate: LocalDate?,
//    onDateSelected: (LocalDate?) -> Unit
//) {
//    val days = mutableListOf<Any>()
//    val firstDay = currentMonth.atDay(1)
//    val lastDay = currentMonth.atEndOfMonth()
//
//    // Add blank days before the first day of the month
//    for (i in 1 until firstDay.dayOfWeek.value) {
//        days.add("")
//    }
//
//    // Add days of the month
//    for (i in 1..lastDay.dayOfMonth) {
//        days.add(LocalDate.of(currentMonth.year, currentMonth.month, i))
//    }
//
//    LazyColumn {
//        val chunkedDays = days.chunked(7)
//        items(chunkedDays) { weekDays ->
//            LazyRow(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 8.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                items(weekDays) { day ->
//                    DayCell(
//                        date = day,
//                        selectedDate = selectedDate,
//                        onDateSelected = onDateSelected
//                    )
//                }
//            }
//        }
//    }
//}

//@Composable
//fun DayCell(date: Any, selectedDate: LocalDate?, onDateSelected: (LocalDate?) -> Unit) {
//    val day = when (date) {
//        is LocalDate -> date.dayOfMonth.toString()
//        else -> ""
//    }
//
//    val isSelected = date is LocalDate && date == selectedDate
//    val isToday = date is LocalDate && date == LocalDate.now() // Tandai hari ini
//    Box(
//        modifier = Modifier
//            .padding(4.dp)
//            .size(40.dp)
//            .clip(CircleShape)
//            .background(if (isSelected) Color.LightGray else Color.Transparent)
//            .border(
//                width = if (isToday) 2.dp else 0.dp,
//                color = if (isToday) MaterialTheme.colorScheme.primary else Color.Transparent,
//                shape = CircleShape
//            )
//            .clickable {
//                if (date is LocalDate) {
//                    onDateSelected(date)
//                } else {
//                    onDateSelected(null)
//                }
//            },
//        contentAlignment = Alignment.Center
//    ) {
//        if (day.isNotBlank()) {
//            Text(
//                text = day,
//                textAlign = TextAlign.Center,
//                color = if (isSelected) Color.White else Color.Black,
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//}
