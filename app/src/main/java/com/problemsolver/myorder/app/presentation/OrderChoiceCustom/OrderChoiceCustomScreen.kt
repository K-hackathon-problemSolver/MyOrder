package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


// val todoViewModel by viewModels<TodoViewModel> ()
//MainActivity에 추가해야함

// TodoScreenActivity(todoViewModel)
//set Content에 넣고 실행해야 돌아감

@Composable
fun OrderChoiceCustomScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        CustomTopBar()

    }
}

@Composable
fun ColumnScope.CustomTopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        TextButton(modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "취소",
                color = Color.Black)
        }
        Text(modifier = Modifier.weight(8f),
            textAlign = TextAlign.Center,
            text = "주문서 수정",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        TextButton(modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "적용",
                color = Color.Black)
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun CustomBody(
    items:List<Data>,
    onAddItem:(Data) -> Unit,
    onRemoveItem:(Data) -> Unit
){
    Column() {
        LazyColumn(modifier = Modifier
            .weight(1f),
        contentPadding = PaddingValues(top = 8.dp)){
            items(items=items){
                ToDoRow(todo = it,
                    onItemClick = { onRemoveItem(it)},
                    modifier = Modifier.fillMaxWidth())
            }
        }
        Button(onClick = { onAddItem(RandomData()) },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
                Text(text = "카테고리 추가")
        }
    }
}

@Composable
fun TodoScreenActivity(todoViewModel: TodoViewModel) {
    val items: List<Data> by todoViewModel.todoItem.observeAsState(listOf())
    CustomBody(
        items = items,
        onAddItem = { todoViewModel.addItem(it) },
        onRemoveItem = { todoViewModel.removeItem(it) })
}

@Composable
fun ToDoRow(
    todo : Data,
    onItemClick: (Data) -> Unit,
    modifier: Modifier
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(todo) }
        .padding(horizontal = 16.dp, vertical = 9.dp)) {
        Text(todo.task,
        textAlign = TextAlign.End)
    }
    Column(modifier = Modifier) {
        val textState = remember{
            mutableStateOf("")
        }
        val textState1 = remember{
            mutableStateOf("")
        }
        val textState2 = remember{
            mutableStateOf("")
        }

        TextField(
            value = textState.value,
            placeholder = { Text("카테고리명") },
            onValueChange = { textValue -> textState.value = textValue })
        Row(modifier = Modifier) {
            TextField(
                value = textState1.value,
                placeholder = { Text("옵션명") },
                onValueChange = { textValue -> textState1.value = textValue })
            TextField(
                value = textState2.value,
                placeholder = { Text("가격") },
                onValueChange = { textValue -> textState2.value = textValue })
        }
    }
}

@Preview
@Composable
fun prqwe(){
    OrderChoiceCustomScreen()
}