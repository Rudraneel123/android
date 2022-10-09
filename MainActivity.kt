package com.example.myapplicationcmp

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationcmp.ui.theme.MyApplicationcmpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationcmpTheme {
                // A surface container using the 'background' color from the theme
                MyApp()

            }
        }
    }
}

//@Preview
@Composable
fun MyCircle(counter: Int=0,updateCounter:(Int)->Unit){
//    var counter by remember {
//        mutableStateOf(0)
//    }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateCounter(counter + 1)
//                counter += 1
//                Log.d("Tap", "MyCircle: $counter")
            },
        shape = CircleShape,
        elevation = 8.dp
    ) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap", modifier = Modifier)
        }
    }
}

@Composable
fun MyApp(){

    val counter =remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth() ,
        color = Color(0xFF03DAC5)
          ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =Alignment.CenterHorizontally,
        ) {
            Text(text = "₹${counter.value}", fontSize = 50.sp, style = TextStyle(color = Color.White), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            MyCircle(counter=counter.value){ newValue->
                counter.value=newValue
            }
            if(counter.value>40){
               Text(text = "Money exceeded \uD83D\uDE32 ")
            }
        }
    }
}


@Preview( showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationcmpTheme {
        MyApp()
    }
}