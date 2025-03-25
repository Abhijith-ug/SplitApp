package com.example.splitapp.presentation.addsplit.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.splitapp.domain.ContactModel
import com.example.splitapp.presentation.core.SplitTypography

@Composable
fun UserComponent(modifier: Modifier = Modifier,item:ContactModel) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth().
                background(MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium).
        padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .clip(CircleShape)
        ) {
            if (item.image != null) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current).data(item.image)
                        .build(), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text(
                    text = "${item.name[0]}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

      Text(text = item.name, style = SplitTypography.SplitStyle600.copy(
          color = Color.Black,
          fontSize = 16.sp
      ))
    }
}