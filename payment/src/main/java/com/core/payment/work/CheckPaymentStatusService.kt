package com.core.payment.work

import android.content.Context
import com.core.payment.ConfigurationService
import com.core.payment.listeners.ICheckPaymentStatusListener
import com.core.payment.listeners.ICheckoutResultListener
import com.core.payment.params.CheckPaymentStatusParams
import ua.privatbank.paylibliqpay.ErrorCode
import ua.privatbank.paylibliqpay.LiqPay
import ua.privatbank.paylibliqpay.LiqPayCallBack
import java.util.HashMap

class CheckPaymentStatusService  constructor(val context: Context) {
    fun checkPaymentStatus(
        checkPaymentStatusParams: CheckPaymentStatusParams,
        listener: LiqPayCallBack
    ) {
        val map = HashMap<String, String>()

        map["version"] = checkPaymentStatusParams.version
        map["public_key"] = checkPaymentStatusParams.publicKey
        map["order_id"] = checkPaymentStatusParams.paymentResult.orderId

        LiqPay.api(context, "status", map, ConfigurationService.liqPayPrivateKey, listener)
    }
}