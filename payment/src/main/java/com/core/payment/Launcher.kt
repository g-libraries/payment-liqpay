package com.core.payment

import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.core.payment.listeners.ICheckPaymentStatusListener
import com.core.payment.listeners.ICheckoutResultListener
import com.core.payment.params.CheckPaymentStatusParams
import com.core.payment.params.CheckoutPaymentParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class Launcher  constructor(val service: LiqPayService) : ICheckoutResultListener,
    ICheckPaymentStatusListener {

    suspend fun launchPayment(
        currency: String = "uah",
        amount2pay: Float,
        title: String,
        orderId: String,
        listener: ICheckoutResultListener
    ) =
        withContext(Dispatchers.IO) {
            service.pay(amount2pay.toString(), currency, title, orderId, listener)
        }

    override fun checkoutResultSuccess(params: CheckoutPaymentParams) {
        params.operationResult?.let {
            obtainResult(it)
        }
    }

    override fun checkoutResultFail(params: CheckoutPaymentParams) {
        params.operationResult?.let {
            obtainResult(it)
        }
    }

    override fun checkPaymentStatusResultFail(params: CheckPaymentStatusParams) {
        params.operationResult?.let {
            obtainResult(it)
        }
    }

    override fun checkPaymentStatusResultSuccess(params: CheckPaymentStatusParams) {
        params.operationResult?.let { obtainResult(it) }
    }

//    {"action":"pay","payment_id":1094910787,"status":"success","version":3,"type":"buy","paytype":"card","public_key":"sandbox_i91276316781","acq_id":414963,"order_id":"762f0120-fe2d-4464-8f1f-eac22ee6c609","liqpay_order_id":"ZK44S2HI1565794050573279","description":"account top-up","sender_phone":"380635749823","sender_card_mask2":"516875*06","sender_card_bank":"pb","sender_card_type":"mc","sender_card_country":804,"ip":"37.73.104.75","amount":90,"currency":"UAH","sender_commission":0,"receiver_commission":2.48,"agent_commission":0,"amount_debit":90,"amount_credit":90,"commission_debit":0,"commission_credit":2.48,"currency_debit":"UAH","currency_credit":"UAH","sender_bonus":0,"amount_bonus":0,"mpi_eci":"7","is_3ds":false,"language":"ru","create_date":1565794050579,"end_date":1565794050621,"transaction_id":1094910787,"signature":"q7OcdWM\/zlRwAZd9Ad3YX9uwANw="}

    fun obtainResult(json: String): PaymentResult? {
        return try {
            Gson().fromJson(json, PaymentResult::class.java)
        } catch (e: JsonSyntaxException) {
            Timber.e(e)
            null
        }
    }
}