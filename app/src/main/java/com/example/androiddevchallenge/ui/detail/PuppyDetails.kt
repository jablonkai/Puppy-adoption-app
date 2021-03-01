/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyDetail(puppy: Puppy) {
    Scaffold(
        topBar = { AppBar() },
        content = { Content(puppy) },
        backgroundColor = MaterialTheme.colors.secondary
    )
}

@Composable
private fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "Puppy Details")
        },
    )
}

@Composable
private fun Content(
    puppy: Puppy,
    modifier: Modifier = Modifier

) {
    Box(modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = puppy.name, fontSize = 32.sp)
                    Text(text = puppy.age.toString() + " éves")
                }
                Card(
                    modifier = Modifier.size(128.dp),
                    elevation = 2.dp
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.frakk),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = puppy.type,
                    style = MaterialTheme.typography.body1,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = puppy.city,
                    style = MaterialTheme.typography.body1,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(text = puppy.story, modifier = modifier.padding(top = 16.dp))
        }
    }
}
