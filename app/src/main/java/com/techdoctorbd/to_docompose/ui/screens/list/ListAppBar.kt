package com.techdoctorbd.to_docompose.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.techdoctorbd.to_docompose.R
import com.techdoctorbd.to_docompose.components.PriorityItem
import com.techdoctorbd.to_docompose.data.models.TaskPriority
import com.techdoctorbd.to_docompose.ui.theme.MEDIUM_PADDING
import com.techdoctorbd.to_docompose.ui.theme.Typography
import com.techdoctorbd.to_docompose.ui.theme.topAppBarBackgroundColor
import com.techdoctorbd.to_docompose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (TaskPriority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Tasks", color = MaterialTheme.colors.topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (TaskPriority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = { onSearchClicked() })
    {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (TaskPriority) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(id = R.string.sort_tasks),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onSortClicked(TaskPriority.HIGH)
                }
            ) {
                PriorityItem(taskPriority = TaskPriority.HIGH)
            }

            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onSortClicked(TaskPriority.LOW)
                }
            ) {
                PriorityItem(taskPriority = TaskPriority.LOW)
            }

            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onSortClicked(TaskPriority.NONE)
                }
            ) {
                PriorityItem(taskPriority = TaskPriority.NONE)
            }
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(id = R.string.delete_all_tasks),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteClicked()
                }
            ) {
                Text(
                    modifier = Modifier.padding(start = MEDIUM_PADDING),
                    text = stringResource(id = R.string.delete_all_tasks),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
private fun DefaultAppbarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}