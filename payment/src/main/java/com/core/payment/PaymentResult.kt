package com.core.payment

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


/**{
//    "action": "pay",
//    "payment_id": 1084703110,
//    "status": "failure",
//    "err_code": "err_card_receiver_def",
//    "err_description": "У получателя не установлена карта для приема платежей",
//    "version": 3,
//    "type": "buy",
//    "paytype": "card",
//    "public_key": "sandbox_i17799470753",
//    "acq_id": 414963,
//    "order_id": "7041",
//    "liqpay_order_id": "06LM47HE1564669705289100",
//    "description": "account top-up",
//    "sender_phone": "380635749823",
//    "sender_card_mask2": "516875*06",
//    "sender_card_bank": "pb",
//    "sender_card_type": "mc",
//    "sender_card_country": 804,
//    "ip": "37.73.69.12",
//    "amount": 90,
//    "currency": "UAH",
//    "sender_commission": 0,
//    "receiver_commission": 0,
//    "agent_commission": 0,
//    "mpi_eci": "7",
//    "is_3ds": false,
//    "language": "ru",
//    "create_date": 1564669705295,
//    "end_date": 1564669705302,
//    "transaction_id": 1084703110,
//    "code": "err_card_receiver_def",
//    "signature": "ClcvGc8v2q45ecqNyRYWlUJBrE4="
 */


data class PaymentResult(
    @SerializedName("action")
    @Expose
    val action: String,
    @Expose
    val paymentId: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("err_code")
    @Expose
    val errCode: String,
    @SerializedName("err_description")
    @Expose
    val errDescription: String,
    @SerializedName("version")
    @Expose
    val version: Int,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("paytype")
    @Expose
    val paytype: String,
    @SerializedName("public_key")
    @Expose
    val publicKey: String,
    @SerializedName("acq_id")
    @Expose
    val acqId: Int,
    @SerializedName("order_id")
    @Expose
    val orderId: String,
    @SerializedName("liqpay_order_id")
    @Expose
    val liqpayOrderId: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("sender_phone")
    @Expose
    val senderPhone: String,
    @SerializedName("ip")
    @Expose
    val ip: String,
    @SerializedName("amount")
    @Expose
    val amount: Float,
    @SerializedName("currency")
    @Expose
    val currency: String,
    @SerializedName("create_date")
    @Expose
    val createDate: String,
    @SerializedName("end_date")
    @Expose
    val endDate: String,
    @SerializedName("transaction_id")
    @Expose
    val transactionId: Int,
    @SerializedName("code")
    @Expose
    val code: String,
    @SerializedName("signature")
    @Expose
    val signature: String
)
