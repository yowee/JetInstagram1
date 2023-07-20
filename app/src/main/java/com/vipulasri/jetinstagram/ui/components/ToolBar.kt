package com.vipulasri.jetinstagram.ui.components

import android.widget.Toolbar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R

@Composable
fun Toolbar(name: String, ic_1 : Int, ic_2: Int ) {

    Row(
        Modifier
            .fillMaxWidth(1f)
            .height(56.dp)
            .padding(horizontal = 10.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Icon(
            ImageVector.vectorResource(id = ic_1),
            contentDescription = "back"
        )
        Text(
            text = name,
            Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 25.sp
        )
        Icon(
            ImageVector.vectorResource(id = ic_2),
            contentDescription = "ellipsis", Modifier.size(20.dp)
        )
    }

}