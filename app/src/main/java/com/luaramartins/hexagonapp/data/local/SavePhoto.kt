package com.luaramartins.hexagonapp.data.local

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

suspend fun saveImageToInternalStorage(context: Context, uri: Uri?): String? = withContext(
    Dispatchers.IO) {
    val contentResolver = context.contentResolver
    val fileName = "image_${System.currentTimeMillis()}.jpg"
    val directory = context.filesDir

    val file = File(directory, fileName)
    uri?.let {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            val outputStream = FileOutputStream(file)
            inputStream?.copyTo(outputStream)
            inputStream?.close()
            outputStream.close()

            file.absolutePath
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}