package com.problemsolver.myorder.app.presentation.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import java.io.ByteArrayOutputStream


object BitmapConverter {
	fun StringToImageBitmap(encodedString: String?): ImageBitmap? {
		return try {
			if(encodedString == null) throw Exception()
			val decodedByte = Base64.decode(encodedString, Base64.DEFAULT)
			BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size).asImageBitmap()
		} catch (e: Exception) {
			e.printStackTrace()
			return null
		}
	}
}