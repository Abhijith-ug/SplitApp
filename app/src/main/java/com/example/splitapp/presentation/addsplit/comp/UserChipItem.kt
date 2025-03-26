package com.example.splitapp.presentation.addsplit.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitapp.R
import com.example.splitapp.presentation.core.SplitTypography

@Composable
fun UserChipItem(modifier: Modifier = Modifier, text: String,onClose:()->Unit) {
    Row(
        modifier = Modifier.
            background(MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.large).

        padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, style = SplitTypography.SplitStyle400.copy(
            color = MaterialTheme.colorScheme.scrim,
            fontSize = 16.sp
        ))

        Icon(imageVector = Icons.Default.Clear, contentDescription = null, modifier = Modifier
            .clickable {
                onClose.invoke()
            })
    }
}