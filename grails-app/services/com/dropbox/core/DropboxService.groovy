package com.dropbox.core

import grails.transaction.Transactional

@Transactional
class DropboxService {

    AuthService authService
    EntryService entryService

    String getAuthUrl() {
        authService.authUrl
    }

    def finishAuth(String code) {
        authService.finishAuth(code)
    }

    def uploadFile(File file) {
        // TODO: upload a file
    }

    File downloadFile() {
        // TODO: download a file
    }

    def deleteFile() {
        // TODO: delete a file
    }

    def createFolder() {
        // TODO: create a folder
    }

    def deleteFolder() {
        // TODO: delete a folder
    }

    def listFoldersAndFilesInPath(String path) {
        // TODO: list folders with their files
        entryService.listEntries(path)
    }
}
