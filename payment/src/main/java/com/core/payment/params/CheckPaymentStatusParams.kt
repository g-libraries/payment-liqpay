package com.core.payment.params

import android.content.Context
import com.core.payment.ConfigurationService
import com.core.payment.PaymentResult
import com.core.payment.listeners.ICheckPaymentStatusListener
import ua.privatbank.paylibliqpay.ErrorCode

class CheckPaymentStatusParams(val paymentResult: PaymentResult) {
    var version: String = "3"
    var publicKey: String = ConfigurationService.liqPayPublicKey
    var listener: ICheckPaymentStatusListener? = null
    var operationResult: String? = null
    var operationError: ErrorCode? = null
}