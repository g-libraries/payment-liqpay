package com.core.payment.listeners

import com.core.payment.params.CheckoutPaymentParams

interface ICheckoutResultListener {
    fun checkoutResultSuccess(params: CheckoutPaymentParams)
    fun checkoutResultFail(params: CheckoutPaymentParams)
}


