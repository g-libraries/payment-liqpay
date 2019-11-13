package com.core.payment.work

import android.content.Context
import android.os.AsyncTask
import com.core.payment.ConfigurationService
import com.core.payment.listeners.ICheckoutResultListener
import com.core.payment.params.CheckPaymentStatusParams
import com.core.payment.params.CheckoutPaymentParams
import ua.privatbank.paylibliqpay.ErrorCode
import ua.privatbank.paylibliqpay.LiqPay
import ua.privatbank.paylibliqpay.LiqPayCallBack
import java.util.HashMap


class CheckoutPaymentService  constructor(val context: Context) {
    fun pay(params: CheckoutPaymentParams, listener: LiqPayCallBack) {
        val map = HashMap<String, String>()

        map["version"] = params.version
        map["public_key"] = params.publicKey
        map["action"] = params.action
        map["amount"] = params.amount
        map["server_url"] = params.serverUrl
        map["currency"] = params.currency
        map["description"] = params.description
        map["order_id"] = params.orderId

        LiqPay.checkout(context, map, ConfigurationService.liqPayPrivateKey, listener)
    }
}
