package com.example.kandroid_lab05.helpers

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Modifier.imageModifier : Modifier
    get() = this.size(150.dp).border(width = 5.dp, color = Color.Cyan, shape = CircleShape).padding(20.dp)

val Modifier.cardRow : Modifier
    get() = this.fillMaxWidth().border(color = Color.Magenta, width = 5.dp, shape = RoundedCornerShape(
        20.dp
    )
    ).padding(20.dp)