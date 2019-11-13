package com.core.payment.params

import com.core.payment.ConfigurationService
import ua.privatbank.paylibliqpay.ErrorCode
import java.util.*

class CheckoutPaymentParams {
    var version: String = "3"
    var publicKey: String = ConfigurationService.liqPayPublicKey
    var action: String = "pay"
    var amount: String = "0.01"
    var currency: String = "uah"
    var serverUrl: String = "https://merryberry.gbsfo.com/api/v2/order/checkout"
    var description: String = "account top-up"
    var orderId: String = UUID.randomUUID()
        .toString()   //Generate new value of order_id on each call to LiqPay service
    var language: String = "ru"
    var operationResult: String? = null
    var operationError: ErrorCode? = null
}