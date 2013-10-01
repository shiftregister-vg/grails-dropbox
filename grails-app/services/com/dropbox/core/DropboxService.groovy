package com.dropbox.core

import grails.transaction.Transactional

@Transactional
class DropboxService {

    AuthService authService

    String getAuthUrl() {
        authService.authUrl
    }

    def finishAuth(String code) {
        authService.finishAuth(code)
    }
}
