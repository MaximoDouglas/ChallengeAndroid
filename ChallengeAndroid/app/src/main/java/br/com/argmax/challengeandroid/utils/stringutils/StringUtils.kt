package br.com.argmax.challengeandroid.utils.stringutils

fun compactStringWithDots(string: String, maxLength: Int): String {
    return string.subSequence(0, maxLength) as String + "..."
}