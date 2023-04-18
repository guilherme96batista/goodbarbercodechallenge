package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

import java.net.InetAddress


class ConnectionChecker() {
    companion object {
        val hasNetworkConnected = isNetworkConnected()

        private fun isNetworkConnected(): Boolean {
            return try {
                val address = InetAddress.getByName("www.google.com")
                !address.equals("")
            } catch (e: Exception) {
                false
            }
        }
    }
}
