package com.example.myapplication4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.myapplication4.ui.theme.MyApplication4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.enableEdgeToEdge(window) // <-- Правильный вызов
        setContent {
            MyApplication4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // В самом приложении выводим все три варианта друг под другом
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Task3Variant1()
                        Task3Variant2()
                        Task3Variant3()
                    }
                }
            }
        }
    }
}

// ==========================================
// ВАРИАНТ 1: Зелёный, 16.sp, курсив, по центру
// ==========================================
@Composable
fun Task3Variant1() {
    Text(
        text = stringResource(id = R.string.compose_desc),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

// ==========================================
// ВАРИАНТ 2: Одна строка с многоточием
// ==========================================
@Composable
fun Task3Variant2() {
    Text(
        text = stringResource(id = R.string.compose_desc),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth() // Растягиваем, чтобы текст точно обрезался
    )
}

// ==========================================
// ВАРИАНТ 3: Отступ 48.dp, 24.sp, чёрный, зелёный фон, подчёркнутый
// ==========================================
@Composable
fun Task3Variant3() {
    Text(
        text = stringResource(id = R.string.compose_desc),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .padding(top = 48.dp) // Отступ перед первой строкой
            .background(Color.Green) // Зеленый фон
    )
}

// ==========================================
// ПРЕВЬЮ (PREVIEWS)
// ==========================================

@Preview(name = "1. Зеленый курсив", showBackground = true)
@Composable
fun PreviewVariant1() {
    MyApplication4Theme {
        Task3Variant1()
    }
}

@Preview(name = "2. Одна строка", showBackground = true, widthDp = 300)
@Composable
fun PreviewVariant2() {
    MyApplication4Theme {
        Task3Variant2()
    }
}

@Preview(name = "3. Подчеркнутый на фоне", showBackground = true)
@Composable
fun PreviewVariant3() {
    MyApplication4Theme {
        Task3Variant3()
    }
}