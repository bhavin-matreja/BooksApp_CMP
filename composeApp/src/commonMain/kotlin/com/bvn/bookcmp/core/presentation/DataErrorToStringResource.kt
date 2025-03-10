package com.bvn.bookcmp.core.presentation

import bookapp_cmp.composeapp.generated.resources.Res
import bookapp_cmp.composeapp.generated.resources.error_disk_full
import bookapp_cmp.composeapp.generated.resources.error_no_internet
import bookapp_cmp.composeapp.generated.resources.error_request_timeout
import bookapp_cmp.composeapp.generated.resources.error_serialization
import bookapp_cmp.composeapp.generated.resources.error_too_many_requests
import bookapp_cmp.composeapp.generated.resources.error_unknown
import com.bvn.bookcmp.core.domain.DataError

fun DataError.toUIText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
    }
    return UiText.StringResourceId(stringRes)
}