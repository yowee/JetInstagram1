package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.components.Toolbar
import com.vipulasri.jetinstagram.ui.components.diagonalGradientBorder
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.theme.grey70

@Composable
fun FavoriteScreen() {
    Scaffold(topBar = { Toolbar("Profile", R.drawable.back, R.drawable.plus) }) {
        val users = listOf<User>(currentUser, currentUser, currentUser);

        Column(modifier = Modifier.padding(10.dp)) {
            SearchBar()
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {

                itemsIndexed(users) { _, user ->
                    FavoriteUser(
                        user
                    )
                }

            }


        }

    }

}

@Composable
fun SearchBar1() {

    TextField(
        value = "",
        onValueChange = {
//            onValueChange(it)
        },

        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = grey70,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text("Search") }
    )


}

@Composable
fun FavoriteUser(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        User(user = user)
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add")
        }
    }
}

@Composable
fun User(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfilePic(user)
        Column(Modifier.weight(1f)) {
            Text(
                text = "yome",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "yowee_ee",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .height(32.dp)
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent, // Transparent background
                contentColor = Color.White // White text color
            ),
            shape = RoundedCornerShape(16.dp), // Rounded corners
            elevation = ButtonDefaults.elevation(0.dp) // No elevation
        ) {
            Text(text = "Add")
        }
    }
}

@Composable
@Preview
fun Preview() {
    FavoriteScreen()
}

@Composable
private fun ProfilePic2(user: User) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .icon()
            .padding(5.dp)
            .size(150.dp)
    ) {
        Image(
            painter = rememberImagePainter(user.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .size(150.dp)
        )
    }
}

@Composable
fun ProfilePic(user: User) {
    val shape = CircleShape
    Box(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .size(66.dp)
                .padding(6.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
            Image(
                painter = rememberImagePainter(user.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun SearchBar3() {
    TextField(
        value = "",
        onValueChange = { /* Handle value change */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black,
            cursorColor = Color.Black
        ),
        placeholder = {
            Text("Search", color = Color.Gray)
        }
    )
}

// Custom VisualTransformation to add a search icon
@Composable
fun SearchBar() {
//    var searchText by remember { mutableStateOf("") }

    TextField(
        value = "",
        onValueChange = {  },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black,
            cursorColor = Color.Black
        ),
        placeholder = {
            Text("Search", color = Color.Gray)
        }
    )
}

