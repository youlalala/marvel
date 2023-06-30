package com.youlalala.marvel.data

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Date

object Utils {

    fun getTsHash(ts: String): String {
        return md5(
            ts +
                    BuildConfig.MARVEL_PRIVATE_KEY +
                    BuildConfig.MARVEL_PUBLIC_KEY)
    }

    fun getTimesStamp(): String = Date().time.toString()

    private fun md5(string: String): String {
        val md5 = "MD5"

        try {
            val digest = MessageDigest.getInstance(md5)
            digest.update(string.toByteArray())
            val messageDigest = digest.digest()

            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) {
                    h = "0$h"
                }
                hexString.append(h)
            }
            return hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }


}