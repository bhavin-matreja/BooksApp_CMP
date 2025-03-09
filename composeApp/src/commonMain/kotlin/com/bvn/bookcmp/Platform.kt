package com.bvn.bookcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform