package com.ramyres.youshallnotpass.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramyres.youshallnotpass.R
import com.ramyres.youshallnotpass.ui.theme.DarkFont
import com.ramyres.youshallnotpass.ui.theme.YellowBG
import com.ramyres.youshallnotpass.ui.theme.YouShallNotPassTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cabecalho(modifier: Modifier) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = YellowBG,
            titleContentColor = DarkFont,
        ),
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            Image(painter = painterResource(id = R.drawable.gandalf),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.wrapContentHeight().width(70.dp))
//            IconButton(onClick = { /* do something */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Lock,
//                    contentDescription = "Localized description",
//                    tint = DarkFont
//                )
//            }
        }
    )
}

@Preview(showBackground = true, name = "CabecalhoDark", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, name = "CabecalhoLight",uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Composable
fun CabecalhoPreview() {
    YouShallNotPassTheme {
        Cabecalho(Modifier)
    }
}