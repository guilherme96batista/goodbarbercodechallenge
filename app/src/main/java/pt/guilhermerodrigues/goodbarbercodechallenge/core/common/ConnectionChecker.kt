package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

import java.net.InetSocketAddress
import java.net.Socket


object ConnectionChecker {
    val hasNetworkConnection = isNetworkConnected()

    private fun isNetworkConnected():  Boolean {
        return try {
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            true
        } catch (e: Exception) {
            false
        }
    }
}
