//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//
//
//@Composable
//fun CustomDialog(openDialogCustom: MutableState<Boolean>) {
//    Dialog(onDismissRequest = { openDialogCustom.value = false}) {
//        CustomDialogUI(openDialogCustom = openDialogCustom)
//    }
//}
//
////Layout
//@Composable
//fun CustomDialogUI(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>){
//    Card(
//            //shape = MaterialTheme.shapes.medium,
//            shape = RoundedCornerShape(10.dp),
//            // modifier = modifier.size(280.dp, 240.dp)
//            modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
//            elevation = 8.dp
//    ) {
//        Column(
//                modifier
//                        .background(Color.White)) {
//
//            //.......................................................................
//            Image(
//                    painter = painterResource(id = com.littlebit.popups.R.drawable.ic_baseline_notifications_24),
//                    contentDescription = null, // decorative
//                    contentScale = ContentScale.Fit,
//                    colorFilter  = ColorFilter.tint(
//                            color = MaterialTheme.colorScheme.primary
//                    ),
//                    modifier = Modifier
//                            .padding(top = 35.dp)
//                            .height(70.dp)
//                            .fillMaxWidth(),
//
//                    )
//
//            Column(modifier = Modifier.padding(16.dp)) {
//                androidx.compose.material3.Text(
//                        text = "Get Updates",
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                                .padding(top = 5.dp)
//                                .fillMaxWidth(),
//                        style = MaterialTheme.typography.labelLarge,
//                        maxLines = 2,
//                        overflow = TextOverflow.Ellipsis
//                )
//                androidx.compose.material3.Text(
//                        text = "Allow Permission to send you notifications when new art styles added.",
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
//                                .fillMaxWidth(),
//                        style = MaterialTheme.typography.bodyMedium
//                )
//            }
//            //.......................................................................
//            Row(
//                    Modifier
//                            .fillMaxWidth()
//                            .padding(top = 10.dp)
//                            .background(MaterialTheme.colorScheme.tertiaryContainer),
//                    horizontalArrangement = Arrangement.SpaceAround) {
//
//                androidx.compose.material3.TextButton(onClick = {
//                    openDialogCustom.value = false
//                }) {
//
//                    androidx.compose.material3.Text(
//                            "Not Now",
//                            fontWeight = FontWeight.Bold,
//                            color = MaterialTheme.colorScheme.secondary,
//                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
//                    )
//                }
//                androidx.compose.material3.TextButton(onClick = {
//                    openDialogCustom.value = false
//                }) {
//                    androidx.compose.material3.Text(
//                            "Allow",
//                            fontWeight = FontWeight.ExtraBold,
//                            color = Color.Black,
//                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//@SuppressLint("UnrememberedMutableState")
//@Preview (name="Custom Dialog")
//@Composable
//fun MyDialogUIPreview(){
//    CustomDialogUI(openDialogCustom = mutableStateOf(false))
//}