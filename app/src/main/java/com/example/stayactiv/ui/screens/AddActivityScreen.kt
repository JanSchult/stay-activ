package com.example.stayactiv.ui.screens

import android.media.Rating
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stayactiv.ui.composables.add.ActivityCategoryPicker
import com.example.stayactiv.ui.composables.add.ActivityDurationInput
import com.example.stayactiv.ui.composables.add.ActivityNoteInput
import com.example.stayactiv.ui.composables.add.ActivityRatingSelector
import com.example.stayactiv.ui.composables.add.ActivityTitleInput
import com.example.stayactiv.ui.composables.add.AddActivityActions
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.AddActivityUiState
import com.example.stayactiv.util.RatingCategory

@Composable
fun AddActivityScreen(
    state: AddActivityUiState,
    onTitleChange: (String) -> Unit,
    onCategoryChange: (ActivityCategory) -> Unit,
    onDurationChange: (Int?) -> Unit,
    onRatingChange: (RatingCategory) -> Unit,
    onNoteChange: (String) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        ActivityTitleInput(state.title, onTitleChange)

        ActivityCategoryPicker(
            selected = state.category,
            onCategorySelected = onCategoryChange
        )

        ActivityDurationInput(
            durationMinutes = state.durationMinutes,
            onDurationChange = onDurationChange
        )

        ActivityRatingSelector(
            rating = state.rating,
            onRatingChange = onRatingChange
        )

        ActivityNoteInput(
            note = state.note,
            onNoteChange = onNoteChange
        )

        Spacer(modifier = Modifier.weight(1f))

        AddActivityActions(onSave = onSave)
    }
}

