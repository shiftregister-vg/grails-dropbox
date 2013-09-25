package com.dropbox.core

import grails.transaction.Transactional

@Transactional
class AuthService {

    def grailsApplication

    String getAppKey() {
        grailsApplication.config.grails.plugin.dropbox.appKey
    }

    String getAppSecret() {
        grailsApplication.config.grails.plugin.dropbox.appSecret
    }

    String getClientIdentifier() {
        grailsApplication.config.grails.plugin.dropbox.clientIdentifier
    }

    def getAppInfoAndConfig() {
        DbxAppInfo appInfo = new DbxAppInfo(appKey, appSecret)
        DbxRequestConfig config = new DbxRequestConfig(clientIdentifier, Locale.getDefault().toString())
        [appInfo: appInfo, config: config]
    }

    String getAuthUrl() {
        def _appInfoAndConfig = appInfoAndConfig
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(_appInfoAndConfig.config, _appInfoAndConfig.appInfo)
        webAuth.start()
    }
}
