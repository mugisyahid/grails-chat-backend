package com.ismachat

import com.ismachat.service.BootStrapService

class BootStrap {

    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.appInit()
    }


    def destroy = {
    }
}
