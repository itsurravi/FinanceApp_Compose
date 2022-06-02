package com.example.financeappcompose.ui.screens

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financeappcompose.R
import com.example.financeappcompose.ui.coloredShadow
import com.example.financeappcompose.ui.theme.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenUI() {
    val sendMoneyData = mutableListOf(
        SendMoneyItem(R.drawable.user1, "Jimmy", "$55.90"),
        SendMoneyItem(R.drawable.user2, "Kate", "$152.10"),
        SendMoneyItem(R.drawable.user3, "Smith", "$75.40"),
        SendMoneyItem(R.drawable.user3, "John", "$87.67"),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        item {
            HeaderUI()
            CardUI()
            DataUI()
            ServicesUI()
            SendMoneyUI(sendMoneyData)
        }
    }
}

@Composable
fun SendMoneyUI(sendMoneyData: MutableList<SendMoneyItem>) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Send Money",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        LazyRow {
            items(sendMoneyData.size) {
                SendMoneyItemUI(
                    sendMoneyData[it],
                    modifier = Modifier.padding(
                        start = if (it == 0) 20.dp else 10.dp,
                        end = if (it == sendMoneyData.size - 1) 20.dp else 0.dp
                    )
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
    }
}

@Composable
fun SendMoneyItemUI(
    item: SendMoneyItem,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(bottom = 6.dp, end = 6.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .size(width = 100.dp, height = Dp.Unspecified)
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageId), contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = item.name,
                color = PrimaryGrey,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Text(
                text = item.amount,
                color = PrimaryGrey,
                modifier = Modifier.alpha(0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins
            )
        }
    }
}

data class SendMoneyItem(val imageId: Int, val name: String, val amount: String)

@Composable
fun ServicesUI() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Services",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceUI(R.drawable.ic_money_send, "Send", Service1)
            ServiceUI(R.drawable.ic_bill, "Bill", Service2)
            ServiceUI(R.drawable.ic_recharge, "Recharge", Service3)
            ServiceUI(R.drawable.ic_more, "More", Service4)
        }
    }
}

@Composable
fun ServiceUI(id: Int, text: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color),
            border = BorderStroke(
                width = 0.dp,
                color = Color.White
            )
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            color = PrimaryGrey,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun DataUI() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "$67.50K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                lineHeight = 20.sp
            )
            Text(
                text = "Total Income",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$12.80K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                lineHeight = 20.sp
            )
            Text(
                text = "Total Spent",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CardUI() {
    Card(
        backgroundColor = CardRed,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(Dp.Unspecified)
            .coloredShadow(CardRed),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f),
                    fontFamily = poppins
                )
                Text(
                    text = "$28,067.50",
                    color = Color.White,
                    fontFamily = poppins,
                    fontSize = 30.sp
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryGrey),
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically),
                        color = Color.White
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.4f)
                    .size(80.dp)
                    .padding(top = 20.dp, end = 20.dp)
            )
        }

    }
}

@Composable
fun HeaderUI() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 26.dp)
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hi John", color = PrimaryGrey,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp,
                fontFamily = poppins,
            )
            Text(
                text = "Welcome Back", color = PrimaryGrey,
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold
            )
        }
        //Spacer(modifier = Modifier.fillMaxWidth())
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .border(width = 0.dp, Color.Transparent, shape = Shapes.medium)
                .clip(Shapes.medium)
        )
    }
}