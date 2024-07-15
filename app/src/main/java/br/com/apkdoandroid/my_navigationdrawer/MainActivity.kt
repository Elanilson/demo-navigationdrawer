package br.com.apkdoandroid.my_navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.apkdoandroid.my_navigationdrawer.ui.theme.My_navigationdrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_navigationdrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    var drawerIndex by remember{ mutableStateOf(0) }
                    val scope = rememberCoroutineScope()
                    
                    MeuNavigationDrawer(
                        drawerState = drawerState,
                        items = MeuNavigationDrawerItem.items,
                        drawerIndex = drawerIndex,
                        content = {
                                  Scaffold(
                                      topBar = {
                                          TopAppBar(
                                              title = { },
                                              navigationIcon = {
                                                  IconButton(
                                                      onClick = {  
                                                                if(drawerState.isClosed){
                                                                    scope.launch { 
                                                                        drawerState.open()
                                                                    }
                                                                }
                                                      },
                                                      content = {
                                                          Icon(
                                                              imageVector = Icons.Rounded.Menu,
                                                              contentDescription = null
                                                          )
                                                      }
                                                  ) 
                                              }
                                          )
                                      }
                                  ) {paddingValues ->  
                                      
                                      Column(
                                          modifier = Modifier
                                              .fillMaxSize()
                                              .padding(paddingValues),
                                          verticalArrangement = Arrangement.Center,
                                          horizontalAlignment = Alignment.CenterHorizontally
                                      ) {
                                          Text(text = stringResource(id = MeuNavigationDrawerItem.items[drawerIndex].title))
                                      }
                                  }
                        },
                        onClick =  {
                            scope.launch {
                                drawerState.close()
                                drawerIndex = it
                            }
                        }
                    )
                    
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_navigationdrawerTheme {
        Greeting("Android")
    }
}