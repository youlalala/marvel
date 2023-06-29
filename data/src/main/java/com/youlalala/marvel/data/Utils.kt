package com.youlalala.marvel.data

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Date

object Utils {

    fun getTsHash(): MutableMap<String,String> {
        val map = mutableMapOf<String, String>()
        val ts = getTimesStamp()
        map["ts"] = ts
        map["hash"] = md5(
            ts +
                    BuildConfig.MARVEL_PRIVATE_KEY +
                    BuildConfig.MARVEL_PUBLIC_KEY)
        return map
    }

    private fun getTimesStamp(): String = Date().time.toString()

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