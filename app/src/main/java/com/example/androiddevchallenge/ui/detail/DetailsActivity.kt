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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import com.example.androiddevchallenge.model.puppyList
import com.example.androiddevchallenge.ui.theme.MyTheme

private const val KEY_ARG_PUPPY = "KEY_ARG_PUPPY"

fun launchDetailsActivity(context: Context, id: Int) {
    context.startActivity(createDetailsActivityIntent(context, id))
}

@VisibleForTesting
fun createDetailsActivityIntent(context: Context, id: Int): Intent {
    val intent = Intent(context, DetailsActivity::class.java)
    intent.putExtra(KEY_ARG_PUPPY, id)
    return intent
}

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppyId = getDetailsArgs(intent)

        setContent {
            MyTheme {
                PuppyDetail(puppyList[puppyId])
            }
        }
    }

    private fun getDetailsArgs(intent: Intent): Int {
        val cityArg = intent.getIntExtra(KEY_ARG_PUPPY, -1)
        if (cityArg == -1) {
            throw IllegalStateException("KEY_ARG_PUPPY arg value -1")
        }
        return cityArg
    }
}
