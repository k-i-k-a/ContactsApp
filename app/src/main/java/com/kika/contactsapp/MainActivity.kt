package com.kika.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.kika.contactsapp.data.DataSource
import com.kika.contactsapp.ui.theme.ContactsAppTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                ContactsApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsApp(modifier: Modifier=Modifier){
    val context= LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar={
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Contacts App")
                }
                ,
                actions = {
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.setData(Uri.parse("tel:+201224764545"))
                        startActivity(context, intent, null)
                    },modifier=Modifier) {
                        Icon(
                            painter =painterResource(id = R.drawable.home) ,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ContactsGrid(modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun ContactsGrid( modifier: Modifier = Modifier) {
    val contacts = DataSource().loadContacts()
    LazyVerticalGrid(columns = GridCells.Fixed(3),modifier=modifier) {
        items(contacts){
            ContactsCard(name = it.name, phone = it.phone, image = it.image)
        }
    }
}

@Composable
fun ContactsCard(name:Int,phone:Int,image:Int,modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val phonenumber=stringResource(id = phone)
    Column( horizontalAlignment = Alignment.CenterHorizontally,modifier= modifier
        .background(Color.LightGray)
        .clickable {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:${phonenumber}"))
            startActivity(context, intent, null)
        }){
        Image(painter = painterResource(id =image ), contentDescription ="profile picture",modifier=modifier.size(150.dp), contentScale = ContentScale.Crop)
        Text(text = stringResource(id = name) , fontSize = 16.sp)
        SelectionContainer {
            Text(text = stringResource(id = phone), fontSize = 12.sp,color=Color.DarkGray)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactsAppPreview() {
    ContactsApp()
}