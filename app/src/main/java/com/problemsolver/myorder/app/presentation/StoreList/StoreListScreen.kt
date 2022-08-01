package com.problemsolver.myorder.app.presentation.StoreList

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.problemsolver.myorder.R
import com.problemsolver.myorder.ui.theme.MyOrderTheme

@Composable
fun StoreListScreen() {
    val stores = listOf<String>("스윗케이크", "루미케이크", "루미케이크","루미케이크","루미케이크","루미케이크","루미케이크","루미케이크","루미케이크","루미케이크",)

    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Row() {

        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(stores.size){
                StoreItem(
                    stores[it],
                    "https://i0.wp.com/moi.today/wp-content/uploads/2020/09/IMG_220812-scaled.jpg?fit=2560%2C2560&ssl=1"
                )
            }
        }
    }
}

@Composable
fun StoreItem(
    storeName: String,
    imageUrl: String,
    modifier: Modifier = Modifier.padding(10.dp)
) {
    Column(modifier = modifier) {
        StoreItemImage(imageUrl = imageUrl)
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = storeName, fontSize = 9.sp, )
        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Composable
fun StoreItemImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "store image",
        placeholder = painterResource(R.drawable.sample_cake),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
    )
}

@Preview()
@Composable
fun PreviewStoreListScreen() {
    StoreListScreen()
}