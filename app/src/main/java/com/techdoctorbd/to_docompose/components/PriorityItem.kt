package com.techdoctorbd.to_docompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techdoctorbd.to_docompose.data.models.TaskPriority
import com.techdoctorbd.to_docompose.ui.theme.MEDIUM_PADDING
import com.techdoctorbd.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.techdoctorbd.to_docompose.ui.theme.Typography

@Composable
fun PriorityItem(taskPriority: TaskPriority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = taskPriority.color)
        }
        Text(
            modifier = Modifier.padding(start = MEDIUM_PADDING),
            text = taskPriority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(taskPriority = TaskPriority.HIGH)
}