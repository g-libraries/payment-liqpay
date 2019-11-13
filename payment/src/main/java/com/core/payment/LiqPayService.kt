package com.core.payment

import com.core.payment.listeners.ICheckPaymentStatusListener
import com.core.payment.listeners.ICheckoutResultListener
import com.core.payment.params.CheckPaymentStatusParams
import com.core.payment.params.CheckoutPaymentParams
import com.core.payment.work.CheckPaymentStatusService
import com.core.payment.work.CheckoutPaymentService
import ua.privatbank.paylibliqpay.ErrorCode
import ua.privatbank.paylibliqpay.LiqPayCallBack

class LiqPayService  constructor(
    private val checkoutPaymentService: CheckoutPaymentService,
    private val checkPaymentStatusService: CheckPaymentStatusService
) {
    suspend fun pay(
        amount2pay: String,
        currency: String,
        title: String,
        orderId: String,
        listener: ICheckoutResultListener
    ) {
        val params = CheckoutPaymentParams()

        params.amount = amount2pay
        params.currency = currency
        params.description = title
        params.orderId = orderId

        checkoutPaymentService.pay(params, object : LiqPayCallBack {
            /**
             * {
             * @param response : "action": "pay",
             * "payment_id": 1084502829,
             * "status": "failure",
             * "err_code": "err_card_receiver_def",
             * "err_description": "У получателя не установлена карта для приема платежей",
             * "version": 3,
             * "type": "buy",
             * "paytype": "card",
             * "public_key": "sandbox_i17799470753",
             * "acq_id": 414963,
             * "order_id": "7597",
             * "liqpay_order_id": "QDL3VWAG1564657323772015",
             * "description": "account top-up",
             * "sender_phone": "380635749823",
             * "sender_card_mask2": "516875*06",
             * "sender_card_bank": "pb",
             * "sender_card_type": "mc",
             * "sender_card_country": 804,
             * "ip": "37.73.69.12",
             * "amount": 0.01,
             * "currency": "UAH",
             * "sender_commission": 0,
             * "receiver_commission": 0,
             * "agent_commission": 0,
             * "mpi_eci": "7",
             * "is_3ds": false,
             * "language": "ru",
             * "create_date": 1564657323775,
             * "end_date": 1564657323780,
             * "transaction_id": 1084502829,
             * "code": "err_card_receiver_def",
             * "signature": "i/xfXd3caFhber5bvvI4k0SngnA="
             * }
             */

            override fun onResponseSuccess(response: String) {
                params.operationResult = response
                listener.checkoutResultSuccess(params)
            }

            override fun onResponceError(errorCode: ErrorCode) {
                params.operationError = errorCode
                listener.checkoutResultFail(params)
            }
        })
    }

    suspend fun checkPaymentStatus(
        paymentResult: PaymentResult,
        listener: ICheckPaymentStatusListener
    ) {
        val params = CheckPaymentStatusParams(paymentResult)
        params.listener = listener

        checkPaymentStatusService.checkPaymentStatus(params, object : LiqPayCallBack {
            override fun onResponseSuccess(s: String) {
                params.operationResult = s
                listener.checkPaymentStatusResultSuccess(params)
            }

            override fun onResponceError(errorCode: ErrorCode) {
                params.operationError = errorCode
                listener.checkPaymentStatusResultFail(params)
            }
        })
    }
}
