package org.javiermf.primitives.url

import org.javiermf.primitives.exceptions.message

data class Url(private val url: String) {

    init {
        // Edge 16 limit https://stackoverflow.com/questions/417142/what-is-the-maximum-length-of-a-url-in-different-browsers
        require(url.length < 2047) { message("Url too long") }
        require( urlRegex matches url ) { message("The string is not a valid URL") }
    }

    val value get() = url

    override fun toString() = value

    companion object {
        // https://gist.github.com/dperini/729294 from https://mathiasbynens.be/demo/url-regex
        val urlRegex = "(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z0-9\\u00a1-\\uffff][a-z0-9\\u00a1-\\uffff_-]{0,62})?[a-z0-9\\u00a1-\\uffff]\\.)+(?:[a-z\\u00a1-\\uffff]{2,}\\.?))(?::\\d{2,5})?(?:[/?#]\\S*)?".toRegex()
    }
}