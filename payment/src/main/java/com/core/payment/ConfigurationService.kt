package com.core.payment

class ConfigurationService  constructor() {
    companion object {
        var instance: ConfigurationService = ConfigurationService()

        var liqPayPublicKey = ""
        var liqPayPrivateKey = ""
    }
}