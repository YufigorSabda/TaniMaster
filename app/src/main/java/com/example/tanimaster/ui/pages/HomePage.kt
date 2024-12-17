package com.example.tanimaster.ui.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tanimaster.R
import com.example.tanimaster.ui.components.*
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import org.threeten.bp.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    var query by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        // Bagian Atas (Header)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                HeadingText("Hallo, Figor!")
                CustomText("You have 2 task today~")
            }
            BoxImage(imageUrl = R.drawable.profile, title = "Profile Image", size = 70.dp)
        }

        // Search Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SearchTextField(query = query, onQueryChange = { query = it })
        }

        // Kalender dan Task
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeadingText("Kalender")
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Icon(imageVector = Icons.Default.DateRange, modifier = Modifier.size(14.dp), contentDescription = "Date range", tint = Color.Black)
                    val today = LocalDate.now()
                    Text(text = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))) // Menambahkan tahun
                }
            }

            CalendarRow(selectedDate = selectedDate) { date ->
                selectedDate = date
            }

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(2) {
                    Task()
                }
            }

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(2) {
                    UndoneTask()
                }
            }

            ButtonText(modifier = Modifier.fillMaxWidth(), text = "Show All Task") // Pastikan komponen ini ada

            selectedDate?.let { selectedDateValue ->
                Text(text = "Tanggal Terpilih: ${selectedDateValue.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun CalendarRow(selectedDate: LocalDate?, onDateSelected: (LocalDate) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getHorizontalCalendar()) { date ->
            CalendarItem(date, isSelected = date == selectedDate, onClick = { onDateSelected(date) })
        }
    }
}

@Composable
fun CalendarItem(date: LocalDate, isSelected: Boolean, onClick: () -> Unit) {
    val isWeekend = date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(60.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary
                else Color.LightGray
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = date.dayOfMonth.toString(), fontWeight = FontWeight.Bold, color = if (isSelected) Color.White else Color.Black, style = MaterialTheme.typography.bodyMedium)
            Text(text = date.month.name.substring(0, 3), color = if (isSelected) Color.White else Color.Black, style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun getHorizontalCalendar(): List<LocalDate> {
    val today = LocalDate.now()
    val endMonth = YearMonth.of(today.year, 12) // Sampai akhir tahun
    val calendarDates = mutableListOf<LocalDate>()
    var currentMonth = YearMonth.of(today.year, today.month)
    while (!currentMonth.isAfter(endMonth)) {
        for (day in 1..currentMonth.lengthOfMonth()) {
            calendarDates.add(LocalDate.of(currentMonth.year, currentMonth.month, day))
        }
        currentMonth = currentMonth.plusMonths(1)
    }
    return calendarDates
}