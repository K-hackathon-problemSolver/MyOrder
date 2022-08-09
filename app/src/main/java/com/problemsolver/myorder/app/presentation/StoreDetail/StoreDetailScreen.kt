package com.problemsolver.myorder.app.presentation.StoreDetail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.presentation.StoreList.StoreItemImage
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun StoreDetailScreen(){


    Column(modifier = Modifier
        .background(color = Color.White)) {
        StoreDetailMainPic()
        StoreDetailDescription()
        DevideLine()
        StoreDetailList()
    }
}

@Composable
fun ColumnScope.StoreDetailMainPic(){
    Image(modifier = Modifier
        .padding(30.dp)
        .fillMaxWidth(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.sample_cake),
        contentDescription = "mainPic" )
    }


@Composable
fun ColumnScope.StoreDetailDescription(){
   Column(modifier = Modifier.fillMaxWidth(),
   horizontalAlignment = Alignment.CenterHorizontally) {
       Text(text = "위드미케이크",
           fontSize = 20.sp)
       Spacer(modifier = Modifier.size(5.dp))
       Box(modifier = Modifier
           .fillMaxWidth()){
        timeSelector(modifier = Modifier.align(Alignment.Center),{ /* TODO */})
       }
       Spacer(modifier = Modifier.size(5.dp))
       Text(text = "안녕하세요. 사랑과 정성으로 만드는 위드미 케이크입니다.")
       Text(text = "당일배송 가능합니다.")
   }
}

@Composable
fun timeSelector(
    modifier: Modifier = Modifier,
    onCheckedChange: () -> Unit
) {
    val categoryList = listOf("월 11:00 ~ 17:00","화 11:00 ~ 17:00","수 11:00 ~ 17:00","목 11:00 ~ 17:00","금 11:00 ~ 17:00","토 11:00 ~ 17:00","일 11:00 ~ 17:00",)
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("영업시간 보기") }

    Row(modifier = modifier) {
        Text(
            text = selectedText,
            modifier = Modifier.align(Alignment.CenterVertically),
            fontSize = 15.sp
        )

        IconToggleButton(
            modifier = Modifier.size(30.dp),
            checked = isDropDownMenuExpanded,
            onCheckedChange = { onCheckedChange() },
        ) {
            var isDropDownMenuExpanded by remember { mutableStateOf(false) }
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = "arrow down",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { isDropDownMenuExpanded = true }
            )

            DropdownMenu(
                modifier = Modifier.wrapContentSize(),
                expanded = isDropDownMenuExpanded,
                onDismissRequest = { isDropDownMenuExpanded = false },
            ) {
                repeat(7) {

                    DropdownMenuItem(
                        modifier = Modifier.width(200.dp),
                        onClick = {
                            selectedText = categoryList.get(it)
                            isDropDownMenuExpanded = false
                        },
                        contentPadding = PaddingValues(horizontal = 20.dp)
                    ) {
                        Text(text = categoryList.get(it))
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.DevideLine(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(color = Color.LightGray)){

    }
}

@Composable
fun ColumnScope.StoreDetailList(){

    val options = listOf<String>("벌스데이 케이크", "캐릭터 도시락 케이크","레터링 도시락 케이크","레터링 케이크")
    val price = listOf<String>("12,900원~","6,900원~","15,900원~","26,900원~")

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(20.dp)){
        items(options.size){
            StoreDetailOption(optionName = options[it],
                imageUrl = "https://i0.wp.com/moi.today/wp-content/uploads/2020/09/IMG_220812-scaled.jpg?fit=2560%2C2560&ssl=1" ,
                price =price[it] )
        }
    }
}

@Composable
fun StoreDetailOption(
    optionName: String,
    imageUrl: String,
    price: String,
    modifier: Modifier = Modifier.padding(10.dp)
) {
    Column(modifier = modifier) {
        StoreItemImage(imageUrl = imageUrl)
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = optionName, fontSize = 16.sp, )
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = price, fontSize = 16.sp, )
        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Composable
fun StoreDetailOptionImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "option image",
        placeholder = painterResource(R.drawable.sample_cake),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
    )
}

@Preview
@Composable
fun preDetail(){
    StoreDetailScreen()
}