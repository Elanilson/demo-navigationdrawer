package br.com.apkdoandroid.my_navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.apkdoandroid.my_navigationdrawer.ui.theme.PrimaryColorLight

import br.com.apkdoandroid.my_navigationdrawer.R;
import br.com.apkdoandroid.my_navigationdrawer.ui.theme.TextColorLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeuNavigationDrawer(
    modifier : Modifier = Modifier,
    drawerState: DrawerState,
    items : List<MeuNavigationDrawerItem>,
    drawerIndex : Int,
    content : @Composable () -> Unit,
    onClick : (Int) -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = PrimaryColorLight) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .border(1.dp, Color.White, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Elanilson de Jesus",
                            style = TextStyle(
                                color = TextColorLight,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(500)
                            )
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Ver Perfil",
                            style = TextStyle(
                                color = TextColorLight ,
                                fontWeight = FontWeight(500)
                            )
                        )
                    }

                }



                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    items.forEachIndexed { index, meuDrawerItem ->
                        NavigationDrawerItem(
                            label = {
                                    Text(text = stringResource(id = meuDrawerItem.title))
                            },
                            selected = index == drawerIndex,
                            onClick = { onClick(index) },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding),
                            icon = {
                                Icon(
                                    painter = if(index == drawerIndex){
                                            painterResource(id = meuDrawerItem.selectedIcon)
                                           }else{
                                        painterResource(id = meuDrawerItem.unSelectedIcon)
                                           },
                                    contentDescription = null
                                )
                            },
                            badge = {
                                if (meuDrawerItem.badge > 0){
                                    Box(
                                        modifier = Modifier
                                            .size(20.dp)
                                            .background(Color.Red, RoundedCornerShape(4.dp)),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Text(text = meuDrawerItem.badge.toString(),
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                color = Color.White
                                            )
                                        )
                                    }
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = PrimaryColorLight,
                                unselectedContainerColor = Color.Transparent
                            )
                        )


                    }

                }

            }
        },
        modifier = modifier,
        drawerState = drawerState,
        content =content
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MeuNavigationDrawerPreview() {

    val drawerState = rememberDrawerState(DrawerValue.Open)
    var drawerIndex by remember{ mutableStateOf(0) }

    MeuNavigationDrawer(
        drawerState = drawerState,
        items = MeuNavigationDrawerItem.items,
        drawerIndex = drawerIndex,
        content = { },
        onClick = {
            drawerIndex = it
        }
    )

}