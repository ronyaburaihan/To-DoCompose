package com.techdoctorbd.to_docompose.data.models

import androidx.compose.ui.graphics.Color
import com.techdoctorbd.to_docompose.ui.theme.HighPriorityColor
import com.techdoctorbd.to_docompose.ui.theme.LowPriorityColor
import com.techdoctorbd.to_docompose.ui.theme.MediumPriorityColor
import com.techdoctorbd.to_docompose.ui.theme.NonePriorityColor

enum class TaskPriority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}