package vitec.sureservice.ui.reservation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vitec.sureservice.R


@Composable
fun PaymentSuccess() {

    var review by remember { mutableStateOf("") }
    var calification by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Successfully Paid",
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.payment_sucess),
            contentDescription = "Payment Success Image",
            modifier = Modifier
                .height(320.dp)
                .width(320.dp)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Text(
            text = "Rate from 1 to 10 to: Alan Perez",
            style = TextStyle(color = Color.Black, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))

        OutlinedTextField(value = calification, onValueChange = {calification = it},
            modifier = Modifier
                .width(100.dp),
            singleLine = true,
            label = {Text(text = "Calification")}
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        OutlinedTextField(value = review, onValueChange = { review = it },
            label = { Text(text = "Review") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = TextFieldDefaults.textFieldColors(unfocusedIndicatorColor = Color.Transparent))

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(colorSureService2)),
        ) {
            Text(text = "SEND",
                style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium))
        }

    }

}