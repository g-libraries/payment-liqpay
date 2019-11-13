package com.core.payment.listeners

import com.core.payment.params.CheckPaymentStatusParams

interface ICheckPaymentStatusListener {
    fun checkPaymentStatusResultSuccess(params: CheckPaymentStatusParams)
    fun checkPaymentStatusResultFail(params: CheckPaymentStatusParams)
}
