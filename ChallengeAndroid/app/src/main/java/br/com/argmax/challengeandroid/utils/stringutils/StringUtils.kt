package br.com.argmax.challengeandroid.utils.stringutils

fun compactStringWithDots(string: String, maxLength: Int): String {
    if (string.length > maxLength) {
        return string.subSequence(0, maxLength) as String + "..."
    }

    return string
}