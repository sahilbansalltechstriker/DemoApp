package com.example.demoapp.serviceHandlers

import com.example.demoapp.serviceHandler.MyApi


class Repository(
    private val api: MyApi
) : SafeApiRequest() {


}