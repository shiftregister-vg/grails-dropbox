package com.dropbox.core



import spock.lang.*

/**
 *
 */
class AuthServiceSpec extends Specification {

    def grailsApplication
    def authService

    def setup() {
    }

    def cleanup() {
    }

    void "test appKey"() {
        // grailsApplication.config.grails.plugin.dropbox.appKey = '1234567890'
        assert authService == '1234567890'
    }
}
