package com.dropbox.core

import grails.transaction.Transactional

@Transactional
class EntryService {

    AuthService authService

    def listEntries(String path) {
        DbxEntry.WithChildren listing = authService.client.getMetadataWithChildren(path)
        return listing.children
    }
}
