package com.mrjalal.monsterlabtesttask.core.data

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiCallFactory {

    companion object {

        fun get(urlString: String): String {

            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inStream = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var inputLine: String?
                while (inStream.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                inStream.close()
                return response.toString()
            } else {
                throw throw HttpCodeException(responseCode)
            }
        }

        fun post(url: String, body: JSONObject): String {

            val urlObject = URL(url)
            val connection = urlObject.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true
            val outputStream = connection.outputStream
            outputStream.write(body.toString().toByteArray())
            outputStream.flush()
            outputStream.close()

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {

                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }
                reader.close()
                inputStream.close()
                connection.disconnect()
                return response.toString()
            } else {
                throw HttpCodeException(responseCode)
            }
        }
    }
}