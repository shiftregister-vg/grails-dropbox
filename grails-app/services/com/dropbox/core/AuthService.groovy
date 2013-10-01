package com.dropbox.core

import grails.transaction.Transactional

@Transactional
class AuthService {

    def grailsApplication

    // stateful properties
    private def dbConfig
    private DbxWebAuthNoRedirect _dbxWebAuthNoRedirect

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
        if (!dbConfig) {
            DbxAppInfo appInfo = new DbxAppInfo(appKey, appSecret)
            DbxRequestConfig config = new DbxRequestConfig(clientIdentifier, Locale.getDefault().toString())
            dbconfig = [appInfo: appInfo, config: config]
        }
        return dbConfig
    }

    DbxWebAuthNoRedirect getWebAuthNoRedirect() {
        if (!webAuthNoRedirect) {
            def _appInfoAndConfig = appInfoAndConfig
            _dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(_appInfoAndConfig.config, _appInfoAndConfig.appInfo)
        }

        return webAuthNoRedirect
    }

    String getAuthUrl() {
        webAuthNoRedirect.start()
    }

    def finishAuth(String code) {
        webAuthNoRedirect.finish(code)
    }
}
