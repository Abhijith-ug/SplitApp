package com.example.splitapp.presentation.split_listing.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.splitapp.domain.ContactModel

@Composable
fun SplitItemComp(
    modifier: Modifier = Modifier,
    item: ContactModel
) {
    Column(verticalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .padding(top = 24.dp)
                  .size(100.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .clip(CircleShape)
        ) {
            if (item.image!=null){
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current).data(item.image)
                        .build(), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }else{
                Text(text = "${item.name[0]}", style = MaterialTheme.typography.titleLarge, fontWeight =FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center))
            }




        }
        Text(text = item.name, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center)
    }

}